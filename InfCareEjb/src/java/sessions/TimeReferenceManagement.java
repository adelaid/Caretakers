/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Caretaker;
import domain.Patient;
import domain.TimeReference;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ada
 */
@Stateless
public class TimeReferenceManagement implements TimeReferenceManagementLocal {

    @PersistenceContext(unitName = "InfCareEjbPU")
    private EntityManager em;

    @Override
    public TimeReference getTimeRef(Long trId){
    TimeReference tr=em.find(TimeReference.class, trId);
        System.out.println(tr.getId());
    return tr;
    
    }
    
    
    @Override
    public void addTimeReference(Long caretakerId, String startTime, String endTime, boolean isPatient) {
        TimeReference tf = new TimeReference();

//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
//         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss").withLocale(Locale.ITALY).withZone(ZoneId.systemDefault()).withResolverStyle(ResolverStyle.SMART);
        DateTimeFormatter formatterX
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
//         DateTimeFormatter formatterr =
//    DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
//                     .withLocale( Locale.UK )
//                     .withZone( ZoneId.systemDefault() );

//        String date = "16-08-2016";
//        String startT = "2017-03-21 10:15:00";
//        String endT = "10:20:00";

        LocalDateTime startTim = LocalDateTime.parse(startTime, formatterX);
        LocalDateTime endTim = LocalDateTime.parse(endTime, formatterX);
        
//LocalTime ss=s.toLocalTime();
//LocalDate sss=s.toLocalDate();
//convert String to LocalDate
//LocalDate localDate = LocalDate.parse(date, formatter);
//LocalTime st=LocalTime.parse(startT,formatterX);
//LocalTime et=LocalTime.parse(endT,formatterX);
        tf.setStartTime(startTim);
        tf.setEndTime(endTim);

//        tf.setDday(localDate);
//        tf.setStartTime(st);
//        tf.setEndTime(et);
//        tf.setStartTime(startTime);
//        tf.setEndTime(endTime);
        if (isPatient) {
            Patient pt = em.find(Patient.class, caretakerId);
            tf.setPatient(pt);
        } else {
            Caretaker ct = em.find(Caretaker.class, caretakerId);
            tf.setCt(ct);
        }

        //   tf.setCt(ct);
        em.persist(tf);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persist(Object object) {
        em.persist(object);
    }
}
