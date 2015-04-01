
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deliveryNoteLineServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deliveryNoteLineServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingAccountNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="costCentreKey" type="{http://service.octopus.com/}costCentreKey" minOccurs="0"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discountPercentage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="externProductNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="vatCodeKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deliveryNoteLineServiceData", propOrder = {
    "bookingAccountNr",
    "costCentreKey",
    "count",
    "description",
    "discountPercentage",
    "externProductNr",
    "unit",
    "unitPrice",
    "vatCodeKey"
})
public class DeliveryNoteLineServiceData {

    protected int bookingAccountNr;
    protected CostCentreKey costCentreKey;
    protected double count;
    protected String description;
    protected double discountPercentage;
    protected String externProductNr;
    protected String unit;
    protected double unitPrice;
    protected String vatCodeKey;

    /**
     * Gets the value of the bookingAccountNr property.
     * 
     */
    public int getBookingAccountNr() {
        return bookingAccountNr;
    }

    /**
     * Sets the value of the bookingAccountNr property.
     * 
     */
    public void setBookingAccountNr(int value) {
        this.bookingAccountNr = value;
    }

    /**
     * Gets the value of the costCentreKey property.
     * 
     * @return
     *     possible object is
     *     {@link CostCentreKey }
     *     
     */
    public CostCentreKey getCostCentreKey() {
        return costCentreKey;
    }

    /**
     * Sets the value of the costCentreKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostCentreKey }
     *     
     */
    public void setCostCentreKey(CostCentreKey value) {
        this.costCentreKey = value;
    }

    /**
     * Gets the value of the count property.
     * 
     */
    public double getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(double value) {
        this.count = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the discountPercentage property.
     * 
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Sets the value of the discountPercentage property.
     * 
     */
    public void setDiscountPercentage(double value) {
        this.discountPercentage = value;
    }

    /**
     * Gets the value of the externProductNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternProductNr() {
        return externProductNr;
    }

    /**
     * Sets the value of the externProductNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternProductNr(String value) {
        this.externProductNr = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the unitPrice property.
     * 
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     * 
     */
    public void setUnitPrice(double value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the vatCodeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatCodeKey() {
        return vatCodeKey;
    }

    /**
     * Sets the value of the vatCodeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatCodeKey(String value) {
        this.vatCodeKey = value;
    }

}
