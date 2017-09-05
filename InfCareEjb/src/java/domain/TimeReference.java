/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import util.LocalDateAdapter;
import util.LocalDateTimeConverter;

/**
 *
 * @author Ada
 */
@Entity
//@XmlAccessorType(XmlAccessType.FIELD)

public class TimeReference implements Serializable {

    @ManyToOne
    private Patient patient;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @XmlElement
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

//    private LocalDate dday;
    //  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime startTime;

    //  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @Convert(converter = LocalDateTimeConverter.class)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endTime;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @ManyToOne
    private Caretaker ct;

    @XmlElement
    public Caretaker getCt() {
        return ct;
    }

    public void setCt(Caretaker ct) {
        this.ct = ct;
    }

//
//    public LocalDate getDday() {
//        return dday;
//    }
//
//    public void setDday(LocalDate dday) {
//        this.dday = dday;
//    }
//
//    public LocalTime getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(LocalTime startTime) {
//        this.startTime = startTime;
//    }
//
//    public LocalTime getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(LocalTime endTime) {
//        this.endTime = endTime;
//    }
//    
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
        if (!(object instanceof TimeReference)) {
            return false;
        }
        TimeReference other = (TimeReference) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TimeReference[ id=" + id + " ]";
    }

}
