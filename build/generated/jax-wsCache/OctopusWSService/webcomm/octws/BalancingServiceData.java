
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for balancingServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="balancingServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="creditKey" type="{http://service.octopus.com/}balancingKeyServiceData" minOccurs="0"/>
 *         &lt;element name="debetKey" type="{http://service.octopus.com/}balancingKeyServiceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "balancingServiceData", propOrder = {
    "balanceAmount",
    "creditKey",
    "debetKey"
})
public class BalancingServiceData {

    protected double balanceAmount;
    protected BalancingKeyServiceData creditKey;
    protected BalancingKeyServiceData debetKey;

    /**
     * Gets the value of the balanceAmount property.
     * 
     */
    public double getBalanceAmount() {
        return balanceAmount;
    }

    /**
     * Sets the value of the balanceAmount property.
     * 
     */
    public void setBalanceAmount(double value) {
        this.balanceAmount = value;
    }

    /**
     * Gets the value of the creditKey property.
     * 
     * @return
     *     possible object is
     *     {@link BalancingKeyServiceData }
     *     
     */
    public BalancingKeyServiceData getCreditKey() {
        return creditKey;
    }

    /**
     * Sets the value of the creditKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalancingKeyServiceData }
     *     
     */
    public void setCreditKey(BalancingKeyServiceData value) {
        this.creditKey = value;
    }

    /**
     * Gets the value of the debetKey property.
     * 
     * @return
     *     possible object is
     *     {@link BalancingKeyServiceData }
     *     
     */
    public BalancingKeyServiceData getDebetKey() {
        return debetKey;
    }

    /**
     * Sets the value of the debetKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalancingKeyServiceData }
     *     
     */
    public void setDebetKey(BalancingKeyServiceData value) {
        this.debetKey = value;
    }

}
