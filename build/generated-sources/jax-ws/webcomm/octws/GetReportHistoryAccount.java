
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetReportHistoryAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetReportHistoryAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="historyAccountQueryData" type="{http://service.octopus.com/}historyAccountQueryData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetReportHistoryAccount", propOrder = {
    "historyAccountQueryData"
})
public class GetReportHistoryAccount {

    protected HistoryAccountQueryData historyAccountQueryData;

    /**
     * Gets the value of the historyAccountQueryData property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryAccountQueryData }
     *     
     */
    public HistoryAccountQueryData getHistoryAccountQueryData() {
        return historyAccountQueryData;
    }

    /**
     * Sets the value of the historyAccountQueryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryAccountQueryData }
     *     
     */
    public void setHistoryAccountQueryData(HistoryAccountQueryData value) {
        this.historyAccountQueryData = value;
    }

}
