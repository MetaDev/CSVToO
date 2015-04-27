package webcomm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


import model.CacheModel;

import webcomm.octws.BookyearServiceData;
import webcomm.octws.JournalServiceData;
import webcomm.octws.OctopusWS;
import webcomm.octws.RelationServiceData;
import webcomm.octws.VatCodeServiceData;

/*
 * This class contains all methods used to communicate with the Octopus WS
 * These methods will be executed after use of the program, flushing
 */
public class WSACache1 extends WSAcces {

	private static WSAcces instance;

	public WSACache1() {
		super("Please wait while the application caches existing data.");
	}

	// cache
	@Override
	public void execute(OctopusWS webService) {
		// retrieve all relations
		// filter out the relations that aren't needed, we only need clients
		Set<RelationServiceData> octClients = new HashSet<>();
		for (RelationServiceData relation : webService.getRelations()) {
			if (relation.isClient()) {
				octClients.add(relation);

			}
		}
		CacheModel.setOctClients(octClients);
		//Cache all bookyears and their respective journals
		Map<BookyearServiceData, List<JournalServiceData>> bookYearJournalMap = new HashMap<>();
		for (BookyearServiceData bookyear : webService.getBookyears()) {
			bookYearJournalMap.put(bookyear,
					webService.getJournals(bookyear.getBookyearKey()));
		}
		CacheModel.setAllBookYearsMappedToJournals(bookYearJournalMap);
		// cache VAT codes
		List<VatCodeServiceData> vatCodes = webService.getVatCodes();
		SortedMap<String, VatCodeServiceData> vatCodesMap = new TreeMap<>();
		for (int i = 0; i < vatCodes.size(); i++) {
			vatCodesMap.put(vatCodes.get(i).getCode(), vatCodes.get(i));
		}
		CacheModel.setVatCodes(vatCodesMap);
	}

	public static WSAcces getInstance() {
		if (instance == null)
			instance = new WSACache1();
		return instance;
	}

}
