
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for financialDiversBookingLineServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialDiversBookingLineServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountKey" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="codaInfo" type="{http://service.octopus.com/}codaLineServiceData" minOccurs="0"/>
 *         &lt;element name="costCentreKey" type="{http://service.octopus.com/}costCentreKey" minOccurs="0"/>
 *         &lt;element name="externalRelationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "financialDiversBookingLineServiceData", propOrder = {
    "accountKey",
    "amount",
    "codaInfo",
    "costCentreKey",
    "externalRelationId",
    "reference",
    "type"
})
public class FinancialDiversBookingLineServiceData {

    protected int accountKey;
    protected double amount;
    protected CodaLineServiceData codaInfo;
    protected CostCentreKey costCentreKey;
    protected int externalRelationId;
    protected String reference;
    protected String type;

    /**
     * Gets the value of the accountKey property.
     * 
     */
    public int getAccountKey() {
        return accountKey;
    }

    /**
     * Sets the value of the accountKey property.
     * 
     */
    public void setAccountKey(int value) {
        this.accountKey = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the codaInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CodaLineServiceData }
     *     
     */
    public CodaLineServiceData getCodaInfo() {
        return codaInfo;
    }

    /**
     * Sets the value of the codaInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodaLineServiceData }
     *     
     */
    public void setCodaInfo(CodaLineServiceData value) {
        this.codaInfo = value;
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
     * Gets the value of the externalRelationId property.
     * 
     */
    public int getExternalRelationId() {
        return externalRelationId;
    }

    /**
     * Sets the value of the externalRelationId property.
     * 
     */
    public void setExternalRelationId(int value) {
        this.externalRelationId = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
