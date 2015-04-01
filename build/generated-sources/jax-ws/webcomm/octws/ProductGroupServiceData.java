
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productGroupServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productGroupServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://service.octopus.com/}stringServiceData" minOccurs="0"/>
 *         &lt;element name="productGroupKey" type="{http://service.octopus.com/}productGroupKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productGroupServiceData", propOrder = {
    "description",
    "productGroupKey"
})
public class ProductGroupServiceData {

    protected StringServiceData description;
    protected ProductGroupKey productGroupKey;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link StringServiceData }
     *     
     */
    public StringServiceData getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringServiceData }
     *     
     */
    public void setDescription(StringServiceData value) {
        this.description = value;
    }

    /**
     * Gets the value of the productGroupKey property.
     * 
     * @return
     *     possible object is
     *     {@link ProductGroupKey }
     *     
     */
    public ProductGroupKey getProductGroupKey() {
        return productGroupKey;
    }

    /**
     * Sets the value of the productGroupKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductGroupKey }
     *     
     */
    public void setProductGroupKey(ProductGroupKey value) {
        this.productGroupKey = value;
    }

}
