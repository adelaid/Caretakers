
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for visit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="visit"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caretaker" type="{http://ws/}caretaker" minOccurs="0"/&gt;
 *         &lt;element name="confirmed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="matchtot" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="patient" type="{http://ws/}patient" minOccurs="0"/&gt;
 *         &lt;element name="tr" type="{http://ws/}timeReference" minOccurs="0"/&gt;
 *         &lt;element name="vDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "visit", propOrder = {
    "caretaker",
    "confirmed",
    "grade",
    "id",
    "matchtot",
    "patient",
    "tr",
    "vDate"
})
public class Visit {

    protected Caretaker caretaker;
    protected String confirmed;
    protected int grade;
    protected Long id;
    protected int matchtot;
    protected Patient patient;
    protected TimeReference tr;
    protected String vDate;

    /**
     * Gets the value of the caretaker property.
     * 
     * @return
     *     possible object is
     *     {@link Caretaker }
     *     
     */
    public Caretaker getCaretaker() {
        return caretaker;
    }

    /**
     * Sets the value of the caretaker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Caretaker }
     *     
     */
    public void setCaretaker(Caretaker value) {
        this.caretaker = value;
    }

    /**
     * Gets the value of the confirmed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmed() {
        return confirmed;
    }

    /**
     * Sets the value of the confirmed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmed(String value) {
        this.confirmed = value;
    }

    /**
     * Gets the value of the grade property.
     * 
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     */
    public void setGrade(int value) {
        this.grade = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
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

    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Patient }
     *     
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patient }
     *     
     */
    public void setPatient(Patient value) {
        this.patient = value;
    }

    /**
     * Gets the value of the tr property.
     * 
     * @return
     *     possible object is
     *     {@link TimeReference }
     *     
     */
    public TimeReference getTr() {
        return tr;
    }

    /**
     * Sets the value of the tr property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeReference }
     *     
     */
    public void setTr(TimeReference value) {
        this.tr = value;
    }

    /**
     * Gets the value of the vDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVDate() {
        return vDate;
    }

    /**
     * Sets the value of the vDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVDate(String value) {
        this.vDate = value;
    }

}
