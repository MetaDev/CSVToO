
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relationServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relationServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bankAccountNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bicCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="client" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="contactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="corporationType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultBookingAccountClient" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="defaultBookingAccountSupplier" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expirationDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expirationType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="externalRelationNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="factLanguage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ibanAccountNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relationKey" type="{http://service.octopus.com/}relationKey" minOccurs="0"/>
 *         &lt;element name="remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchField1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="searchField2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="streetAndNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supplier" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="surName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vatType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relationServiceData", propOrder = {
    "active",
    "bankAccountNr",
    "bicCode",
    "city",
    "client",
    "contactPerson",
    "corporationType",
    "country",
    "defaultBookingAccountClient",
    "defaultBookingAccountSupplier",
    "email",
    "expirationDays",
    "expirationType",
    "externalRelationNr",
    "factLanguage",
    "fax",
    "ibanAccountNr",
    "mobile",
    "name",
    "postalCode",
    "relationKey",
    "remarks",
    "searchField1",
    "searchField2",
    "streetAndNr",
    "supplier",
    "surName",
    "telephone",
    "url",
    "vatNr",
    "vatType"
})
public class RelationServiceData {

    protected boolean active;
    protected String bankAccountNr;
    protected String bicCode;
    protected String city;
    protected boolean client;
    protected String contactPerson;
    protected int corporationType;
    protected String country;
    protected int defaultBookingAccountClient;
    protected int defaultBookingAccountSupplier;
    protected String email;
    protected int expirationDays;
    protected int expirationType;
    protected int externalRelationNr;
    protected int factLanguage;
    protected String fax;
    protected String ibanAccountNr;
    protected String mobile;
    protected String name;
    protected String postalCode;
    protected RelationKey relationKey;
    protected String remarks;
    protected String searchField1;
    protected String searchField2;
    protected String streetAndNr;
    protected boolean supplier;
    protected String surName;
    protected String telephone;
    protected String url;
    protected String vatNr;
    protected int vatType;

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the bankAccountNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccountNr() {
        return bankAccountNr;
    }

    /**
     * Sets the value of the bankAccountNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccountNr(String value) {
        this.bankAccountNr = value;
    }

    /**
     * Gets the value of the bicCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBicCode() {
        return bicCode;
    }

    /**
     * Sets the value of the bicCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBicCode(String value) {
        this.bicCode = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the client property.
     * 
     */
    public boolean isClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     */
    public void setClient(boolean value) {
        this.client = value;
    }

    /**
     * Gets the value of the contactPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the value of the contactPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    /**
     * Gets the value of the corporationType property.
     * 
     */
    public int getCorporationType() {
        return corporationType;
    }

    /**
     * Sets the value of the corporationType property.
     * 
     */
    public void setCorporationType(int value) {
        this.corporationType = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the defaultBookingAccountClient property.
     * 
     */
    public int getDefaultBookingAccountClient() {
        return defaultBookingAccountClient;
    }

    /**
     * Sets the value of the defaultBookingAccountClient property.
     * 
     */
    public void setDefaultBookingAccountClient(int value) {
        this.defaultBookingAccountClient = value;
    }

    /**
     * Gets the value of the defaultBookingAccountSupplier property.
     * 
     */
    public int getDefaultBookingAccountSupplier() {
        return defaultBookingAccountSupplier;
    }

    /**
     * Sets the value of the defaultBookingAccountSupplier property.
     * 
     */
    public void setDefaultBookingAccountSupplier(int value) {
        this.defaultBookingAccountSupplier = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the expirationDays property.
     * 
     */
    public int getExpirationDays() {
        return expirationDays;
    }

    /**
     * Sets the value of the expirationDays property.
     * 
     */
    public void setExpirationDays(int value) {
        this.expirationDays = value;
    }

    /**
     * Gets the value of the expirationType property.
     * 
     */
    public int getExpirationType() {
        return expirationType;
    }

    /**
     * Sets the value of the expirationType property.
     * 
     */
    public void setExpirationType(int value) {
        this.expirationType = value;
    }

    /**
     * Gets the value of the externalRelationNr property.
     * 
     */
    public int getExternalRelationNr() {
        return externalRelationNr;
    }

    /**
     * Sets the value of the externalRelationNr property.
     * 
     */
    public void setExternalRelationNr(int value) {
        this.externalRelationNr = value;
    }

    /**
     * Gets the value of the factLanguage property.
     * 
     */
    public int getFactLanguage() {
        return factLanguage;
    }

    /**
     * Sets the value of the factLanguage property.
     * 
     */
    public void setFactLanguage(int value) {
        this.factLanguage = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the ibanAccountNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIbanAccountNr() {
        return ibanAccountNr;
    }

    /**
     * Sets the value of the ibanAccountNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIbanAccountNr(String value) {
        this.ibanAccountNr = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the relationKey property.
     * 
     * @return
     *     possible object is
     *     {@link RelationKey }
     *     
     */
    public RelationKey getRelationKey() {
        return relationKey;
    }

    /**
     * Sets the value of the relationKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationKey }
     *     
     */
    public void setRelationKey(RelationKey value) {
        this.relationKey = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the searchField1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchField1() {
        return searchField1;
    }

    /**
     * Sets the value of the searchField1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchField1(String value) {
        this.searchField1 = value;
    }

    /**
     * Gets the value of the searchField2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchField2() {
        return searchField2;
    }

    /**
     * Sets the value of the searchField2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchField2(String value) {
        this.searchField2 = value;
    }

    /**
     * Gets the value of the streetAndNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAndNr() {
        return streetAndNr;
    }

    /**
     * Sets the value of the streetAndNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAndNr(String value) {
        this.streetAndNr = value;
    }

    /**
     * Gets the value of the supplier property.
     * 
     */
    public boolean isSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     */
    public void setSupplier(boolean value) {
        this.supplier = value;
    }

    /**
     * Gets the value of the surName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Sets the value of the surName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurName(String value) {
        this.surName = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the vatNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatNr() {
        return vatNr;
    }

    /**
     * Sets the value of the vatNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatNr(String value) {
        this.vatNr = value;
    }

    /**
     * Gets the value of the vatType property.
     * 
     */
    public int getVatType() {
        return vatType;
    }

    /**
     * Sets the value of the vatType property.
     * 
     */
    public void setVatType(int value) {
        this.vatType = value;
    }

}
