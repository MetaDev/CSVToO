
package webcomm.octws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetModifiedBalancingRelationsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetModifiedBalancingRelationsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modifiedBalancingArray" type="{http://service.octopus.com/}balancingDetailServiceData" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="deletedBalancingArray" type="{http://service.octopus.com/}balancingDetailServiceData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetModifiedBalancingRelationsResponse", propOrder = {
    "_return",
    "modifiedBalancingArray",
    "deletedBalancingArray"
})
public class GetModifiedBalancingRelationsResponse {

    @XmlElement(name = "return")
    protected int _return;
    @XmlElement(nillable = true)
    protected List<BalancingDetailServiceData> modifiedBalancingArray;
    @XmlElement(nillable = true)
    protected List<BalancingDetailServiceData> deletedBalancingArray;

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
     * Gets the value of the modifiedBalancingArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiedBalancingArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiedBalancingArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BalancingDetailServiceData }
     * 
     * 
     */
    public List<BalancingDetailServiceData> getModifiedBalancingArray() {
        if (modifiedBalancingArray == null) {
            modifiedBalancingArray = new ArrayList<BalancingDetailServiceData>();
        }
        return this.modifiedBalancingArray;
    }

    /**
     * Gets the value of the deletedBalancingArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deletedBalancingArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeletedBalancingArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BalancingDetailServiceData }
     * 
     * 
     */
    public List<BalancingDetailServiceData> getDeletedBalancingArray() {
        if (deletedBalancingArray == null) {
            deletedBalancingArray = new ArrayList<BalancingDetailServiceData>();
        }
        return this.deletedBalancingArray;
    }

}
