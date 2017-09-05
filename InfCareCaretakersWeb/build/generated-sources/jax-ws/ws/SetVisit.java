
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setVisit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setVisit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ctkId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="patientId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="dateV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeRefId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="matchtot" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setVisit", propOrder = {
    "ctkId",
    "patientId",
    "dateV",
    "timeRefId",
    "matchtot"
})
public class SetVisit {

    protected long ctkId;
    protected long patientId;
    protected String dateV;
    protected Long timeRefId;
    protected int matchtot;

    /**
     * Gets the value of the ctkId property.
     * 
     */
    public long getCtkId() {
        return ctkId;
    }

    /**
     * Sets the value of the ctkId property.
     * 
     */
    public void setCtkId(long value) {
        this.ctkId = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     */
    public long getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     */
    public void setPatientId(long value) {
        this.patientId = value;
    }

    /**
     * Gets the value of the dateV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateV() {
        return dateV;
    }

    /**
     * Sets the value of the dateV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateV(String value) {
        this.dateV = value;
    }

    /**
     * Gets the value of the timeRefId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeRefId() {
        return timeRefId;
    }

    /**
     * Sets the value of the timeRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeRefId(Long value) {
        this.timeRefId = value;
    }

    /**
     * Gets the value of the matchtot property.
     * 
     */
    public int getMatchtot() {
        return matchtot;
    }

    /**
     * Sets the value of the matchtot property.
     * 
     */
    public void setMatchtot(int value) {
        this.matchtot = value;
    }

}
