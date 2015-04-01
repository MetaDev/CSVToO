
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExportInvoice complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportInvoice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="journalKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentSequenceNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="returnInvoice" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="returnPdfDocument" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="returnEInvoice" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExportInvoice", propOrder = {
    "bookyearKey",
    "journalKey",
    "documentSequenceNr",
    "returnInvoice",
    "returnPdfDocument",
    "returnEInvoice"
})
public class ExportInvoice {

    protected BookyearKey bookyearKey;
    protected String journalKey;
    protected int documentSequenceNr;
    protected boolean returnInvoice;
    protected boolean returnPdfDocument;
    protected boolean returnEInvoice;

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

    /**
     * Gets the value of the journalKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournalKey() {
        return journalKey;
    }

    /**
     * Sets the value of the journalKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournalKey(String value) {
        this.journalKey = value;
    }

    /**
     * Gets the value of the documentSequenceNr property.
     * 
     */
    public int getDocumentSequenceNr() {
        return documentSequenceNr;
    }

    /**
     * Sets the value of the documentSequenceNr property.
     * 
     */
    public void setDocumentSequenceNr(int value) {
        this.documentSequenceNr = value;
    }

    /**
     * Gets the value of the returnInvoice property.
     * 
     */
    public boolean isReturnInvoice() {
        return returnInvoice;
    }

    /**
     * Sets the value of the returnInvoice property.
     * 
     */
    public void setReturnInvoice(boolean value) {
        this.returnInvoice = value;
    }

    /**
     * Gets the value of the returnPdfDocument property.
     * 
     */
    public boolean isReturnPdfDocument() {
        return returnPdfDocument;
    }

    /**
     * Sets the value of the returnPdfDocument property.
     * 
     */
    public void setReturnPdfDocument(boolean value) {
        this.returnPdfDocument = value;
    }

    /**
     * Gets the value of the returnEInvoice property.
     * 
     */
    public boolean isReturnEInvoice() {
        return returnEInvoice;
    }

    /**
     * Sets the value of the returnEInvoice property.
     * 
     */
    public void setReturnEInvoice(boolean value) {
        this.returnEInvoice = value;
    }

}
