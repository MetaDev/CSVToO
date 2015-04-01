
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsertBalancing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsertBalancing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balacing" type="{http://service.octopus.com/}balancingServiceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertBalancing", propOrder = {
    "balacing"
})
public class InsertBalancing {

    protected BalancingServiceData balacing;

    /**
     * Gets the value of the balacing property.
     * 
     * @return
     *     possible object is
     *     {@link BalancingServiceData }
     *     
     */
    public BalancingServiceData getBalacing() {
        return balacing;
    }

    /**
     * Sets the value of the balacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalancingServiceData }
     *     
     */
    public void setBalacing(BalancingServiceData value) {
        this.balacing = value;
    }

}
