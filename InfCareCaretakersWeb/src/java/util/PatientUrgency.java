/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;

/**
 *
 * @author Ada
 */
public class PatientUrgency {
    LocalDate lastVisit;
    LocalDate nowDate;
    int maxP;

    
    
    public PatientUrgency(LocalDate lastVisit, LocalDate nowDate, int maxP) {
        this.lastVisit = lastVisit;
        this.nowDate = nowDate;
        this.maxP = maxP;
    }

    public PatientUrgency() {
    }
    
    
    

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }

    public LocalDate getNowDate() {
        return nowDate;
    }

    public void setNowDate(LocalDate nowDate) {
        this.nowDate = nowDate;
    }

    public int getMaxP() {
        return maxP;
    }

    public void setMaxP(int maxP) {
        this.maxP = maxP;
    }
    
    
}
