package model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import salestoaccountinglogic.SToAClient;

import webcomm.octws.AccountServiceData;
import webcomm.octws.BookyearServiceData;
import webcomm.octws.JournalServiceData;
import webcomm.octws.RelationServiceData;
import webcomm.octws.VatCodeServiceData;

/*
 * Contains all cached data
 * as well from local data as from online data
 * try to save only what's necessary
 */
public class CacheModel {

	private static SortedMap<String, VatCodeServiceData> vatCodes;
	private static SortedMap<String, AccountServiceData> salesBookingAccounts;
	// cache all journals of current BookYear
	// Map these Journal to their respective key

	private static Map<BookyearServiceData, List<JournalServiceData>> allBookYearsMappedToJournals;
	private static Set<RelationServiceData> octClients;

	public static Map<BookyearServiceData, List<JournalServiceData>> getAllBookYearsMappedToJournals() {
		return allBookYearsMappedToJournals;
	}

	public static void setAllBookYearsMappedToJournals(
			Map<BookyearServiceData, List<JournalServiceData>> allBookYearsMappedToJournals) {
		CacheModel.allBookYearsMappedToJournals = allBookYearsMappedToJournals;
	}

	

	public static SortedMap<String, AccountServiceData> getSalesBookingAccounts() {
		return salesBookingAccounts;
	}

	public static void setSalesBookingAccounts(
			SortedMap<String, AccountServiceData> salesBookingAccounts) {
		CacheModel.salesBookingAccounts = salesBookingAccounts;
	}

	public static Map<String, VatCodeServiceData> getVatCodes() {
		return vatCodes;
	}

	public static void setVatCodes(SortedMap<String, VatCodeServiceData> vatCodes) {
		CacheModel.vatCodes = vatCodes;
	}

	

	public static Set<RelationServiceData> getClients() {
		return octClients;
	}

	public static void setOctClients(Set<RelationServiceData> octClients) {
		CacheModel.octClients = octClients;
		SToAClient.addCachedClients(octClients);
	}

	
}
