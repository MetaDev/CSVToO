
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rappelInfoInvoiceServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rappelInfoInvoiceServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rappelDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="rappelId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rappelInfoInvoiceServiceData", propOrder = {
    "rappelDate",
    "rappelId"
})
public class RappelInfoInvoiceServiceData {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rappelDate;
    protected int rappelId;

    /**
     * Gets the value of the rappelDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRappelDate() {
        return rappelDate;
    }

    /**
     * Sets the value of the rappelDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRappelDate(XMLGregorianCalendar value) {
        this.rappelDate = value;
    }

    /**
     * Gets the value of the rappelId property.
     * 
     */
    public int getRappelId() {
        return rappelId;
    }

    /**
     * Sets the value of the rappelId property.
     * 
     */
    public void setRappelId(int value) {
        this.rappelId = value;
    }

}
