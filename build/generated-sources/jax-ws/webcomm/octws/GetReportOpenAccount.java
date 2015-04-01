
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportOpenAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportOpenAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="openAccountQueryData" type="{http://service.octopus.com/}openAccountQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportOpenAccount", propOrder = {
    "openAccountQueryData"
})
public class GetReportOpenAccount {

    protected OpenAccountQueryData openAccountQueryData;

    /**
     * Gets the value of the openAccountQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link OpenAccountQueryData }
     *     
     */
    public OpenAccountQueryData getOpenAccountQueryData() {
        return openAccountQueryData;
    }

    /**
     * Sets the value of the openAccountQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link OpenAccountQueryData }
     *     
     */
    public void setOpenAccountQueryData(OpenAccountQueryData value) {
        this.openAccountQueryData = value;
    }

}
