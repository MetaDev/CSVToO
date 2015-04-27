package webcomm;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import model.AppConstants;
import model.CacheModel;

import webcomm.octws.AccountServiceData;
import webcomm.octws.BookyearServiceData;
import webcomm.octws.OctopusWS;

public class WSACache2 extends WSAcces {
	private static WSAcces instance;

	public WSACache2() {
		super("Caching booking accounts from chosen book year.");
	}

	@Override
	public void execute(OctopusWS port) {

		BookyearServiceData bookYear = AppConstants.getActiveBookYear();

		// cache the accounts that start with a 7, sales accounts
		List<AccountServiceData> accounts = port.getAccounts(bookYear
				.getBookyearKey());

		SortedMap<String, AccountServiceData> bookingAcounts = new TreeMap<>();

		for (int i = 0; i < accounts.size(); i++) {

			// add all account numbers starting with a 7
			if (String.valueOf(accounts.get(i).getAccountKey().getId())
					.startsWith("7")) {
				bookingAcounts.put(
						accounts.get(i).getAccountKey().getId() + "",
						accounts.get(i));
			}
		}
		CacheModel.setSalesBookingAccounts(bookingAcounts);
	}

	public static WSAcces getInstance() {
		if (instance == null)
			instance = new WSACache2();
		return instance;
	}

}
