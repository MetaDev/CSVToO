package salestoaccountinglogic;

import gui.component.custom.OKNotificationWindow;
import io.FileHandler;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import model.AppConstants;
import util.AppUtil;

//Here comes the code concerning, checking, parsing and converting fields
public class SToAField {

    // all fields in order from imported csv with booking lines
    public enum ImportFields {

        FactuurNummer, KlantID, Naam, StraatEnNummer, Postcode, Gemeente, Land, BTWNummer, FactuurDatum, VervalDatum, Referentie, BoekingBedragExclBTW, ShippingAndHandling, NrOfExperitiationDays, BTW6, BTW21
    }

    public enum VATLiability {

        ParticulierBelgium, ParticulierEurope, CorporationBelgium, CorporationEurope
    }

    // Specifieer de taal van de relatie : 0 - Nederlands , 1 - Frans , 2 -
    // Engels
    public enum Language {

        Dutch, French, English
    }

    // from country code to booking account id
    private static Map<String, String> bookingAccount = new HashMap<>();
    private static Map<String, String> countryCodeMapping = new HashMap<>();
    private static Map<String, String> languageMapping = new HashMap<>();
    private static Map<String, String> vatLiabilityNameMapping = new HashMap<>();

    /*
     * different for each client
     */
    public static String getBookingAccountSuggestion(String countryCode) {
        return bookingAccount.get(countryCode);
    }

    /*
     * all mapping initialisation is done here
     */
    public static void init() {
        // map Vat type on it's name
        vatLiabilityNameMapping
                .put("1", VATLiability.CorporationBelgium.name());
        vatLiabilityNameMapping.put("4", VATLiability.CorporationEurope.name());
        vatLiabilityNameMapping
                .put("7", VATLiability.ParticulierBelgium.name());
        vatLiabilityNameMapping.put("8", VATLiability.ParticulierEurope.name());

        // map English country name to ISO-2 letter Country Code
        List<String[]> countryCodes = FileHandler.parseCSV(AppUtil
                .mergeFolderAndFileName(AppConstants.countryCodeMapFile,
                        AppConstants.configDir));
        FileHandler.cacheCSVMapping(countryCodes, countryCodeMapping);
        // map country code to a language (int)
        List<String[]> languages = FileHandler.parseCSV(AppUtil
                .mergeFolderAndFileName(AppConstants.languageMapFile,
                        AppConstants.configDir));
        FileHandler.cacheCSVMapping(languages, languageMapping);
        // Map booking accounts from country code to booking account id
        List<String[]> bookingAccounts = FileHandler.parseCSV(AppUtil
                .mergeFolderAndFileName(AppConstants.bookingAccountMapFile,
                        AppConstants.configDir));
        FileHandler.cacheCSVMapping(bookingAccounts, bookingAccount);

    }

    public static String getVATLiabilityName(String vatType) {
        return vatLiabilityNameMapping.get(vatType);
    }

    public static String getVATLiabilityCodeByname(String vatName) {
        return AppUtil.getKeyByValue(vatLiabilityNameMapping, vatName);
    }

    public static String getLanguageSuggestionFromMapping(String countryCode) {
        return languageMapping.get(countryCode);
    }

    public static String getlanguagedescription(int languageCode) {
        return SToAField.Language.values()[languageCode].name();
    }

  

    public static String getCountryCodeFromCountryName(String countryName) {
        if (countryCodeMapping.containsKey(countryName)) {
            return countryCodeMapping.get(countryName);
        }
        return "Country code suggestion not found";
    }

    public static boolean isAlphaNumeric(String s) {
        return s.matches("^[a-zA-Z0-9]*$");
    }
 public static String getCountryCodeFromBTWNr(String BTWNr) {
        if (BTWNr.length() >= 2) {
            return BTWNr.substring(0, 2);
        }
        return "";
    }
    public static boolean isBTWNumber(String BTWNr) {
        if (BTWNr.length() < 2) {
            return false;
        }
        // X: a letter or digit; 9: a digit
        String countryCode = BTWNr.substring(0, 2);
        // 1 block of 10 digits (BE0999999999) or (BE1999999999) or
        // (BE999999999)
        if (countryCode.equals("BE")) {
            return BTWNr.matches("^BE[0-1][0-9]{9}$")
                    || BTWNr.matches("^BE[0-9]{9}$");
        } // 1 block of 12 characters (NL999999999B99)
        else if (countryCode.equals("NL")) {
            return BTWNr.matches("^NL[0-9]{9}B[0-9]{2}$");
        } // 1 block of 9 digits (DE999999999)
        else if (countryCode.equals("DE")) {
            return BTWNr.matches("^DE[0-9]{9}$");
        } // 1 block of 2 characters, 1 block of 9 digits (FRXX999999999)
        else if (countryCode.equals("FR")) {
            return BTWNr.matches("^FR[0-9A-Za-z]{2}[0-9]{9}$");
        } // 1 block of 9 characters (ESX9999999X)
        // The first and last characters may be alpha or numeric; but they may
        // not both be numeric.
        else if (countryCode.equals("ES")) {
            return BTWNr.matches("^ES[A-Za-z][0-9]{9}[A-Za-z]$")
                    || BTWNr.matches("^ES[0-9A-Za-z][0-9]{9}[A-Za-z]$")
                    || BTWNr.matches("^ES[A-Za-z][0-9]{9}[0-9A-Za-z]$");
        } // 1 block of 8 digits LU99999999
        else if (countryCode.equals("LU")) {
            return BTWNr.matches("^LU[0-9]{8}$");
        } // 12 characters
        else if (countryCode.equals("SE")) {
            return BTWNr.matches("^SE[0-9]{12}$");
       }
        else if (countryCodeMapping.containsValue(getCountryCodeFromBTWNr(BTWNr))){
            if (!AppConstants.BTWFormatNotSupportedMessage){
                OKNotificationWindow.openError("Country code found: " + getCountryCodeFromBTWNr(BTWNr)+ " but the BTW format is not supported, contact developper.",true);
                AppConstants.BTWFormatNotSupportedMessage=true;
            }
            return true;
        }
        // particulier so no BTW number, but it can't be empty
        else {
            return isBTWNrParticulier(BTWNr);
        }
    }

    public static Date parseDate(String s) {
        try {
            DateFormat SFFormat = new SimpleDateFormat("d/MM/yyyy");
            return SFFormat.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean isBTWNrParticulier(String BTWNr) {
        return BTWNr.equals(AppConstants.particulierCode);
    }

    public static XMLGregorianCalendar stringToXMLGregorianCalendar(String s) {
        XMLGregorianCalendar result = null;
        Date date;
        GregorianCalendar gregorianCalendar;

        date = parseDate(s);
        gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
        gregorianCalendar.setTime(date);
        try {
            result = DatatypeFactory.newInstance().newXMLGregorianCalendar(
                    gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static Double parseDouble(String s) throws NumberFormatException, ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        if (s.length() != 0) {
            Number number = format.parse(s);
            return number.doubleValue();
        }
        return (double) 0;

    }

    // Convert booking date (DD/MM/YYYY) to 201407 (YYYYMM)
    public static int getPeriodSuggestion(String date) {
        Date bookingDate = parseDate(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(bookingDate);
        // January is 0
        String period = cal.get(Calendar.YEAR) + ""
                + String.format("%02d", (cal.get(Calendar.MONTH) + 1));
        return Integer.parseInt(period);
    }

    // return BTWplichtigheid based on BTWnumber
    public static String getBTWPlichtigheid(String BTWNr, String countryName) {
        // particulier
        if (isBTWNrParticulier(BTWNr)) {
            // belg
            if (countryName.equals("Belgium")) {
                return "7";
            } // europees
            else {
                return "8";
            }
        } // Onderneming
        else {
            // belg
            if (BTWNr.startsWith("BE")) {
                return "1";
            } // europees
            else {
                return "4";
            }
        }

    }

    public static boolean isCorrectDate(String s) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            // to check if date can exist, eg. feb 31 2007 doesn't
            formatter.setLenient(false);
            formatter.parse(s);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number number = format.parse(s);
            double d = number.doubleValue();
        } catch (NumberFormatException | ParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isNotOptional(String s) {
        if (s == null) {
            return false;
        }
        return !s.equals("");
    }

    public static boolean hasMaximumLength(String s, int l) {
        return s.length() <= l;
    }

    public static String getMuntCode() {
        return AppConstants.muntCode;
    }

    public static boolean isCountryCode(String countryCode) {
        return countryCodeMapping.values().contains(countryCode);
    }

    /*
     * based on the amount of VAT payed, determine code
     */
    public static String getBTWCodeSuggestion(String BTW6, String BTW21) {
        //if something goes wrong with the parsing output default 00 code
        try {
            double btw6 = parseDouble(BTW6);
            double btw21 = parseDouble(BTW21);
            // 21
            if (btw21 != 0) {
                return "21";
            } // 6
            else if (btw6 != 0) {
                return "06";
            } else // intra communotaire
            if (btw6 == 0 && btw21 == 0) {
                return "CM";

            }
        } catch (Exception e) {

        }
        // error
        return "00";

    }

    /*
     * vat numbers received from webservice can contain dots which complicate
     * the error detecting
     */
    public static String removeDots(String s) {
        return s.replaceAll("\\.", "");
    }

}
