
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportHistorySupplier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportHistorySupplier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="historySupplierQueryData" type="{http://service.octopus.com/}historyRelationQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportHistorySupplier", propOrder = {
    "historySupplierQueryData"
})
public class GetReportHistorySupplier {

    protected HistoryRelationQueryData historySupplierQueryData;

    /**
     * Gets the value of the historySupplierQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryRelationQueryData }
     *     
     */
    public HistoryRelationQueryData getHistorySupplierQueryData() {
        return historySupplierQueryData;
    }

    /**
     * Sets the value of the historySupplierQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryRelationQueryData }
     *     
     */
    public void setHistorySupplierQueryData(HistoryRelationQueryData value) {
        this.historySupplierQueryData = value;
    }

}
