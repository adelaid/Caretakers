
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientNeed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientNeed"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastVisit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ldNow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maxPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="minPeriod" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="needId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="patientId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="timerefId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientNeed", propOrder = {
    "description",
    "lastVisit",
    "ldNow",
    "maxPeriod",
    "minPeriod",
    "needId",
    "patientId",
    "timerefId"
})
public class PatientNeed {

    protected String description;
    protected String lastVisit;
    protected String ldNow;
    protected int maxPeriod;
    protected int minPeriod;
    protected Long needId;
    protected Long patientId;
    protected Long timerefId;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the lastVisit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastVisit() {
        return lastVisit;
    }

    /**
     * Sets the value of the lastVisit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastVisit(String value) {
        this.lastVisit = value;
    }

    /**
     * Gets the value of the ldNow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLdNow() {
        return ldNow;
    }

    /**
     * Sets the value of the ldNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLdNow(String value) {
        this.ldNow = value;
    }

    /**
     * Gets the value of the maxPeriod property.
     * 
     */
    public int getMaxPeriod() {
        return maxPeriod;
    }

    /**
     * Sets the value of the maxPeriod property.
     * 
     */
    public void setMaxPeriod(int value) {
        this.maxPeriod = value;
    }

    /**
     * Gets the value of the minPeriod property.
     * 
     */
    public int getMinPeriod() {
        return minPeriod;
    }

    /**
     * Sets the value of the minPeriod property.
     * 
     */
    public void setMinPeriod(int value) {
        this.minPeriod = value;
    }

    /**
     * Gets the value of the needId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNeedId() {
        return needId;
    }

    /**
     * Sets the value of the needId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNeedId(Long value) {
        this.needId = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPatientId(Long value) {
        this.patientId = value;
    }

    /**
     * Gets the value of the timerefId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimerefId() {
        return timerefId;
    }

    /**
     * Sets the value of the timerefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimerefId(Long value) {
        this.timerefId = value;
    }

}
