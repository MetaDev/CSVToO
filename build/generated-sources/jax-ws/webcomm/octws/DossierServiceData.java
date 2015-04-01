
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dossierServiceData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dossierServiceData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dossierDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dossierKey" type="{http://service.octopus.com/}dossierKey" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dossierServiceData", propOrder = {
    "dossierDescription",
    "dossierKey"
})
public class DossierServiceData {

    protected String dossierDescription;
    protected DossierKey dossierKey;

    /**
     * Gets the value of the dossierDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDossierDescription() {
        return dossierDescription;
    }

    /**
     * Sets the value of the dossierDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDossierDescription(String value) {
        this.dossierDescription = value;
    }

    /**
     * Gets the value of the dossierKey property.
     * 
     * @return
     *     possible object is
     *     {@link DossierKey }
     *     
     */
    public DossierKey getDossierKey() {
        return dossierKey;
    }

    /**
     * Sets the value of the dossierKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link DossierKey }
     *     
     */
    public void setDossierKey(DossierKey value) {
        this.dossierKey = value;
    }

}
