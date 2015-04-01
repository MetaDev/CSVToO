
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAccounts complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAccounts">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAccounts", propOrder = {
    "bookyearKey"
})
public class GetAccounts {

    protected BookyearKey bookyearKey;

    /**
     * Gets the value of the bookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getBookyearKey() {
        return bookyearKey;
    }

    /**
     * Sets the value of the bookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setBookyearKey(BookyearKey value) {
        this.bookyearKey = value;
    }

}
