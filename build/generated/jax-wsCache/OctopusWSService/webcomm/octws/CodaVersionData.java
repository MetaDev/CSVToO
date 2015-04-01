
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for codaVersionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="codaVersionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codaVersion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "codaVersionData", propOrder = {
    "codaVersion"
})
public class CodaVersionData {

    protected int codaVersion;

    /**
     * Gets the value of the codaVersion property.
     * 
     */
    public int getCodaVersion() {
        return codaVersion;
    }

    /**
     * Sets the value of the codaVersion property.
     * 
     */
    public void setCodaVersion(int value) {
        this.codaVersion = value;
    }

}
