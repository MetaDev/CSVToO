
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportOpenClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportOpenClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="openClientQueryData" type="{http://service.octopus.com/}openRelationQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportOpenClient", propOrder = {
    "openClientQueryData"
})
public class GetReportOpenClient {

    protected OpenRelationQueryData openClientQueryData;

    /**
     * Gets the value of the openClientQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link OpenRelationQueryData }
     *     
     */
    public OpenRelationQueryData getOpenClientQueryData() {
        return openClientQueryData;
    }

    /**
     * Sets the value of the openClientQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpenRelationQueryData }
     *     
     */
    public void setOpenClientQueryData(OpenRelationQueryData value) {
        this.openClientQueryData = value;
    }

}
