/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Need;
import domain.PatientNeed;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface NeedManagementLocal {
    public void addGeneralNeed(String type, long duration);
     public Vector<PatientNeed> getAllPatientNeed();

}
