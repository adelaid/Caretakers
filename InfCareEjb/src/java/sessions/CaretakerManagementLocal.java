/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Caretaker;
import domain.TimeReference;
import java.util.Vector;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface CaretakerManagementLocal {
     public void addCaretaker(String firstName, String lastName, String email, String username, String password);
     public Caretaker getCaretaker(String username);
     public boolean userExists(String username, String password);
      public Vector<TimeReference> getAllCaretakersSchedule();
      public void setVisit(Long ctkId, Long patientId, String dateV, Long timeRefId, int matchtot) ;
}
