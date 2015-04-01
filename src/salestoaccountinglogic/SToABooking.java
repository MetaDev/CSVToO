package salestoaccountinglogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import model.AppConstants;
import model.CacheModel;
import model.ConflictTabelRow;
import salestoaccountinglogic.SToAClient.ClientFields;
import webcomm.WSDataObjectCreator;

import webcomm.octws.BuySellBookingLineServiceData;
import webcomm.octws.BuySellBookingServiceData;

public class SToABooking {
	// all fields for a booking line shown in Conflict table
	public enum BookingLineFields {
		FactuurNummer, KlantID, Naam, BTWNummer, LandCode, FactuurDatum, VervalDatum, Referentie, BoekingBedragExclBTW, NrOfExperitiationDays, OctopusClient, BTWCode, BookingAccountKey
	}

	public enum ExperiationType {
		EndOfMonth, AfterBooking
	}

	public static boolean isImportRowValid(ConflictTabelRow row) {
		for (int i = 0; i < BookingLineFields.values().length; i++) {
			if (!fieldIsValid(BookingLineFields.values()[i],
					row.getBookingLineField(BookingLineFields.values()[i])))
				return false;
		}
		//extra logic
		//expiry date is after document date
		Date docDate = SToAField.parseDate(row.getBookingLineField(BookingLineFields.FactuurDatum));
		Date expDate = SToAField.parseDate(row.getBookingLineField(BookingLineFields.VervalDatum));
		if(docDate.after(expDate)){
			return false;
		}
		return true;
	}

	// parse all bookings with only valid fields and convert to a mapping
	// between document id and booking
	public static List<BuySellBookingServiceData> parseCorrectBookings(
			List<ConflictTabelRow> validBooking) {

		// Booking id mapped to a booking line
		Map<Integer, BuySellBookingServiceData> bookings = new HashMap<>();
		int startBookingNr=AppConstants.getStartBookingNr();
		for (ConflictTabelRow line : validBooking) {
			// get Octopus Client
			// because the client does or will exist in Octopus the client
			// optional info doesn't have to be added
			int factuurnNNr =Integer.parseInt( line
					.getBookingLineField(BookingLineFields.FactuurNummer));
			String externalClientID =SToAClient.getExternalOctopusID(line
					.getBookingLineField(BookingLineFields.KlantID));
			boolean isCreditNote = SToAField
					.parseDouble((line
							.getBookingLineField(BookingLineFields.BoekingBedragExclBTW))) < 0;
			// first create a booking if none exists for this factuur nr
			// comment is client name
			if (!bookings.containsKey(factuurnNNr)) {
				bookings.put(
						factuurnNNr,
						WSDataObjectCreator.getNewBooking(startBookingNr+"",
								externalClientID,
								line.getBookingLineField(BookingLineFields.LandCode),
								line.getBookingLineField(BookingLineFields.FactuurDatum),
								line.getBookingLineField(BookingLineFields.VervalDatum),
								line.getClientField(ClientFields.Naam),
								line.getBookingLineField(BookingLineFields.Referentie)));
				startBookingNr++;
			}

			// then add the line as booking line to the corresponding booking
			BuySellBookingServiceData booking = bookings.get(factuurnNNr);
			
			// the reference can be the standard shipping and handling reference
			// if so replace this with the imported reference different then the
			// S&A reference
			if (booking.getReference().equals(
					AppConstants.shippingAndHandlingReference)) {
				if (!line.getBookingLineField(BookingLineFields.Referentie)
						.equals(AppConstants.shippingAndHandlingReference)) {
					booking.setReference(line
							.getBookingLineField(BookingLineFields.Referentie));
				}
			}
			// calculate from the booking amount and VAT %
			String vatCodeKey = line
					.getBookingLineField(BookingLineFields.BTWCode);
			// booking lines are positive because all credit notes and regular
			// bookings are done seperately

			double baseAmount = Math
					.abs(SToAField.parseDouble((line
							.getBookingLineField(BookingLineFields.BoekingBedragExclBTW))));
			double vatAmount = SToABooking.getBookingVatAmount(baseAmount,
					vatCodeKey);
			int acctKey = Integer.parseInt(line
					.getBookingLineField(BookingLineFields.BookingAccountKey));

			BuySellBookingLineServiceData bookingLine = WSDataObjectCreator
					.getBookingLine(acctKey, baseAmount, vatAmount, vatCodeKey,
							 line.getBookingLineField(BookingLineFields.Referentie)+ "; "+	line.getClientField(ClientFields.Naam));
			// add line to booking and update booking total
			WSDataObjectCreator.addBookingLineToBookingAndUpdateBookingAmount(booking, bookingLine, isCreditNote);
			
		}
		//recalculate total amount for each booking
		
		//convert to a sorted list
		SortedMap<Integer, BuySellBookingServiceData> sortedBookings = new TreeMap<>();
		for(Map.Entry<Integer, BuySellBookingServiceData> entry: bookings.entrySet()){
			sortedBookings.put(entry.getValue().getDocumentSequenceNr(),entry.getValue());
		}
		return new ArrayList<>(sortedBookings.values());
	}

	public static double getBookingVatAmount(double baseAmount,
			String vatCodeKey) {
		double percentage = CacheModel.getVatCodes().get(vatCodeKey)
				.getBasePercentage();
		//round to 2 decimals after comma
		double vatAmount = SToABooking.roundForVATAmount(baseAmount * (percentage / 100));
		return vatAmount;
	}

	public static boolean fieldIsValid(BookingLineFields field, String s) {
		switch (field) {
		case BoekingBedragExclBTW:
			return SToAField.isDouble(s) && SToAField.isNotOptional(s);
		case FactuurDatum:
			return SToAField.isCorrectDate(s) && SToAField.isNotOptional(s);
		case VervalDatum:
			return SToAField.isCorrectDate(s) && SToAField.isNotOptional(s);
		case BTWNummer:
			return (SToAField.isBTWNumber(s)) && SToAField.isNotOptional(s);
		case KlantID:
			return (SToAField.isInteger(s)) && SToAField.isNotOptional(s);
		case NrOfExperitiationDays:
			return (SToAField.isInteger(s)) && SToAField.isNotOptional(s);
		case LandCode:
			return SToAField.isCountryCode(s);
		case OctopusClient:
			return SToAField.isNotOptional(s);
		default:
			return SToAField.isNotOptional(s);
		}
		// if an unknown field, show in log
	}
	public static double roundForVATAmount(double notRoundedVatAmount){
		return Math.round(notRoundedVatAmount*100.0)/100.0;
	}

}
