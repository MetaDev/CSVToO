package model;


import salestoaccountinglogic.SToABooking.BookingLineFields;
import salestoaccountinglogic.SToAClient;
import salestoaccountinglogic.SToAClient.ClientFields;
import salestoaccountinglogic.SToAField;
import salestoaccountinglogic.SToAField.ImportFields;
import webcomm.octws.RelationServiceData;

public class ConflictTabelRow {

	private String[] importFields;
	private String[] bookingLineFields;
	private int[] modifiedColumns;

	public String[] getImportFields() {
		return importFields;
	}

	public void updateClientMapping() {
		setBookingLinefield(
				BookingLineFields.OctopusClient,
				getExternalClientName(bookingLineFields[BookingLineFields.KlantID
						.ordinal()]));
	}

	public void setBookingLinefield(BookingLineFields field, String value) {
		setColumn(value, field.ordinal());
	}

	public void initBookingLineField(BookingLineFields field, String value) {
		bookingLineFields[field.ordinal()] = value;
	}

	// TODO use new set method everywhere
	public ConflictTabelRow(String[] line, boolean isShipping) {
		importFields = line;
		this.modifiedColumns = new int[line.length + 1];
		bookingLineFields = new String[BookingLineFields.values().length];
		// use importfields to auto-fill booking line fields
		// first the copy paste fields (1-1)
		// ImportFields.FactuurNummer,ImportFields.KlantID,ImportFields.BTWNummer,ImportFields.BoekingBedragExclBTW,
		initBookingLineField(BookingLineFields.FactuurNummer,
				getImportField(ImportFields.FactuurNummer));
		bookingLineFields[BookingLineFields.KlantID.ordinal()] = line[ImportFields.KlantID
				.ordinal()];
		bookingLineFields[BookingLineFields.BTWNummer.ordinal()] = line[ImportFields.BTWNummer
				.ordinal()];
		bookingLineFields[BookingLineFields.LandCode.ordinal()] = SToAField
				.getCountryCodeFromCountryName(line[ImportFields.Land.ordinal()]);
		bookingLineFields[BookingLineFields.FactuurDatum.ordinal()] = line[ImportFields.FactuurDatum
				.ordinal()];
		bookingLineFields[BookingLineFields.VervalDatum.ordinal()] = line[ImportFields.VervalDatum
				.ordinal()];
		initBookingLineField(BookingLineFields.Naam,
				line[ImportFields.Naam.ordinal()]);
		// if it's a shipping the amount is equal to the shipping price
		// the reference is already defined message stating that the payment is
		// a shipping and handling line
		if (isShipping) {
			bookingLineFields[BookingLineFields.BoekingBedragExclBTW.ordinal()] = line[ImportFields.ShippingAndHandling
					.ordinal()];
			bookingLineFields[BookingLineFields.Referentie.ordinal()] = AppConstants.shippingAndHandlingReference;
		} else {
			bookingLineFields[BookingLineFields.Referentie.ordinal()] = line[ImportFields.Referentie
					.ordinal()];
			bookingLineFields[BookingLineFields.BoekingBedragExclBTW.ordinal()] = line[ImportFields.BoekingBedragExclBTW
					.ordinal()];
		}
		bookingLineFields[BookingLineFields.NrOfExperitiationDays.ordinal()] = line[ImportFields.NrOfExperitiationDays
				.ordinal()];
		// to convert lines

		bookingLineFields[BookingLineFields.OctopusClient.ordinal()] = getExternalClientName(line[ImportFields.KlantID
				.ordinal()]);
		String BTWCode = SToAField.getBTWCodeSuggestion(
				line[ImportFields.BTW6.ordinal()],
				line[ImportFields.BTW21.ordinal()]);
		// default btwcode or non existing BTWCode
		if (BTWCode.equals("00")
				|| !CacheModel.getVatCodes().containsKey(BTWCode)) {
			// if not found in map set default
			if (!CacheModel.getVatCodes().containsKey(BTWCode))
				BTWCode = CacheModel.getVatCodes().keySet()
						.toArray(new String[] {})[0];
			this.modifiedColumns[BookingLineFields.BTWCode.ordinal()] = 1;
		}
		bookingLineFields[BookingLineFields.BTWCode.ordinal()] = BTWCode;
		String bookingAccount = SToAField
				.getBookingAccountSuggestion(bookingLineFields[BookingLineFields.LandCode
						.ordinal()]);
		// if booking account not exists in account
           
		if (bookingAccount==null || !CacheModel.getSalesBookingAccounts().keySet()
				.contains(bookingAccount)) {
			bookingAccount = CacheModel.getSalesBookingAccounts().keySet()
					.toArray(new String[] {})[0];
                        //set booking account column as modified
			this.modifiedColumns[BookingLineFields.BookingAccountKey.ordinal()] = 1;
		}
		bookingLineFields[BookingLineFields.BookingAccountKey.ordinal()] = bookingAccount;

	}

	private String getExternalClientName(String clientID) {
		RelationServiceData externalClient = SToAClient
				.getClientFromExtID(SToAClient.getExternalOctopusID(clientID));
		if (externalClient != null)
			return externalClient.getName();
		return "";
	}

	private String getImportField(ImportFields field) {
		return importFields[field.ordinal()];
	}

	public String getBookingLineField(BookingLineFields field) {
		return bookingLineFields[field.ordinal()];
	}

	/*
	 * search for a client field in the booking line first if present if not
	 * suggest something else that could be correct or return an empty string
	 */
	public String getClientField(ClientFields field) {
		switch (field) {
		case BTWNummer:
			return bookingLineFields[BookingLineFields.BTWNummer.ordinal()];
		case BTWPlichtigheid:
			return SToAField.getBTWPlichtigheid(
					bookingLineFields[BookingLineFields.BTWNummer.ordinal()],
					importFields[ImportFields.Land.ordinal()]);
		case BookingAccount:
			return bookingLineFields[BookingLineFields.BookingAccountKey
					.ordinal()];
		case Gemeente:
			return importFields[ImportFields.Gemeente.ordinal()];
		case LandCode:
			return bookingLineFields[BookingLineFields.LandCode.ordinal()];
		case Language:
			return SToAClient
					.getClientLanguageSuggestion(bookingLineFields[BookingLineFields.LandCode
							.ordinal()]);
		case Naam:
			return getBookingLineField(BookingLineFields.Naam);
		case NrOfExperitiationDays:
			return bookingLineFields[BookingLineFields.NrOfExperitiationDays
					.ordinal()];
		case OctopusExternalID:
			return SToAClient
					.getExternalOctopusID(bookingLineFields[BookingLineFields.KlantID
							.ordinal()]);
		case Postcode:
			return importFields[ImportFields.Postcode.ordinal()];
		case StraatEnNummer:
			return importFields[ImportFields.StraatEnNummer.ordinal()];
		default:
			return "";

		}
	}

	public int[] getModifiedFields() {
		return modifiedColumns;
	}

	public String getColumn(int column) {
		return bookingLineFields[column];
	}

	public void setColumn(String value, int column) {
		if (value != null && !value.equals(bookingLineFields[column])) {
			bookingLineFields[column] = value;
			modifiedColumns[column] = 1;
		}
	}

	public boolean columnIsModified(int column) {
		return modifiedColumns[column] == 1;
	}
}
