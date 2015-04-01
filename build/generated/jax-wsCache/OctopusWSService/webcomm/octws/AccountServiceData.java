
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountKey" type="{http://service.octopus.com/}accountKey" minOccurs="0"/>
 *         &lt;element name="description" type="{http://service.octopus.com/}stringServiceData" minOccurs="0"/>
 *         &lt;element name="fiscProfessionalPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fiscRecupPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="vatRecupPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountServiceData", propOrder = {
    "accountKey",
    "description",
    "fiscProfessionalPercentage",
    "fiscRecupPercentage",
    "vatRecupPercentage"
})
public class AccountServiceData {

    protected AccountKey accountKey;
    protected StringServiceData description;
    protected double fiscProfessionalPercentage;
    protected double fiscRecupPercentage;
    protected double vatRecupPercentage;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link StringServiceData }
     *     
     */
    public StringServiceData getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringServiceData }
     *     
     */
    public void setDescription(StringServiceData value) {
        this.description = value;
    }

    /**
     * Gets the value of the fiscProfessionalPercentage property.
     * 
     */
    public double getFiscProfessionalPercentage() {
        return fiscProfessionalPercentage;
    }

    /**
     * Sets the value of the fiscProfessionalPercentage property.
     * 
     */
    public void setFiscProfessionalPercentage(double value) {
        this.fiscProfessionalPercentage = value;
    }

    /**
     * Gets the value of the fiscRecupPercentage property.
     * 
     */
    public double getFiscRecupPercentage() {
        return fiscRecupPercentage;
    }

    /**
     * Sets the value of the fiscRecupPercentage property.
     * 
     */
    public void setFiscRecupPercentage(double value) {
        this.fiscRecupPercentage = value;
    }

    /**
     * Gets the value of the vatRecupPercentage property.
     * 
     */
    public double getVatRecupPercentage() {
        return vatRecupPercentage;
    }

    /**
     * Sets the value of the vatRecupPercentage property.
     * 
     */
    public void setVatRecupPercentage(double value) {
        this.vatRecupPercentage = value;
    }

}
