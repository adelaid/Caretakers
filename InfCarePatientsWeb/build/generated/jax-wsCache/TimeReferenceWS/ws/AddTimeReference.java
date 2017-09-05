
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addTimeReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addTimeReference"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caretakerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isPatient" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addTimeReference", propOrder = {
    "caretakerId",
    "startTime",
    "endTime",
    "isPatient"
})
public class AddTimeReference {

    protected Long caretakerId;
    protected String startTime;
    protected String endTime;
    protected boolean isPatient;

    /**
     * Gets the value of the caretakerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCaretakerId() {
        return caretakerId;
    }

    /**
     * Sets the value of the caretakerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCaretakerId(Long value) {
        this.caretakerId = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the isPatient property.
     * 
     */
    public boolean isIsPatient() {
        return isPatient;
    }

    /**
     * Sets the value of the isPatient property.
     * 
     */
    public void setIsPatient(boolean value) {
        this.isPatient = value;
    }

}
