
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportHistoryClient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportHistoryClient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="historyClientQueryData" type="{http://service.octopus.com/}historyRelationQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportHistoryClient", propOrder = {
    "historyClientQueryData"
})
public class GetReportHistoryClient {

    protected HistoryRelationQueryData historyClientQueryData;

    /**
     * Gets the value of the historyClientQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryRelationQueryData }
     *     
     */
    public HistoryRelationQueryData getHistoryClientQueryData() {
        return historyClientQueryData;
    }

    /**
     * Sets the value of the historyClientQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryRelationQueryData }
     *     
     */
    public void setHistoryClientQueryData(HistoryRelationQueryData value) {
        this.historyClientQueryData = value;
    }

}
