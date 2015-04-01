
package webcomm.octws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetModifiedFinancialDiversBookingsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetModifiedFinancialDiversBookingsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modifiedFinancialDiversBookingArray" type="{http://service.octopus.com/}financialDiversBookingServiceData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetModifiedFinancialDiversBookingsResponse", propOrder = {
    "_return",
    "modifiedFinancialDiversBookingArray"
})
public class GetModifiedFinancialDiversBookingsResponse {

    @XmlElement(name = "return")
    protected int _return;
    @XmlElement(nillable = true)
    protected List<FinancialDiversBookingServiceData> modifiedFinancialDiversBookingArray;

    /**
     * Gets the value of the return property.
     * 
     */
    public int getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     */
    public void setReturn(int value) {
        this._return = value;
    }

    /**
     * Gets the value of the modifiedFinancialDiversBookingArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiedFinancialDiversBookingArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiedFinancialDiversBookingArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialDiversBookingServiceData }
     * 
     * 
     */
    public List<FinancialDiversBookingServiceData> getModifiedFinancialDiversBookingArray() {
        if (modifiedFinancialDiversBookingArray == null) {
            modifiedFinancialDiversBookingArray = new ArrayList<FinancialDiversBookingServiceData>();
        }
        return this.modifiedFinancialDiversBookingArray;
    }

}
