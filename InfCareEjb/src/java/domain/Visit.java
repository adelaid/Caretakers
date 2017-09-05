/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

import java.time.LocalDateTime;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import util.LocalDateAdapter;
import util.LocalDateTimeConverter;

/**
 *
 * @author Ada
 */
@Entity
public class Visit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int grade;
    
    private String confirmed;
    
    private int matchtot;

    public int getMatchtot() {
        return matchtot;
    }

    public void setMatchtot(int matchtot) {
        this.matchtot = matchtot;
    }

   

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime vDate;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Caretaker caretaker;

    @ManyToOne
    private TimeReference tr;

     @XmlElement
    public TimeReference getTr() {
        return tr;
    }

    public void setTr(TimeReference tr) {
        this.tr = tr;
    }
    
    
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDateTime getvDate() {
        return vDate;
    }

    public void setvDate(LocalDateTime vDate) {
        this.vDate = vDate;
    }

    @XmlElement
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @XmlElement
    public Caretaker getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visit)) {
            return false;
        }
        Visit other = (Visit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Visit[ id=" + id + " ]";
    }

}
