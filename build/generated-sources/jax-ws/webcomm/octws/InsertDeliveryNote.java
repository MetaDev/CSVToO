
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InsertDeliveryNote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsertDeliveryNote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deliveryNote" type="{http://service.octopus.com/}deliveryNoteServiceData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertDeliveryNote", propOrder = {
    "deliveryNote"
})
public class InsertDeliveryNote {

    protected DeliveryNoteServiceData deliveryNote;

    /**
     * Gets the value of the deliveryNote property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryNoteServiceData }
     *     
     */
    public DeliveryNoteServiceData getDeliveryNote() {
        return deliveryNote;
    }

    /**
     * Sets the value of the deliveryNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryNoteServiceData }
     *     
     */
    public void setDeliveryNote(DeliveryNoteServiceData value) {
        this.deliveryNote = value;
    }

}
