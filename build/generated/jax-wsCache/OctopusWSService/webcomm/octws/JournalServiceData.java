
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for journalServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="journalServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="closed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="closedPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="journalKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastBookedDocumentNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="protectedPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "journalServiceData", propOrder = {
    "bookyearKey",
    "closed",
    "closedPeriod",
    "currencyCode",
    "journalKey",
    "lastBookedDocumentNr",
    "name",
    "protectedPeriod"
})
public class JournalServiceData {

    protected BookyearKey bookyearKey;
    protected boolean closed;
    protected int closedPeriod;
    protected String currencyCode;
    protected String journalKey;
    protected int lastBookedDocumentNr;
    protected String name;
    protected int protectedPeriod;

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
     * Gets the value of the closed property.
     * 
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * Sets the value of the closed property.
     * 
     */
    public void setClosed(boolean value) {
        this.closed = value;
    }

    /**
     * Gets the value of the closedPeriod property.
     * 
     */
    public int getClosedPeriod() {
        return closedPeriod;
    }

    /**
     * Sets the value of the closedPeriod property.
     * 
     */
    public void setClosedPeriod(int value) {
        this.closedPeriod = value;
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
     * Gets the value of the lastBookedDocumentNr property.
     * 
     */
    public int getLastBookedDocumentNr() {
        return lastBookedDocumentNr;
    }

    /**
     * Sets the value of the lastBookedDocumentNr property.
     * 
     */
    public void setLastBookedDocumentNr(int value) {
        this.lastBookedDocumentNr = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the protectedPeriod property.
     * 
     */
    public int getProtectedPeriod() {
        return protectedPeriod;
    }

    /**
     * Sets the value of the protectedPeriod property.
     * 
     */
    public void setProtectedPeriod(int value) {
        this.protectedPeriod = value;
    }

}
