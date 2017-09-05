/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Comparator;

/**
 *
 * @author Ada
 */
public class PatientGrade implements Comparator<PatientGrade> {
    double grade;
    Long tr;

    public PatientGrade(double grade, Long tr) {
        this.grade = grade;
        this.tr = tr;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Long getTr() {
        return tr;
    }

    public void setTr(Long tr) {
        this.tr = tr;
    }

    public int compare(PatientGrade o, PatientGrade o1) {
   //    double compareGrade = ((PatientGrade) o).getGrade();
 return Double.compare(o.getGrade(),o1.getGrade());
		//ascending order
		//return this.grade - compareGrade;
    }

//    @Override
//    public int compare(Object o1, Object o2) {
//        
//         return Double.compare(((PatientGrade)o1).getGrade(),((PatientGrade)o1).getGrade());
//    }
//
//    @Override
//    public int compare(PatientGrade o1, PatientGrade o2) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
