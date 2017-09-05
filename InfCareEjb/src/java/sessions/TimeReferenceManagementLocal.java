/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.TimeReference;
import java.time.LocalDateTime;
import javax.ejb.Local;

/**
 *
 * @author Ada
 */
@Local
public interface TimeReferenceManagementLocal {
     public void addTimeReference(Long caretakerId, String startTime, String endTime,boolean isPatient);
     public TimeReference getTimeRef(Long trId);
}
