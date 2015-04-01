
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for costCentreServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="costCentreServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="closed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="costCentreKey" type="{http://service.octopus.com/}costCentreKey" minOccurs="0"/>
 *         &lt;element name="description" type="{http://service.octopus.com/}stringServiceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "costCentreServiceData", propOrder = {
    "closed",
    "costCentreKey",
    "description"
})
public class CostCentreServiceData {

    protected boolean closed;
    protected CostCentreKey costCentreKey;
    protected StringServiceData description;

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

}
