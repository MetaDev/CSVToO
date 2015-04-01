package model;

import webcomm.octws.BookyearServiceData;
import webcomm.octws.JournalServiceData;

//save all enums, filenames from config, ... here
public class AppConstants {

	public static final String configDir = "config";
	public static final String clientMapFile = "clientMap.csv";
	public static final String bookingAccountMapFile = "bookingAccountMap.csv";
	public static final String countryCodeMapFile = "countryCodeMap.csv";
	public static final String languageMapFile = "languageMap.csv";
	public static final String preferenceFile = "preferences.csv";
	public static final String muntCode = "EUR";
	public static final String particulierCode = "Particulier";
	public static String defaultLanguage = "2";
	public static final String shippingAndHandlingReference = "Shipping and Handling";
	private static String userName = "";
	private static String passWord = "";
	public static String logFile = "log.txt";
	public static String logDir = "log";
	private static JournalServiceData activeJournal;
	private static BookyearServiceData activeBookYear;

	public static void setActiveBookYearAndJournal(
			BookyearServiceData activeBookYear, JournalServiceData journal) {
		AppConstants.activeJournal = journal;
		AppConstants.activeBookYear = activeBookYear;
	}

	public static JournalServiceData getActiveJournal() {
		return activeJournal;
	}

	public static BookyearServiceData getActiveBookYear() {
		return activeBookYear;
	}

	public static int getStartBookingNr() {
		return activeJournal.getLastBookedDocumentNr() + 1;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		AppConstants.userName = userName;
	}

	public static String getPassWord() {
		return passWord;
	}

	public static void setPassWord(String passWord) {
		AppConstants.passWord = passWord;
	}

	// Specifieer het verval dag type : 1 - Einde maand , 2 - na factuur
	public static final int experitiationType = 2;

}
