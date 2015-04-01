
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for historyData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="historyData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="bookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditBookingAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="creditDocumentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="debetBookingAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="debetDocumentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="documentSequenceNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="journalKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "historyData", propOrder = {
    "bookyearKey",
    "bookyearPeriodNr",
    "comment",
    "creditBookingAmount",
    "creditDocumentAmount",
    "currencyCode",
    "debetBookingAmount",
    "debetDocumentAmount",
    "documentDate",
    "documentSequenceNr",
    "exchangeRate",
    "journalKey",
    "reference"
})
public class HistoryData {

    protected BookyearKey bookyearKey;
    protected int bookyearPeriodNr;
    protected String comment;
    protected double creditBookingAmount;
    protected double creditDocumentAmount;
    protected String currencyCode;
    protected double debetBookingAmount;
    protected double debetDocumentAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar documentDate;
    protected int documentSequenceNr;
    protected double exchangeRate;
    protected String journalKey;
    protected String reference;

    /**
     * Gets the value of the bookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getBookyearKey() {
        return bookyearKey;
    }

    /**
     * Sets the value of the bookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setBookyearKey(BookyearKey value) {
        this.bookyearKey = value;
    }

    /**
     * Gets the value of the bookyearPeriodNr property.
     * 
     */
    public int getBookyearPeriodNr() {
        return bookyearPeriodNr;
    }

    /**
     * Sets the value of the bookyearPeriodNr property.
     * 
     */
    public void setBookyearPeriodNr(int value) {
        this.bookyearPeriodNr = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the creditBookingAmount property.
     * 
     */
    public double getCreditBookingAmount() {
        return creditBookingAmount;
    }

    /**
     * Sets the value of the creditBookingAmount property.
     * 
     */
    public void setCreditBookingAmount(double value) {
        this.creditBookingAmount = value;
    }

    /**
     * Gets the value of the creditDocumentAmount property.
     * 
     */
    public double getCreditDocumentAmount() {
        return creditDocumentAmount;
    }

    /**
     * Sets the value of the creditDocumentAmount property.
     * 
     */
    public void setCreditDocumentAmount(double value) {
        this.creditDocumentAmount = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the debetBookingAmount property.
     * 
     */
    public double getDebetBookingAmount() {
        return debetBookingAmount;
    }

    /**
     * Sets the value of the debetBookingAmount property.
     * 
     */
    public void setDebetBookingAmount(double value) {
        this.debetBookingAmount = value;
    }

    /**
     * Gets the value of the debetDocumentAmount property.
     * 
     */
    public double getDebetDocumentAmount() {
        return debetDocumentAmount;
    }

    /**
     * Sets the value of the debetDocumentAmount property.
     * 
     */
    public void setDebetDocumentAmount(double value) {
        this.debetDocumentAmount = value;
    }

    /**
     * Gets the value of the documentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets the value of the documentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocumentDate(XMLGregorianCalendar value) {
        this.documentDate = value;
    }

    /**
     * Gets the value of the documentSequenceNr property.
     * 
     */
    public int getDocumentSequenceNr() {
        return documentSequenceNr;
    }

    /**
     * Sets the value of the documentSequenceNr property.
     * 
     */
    public void setDocumentSequenceNr(int value) {
        this.documentSequenceNr = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     */
    public void setExchangeRate(double value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the journalKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournalKey() {
        return journalKey;
    }

    /**
     * Sets the value of the journalKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournalKey(String value) {
        this.journalKey = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

}
