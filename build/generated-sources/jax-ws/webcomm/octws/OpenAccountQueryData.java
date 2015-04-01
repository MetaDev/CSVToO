
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for openAccountQueryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="openAccountQueryData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fromBookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="fromBookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toBookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="toBookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "openAccountQueryData", propOrder = {
    "accountNr",
    "fromBookyearKey",
    "fromBookyearPeriodNr",
    "toBookyearKey",
    "toBookyearPeriodNr"
})
public class OpenAccountQueryData {

    protected int accountNr;
    protected BookyearKey fromBookyearKey;
    protected int fromBookyearPeriodNr;
    protected BookyearKey toBookyearKey;
    protected int toBookyearPeriodNr;

    /**
     * Gets the value of the accountNr property.
     * 
     */
    public int getAccountNr() {
        return accountNr;
    }

    /**
     * Sets the value of the accountNr property.
     * 
     */
    public void setAccountNr(int value) {
        this.accountNr = value;
    }

    /**
     * Gets the value of the fromBookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getFromBookyearKey() {
        return fromBookyearKey;
    }

    /**
     * Sets the value of the fromBookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setFromBookyearKey(BookyearKey value) {
        this.fromBookyearKey = value;
    }

    /**
     * Gets the value of the fromBookyearPeriodNr property.
     * 
     */
    public int getFromBookyearPeriodNr() {
        return fromBookyearPeriodNr;
    }

    /**
     * Sets the value of the fromBookyearPeriodNr property.
     * 
     */
    public void setFromBookyearPeriodNr(int value) {
        this.fromBookyearPeriodNr = value;
    }

    /**
     * Gets the value of the toBookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getToBookyearKey() {
        return toBookyearKey;
    }

    /**
     * Sets the value of the toBookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setToBookyearKey(BookyearKey value) {
        this.toBookyearKey = value;
    }

    /**
     * Gets the value of the toBookyearPeriodNr property.
     * 
     */
    public int getToBookyearPeriodNr() {
        return toBookyearPeriodNr;
    }

    /**
     * Sets the value of the toBookyearPeriodNr property.
     * 
     */
    public void setToBookyearPeriodNr(int value) {
        this.toBookyearPeriodNr = value;
    }

}
