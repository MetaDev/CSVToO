
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for balancingDetailServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="balancingDetailServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creditBalancedBookingAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="creditDocument" type="{http://service.octopus.com/}balancingDocumentServiceData" minOccurs="0"/>
 *         &lt;element name="debetBalancedBookingAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="debetDocument" type="{http://service.octopus.com/}balancingDocumentServiceData" minOccurs="0"/>
 *         &lt;element name="type" type="{http://service.octopus.com/}balancingTypeServiceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "balancingDetailServiceData", propOrder = {
    "creditBalancedBookingAmount",
    "creditDocument",
    "debetBalancedBookingAmount",
    "debetDocument",
    "type"
})
public class BalancingDetailServiceData {

    protected double creditBalancedBookingAmount;
    protected BalancingDocumentServiceData creditDocument;
    protected double debetBalancedBookingAmount;
    protected BalancingDocumentServiceData debetDocument;
    protected BalancingTypeServiceData type;

    /**
     * Gets the value of the creditBalancedBookingAmount property.
     * 
     */
    public double getCreditBalancedBookingAmount() {
        return creditBalancedBookingAmount;
    }

    /**
     * Sets the value of the creditBalancedBookingAmount property.
     * 
     */
    public void setCreditBalancedBookingAmount(double value) {
        this.creditBalancedBookingAmount = value;
    }

    /**
     * Gets the value of the creditDocument property.
     * 
     * @return
     *     possible object is
     *     {@link BalancingDocumentServiceData }
     *     
     */
    public BalancingDocumentServiceData getCreditDocument() {
        return creditDocument;
    }

    /**
     * Sets the value of the creditDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalancingDocumentServiceData }
     *     
     */
    public void setCreditDocument(BalancingDocumentServiceData value) {
        this.creditDocument = value;
    }

    /**
     * Gets the value of the debetBalancedBookingAmount property.
     * 
     */
    public double getDebetBalancedBookingAmount() {
        return debetBalancedBookingAmount;
    }

    /**
     * Sets the value of the debetBalancedBookingAmount property.
     * 
     */
    public void setDebetBalancedBookingAmount(double value) {
        this.debetBalancedBookingAmount = value;
    }

    /**
     * Gets the value of the debetDocument property.
     * 
     * @return
     *     possible object is
     *     {@link BalancingDocumentServiceData }
     *     
     */
    public BalancingDocumentServiceData getDebetDocument() {
        return debetDocument;
    }

    /**
     * Sets the value of the debetDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalancingDocumentServiceData }
     *     
     */
    public void setDebetDocument(BalancingDocumentServiceData value) {
        this.debetDocument = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link BalancingTypeServiceData }
     *     
     */
    public BalancingTypeServiceData getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalancingTypeServiceData }
     *     
     */
    public void setType(BalancingTypeServiceData value) {
        this.type = value;
    }

}
