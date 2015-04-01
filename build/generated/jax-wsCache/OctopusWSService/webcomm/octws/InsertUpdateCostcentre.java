
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsertUpdateCostcentre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsertUpdateCostcentre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="costcentre" type="{http://service.octopus.com/}costCentreServiceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertUpdateCostcentre", propOrder = {
    "costcentre"
})
public class InsertUpdateCostcentre {

    protected CostCentreServiceData costcentre;

    /**
     * Gets the value of the costcentre property.
     * 
     * @return
     *     possible object is
     *     {@link CostCentreServiceData }
     *     
     */
    public CostCentreServiceData getCostcentre() {
        return costcentre;
    }

    /**
     * Sets the value of the costcentre property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostCentreServiceData }
     *     
     */
    public void setCostcentre(CostCentreServiceData value) {
        this.costcentre = value;
    }

}
