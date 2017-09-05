/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Caretaker;
import domain.Patient;
import domain.TimeReference;
import domain.Visit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ada
 */
@Stateless
public class CaretakerManagement implements CaretakerManagementLocal {
    
    @PersistenceContext(unitName = "InfCareEjbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    @Override
    public void setVisit(Long ctkId, Long patientId, String dateV, Long timeRefId, int matchtot) {
        Visit v = new Visit();
        
        Caretaker ct = em.find(Caretaker.class, ctkId);
        Patient pt = em.find(Patient.class, patientId);
        TimeReference tr=em.find(TimeReference.class, timeRefId);
        v.setCaretaker(ct);
        v.setPatient(pt);
        DateTimeFormatter formatterX
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
        LocalDateTime data = LocalDateTime.parse(dateV, formatterX);
        v.setvDate(data);
        v.setTr(tr);
        v.setConfirmed("NO");
        v.setMatchtot(matchtot);
        em.persist(v);
    }
    
    @Override
    public Vector<TimeReference> getAllCaretakersSchedule() {
        Query query = em.createQuery("SELECT u FROM TimeReference AS u WHERE u.ct IS NOT NULL", TimeReference.class);
        //Query query = em.createQuery("SELECT tl FROM TimeReference tl",TimeReference.class);
        Vector<TimeReference> tr = (Vector<TimeReference>) query.getResultList();
        //   em.find(TimeReference.class, query);
        for (int i = 0; i < tr.size(); i++) {
           // System.out.println("test" +tr.get(i).getCt().getTimeReference().get(0).getStartTime());
            //  em.find(TimeReference.class, query);
        }
        
        return (Vector<TimeReference>) query.getResultList();
    }
    
    @Override
    public void addCaretaker(String firstName, String lastName, String email, String username, String password) {
        Caretaker c = new Caretaker();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setUsername(username);
        c.setPassword(password);
        em.persist(c);
        
    }
    
    @Override
    public Caretaker getCaretaker(String username) {
        Query query = em.createQuery("SELECT u FROM Caretaker AS u WHERE u.username = '" + username + "'", Caretaker.class);
        //  System.out.println("management " + query.getSingleResult().toString());
        Caretaker ct = (Caretaker) query.getSingleResult();
        System.out.println("achi" + ct.getUsername());
        return ct;
    }
    
    @Override
    public boolean userExists(String username, String password) {
        
        Query query = em.createQuery("SELECT u FROM Caretaker AS u WHERE u.username = '" + username + "'", Caretaker.class);
        Caretaker ct = (Caretaker) query.getSingleResult();
        if (ct.getPassword().equals(password)) {
            System.out.println("exista");
            return true;
            
        } else {
            System.out.println("nu exista");
            return false;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
