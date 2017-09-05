/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Address;
import domain.Need;
import domain.Patient;
import domain.TimeReference;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface PatientManagementLocal {
    
    public Vector<TimeReference> getAllPatientsSchedule();
    
     public void setNeed(String desc,String lastVisit, int minP, int maxP, String needType, String username, Long timerefId );
     
     public Vector<Need> getAllNeeds();
     
     public Need getNeed(String type);

    public void addPatient(String firstName, String lastName, String email, String username, String password, String city, String street, String streetNo);

    public Patient getPatient(String username);

    public boolean userExists(String username, String password) ;
     
}
