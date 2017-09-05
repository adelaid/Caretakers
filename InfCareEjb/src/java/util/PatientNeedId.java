/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ada
 */
public class PatientNeedId implements Serializable {

    private Long patientId;
    private Long needId;
    private Long timerefId;

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 37 * hash + Objects.hashCode(this.patientId);
//        hash = 37 * hash + (int) (this.needId ^ (this.needId >>> 32));
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final PatientNeedId other = (PatientNeedId) obj;
//        if (this.needId != other.needId) {
//            return false;
//        }
//        if (!Objects.equals(this.patientId, other.patientId)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.patientId);
        hash = 59 * hash + Objects.hashCode(this.needId);
        hash = 59 * hash + Objects.hashCode(this.timerefId);
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
        final PatientNeedId other = (PatientNeedId) obj;
        if (!Objects.equals(this.patientId, other.patientId)) {
            return false;
        }
        if (!Objects.equals(this.needId, other.needId)) {
            return false;
        }
        if (!Objects.equals(this.timerefId, other.timerefId)) {
            return false;
        }
        return true;
    }
}