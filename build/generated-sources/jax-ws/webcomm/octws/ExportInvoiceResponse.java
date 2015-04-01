
package webcomm.octws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExportInvoiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportInvoiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="invoice" type="{http://service.octopus.com/}invoiceServiceData" minOccurs="0"/>
 *         &lt;element name="pdfDocument" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="einvoiceXml" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
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
@XmlType(name = "ExportInvoiceResponse", propOrder = {
    "_return",
    "invoice",
    "pdfDocument",
    "einvoiceXml",
    "publishUrl"
})
public class ExportInvoiceResponse {

    @XmlElement(name = "return")
    protected int _return;
    protected InvoiceServiceData invoice;
    @XmlElementRef(name = "pdfDocument", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> pdfDocument;
    @XmlElementRef(name = "einvoiceXml", type = JAXBElement.class, required = false)
    protected JAXBElement<byte[]> einvoiceXml;
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
     * Gets the value of the invoice property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceServiceData }
     *     
     */
    public InvoiceServiceData getInvoice() {
        return invoice;
    }

    /**
     * Sets the value of the invoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceServiceData }
     *     
     */
    public void setInvoice(InvoiceServiceData value) {
        this.invoice = value;
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
     * Gets the value of the einvoiceXml property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getEinvoiceXml() {
        return einvoiceXml;
    }

    /**
     * Sets the value of the einvoiceXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setEinvoiceXml(JAXBElement<byte[]> value) {
        this.einvoiceXml = value;
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
