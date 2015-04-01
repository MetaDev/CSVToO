
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buySellBookingLineServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buySellBookingLineServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountKey" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="baseAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="costCentreKey" type="{http://service.octopus.com/}costCentreKey" minOccurs="0"/>
 *         &lt;element name="vatAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="vatCodeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buySellBookingLineServiceData", propOrder = {
    "accountKey",
    "baseAmount",
    "comment",
    "costCentreKey",
    "vatAmount",
    "vatCodeKey"
})
public class BuySellBookingLineServiceData {

    protected int accountKey;
    protected double baseAmount;
    protected String comment;
    protected CostCentreKey costCentreKey;
    protected double vatAmount;
    protected String vatCodeKey;

    /**
     * Gets the value of the accountKey property.
     * 
     */
    public int getAccountKey() {
        return accountKey;
    }

    /**
     * Sets the value of the accountKey property.
     * 
     */
    public void setAccountKey(int value) {
        this.accountKey = value;
    }

    /**
     * Gets the value of the baseAmount property.
     * 
     */
    public double getBaseAmount() {
        return baseAmount;
    }

    /**
     * Sets the value of the baseAmount property.
     * 
     */
    public void setBaseAmount(double value) {
        this.baseAmount = value;
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
     * Gets the value of the vatAmount property.
     * 
     */
    public double getVatAmount() {
        return vatAmount;
    }

    /**
     * Sets the value of the vatAmount property.
     * 
     */
    public void setVatAmount(double value) {
        this.vatAmount = value;
    }

    /**
     * Gets the value of the vatCodeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatCodeKey() {
        return vatCodeKey;
    }

    /**
     * Sets the value of the vatCodeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatCodeKey(String value) {
        this.vatCodeKey = value;
    }

}
