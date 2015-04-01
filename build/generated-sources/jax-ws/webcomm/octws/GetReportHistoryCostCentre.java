
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportHistoryCostCentre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportHistoryCostCentre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="historyCostCentreQueryData" type="{http://service.octopus.com/}historyCostCentreQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportHistoryCostCentre", propOrder = {
    "historyCostCentreQueryData"
})
public class GetReportHistoryCostCentre {

    protected HistoryCostCentreQueryData historyCostCentreQueryData;

    /**
     * Gets the value of the historyCostCentreQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryCostCentreQueryData }
     *     
     */
    public HistoryCostCentreQueryData getHistoryCostCentreQueryData() {
        return historyCostCentreQueryData;
    }

    /**
     * Sets the value of the historyCostCentreQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryCostCentreQueryData }
     *     
     */
    public void setHistoryCostCentreQueryData(HistoryCostCentreQueryData value) {
        this.historyCostCentreQueryData = value;
    }

}
