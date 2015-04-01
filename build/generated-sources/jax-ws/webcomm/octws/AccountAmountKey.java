
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountAmountKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountAmountKey">
 *   &lt;complexContent>
 *     &lt;extension base="{http://service.octopus.com/}comparator">
 *       &lt;sequence>
 *         &lt;element name="accountKey" type="{http://service.octopus.com/}accountKey" minOccurs="0"/>
 *         &lt;element name="bookyearPeriodKey" type="{http://service.octopus.com/}bookyearPeriodKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountAmountKey", propOrder = {
    "accountKey",
    "bookyearPeriodKey"
})
public class AccountAmountKey
    extends Comparator
{

    protected AccountKey accountKey;
    protected BookyearPeriodKey bookyearPeriodKey;

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
     * Gets the value of the bookyearPeriodKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearPeriodKey }
     *     
     */
    public BookyearPeriodKey getBookyearPeriodKey() {
        return bookyearPeriodKey;
    }

    /**
     * Sets the value of the bookyearPeriodKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearPeriodKey }
     *     
     */
    public void setBookyearPeriodKey(BookyearPeriodKey value) {
        this.bookyearPeriodKey = value;
    }

}
