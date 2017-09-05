
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for giveGrade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="giveGrade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="visitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "giveGrade", propOrder = {
    "grade",
    "visitId"
})
public class GiveGrade {

    protected int grade;
    protected Long visitId;

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
     * Gets the value of the visitId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getVisitId() {
        return visitId;
    }

    /**
     * Sets the value of the visitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setVisitId(Long value) {
        this.visitId = value;
    }

}
