
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookyearPeriodKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookyearPeriodKey">
 *   &lt;complexContent>
 *     &lt;extension base="{http://service.octopus.com/}comparator">
 *       &lt;sequence>
 *         &lt;element name="bookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="bookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookyearPeriodKey", propOrder = {
    "bookyearKey",
    "bookyearPeriodNr"
})
public class BookyearPeriodKey
    extends Comparator
{

    protected BookyearKey bookyearKey;
    protected int bookyearPeriodNr;

    /**
     * Gets the value of the bookyearKey property.
     * 
     * @return
     *     possible object is
     *     {@link BookyearKey }
     *     
     */
    public BookyearKey getBookyearKey() {
        return bookyearKey;
    }

    /**
     * Sets the value of the bookyearKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookyearKey }
     *     
     */
    public void setBookyearKey(BookyearKey value) {
        this.bookyearKey = value;
    }

    /**
     * Gets the value of the bookyearPeriodNr property.
     * 
     */
    public int getBookyearPeriodNr() {
        return bookyearPeriodNr;
    }

    /**
     * Sets the value of the bookyearPeriodNr property.
     * 
     */
    public void setBookyearPeriodNr(int value) {
        this.bookyearPeriodNr = value;
    }

}
