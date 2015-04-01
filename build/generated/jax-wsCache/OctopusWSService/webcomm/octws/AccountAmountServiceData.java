
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountAmountServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountAmountServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountAmountKey" type="{http://service.octopus.com/}accountAmountKey" minOccurs="0"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountAmountServiceData", propOrder = {
    "accountAmountKey",
    "balance"
})
public class AccountAmountServiceData {

    protected AccountAmountKey accountAmountKey;
    protected double balance;

    /**
     * Gets the value of the accountAmountKey property.
     * 
     * @return
     *     possible object is
     *     {@link AccountAmountKey }
     *     
     */
    public AccountAmountKey getAccountAmountKey() {
        return accountAmountKey;
    }

    /**
     * Sets the value of the accountAmountKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountAmountKey }
     *     
     */
    public void setAccountAmountKey(AccountAmountKey value) {
        this.accountAmountKey = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBalance(double value) {
        this.balance = value;
    }

}
