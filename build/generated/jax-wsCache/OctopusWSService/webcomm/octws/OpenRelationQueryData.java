
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for openRelationQueryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="openRelationQueryData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="externalRelationId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fromBookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="fromBookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toBookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="toBookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "openRelationQueryData", propOrder = {
    "externalRelationId",
    "fromBookyearKey",
    "fromBookyearPeriodNr",
    "toBookyearKey",
    "toBookyearPeriodNr"
})
public class OpenRelationQueryData {

    protected int externalRelationId;
    protected BookyearKey fromBookyearKey;
    protected int fromBookyearPeriodNr;
    protected BookyearKey toBookyearKey;
    protected int toBookyearPeriodNr;

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
     * Gets the value of the fromBookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getFromBookyearKey() {
        return fromBookyearKey;
    }

    /**
     * Sets the value of the fromBookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setFromBookyearKey(BookyearKey value) {
        this.fromBookyearKey = value;
    }

    /**
     * Gets the value of the fromBookyearPeriodNr property.
     * 
     */
    public int getFromBookyearPeriodNr() {
        return fromBookyearPeriodNr;
    }

    /**
     * Sets the value of the fromBookyearPeriodNr property.
     * 
     */
    public void setFromBookyearPeriodNr(int value) {
        this.fromBookyearPeriodNr = value;
    }

    /**
     * Gets the value of the toBookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getToBookyearKey() {
        return toBookyearKey;
    }

    /**
     * Sets the value of the toBookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setToBookyearKey(BookyearKey value) {
        this.toBookyearKey = value;
    }

    /**
     * Gets the value of the toBookyearPeriodNr property.
     * 
     */
    public int getToBookyearPeriodNr() {
        return toBookyearPeriodNr;
    }

    /**
     * Sets the value of the toBookyearPeriodNr property.
     * 
     */
    public void setToBookyearPeriodNr(int value) {
        this.toBookyearPeriodNr = value;
    }

}
