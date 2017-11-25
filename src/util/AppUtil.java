package util;

import io.FileHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.datatype.XMLGregorianCalendar;

import model.AppConstants;
import salestoaccountinglogic.SToAClient;

import webcomm.octws.BuySellBookingLineServiceData;
import webcomm.octws.BuySellBookingServiceData;
import webcomm.octws.RelationServiceData;

public class AppUtil {

	public static String mergeFolderAndFileName(String fileName, String folder) {
		return folder + "/" + fileName;
	}

	// when reading UTF-8 there's a BOM in the file, a
	public static void printLine(String[] line) {
		for (String field : line)
			System.out.print(field + ",");
		System.out.println();
	}

	public static List<String> splitTextByNumber(int number, String text) {
		List<String> strings = new ArrayList<String>();
		int index = 0;
		while (index < text.length()) {
			strings.add(text.substring(index,
					Math.min(index + 4, text.length())));
			index += 4;
		}
		return strings;

	}

	public static <E extends Enum<E>> String[] getNamesFromEnum(
			Class<E> enumData) {
		String names[] = new String[enumData.getEnumConstants().length];
		for (int i = 0; i < names.length; i++) {
			names[i] = enumData.getEnumConstants()[i].name();
		}

		return names;
	}

	public static String printRelation(RelationServiceData relation) {
		String relationDescription = "";
		relationDescription += "Client " + relation.getName() + " Oct Ext NR "
				+ relation.getExternalRelationNr() ;
				
		relationDescription += "Adress: " + relation.getStreetAndNr() + ", "
				+ relation.getCity() + " " + relation.getCountry() + '\n';
		relationDescription += "Info: booking account: "
				+ relation.getDefaultBookingAccountClient() + "; Vat type: "
				+ relation.getVatType() +
                                "; VAT nr:"+ relation.getVatNr() +"\n\n";
		return relationDescription;
	}

	public static String printBooking(BuySellBookingServiceData booking) {
		String bookingDescription = "";
		bookingDescription += "Booking for "
				+ SToAClient.getClientFromExtID(
						booking.getExternalRelationId() + "").getName()
                        + "with VAT: "+SToAClient.getClientFromExtID(
						booking.getExternalRelationId() + "").getVatNr()
                        + "with ext Oct nr: "+
						booking.getExternalRelationId()
				+ " with number: " + booking.getDocumentSequenceNr() + '\n';
		bookingDescription += "date: "
				+ printXMLCalendar(booking.getDocumentDate())
				+ "; expiry date: " + printXMLCalendar(booking.getExpiryDate())
				+ " perdiod: " + booking.getBookyearPeriodeNr() + '\n';
		bookingDescription += "reference: " + booking.getReference() + '\n';
		bookingDescription += "total amount: "
				+ printAmountEuro(booking.getAmount()) + "\n\n";
		for (BuySellBookingLineServiceData bookingLine : booking
				.getBookingLines()) {
			bookingDescription += "Line;\nbase amount: "
					+ printAmountEuro(bookingLine.getBaseAmount())
					+ "; vat amount: "
					+ printAmountEuro(bookingLine.getVatAmount()) + '\n';
			bookingDescription += "comment: " + bookingLine.getComment() + '\n';
		}
		bookingDescription += "\n\n";
		return bookingDescription;
	}

	public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
		for (Entry<T, E> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static String printAmountEuro(double d) {
		return new DecimalFormat("#0.00").format(d) + " Euro";
	}

	public static String printXMLCalendar(XMLGregorianCalendar calendar) {
		return calendar.getDay() + "/" + calendar.getMonth() + "/"
				+ calendar.getYear();
	}

	public static String printAllBookings(String header,
			List<BuySellBookingServiceData> toPrintBookings) {
		String bookingsInText=header;
		for (BuySellBookingServiceData booking : toPrintBookings) {
			bookingsInText += AppUtil.printBooking(booking);
		}
		return bookingsInText;
	}
	public static String printAllClients(String header,
			Collection<RelationServiceData> toPrintRelations){
		String relationsInText=header;
		for (RelationServiceData relation : new ArrayList<>(toPrintRelations)) {
			relationsInText += AppUtil.printRelation(relation);
		}
		return relationsInText;
	}
	public static void saveToLog(String message){
		String logText = new Date().toString() + message;
		FileHandler.appendToFile(AppUtil.mergeFolderAndFileName(
				AppConstants.logFile, AppConstants.logDir), logText);
	}
}
