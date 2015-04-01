package salestoaccountinglogic;

import io.FileHandler;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import model.AppConstants;
import util.AppUtil;

//Here comes the code concerning, checking, parsing and converting fields
public class SToAField {
	// all fields in order from imported csv with booking lines
	public enum ImportFields {
		FactuurNummer, KlantID, Naam, StraatEnNummer, Postcode, Gemeente, LandCode, BTWNummer, FactuurDatum, VervalDatum, Opmerking, Referentie, BoekingBedragExclBTW, BTWCode, Betalingswijze
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
	private static Map<String, String> languageMapping = new HashMap<>();
	private static Map<String, String> vatLiabilityNameMapping = new HashMap<>();
	private static Set<String> countryCodes = new HashSet<>();

	/*
	 * different for each client
	 */
	// client specific
	public static String getBookingAccountSuggestion(String countryCode) {
		return "700000";
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

		// map country code to a language (int)
		List<String[]> languages = FileHandler.parseCSVCommaAndQuotes(AppUtil
				.mergeFolderAndFileName(AppConstants.languageMapFile,
						AppConstants.configDir));
		FileHandler.cacheCSVMapping(languages, languageMapping);
		// Save all correct iso 2 country codes
		countryCodes.addAll(Arrays.asList(Locale.getISOCountries()));

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

	public static boolean isAlphaNumeric(String s) {
		return s.matches("^[a-zA-Z0-9]*$");
	}

	public static boolean isBTWNumber(String BTWNr) {
		if (BTWNr.length() < 2)
			return false;
		// X: a letter or digit; 9: a digit
		String countryCode = BTWNr.substring(0, 2);
		// 1 block of 10 digits (BE0999999999) or (BE1999999999) or
		// (BE999999999)
		if (countryCode.equals("BE")) {
			return BTWNr.matches("^BE[0-1][0-9]{9}$")
					|| BTWNr.matches("^BE[0-9]{9}$");
		}
		// 1 block of 12 characters (NL999999999B99)
		else if (countryCode.equals("NL")) {
			return BTWNr.matches("^NL[0-9]{9}B[0-9]{2}$");
		}
		// 1 block of 9 digits (DE999999999)
		else if (countryCode.equals("DE")) {
			return BTWNr.matches("^DE[0-9]{9}$");
		}
		// 1 block of 2 characters, 1 block of 9 digits (FRXX999999999)
		else if (countryCode.equals("FR")) {
			return BTWNr.matches("^FR[0-9A-Za-z]{2}[0-9]{9}$");
		}
		// 1 block of 9 characters (ESX9999999X)
		// The first and last characters may be alpha or numeric; but they may
		// not both be numeric.
		else if (countryCode.equals("ES")) {
			return BTWNr.matches("^ES[A-Za-z][0-9]{9}[A-Za-z]$")
					|| BTWNr.matches("^ES[0-9A-Za-z][0-9]{9}[A-Za-z]$")
					|| BTWNr.matches("^ES[A-Za-z][0-9]{9}[0-9A-Za-z]$");
		}
		// 1 block of 8 digits LU99999999
		else if (countryCode.equals("LU")) {
			return BTWNr.matches("^LU[0-9]{8}$");
		}
		// 1 block of 8 digits SI99999999
		else if (countryCode.equals("SI")) {
			return BTWNr.matches("^SI[0-9]{8}$");
		} else if (countryCode.equals("AT")) {
			return BTWNr.matches("^ATU[0-9]{9}$");
		} else if (countryCode.equals("BG")) {
			return BTWNr.matches("^BG[0-9]{9}$")
					|| BTWNr.matches("^BG[0-9]{10}$");
		} else if (countryCode.equals("CY")) {
			return BTWNr.matches("^CY[0-9]{9}$");
		} else if (countryCode.equals("CZ")) {
			return BTWNr.matches("^CZ[0-9]{8}$")
					|| BTWNr.matches("^CZ[0-9]{9}$")
					|| BTWNr.matches("^CZ[0-9]{10}$");
		} else if (countryCode.equals("EE")) {
			return BTWNr.matches("^EE[0-9]{9}$");
		} else if (countryCode.equals("EL")) {
			return BTWNr.matches("^EL[0-9]{9}$");
		} else if (countryCode.equals("FI")) {
			return BTWNr.matches("^FI[0-9]{8}$");
		} else if (countryCode.equals("GB")) {
			return BTWNr.matches("^GB[0-9]{3} [0-9]{4} [0-9]{2}$")
					|| BTWNr.matches("^GB[0-9]{3} [0-9]{4} [0-9]{2} [0-9]{3}$")
					|| BTWNr.matches("^GBGD[0-9]{3}$")
					|| BTWNr.matches("^GBHA[0-9]{3}$");
		} else if (countryCode.equals("HR")) {
			return BTWNr.matches("^HR[0-9]{11}$");
		} else if (countryCode.equals("HU")) {
			return BTWNr.matches("^HU[0-9]{8}$");
		} else if (countryCode.equals("IE")) {
			return BTWNr.matches("^IE[0-9]S[0-9]{5}L$")
					|| BTWNr.matches("^IE[0-9]{5}WI$");
		} else if (countryCode.equals("IT")) {
			return BTWNr.matches("^IT[0-9]{11}$");
		} else if (countryCode.equals("LT")) {
			return BTWNr.matches("^LT[0-9]{9}$")
					|| BTWNr.matches("^LT[0-9]{12}$");
		} else if (countryCode.equals("LV")) {
			return BTWNr.matches("^LV[0-9]{11}$");
		} else if (countryCode.equals("MT")) {
			return BTWNr.matches("^MT[0-9]{8}$");
		} else if (countryCode.equals("PL")) {
			return BTWNr.matches("^PL[0-9]{10}$");
		} else if (countryCode.equals("PT")) {
			return BTWNr.matches("^HR[0-9]{9}$");
		} else if (countryCode.equals("RO")) {
			return BTWNr.matches("^HR[0-9]{2,10}$");
		} else if (countryCode.equals("SE")) {
			return BTWNr.matches("^HR[0-9]{13}$");
		} else if (countryCode.equals("SI")) {
			return BTWNr.matches("^HR[0-9]{8}$");
		} else if (countryCode.equals("SL")) {
			return BTWNr.matches("^HR[0-9]{10}$");
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

	public static String removeBTWFormatting(String BTWNr) {
		return parseAlphaNumeric(BTWNr);
	}

	public static String parseAlphaNumeric(String alphaNum) {
		return alphaNum.replaceAll("[^0-9A-Z]", "");
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

	public static String getNumerOfExperiationDays(String[] importLine) {
		String betalingsWijze = importLine[ImportFields.Betalingswijze
				.ordinal()];
		// contant payment
		if (betalingsWijze.equals("KON") || betalingsWijze.equals("ADV"))
			return "0";
		return parseNumeric(betalingsWijze);
	}

	public static String parseNumeric(String stringWithNumeric) {
		return stringWithNumeric.replaceAll("[^0-9]", "");
	}

	public static Double parseDouble(String s) {
		try {
			NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
			Number number = format.parse(s);
			return number.doubleValue();
		} catch (NumberFormatException | ParseException e) {
			return null;
		}
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
	public static String getBTWPlichtigheid(String BTWNr, String landCode) {
		// particulier
		if (isBTWNrParticulier(BTWNr)) {
			// belg
			if (landCode.equals("BE")) {
				return "7";
			}
			// europees
			else {
				return "8";
			}
		}
		// Onderneming
		else {
			// belg
			if (landCode.equals("BE")) {
				return "1";
			}
			// europees
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
		if (s == null)
			return false;
		return !s.equals("");
	}

	public static boolean hasMaximumLength(String s, int l) {
		return s.length() <= l;
	}

	public static String getMuntCode() {
		return AppConstants.muntCode;
	}

	public static boolean isCountryCode(String countryCode) {
		return countryCodes.contains(countryCode);
	}

	/*
	 * based on the amount of VAT payed, determine code
	 */
	public static String getBTWCodeSuggestion(String importBTWCode) {
		// only INCO needs to be translated
		if (importBTWCode.equals("INCO")) {
			return "CM";
		}
		return importBTWCode;
	}

	/*
	 * remove everything except numbers comma's and negative signs
	 */
	public static String parseAmountFromStringWithCurrency(
			String amountWithCurrency) {
		return amountWithCurrency.replaceAll("[^0-9,.-]", "");
	}

	/*
	 * vat numbers received from webservice can contain dots which complicate
	 * the error detecting
	 */
	public static String removeDots(String s) {
		return s.replaceAll("\\.", "");
	}

}
