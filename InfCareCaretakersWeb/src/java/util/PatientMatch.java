/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Comparator;
import ws.Patient;
import ws.TimeReference;

/**
 *
 * @author Ada
 */
public class PatientMatch implements Comparator<PatientMatch> {

    TimeReference tr;
    Patient p;
    double match;
    double matchU;
    double matchG;
    double matchC;

    public double getMatchC() {
        return matchC;
    }

    public void setMatchC(double matchC) {
        this.matchC = matchC;
    }

    public double getMatchU() {
        return matchU;
    }

    public void setMatchU(double matchU) {
        this.matchU = matchU;
    }

    public double getMatchG() {
        return matchG;
    }

    public void setMatchG(double matchG) {
        this.matchG = matchG;
    }

    public TimeReference getTr() {
        return tr;
    }

    public void setTr(TimeReference tr) {
        this.tr = tr;
    }

    public PatientMatch(TimeReference tr, Patient p, double match) {
        this.tr = tr;
        this.p = p;
        this.match = match;
    }

//    public double givePforContinuancy(PatientContinuancy pc){
//    
//    
//    }
//    
    public double givePforUrgency(PatientUrgency pu) {
        double m = 0;
        //pu.getLastVisit();
        LocalDate nowDate = pu.getNowDate();
        // pu.getMaxP();
        LocalDate ldt = pu.getLastVisit().plusDays(pu.getMaxP());
        long daysBetween = DAYS.between(nowDate, ldt);
        System.out.println("days between " + daysBetween);
        if (daysBetween == 1) {
            m = 100;
        } else if (daysBetween > 1 && daysBetween < 4) {
            m = 50;

        } else if (daysBetween >= 4 && daysBetween < 7) {

            m = 30;

        } else if (daysBetween >= 7 && daysBetween < 10) {
            m = 10;

        } else if (daysBetween > 10) {
            m = 0;

        }
        return m;

    }

    public double giveP(double grade) {
        double m = 0;
        if (grade >= 0 && grade < 2) {
            m = 0;
        } else if (grade < 5 && grade >= 2) {
            m = 10;
        } else if (grade >= 5 && grade <= 8) {
            m = 20;
        } else if (grade > 8) {
            m = 30;
        }
        return m;
    }

    public PatientMatch() {
    }

    public PatientMatch(Patient p, double match) {
        this.p = p;
        this.match = match;
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public double getMatch() {
        return match;
    }

    public void setMatch(double match) {
        this.match = match;
    }

    @Override
    public int compare(PatientMatch o1, PatientMatch o2) {
        return Double.compare(o1.getMatch(), o2.getMatch());
    }

}
