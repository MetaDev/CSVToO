
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for balancingTypeServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="balancingTypeServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="externalRelationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="relationKey" type="{http://service.octopus.com/}relationKey" minOccurs="0"/>
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
@XmlType(name = "balancingTypeServiceData", propOrder = {
    "accountNr",
    "externalRelationId",
    "relationKey",
    "type"
})
public class BalancingTypeServiceData {

    protected int accountNr;
    protected int externalRelationId;
    protected RelationKey relationKey;
    protected String type;

    /**
     * Gets the value of the accountNr property.
     * 
     */
    public int getAccountNr() {
        return accountNr;
    }

    /**
     * Sets the value of the accountNr property.
     * 
     */
    public void setAccountNr(int value) {
        this.accountNr = value;
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
