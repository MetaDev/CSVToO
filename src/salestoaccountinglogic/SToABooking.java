package salestoaccountinglogic;

import gui.component.custom.OKNotificationWindow;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.AppConstants;
import model.CacheModel;
import model.ConflictTabelRow;
import salestoaccountinglogic.SToAClient.ClientFields;
import util.AppUtil;
import webcomm.WSDataObjectCreator;

import webcomm.octws.BuySellBookingLineServiceData;
import webcomm.octws.BuySellBookingServiceData;
import webcomm.octws.RelationServiceData;

public class SToABooking {

    // all fields for a booking line shown in Conflict table
    public enum BookingLineFields {

        FactuurNummer, CreditNotaNummer, KlantID, Naam, BTWNummer, LandCode, FactuurDatum, VervalDatum, Referentie, BoekingBedragExclBTW, NrOfExperitiationDays, OctopusClient, BTWCode, BookingAccountKey
    }

    public enum ExperiationType {

        EndOfMonth, AfterBooking
    }

    public static boolean isImportRowValid(ConflictTabelRow row) {
        for (int i = 0; i < BookingLineFields.values().length; i++) {
            if (!fieldIsValid(BookingLineFields.values()[i],
                    row.getBookingLineField(BookingLineFields.values()[i]))) {
                return false;
            }
        }
        //extra logic
        //expiry date is after document date
        Date docDate = SToAField.parseDate(row.getBookingLineField(BookingLineFields.FactuurDatum));
        Date expDate = SToAField.parseDate(row.getBookingLineField(BookingLineFields.VervalDatum));
        if (docDate.after(expDate)) {
            return false;
        }
        return true;
    }
//format: factuurnummer, booking nummer, factuur VAT, booking VAT, SF ID, SF to oct mapped ID, VAT mapped oct ID
    public static String checkBooking( ConflictTabelRow line, BuySellBookingServiceData booking) {
        String logtext="";
        //check equality
        String importVAT = line.getBookingLineField(SToABooking.BookingLineFields.BTWNummer);
        String clientVAT = SToAField.removeDots(SToAClient.getClientFromExtID(booking.getExternalRelationId()).getVatNr());
        boolean vatEquals= importVAT.equals(clientVAT);
        //only retrun a warning text when there is a VAT mismatch
        if (vatEquals){
            return null;
        }
        String SFID = line.getBookingLineField(SToABooking.BookingLineFields.KlantID);
        String OctID = SToAClient.getExternalOctopusID(SFID) + "";
        //if client exist
        logtext += "SF ID: " + SFID + "; mapped Oct ext ID: " + OctID ;
        logtext+="\n";
        logtext+="the salesforce line has name: "+line.getBookingLineField(SToABooking.BookingLineFields.Naam);
        logtext+="\n";
        logtext+= "the mapped oct ext id corresponds to name: " +SToAClient.getClientFromExtID(OctID).getName();
        logtext+="\n";
        RelationServiceData test=SToAClient.getClientByVATNr(importVAT);
        if(test!=null){
            logtext+= "the VAT from the booking line maps to the name: " + test.getName();
            logtext+="\n";
        }
        return logtext;
   }
    //format: factuurnummer, booking nummer, factuur VAT, booking VAT, SF ID, SF to oct mapped ID, VAT mapped oct ID
    static void addBookingToLog(String logtext, ConflictTabelRow line, BuySellBookingServiceData booking) {
        logtext += "factuur nr: " + line.getBookingLineField(BookingLineFields.FactuurNummer);
        logtext += "booking nr: " + booking.getDocumentSequenceNr()+"\n";
        //check equality
        String importVAT = line.getBookingLineField(SToABooking.BookingLineFields.BTWNummer);
        String clientVAT = SToAField.removeDots(SToAClient.getClientFromExtID(booking.getExternalRelationId()).getVatNr());
        logtext += importVAT.equals(clientVAT) ? "VAT matches\n" : "Error VAT does not match\n";
        logtext += "factuur VAT nr: " + importVAT + " oct booking VAT nr: " + clientVAT + "\n";
        String SFID = line.getBookingLineField(SToABooking.BookingLineFields.KlantID);
        String OctID = SToAClient.getExternalOctopusID(SFID) + "";
        //if client exist
        RelationServiceData test=SToAClient.getClientByVATNr(importVAT);
        
        logtext += "SF ID: " + SFID + "SF mapped Oct ext ID: " + OctID ;
        logtext+=" SF mapped Oct internal ID: " + SToAClient.getClientFromExtID(OctID).getRelationKey().getId();
        logtext+="\n";
        if(test!=null){
            String vatMappedOctID = SToAClient.getClientByVATNr(importVAT).getExternalRelationNr() + "";
            logtext+= " VAT mapped ext Oct ID: " + vatMappedOctID;
            logtext+= " VAT mapped int Oct ID: " + SToAClient.getClientByVATNr(importVAT).getRelationKey().getId();
            
        }
        logtext+= "\n";
        System.out.println(logtext);
    }

    // parse all bookings with only valid fields and convert to a mapping
    // between document id and booking
    public static List<BuySellBookingServiceData> parseCorrectBookings(
            List<ConflictTabelRow> validBooking) {

        //DEBUG
        String logtext="";
        
        // Booking id mapped to a booking line
        Map<Integer, BuySellBookingServiceData> bookings = new HashMap<>();
        int startBookingNr = AppConstants.getStartBookingNr();
        for (ConflictTabelRow line : validBooking) {
            // get Octopus Client
            // because the client does or will exist in Octopus the client
            // optional info doesn't have to be added
            int factuurnNNr = Integer.parseInt(line
                    .getBookingLineField(BookingLineFields.FactuurNummer));
            String externalClientID = SToAClient.getExternalOctopusID(line
                    .getBookingLineField(BookingLineFields.KlantID));

            // first create a booking if none exists for this factuur nr
            // comment is client name
            if (!bookings.containsKey(factuurnNNr)) {
                bookings.put(
                        factuurnNNr,
                        WSDataObjectCreator.getNewBooking(startBookingNr + "",
                                externalClientID,
                                line.getBookingLineField(BookingLineFields.LandCode),
                                line.getBookingLineField(BookingLineFields.FactuurDatum),
                                line.getBookingLineField(BookingLineFields.VervalDatum),
                                line.getClientField(ClientFields.Naam),
                                line.getBookingLineField(BookingLineFields.Referentie)));
                startBookingNr++;
                //DEBUG
                addBookingToLog(logtext,line,bookings.get(factuurnNNr));
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

            double amount = 0;
            try {
                amount = SToAField.parseDouble((line
                        .getBookingLineField(BookingLineFields.BoekingBedragExclBTW)));
            } catch (NumberFormatException | ParseException ex) {
                OKNotificationWindow.openError("Booking: " + factuurnNNr + " has an unreadable booking amount. Please close app and change amount into correct format.", false);
            }
            double baseAmount = amount;
            boolean isCreditNote = false;
            //if credit note set abs value
            if (!line.getBookingLineField(BookingLineFields.CreditNotaNummer).equals("")) {
                isCreditNote = true;
                baseAmount = Math.abs(amount);
            }
            double vatAmount = SToABooking.getBookingVatAmount(baseAmount,
                    vatCodeKey);
            int acctKey = Integer.parseInt(line
                    .getBookingLineField(BookingLineFields.BookingAccountKey));

            BuySellBookingLineServiceData bookingLine = WSDataObjectCreator
                    .getBookingLine(acctKey, baseAmount, vatAmount, vatCodeKey,
                            line.getBookingLineField(BookingLineFields.Referentie) + "; " + line.getClientField(ClientFields.Naam));

            // add line to booking and update booking total
            WSDataObjectCreator.addBookingLineToBookingAndUpdateBookingAmount(booking, bookingLine, isCreditNote);

        }

        //convert to a sorted list
        SortedMap<Integer, BuySellBookingServiceData> sortedBookings = new TreeMap<>();
        for (Map.Entry<Integer, BuySellBookingServiceData> entry : bookings.entrySet()) {
            sortedBookings.put(entry.getValue().getDocumentSequenceNr(), entry.getValue());

        }
        //DEBUG
        System.out.println("test");
        System.out.println(logtext);
        
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
            case CreditNotaNummer:
                return true;
            default:
                return SToAField.isNotOptional(s);
        }
        // if an unknown field, show in log
    }

    public static double roundForVATAmount(double notRoundedVatAmount) {
        return Math.round(notRoundedVatAmount * 100.0d) / 100.0d;
    }

}
