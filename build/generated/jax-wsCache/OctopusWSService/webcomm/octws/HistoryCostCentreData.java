
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for historyCostCentreData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="historyCostCentreData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountKey" type="{http://service.octopus.com/}accountKey" minOccurs="0"/>
 *         &lt;element name="accountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activeCostCentre" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="bookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="costCentreKey" type="{http://service.octopus.com/}costCentreKey" minOccurs="0"/>
 *         &lt;element name="costCentreName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditBookingAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="debetBookingAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="documentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="documentSequenceNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="journalKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationKey" type="{http://service.octopus.com/}relationKey" minOccurs="0"/>
 *         &lt;element name="relationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "historyCostCentreData", propOrder = {
    "accountKey",
    "accountName",
    "activeCostCentre",
    "bookyearKey",
    "bookyearPeriodNr",
    "comment",
    "costCentreKey",
    "costCentreName",
    "creditBookingAmount",
    "debetBookingAmount",
    "documentDate",
    "documentSequenceNr",
    "journalKey",
    "relationKey",
    "relationName"
})
public class HistoryCostCentreData {

    protected AccountKey accountKey;
    protected String accountName;
    protected boolean activeCostCentre;
    protected BookyearKey bookyearKey;
    protected int bookyearPeriodNr;
    protected String comment;
    protected CostCentreKey costCentreKey;
    protected String costCentreName;
    protected double creditBookingAmount;
    protected double debetBookingAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar documentDate;
    protected int documentSequenceNr;
    protected String journalKey;
    protected RelationKey relationKey;
    protected String relationName;

    /**
     * Gets the value of the accountKey property.
     * 
     * @return
     *     possible object is
     *     {@link AccountKey }
     *     
     */
    public AccountKey getAccountKey() {
        return accountKey;
    }

    /**
     * Sets the value of the accountKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountKey }
     *     
     */
    public void setAccountKey(AccountKey value) {
        this.accountKey = value;
    }

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the activeCostCentre property.
     * 
     */
    public boolean isActiveCostCentre() {
        return activeCostCentre;
    }

    /**
     * Sets the value of the activeCostCentre property.
     * 
     */
    public void setActiveCostCentre(boolean value) {
        this.activeCostCentre = value;
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
     * Gets the value of the costCentreKey property.
     * 
     * @return
     *     possible object is
     *     {@link CostCentreKey }
     *     
     */
    public CostCentreKey getCostCentreKey() {
        return costCentreKey;
    }

    /**
     * Sets the value of the costCentreKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostCentreKey }
     *     
     */
    public void setCostCentreKey(CostCentreKey value) {
        this.costCentreKey = value;
    }

    /**
     * Gets the value of the costCentreName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostCentreName() {
        return costCentreName;
    }

    /**
     * Sets the value of the costCentreName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostCentreName(String value) {
        this.costCentreName = value;
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
     * Gets the value of the relationKey property.
     * 
     * @return
     *     possible object is
     *     {@link RelationKey }
     *     
     */
    public RelationKey getRelationKey() {
        return relationKey;
    }

    /**
     * Sets the value of the relationKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationKey }
     *     
     */
    public void setRelationKey(RelationKey value) {
        this.relationKey = value;
    }

    /**
     * Gets the value of the relationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * Sets the value of the relationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationName(String value) {
        this.relationName = value;
    }

}
