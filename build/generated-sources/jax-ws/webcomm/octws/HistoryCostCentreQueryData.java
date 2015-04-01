
package webcomm.octws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for historyCostCentreQueryData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="historyCostCentreQueryData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromAccountNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fromBookyearKey" type="{http://service.octopus.com/}bookyearKey" minOccurs="0"/>
 *         &lt;element name="fromBookyearPeriodNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="showActiveCostCentres" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="showEmptyCostcentres" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="showInactiveCostCentres" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="toAccountNr" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "historyCostCentreQueryData", propOrder = {
    "fromAccountNr",
    "fromBookyearKey",
    "fromBookyearPeriodNr",
    "showActiveCostCentres",
    "showEmptyCostcentres",
    "showInactiveCostCentres",
    "toAccountNr",
    "toBookyearKey",
    "toBookyearPeriodNr"
})
public class HistoryCostCentreQueryData {

    protected int fromAccountNr;
    protected BookyearKey fromBookyearKey;
    protected int fromBookyearPeriodNr;
    protected boolean showActiveCostCentres;
    protected boolean showEmptyCostcentres;
    protected boolean showInactiveCostCentres;
    protected int toAccountNr;
    protected BookyearKey toBookyearKey;
    protected int toBookyearPeriodNr;

    /**
     * Gets the value of the fromAccountNr property.
     * 
     */
    public int getFromAccountNr() {
        return fromAccountNr;
    }

    /**
     * Sets the value of the fromAccountNr property.
     * 
     */
    public void setFromAccountNr(int value) {
        this.fromAccountNr = value;
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
     * Gets the value of the showActiveCostCentres property.
     * 
     */
    public boolean isShowActiveCostCentres() {
        return showActiveCostCentres;
    }

    /**
     * Sets the value of the showActiveCostCentres property.
     * 
     */
    public void setShowActiveCostCentres(boolean value) {
        this.showActiveCostCentres = value;
    }

    /**
     * Gets the value of the showEmptyCostcentres property.
     * 
     */
    public boolean isShowEmptyCostcentres() {
        return showEmptyCostcentres;
    }

    /**
     * Sets the value of the showEmptyCostcentres property.
     * 
     */
    public void setShowEmptyCostcentres(boolean value) {
        this.showEmptyCostcentres = value;
    }

    /**
     * Gets the value of the showInactiveCostCentres property.
     * 
     */
    public boolean isShowInactiveCostCentres() {
        return showInactiveCostCentres;
    }

    /**
     * Sets the value of the showInactiveCostCentres property.
     * 
     */
    public void setShowInactiveCostCentres(boolean value) {
        this.showInactiveCostCentres = value;
    }

    /**
     * Gets the value of the toAccountNr property.
     * 
     */
    public int getToAccountNr() {
        return toAccountNr;
    }

    /**
     * Sets the value of the toAccountNr property.
     * 
     */
    public void setToAccountNr(int value) {
        this.toAccountNr = value;
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
