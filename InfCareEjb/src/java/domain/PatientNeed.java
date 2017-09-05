/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import util.LocalDateAdapter;
import util.LocalDateTimeConverter;
import util.PatientNeedId;

/**
 *
 * @author Ada
 */
@Entity
@IdClass(PatientNeedId.class)
public class PatientNeed implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    private Long patientId;
    @Id
    private Long needId;
    
    @Id
    private Long timerefId;

    public Long getTimerefId() {
        return timerefId;
    }

    public void setTimerefId(Long timerefId) {
        this.timerefId = timerefId;
    }
    

    private String description;
    private int minPeriod;
    private int maxPeriod;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime ldNow;

     @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDateTime getLdNow() {
        return ldNow;
    }

    public void setLdNow(LocalDateTime ldNow) {
        this.ldNow = ldNow;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime lastVisit;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinPeriod() {
        return minPeriod;
    }

    public void setMinPeriod(int minPeriod) {
        this.minPeriod = minPeriod;
    }

    public int getMaxPeriod() {
        return maxPeriod;
    }

    public void setMaxPeriod(int maxPeriod) {
        this.maxPeriod = maxPeriod;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getNeedId() {
        return needId;
    }

    public void setNeedId(Long needId) {
        this.needId = needId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.patientId);
        hash = 79 * hash + Objects.hashCode(this.needId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PatientNeed other = (PatientNeed) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.needId, other.needId)) {
            return false;
        }
        return true;
    }

}
