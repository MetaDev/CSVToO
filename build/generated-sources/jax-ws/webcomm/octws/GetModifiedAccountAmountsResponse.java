
package webcomm.octws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetModifiedAccountAmountsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetModifiedAccountAmountsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modifiedAccountAmounts" type="{http://service.octopus.com/}accountAmountServiceData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletedAccountAmounts" type="{http://service.octopus.com/}accountAmountServiceData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetModifiedAccountAmountsResponse", propOrder = {
    "_return",
    "modifiedAccountAmounts",
    "deletedAccountAmounts"
})
public class GetModifiedAccountAmountsResponse {

    @XmlElement(name = "return")
    protected int _return;
    @XmlElement(nillable = true)
    protected List<AccountAmountServiceData> modifiedAccountAmounts;
    @XmlElement(nillable = true)
    protected List<AccountAmountServiceData> deletedAccountAmounts;

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
     * Gets the value of the modifiedAccountAmounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiedAccountAmounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiedAccountAmounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountAmountServiceData }
     * 
     * 
     */
    public List<AccountAmountServiceData> getModifiedAccountAmounts() {
        if (modifiedAccountAmounts == null) {
            modifiedAccountAmounts = new ArrayList<AccountAmountServiceData>();
        }
        return this.modifiedAccountAmounts;
    }

    /**
     * Gets the value of the deletedAccountAmounts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deletedAccountAmounts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeletedAccountAmounts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountAmountServiceData }
     * 
     * 
     */
    public List<AccountAmountServiceData> getDeletedAccountAmounts() {
        if (deletedAccountAmounts == null) {
            deletedAccountAmounts = new ArrayList<AccountAmountServiceData>();
        }
        return this.deletedAccountAmounts;
    }

}
