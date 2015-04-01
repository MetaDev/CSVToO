package webcomm;


import model.AppConstants;
import salestoaccountinglogic.SToAField;

import webcomm.octws.BuySellBookingLineServiceData;
import webcomm.octws.BuySellBookingServiceData;
import webcomm.octws.RelationServiceData;

public class WSDataObjectCreator {

	public static BuySellBookingServiceData getNewBooking(String sequenceNumber,
			String externalClientID, String countryCode, String factuurDatum,
			String vervalDatum, String Commentaar, String Referentie) {

		// Maak een nieuw boeking object aan
		BuySellBookingServiceData booking = new BuySellBookingServiceData();

		// Dit is een boekjaar dat we verkregen hebben via getBookyears()
		booking.setBookyearKey(AppConstants.getActiveBookYear()
				.getBookyearKey());
		// Specifieer het dagboek - Dit dagboek dient te bestaan in Octopus
		// Lijst van dagboeken is op te vragen via getJournals()
		booking.setJournalKey(AppConstants.getActiveJournal().getJournalKey());
		// Het eerstvolgend nummer van het dagboek. De documenten moeten een
		// ononderbroken lijst zijn.
		// U kan enkel het document nummer ophogen in de applicatie.
		// Het laatst geboekt nummer kan u terug vinden in het dagboek via
		// getLastBookedDocumentNr()
		booking.setDocumentSequenceNr(Integer.parseInt(sequenceNumber));
		// Specifieer de boekjaar periode waarin de boeking dient gemaakt te
		// worden.
		// Deze dient tot het boekjaar te behoren.
		booking.setBookyearPeriodeNr(SToAField.getPeriodSuggestion(factuurDatum));
		// Specifieer het totaal bedrag van de boeking, nu nog niet van
		// toepassing aangezien nog boeking lijnen worden toegevoegd
		// booking.setAmount(FactuurBedrag);
		// Specifieer de muntcode
		booking.setCurrencyCode(AppConstants.muntCode);
		// Specifieer de wisselkoers
		booking.setExchangeRate(1.0);
		// Specifieer commentaar / lege string
		booking.setComment(Commentaar);
		// Specifieer een referentie - bvb gestructureerde mededeling
		booking.setReference(Referentie);
		// Specifieer de externe relatie
		booking.setExternalRelationId(Integer
				.parseInt(externalClientID));
		// Specifieer document en verval datum
	
		booking.setDocumentDate(SToAField.stringToXMLGregorianCalendar(factuurDatum));
		booking.setExpiryDate(SToAField.stringToXMLGregorianCalendar(vervalDatum));
		

		return booking;

	}

	public static void addBookingLineToBookingAndUpdateBookingAmount(
			BuySellBookingServiceData booking,
			BuySellBookingLineServiceData line, boolean isCreditNote) {
		// Voeg deze lijn toe aan de boeking
		booking.getBookingLines().add(line);

		// update the total amount of the booking
		// round the vat amount to 2 numbers after comma
		if (isCreditNote) {
			booking.setAmount(booking.getAmount()
					- (line.getBaseAmount() + line.getVatAmount()));
		} else {
			booking.setAmount(booking.getAmount()
					+ (line.getBaseAmount() + line.getVatAmount()));
		}
	}
	
	public static BuySellBookingLineServiceData getBookingLine(int accountKey,
			double baseAmount, double vatAmount, String vatCodeKey,
			String Comment) {
		// Maak een detail lijn aan
		BuySellBookingLineServiceData lineData = new BuySellBookingLineServiceData();
		// Specifieer de verkoopsboekingrekening
		lineData.setAccountKey(accountKey);
		// Specifieer het basisbedrag
		lineData.setBaseAmount(baseAmount);
		// Specifieer het btw bedrag
		lineData.setVatAmount(vatAmount);
		// Specifieer de btw code : Dit is een btwcode zoals deze is
		// gedefinieerd in de applicatie
		lineData.setVatCodeKey(vatCodeKey);
		// Specifieer een gepaste commentaar
		lineData.setComment(Comment);

		return lineData;

	}

	/*
	 * returns a octopus client object
	 */
	public static RelationServiceData getRelation(String externalID,
			String name, String sreetAndNumber, String postalCode, String city,
			String countryCode, String BTWNumber, String bookingAccount,
			String experiationDays, String language, String BTWPlichtigheid,
			String IBANNumber, String BICCode) {
		// Maak een nieuw relatie object aan
		RelationServiceData relation = new RelationServiceData();

		//maak relatie actief
		relation.setActive(true);
		// De relationKey is een interne key van het pakket. Wanneer een relatie
		// wordt toegevoegd dan
		// wordt deze key ingevuld door de webservice.
		relation.setRelationKey(null);
		// Geef de externe relatie id op. Dit is de identificatie die een
		// bepaalde relatie heeft in uw pakket.
		// Deze is belangrijk!
		relation.setExternalRelationNr(Integer.parseInt(externalID));
		// Specifieer de naam
		relation.setName(name);
		// Specifieer de vennootschapsvorm
		// Lijst van mogelijke waarden Zie RelationServiceData

		// Specifieer het adres
		relation.setStreetAndNr(sreetAndNumber);
		relation.setPostalCode(postalCode);
		relation.setCity(city);
		relation.setCountry(countryCode);

		// Bepaal of de relatie klant en/of leverancier is. Ten minste een van
		// beide moet true zijn
		relation.setClient(true);
		relation.setSupplier(false);
		// dropdown, rekening die begint met 7
		relation.setDefaultBookingAccountClient(Integer
				.parseInt(bookingAccount));

		// optioneel
		relation.setBicCode(BICCode);
		relation.setIbanAccountNr(IBANNumber);

		// Niet gebruikte velden
		relation.setCorporationType(0);
		relation.setEmail("");
		relation.setTelephone("");
		relation.setUrl("");
		relation.setBankAccountNr("");
		relation.setSearchField1("");
		relation.setSearchField2("");
		relation.setContactPerson("");
		relation.setMobile("");
		relation.setRemarks("");
		relation.setSurName("");
		relation.setFax("");

		// betaling verval type
		relation.setExpirationType(AppConstants.experitiationType);
		// Specifieer het aantal dagen
		relation.setExpirationDays(Integer.parseInt(experiationDays));

		relation.setFactLanguage(Integer.parseInt(language));

		// Specifieer btw nummer
		relation.setVatNr(BTWNumber);
		// Specifieer btw plichtigheid
		relation.setVatType(Integer.parseInt(BTWPlichtigheid));

		// Deze relatie zal toegevoegd worden wanneer er geen relatie bestaat
		// met dit extern relatie nummer.
		// Moest deze wel bestaan dan zal die relatie worden bijgewerkt met deze
		// gegevens.
		return relation;
	}

}
