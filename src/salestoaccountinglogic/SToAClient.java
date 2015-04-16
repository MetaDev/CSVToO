package salestoaccountinglogic;

import fr.marcwrobel.jbanking.bic.Bic;
import fr.marcwrobel.jbanking.iban.Iban;
import gui.component.custom.OKNotificationWindow;
import io.FileHandler;
import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.AppConstants;
import model.CacheModel;
import model.ConflictTabelRow;
import util.AppUtil;

import webcomm.octws.RelationServiceData;

public class SToAClient {

    // key is Import id , value Octopus external id

    public static Map<String, String> clientsMapping = new HashMap<>();
    // key is Import id , value Octopus external id
    public static Map<String, String> newClientsMapping = new HashMap<>();

    public static Set<RelationServiceData> allClients = new HashSet<>();

    // new clients, to be used when uploading
    private static Set<RelationServiceData> newOrEditedClients = new HashSet<>();

    public static RelationServiceData getClientFromExtID(String extID) {
        if (extID == null) {
            return null;
        }
        for (RelationServiceData relation : allClients) {
            if ((relation.getExternalRelationNr() + "").equals(extID)) {
                return relation;
            }
        }
        return null;
    }

    public static RelationServiceData getClientFromExtID(int extID) {
        if (extID == 0) {
            return null;
        }
        for (RelationServiceData relation : allClients) {
            if ((relation.getExternalRelationNr() == extID)) {
                return relation;
            }
        }
        return null;
    }

    public static boolean clientHasMapping(RelationServiceData client) {
        return clientsMapping
                .containsValue(client.getExternalRelationNr() + "");
    }

    /*
     * Use this method when adding a new or edited clients
     */
    public static void addNewOrEditedClient(RelationServiceData client) {
        allClients.add(client);
        newOrEditedClients.add(client);
    }

    /*
     * When creating a new client, check with this method first if a client with
     * this VATNr doesn't already exist
     */
    public static RelationServiceData getClientByVATNr(String VATnr) {
        // private clients don't need a VAT nr
        if (isPrivate(VATnr)) {
            return null;
        }
        for (RelationServiceData client : allClients) {
            if (VATnr.equals(SToAField.removeBTWFormatting(client.getVatNr()))) {
                return client;
            }
        }
        return null;
    }

    /*
     * Use this method to save already existing clients
     */
    public static void addCachedClients(Collection<RelationServiceData> clients) {
        Set<RelationServiceData> clientsWithoutExtID = new HashSet<>();
        // seperate clients with and without ext ID
        for (RelationServiceData client : clients) {

            if (client.getExternalRelationNr() == 0) {
                clientsWithoutExtID.add(client);
				// should the client contain null data this method will fix such
                // that its uploadable
                SToAClient.fixUnUploadableClient(client);
            } else {
                addCachedClient(client);
            }
        }
        // give clients without ext ID a valid ID
        for (RelationServiceData client : clientsWithoutExtID) {
            client.setExternalRelationNr(getValidExternalID());
            // add edited client
            addNewOrEditedClient(client);
        }

    }

    public static Set<RelationServiceData> getAllClients() {
        return allClients;
    }

    public static Set<RelationServiceData> getNewOrEditedClients() {
        return newOrEditedClients;
    }

    /*
     * If a cached client has an ext ID, add
     */
    private static void addCachedClient(RelationServiceData client) {
        allClients.add(client);
    }

    /*
     * some client have no country code or miss some address data, this method
     * replaces the null data with empty string these clients can't be used to
     * link they don't contain correct data. It's just to allow the upload of
     * clients.
     */
	// TODO maybe find country code based on import or vat number
    //return which field was wrong in string
    public static String fixUnUploadableClient(RelationServiceData client) {
        if (client.getCity() == null) {
            client.setCity("");
        }
        if (client.getCountry() == null) {
            client.setCountry("");
        }
        if (client.getPostalCode() == null) {
            client.setPostalCode("");
        }
        if (client.getStreetAndNr() == null) {
            client.setStreetAndNr("");
        }
        return "";
    }

    public static void completeUnvalidClient(RelationServiceData client,
            ConflictTabelRow row) {
        if (!SToAField.isCountryCode(client.getCountry())) {
            client.setCountry(row.getClientField(ClientFields.LandCode));
            OKNotificationWindow.openWarning("Invalid country code is fixed, based on import line.");
        }
        OKNotificationWindow.openWarning("No fixable invalid field found");
		//TODO autocomple vat number too
        //complete all mandatory fields if possible
    }

    /*
     * When adding new client this method is used to retrieve a valid extID
     */
    public static int getValidExternalID() {
        // valid ext ID's start with 1
        int i = 1;
        while (i < Integer.MAX_VALUE) {
            // ID not yet used
            if (getClientFromExtID(i) == null) {
                return i;
            }
            i++;
        }
        // more clients than Integer values from 1 to MAX
        return 0;
    }

    public static boolean clientIsValid(RelationServiceData client) {
        // check Octopusexternalid, VATNR,CountryCode,IBanNr,BicCode
        if (!fieldIsValid(client, ClientFields.OctopusExternalID,
                client.getExternalRelationNr() + "")) {
            return false;
        }
        // an Octopus relation object returns a formatted VAT nr
        if (!fieldIsValid(client, ClientFields.BTWNummer,
                SToAField.removeDots(client.getVatNr()))) {
            return false;
        }
        if (!fieldIsValid(client, ClientFields.LandCode, client.getCountry())) {
            return false;
        }
        if (!fieldIsValid(client, ClientFields.IBANNummer,
                client.getIbanAccountNr())) {
            return false;
        }
        if (!fieldIsValid(client, ClientFields.BICCODE, client.getBicCode())) {
            return false;
        }
        return true;
    }

    public static void init() {
        // build client mapping
        List<String[]> clientMapLines = FileHandler
                .parseCSVCommaAndQuotes(AppUtil.mergeFolderAndFileName(
                                AppConstants.clientMapFile, AppConstants.configDir));
        FileHandler.cacheCSVMapping(clientMapLines, clientsMapping);

    }

    public static String getExternalOctopusID(String clientID) {
        return clientsMapping.get(clientID);
    }

    public static String getClientLanguageSuggestion(String countryCode) {
        String language = SToAField
                .getLanguageSuggestionFromMapping(countryCode);
        if (language == null) {
            language = AppConstants.defaultLanguage;
        }
        return language;

    }

    public static void addNewClientMapping(String importID,
            RelationServiceData client) {
        // insert new intended mapping
        clientsMapping.put(importID, client.getExternalRelationNr() + "");
        newClientsMapping.put(importID, client.getExternalRelationNr() + "");

    }

    public static Map<String, String> getNewClientsMapping() {
        return newClientsMapping;
    }

    public static Set<RelationServiceData> getToUploadValidRelations() {

        Set<RelationServiceData> toUploadRelation = new HashSet<>();
        for (RelationServiceData client : newOrEditedClients) {
            // only upload linked new clients
            if (!CacheModel.getClients().contains(client)) {
                if (clientHasMapping(client)) {
                    toUploadRelation.add(client);
                }
            } // or edited existing clients
            else {
                toUploadRelation.add(client);
            }

        }

        return toUploadRelation;
    }

    public static Map<String, String> getClientsMapping() {
        return clientsMapping;
    }

   // all mapped clients are saved in map so overwrite
    public static void saveClientMapping() {
        FileHandler.flushCSVMapping(clientsMapping, new String[]{"ClientID",
            "OctopusExternalClientID"}, AppUtil.mergeFolderAndFileName(
                AppConstants.clientMapFile, AppConstants.configDir));
    }

    public static List<String> getAllClientIDsLinkedToOctID(String octID) {
        List<String> foundIDs = new ArrayList<>();
        for (Entry<String, String> link : clientsMapping.entrySet()) {
            if (link.getValue().equals(octID)) {
                foundIDs.add(link.getKey());
            }
        }
        return foundIDs;
    }

    public static void removeClientLinksFromFailedUploadClients(List<String> failedClientUploadOctID) {
        //remove all links to failed upload clients
        for (String octID : failedClientUploadOctID) {
            //System.out.println("Client with external Octopus ID: "+octID+ " failed.");
            for (String clientID : getAllClientIDsLinkedToOctID(octID)) {
                clientsMapping.remove(clientID);
            }
        }
    }

    // return wether a client is private or corporate

    public static boolean isPrivate(RelationServiceData client) {
        return client.getName().startsWith(AppConstants.particulierCode);
    }

    // return wether a client is private or corporate
    public static boolean isPrivate(String clientCode) {
        return clientCode.startsWith(AppConstants.particulierCode);
    }

    // use to validate a client after change is made in the edit window
    public static boolean fieldIsValid(RelationServiceData client,
            ClientFields field, String s) {
		// the client is private if it's names starts with the private
        // code
        if (client.getName().startsWith(AppConstants.particulierCode)) {
            switch (field) {
                case BTWNummer:
                    return true;
            }
        }

        switch (field) {
            case OctopusExternalID:
                return (SToAField.isInteger(s)) && SToAField.isNotOptional(s);
            case BTWNummer:
                return (SToAField.isBTWNumber(s)) && SToAField.isNotOptional(s);
            case NrOfExperitiationDays:
                return (SToAField.isInteger(s)) && SToAField.isNotOptional(s);
            case LandCode:
                return SToAField.isCountryCode(s) || !SToAField.isNotOptional(s);
            case IBANNummer:
                return Iban.isValid(s) || !SToAField.isNotOptional(s);
            case BICCODE:
                return Bic.isValid(s) || !SToAField.isNotOptional(s);
            default:
                return true;
        }

    }

    // used in edit client window
    public static boolean fieldIsValid(ClientFields field, String s) {

        switch (field) {
            case OctopusExternalID:
                return (SToAField.isInteger(s)) && SToAField.isNotOptional(s);
            case BTWNummer:
                return (SToAField.isBTWNumber(s)) && SToAField.isNotOptional(s);
            case NrOfExperitiationDays:
                return (SToAField.isInteger(s)) && SToAField.isNotOptional(s);
            case LandCode:
                return SToAField.isCountryCode(s);
            case IBANNummer:
                return Iban.isValid(s) || !SToAField.isNotOptional(s);
            case BICCODE:
                return Bic.isValid(s) || !SToAField.isNotOptional(s);
            default:
                return true;
        }

    }

    // all fields that are filled when creating new client
    public enum ClientFields {

        OctopusExternalID, Naam, StraatEnNummer, Postcode, Gemeente, LandCode, BTWNummer, IBANNummer, BICCODE, BookingAccount, NrOfExperitiationDays, Language, BTWPlichtigheid
    }
}
