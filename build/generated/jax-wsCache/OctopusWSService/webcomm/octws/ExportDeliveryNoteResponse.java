
package webcomm.octws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExportDeliveryNoteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportDeliveryNoteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deliveryNote" type="{http://service.octopus.com/}deliveryNoteServiceData" minOccurs="0"/>
 *         &lt;element name="pdfDocument" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="publishUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportDeliveryNoteResponse", propOrder = {
    "_return",
    "deliveryNote",
    "pdfDocument",
    "publishUrl"
})
public class ExportDeliveryNoteResponse {

    @XmlElement(name = "return")
    protected int _return;
    protected DeliveryNoteServiceData deliveryNote;
    @XmlElementRef(name = "pdfDocument", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> pdfDocument;
    protected String publishUrl;

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

    /**
     * Gets the value of the pdfDocument property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getPdfDocument() {
        return pdfDocument;
    }

    /**
     * Sets the value of the pdfDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setPdfDocument(JAXBElement<byte[]> value) {
        this.pdfDocument = value;
    }

    /**
     * Gets the value of the publishUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublishUrl() {
        return publishUrl;
    }

    /**
     * Sets the value of the publishUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublishUrl(String value) {
        this.publishUrl = value;
    }

}
