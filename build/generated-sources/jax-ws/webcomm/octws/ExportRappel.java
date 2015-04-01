
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExportRappel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExportRappel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="relationKey" type="{http://service.octopus.com/}relationKey" minOccurs="0"/>
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
@XmlType(name = "ExportRappel", propOrder = {
    "relationKey",
    "rappelId"
})
public class ExportRappel {

    protected RelationKey relationKey;
    protected int rappelId;

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
