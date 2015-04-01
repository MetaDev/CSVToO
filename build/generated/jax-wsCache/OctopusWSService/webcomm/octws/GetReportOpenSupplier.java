
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportOpenSupplier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportOpenSupplier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="openSupplierQueryData" type="{http://service.octopus.com/}openRelationQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportOpenSupplier", propOrder = {
    "openSupplierQueryData"
})
public class GetReportOpenSupplier {

    protected OpenRelationQueryData openSupplierQueryData;

    /**
     * Gets the value of the openSupplierQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link OpenRelationQueryData }
     *     
     */
    public OpenRelationQueryData getOpenSupplierQueryData() {
        return openSupplierQueryData;
    }

    /**
     * Sets the value of the openSupplierQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpenRelationQueryData }
     *     
     */
    public void setOpenSupplierQueryData(OpenRelationQueryData value) {
        this.openSupplierQueryData = value;
    }

}
