/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Visit;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface VisitManagementLocal {
     public void confirmVisit(Long visitId);
    public Vector<Visit> getVisitsByPatient(String username);
     public void giveGrade(int grade, Long visitId);
     public Vector<Visit> getAllVisits();
}
