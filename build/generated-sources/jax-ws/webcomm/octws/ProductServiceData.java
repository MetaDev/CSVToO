
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://service.octopus.com/}stringServiceData" minOccurs="0"/>
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultBookingAccountNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="defaultCostCentre" type="{http://service.octopus.com/}costCentreKey" minOccurs="0"/>
 *         &lt;element name="description" type="{http://service.octopus.com/}stringServiceData" minOccurs="0"/>
 *         &lt;element name="externProductNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="priceVatExclusive" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="priceVatInclusive" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="productGroup" type="{http://service.octopus.com/}productGroupKey" minOccurs="0"/>
 *         &lt;element name="productKey" type="{http://service.octopus.com/}productKey" minOccurs="0"/>
 *         &lt;element name="supplierInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productServiceData", propOrder = {
    "code",
    "currencyCode",
    "defaultBookingAccountNr",
    "defaultCostCentre",
    "description",
    "externProductNr",
    "priceVatExclusive",
    "priceVatInclusive",
    "productGroup",
    "productKey",
    "supplierInfo",
    "unit",
    "vatCode"
})
public class ProductServiceData {

    protected StringServiceData code;
    protected String currencyCode;
    protected int defaultBookingAccountNr;
    protected CostCentreKey defaultCostCentre;
    protected StringServiceData description;
    protected String externProductNr;
    protected double priceVatExclusive;
    protected double priceVatInclusive;
    protected ProductGroupKey productGroup;
    protected ProductKey productKey;
    protected String supplierInfo;
    protected String unit;
    protected String vatCode;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link StringServiceData }
     *     
     */
    public StringServiceData getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringServiceData }
     *     
     */
    public void setCode(StringServiceData value) {
        this.code = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the defaultBookingAccountNr property.
     * 
     */
    public int getDefaultBookingAccountNr() {
        return defaultBookingAccountNr;
    }

    /**
     * Sets the value of the defaultBookingAccountNr property.
     * 
     */
    public void setDefaultBookingAccountNr(int value) {
        this.defaultBookingAccountNr = value;
    }

    /**
     * Gets the value of the defaultCostCentre property.
     * 
     * @return
     *     possible object is
     *     {@link CostCentreKey }
     *     
     */
    public CostCentreKey getDefaultCostCentre() {
        return defaultCostCentre;
    }

    /**
     * Sets the value of the defaultCostCentre property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostCentreKey }
     *     
     */
    public void setDefaultCostCentre(CostCentreKey value) {
        this.defaultCostCentre = value;
    }

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
     * Gets the value of the priceVatExclusive property.
     * 
     */
    public double getPriceVatExclusive() {
        return priceVatExclusive;
    }

    /**
     * Sets the value of the priceVatExclusive property.
     * 
     */
    public void setPriceVatExclusive(double value) {
        this.priceVatExclusive = value;
    }

    /**
     * Gets the value of the priceVatInclusive property.
     * 
     */
    public double getPriceVatInclusive() {
        return priceVatInclusive;
    }

    /**
     * Sets the value of the priceVatInclusive property.
     * 
     */
    public void setPriceVatInclusive(double value) {
        this.priceVatInclusive = value;
    }

    /**
     * Gets the value of the productGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ProductGroupKey }
     *     
     */
    public ProductGroupKey getProductGroup() {
        return productGroup;
    }

    /**
     * Sets the value of the productGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductGroupKey }
     *     
     */
    public void setProductGroup(ProductGroupKey value) {
        this.productGroup = value;
    }

    /**
     * Gets the value of the productKey property.
     * 
     * @return
     *     possible object is
     *     {@link ProductKey }
     *     
     */
    public ProductKey getProductKey() {
        return productKey;
    }

    /**
     * Sets the value of the productKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductKey }
     *     
     */
    public void setProductKey(ProductKey value) {
        this.productKey = value;
    }

    /**
     * Gets the value of the supplierInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierInfo() {
        return supplierInfo;
    }

    /**
     * Sets the value of the supplierInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierInfo(String value) {
        this.supplierInfo = value;
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
     * Gets the value of the vatCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatCode() {
        return vatCode;
    }

    /**
     * Sets the value of the vatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatCode(String value) {
        this.vatCode = value;
    }

}
