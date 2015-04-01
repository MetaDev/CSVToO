
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConnectToDossier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConnectToDossier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "ConnectToDossier", propOrder = {
    "dossierKey"
})
public class ConnectToDossier {

    protected DossierKey dossierKey;

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
