
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for setNeed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="setNeed"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastVisit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="minP" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="maxP" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="needType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "setNeed", propOrder = {
    "desc",
    "lastVisit",
    "minP",
    "maxP",
    "needType",
    "username",
    "timerefId"
})
public class SetNeed {

    protected String desc;
    protected String lastVisit;
    protected int minP;
    protected int maxP;
    protected String needType;
    protected String username;
    protected Long timerefId;

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
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
     * Gets the value of the minP property.
     * 
     */
    public int getMinP() {
        return minP;
    }

    /**
     * Sets the value of the minP property.
     * 
     */
    public void setMinP(int value) {
        this.minP = value;
    }

    /**
     * Gets the value of the maxP property.
     * 
     */
    public int getMaxP() {
        return maxP;
    }

    /**
     * Sets the value of the maxP property.
     * 
     */
    public void setMaxP(int value) {
        this.maxP = value;
    }

    /**
     * Gets the value of the needType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeedType() {
        return needType;
    }

    /**
     * Sets the value of the needType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeedType(String value) {
        this.needType = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
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
