
package webcomm.octws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for financialDiversBookingServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialDiversBookingServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingLines" type="{http://service.octopus.com/}financialDiversBookingLineServiceData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="bookyearPeriodeNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="documentSequenceNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="journalKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialDiversBookingServiceData", propOrder = {
    "bookingLines",
    "bookyearKey",
    "bookyearPeriodeNr",
    "documentDate",
    "documentSequenceNr",
    "exchangeRate",
    "journalKey"
})
public class FinancialDiversBookingServiceData {

    @XmlElement(nillable = true)
    protected List<FinancialDiversBookingLineServiceData> bookingLines;
    protected BookyearKey bookyearKey;
    protected int bookyearPeriodeNr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar documentDate;
    protected int documentSequenceNr;
    protected double exchangeRate;
    protected String journalKey;

    /**
     * Gets the value of the bookingLines property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bookingLines property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBookingLines().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialDiversBookingLineServiceData }
     * 
     * 
     */
    public List<FinancialDiversBookingLineServiceData> getBookingLines() {
        if (bookingLines == null) {
            bookingLines = new ArrayList<FinancialDiversBookingLineServiceData>();
        }
        return this.bookingLines;
    }

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
     * Gets the value of the bookyearPeriodeNr property.
     * 
     */
    public int getBookyearPeriodeNr() {
        return bookyearPeriodeNr;
    }

    /**
     * Sets the value of the bookyearPeriodeNr property.
     * 
     */
    public void setBookyearPeriodeNr(int value) {
        this.bookyearPeriodeNr = value;
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

}
