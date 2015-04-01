
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuthenticateAndConnect complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuthenticateAndConnect">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="softwareHouseUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credentials" type="{http://service.octopus.com/}credentials" minOccurs="0"/>
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
@XmlType(name = "AuthenticateAndConnect", propOrder = {
    "softwareHouseUuid",
    "credentials",
    "dossierKey"
})
public class AuthenticateAndConnect {

    protected String softwareHouseUuid;
    protected Credentials credentials;
    protected DossierKey dossierKey;

    /**
     * Gets the value of the softwareHouseUuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftwareHouseUuid() {
        return softwareHouseUuid;
    }

    /**
     * Sets the value of the softwareHouseUuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftwareHouseUuid(String value) {
        this.softwareHouseUuid = value;
    }

    /**
     * Gets the value of the credentials property.
     * 
     * @return
     *     possible object is
     *     {@link Credentials }
     *     
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Sets the value of the credentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credentials }
     *     
     */
    public void setCredentials(Credentials value) {
        this.credentials = value;
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
