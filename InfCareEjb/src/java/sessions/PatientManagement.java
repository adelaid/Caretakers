/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Address;
import domain.Need;
import domain.Patient;
import domain.PatientNeed;
import domain.TimeReference;
import java.time.LocalDate;
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
public class PatientManagement implements PatientManagementLocal {

    @PersistenceContext(unitName = "InfCareEjbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public Vector<TimeReference> getAllPatientsSchedule() {
        Query query = em.createQuery("SELECT u FROM TimeReference AS u WHERE u.patient IS NOT NULL", TimeReference.class);
        //Query query = em.createQuery("SELECT tl FROM TimeReference tl",TimeReference.class);
        Vector<TimeReference> tr = (Vector<TimeReference>) query.getResultList();
        //   em.find(TimeReference.class, query);
        for (int i = 0; i < tr.size(); i++) {
            System.out.println(tr.get(i).getPatient().getFirstName());
            //  em.find(TimeReference.class, query);
        }

        return (Vector<TimeReference>) query.getResultList();
    }

    public void setNeed(String desc, String lastVisit, int minP, int maxP, String needType, String username, Long timerefId) {
        LocalDateTime ldN=LocalDateTime.now();
        PatientNeed pn = new PatientNeed();
        Need nn = getNeed(needType);
        Patient pp = getPatient(username);
        Long needId = nn.getId();
        Long patientId = pp.getId();
        pn.setPatientId(patientId);
        pn.setNeedId(needId);
        pn.setDescription(desc);

        DateTimeFormatter formatterX
                = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
        LocalDateTime lastVisitd = LocalDateTime.parse(lastVisit, formatterX);

        pn.setLastVisit(lastVisitd);
        pn.setMinPeriod(minP);
        pn.setMaxPeriod(maxP);
        pn.setTimerefId(timerefId);
        pn.setLdNow(ldN);
        em.persist(pn);
//update lastVisit field with null, where found: 1111-11-11 00:00:00 (there is no last visit before )
        if (lastVisit.equals("1111-11-11 00:00:00")) {

//            em.createQuery(
//        "UPDATE PatientNeed p SET p.lastVisit = NULL where p.lastVisit='1111-11-11 00:00:00'")
//        .executeUpdate();
//            
            String sQuery = "UPDATE PatientNeed p SET p.lastVisit = :cookieUUID "+
                 "WHERE p.lastVisit = :userID";
     Query query= em.createQuery(sQuery );
     query.setParameter("cookieUUID", null);
     query.setParameter("userID", lastVisitd);
     query.executeUpdate();
            
            
//update patientneed set LASTVISIT = NULL where LASTVISIT='1111-11-11 00:00:00';
        }

    }

    public Vector<Need> getAllNeeds() {
        Query query = em.createQuery("SELECT tl FROM Need tl", Need.class);
        return (Vector<Need>) query.getResultList();
    }

    public Need getNeed(String type) {
        Query query = em.createQuery("SELECT u FROM Need AS u WHERE u.type = '" + type + "'", Need.class);
        //  System.out.println("management " + query.getSingleResult().toString());
        Need ct = (Need) query.getSingleResult();

        return ct;
    }

    @Override
    public void addPatient(String firstName, String lastName, String email, String username, String password, String city, String street, String streetNo) {

        Patient p = new Patient();
        Address a = new Address();

        a.setCity(city);
        a.setStreet(street);
        a.setStreetNo(streetNo);
        em.persist(a);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        p.setUsername(username);
        p.setPassword(password);
        p.setAddress(a);
        em.persist(p);

    }

    @Override
    public Patient getPatient(String username) {
        Query query = em.createQuery("SELECT u FROM Patient AS u WHERE u.username = '" + username + "'", Patient.class);
        //  System.out.println("management " + query.getSingleResult().toString());
        Patient ct = (Patient) query.getSingleResult();

        return ct;
    }

    @Override
    public boolean userExists(String username, String password) {

        Query query = em.createQuery("SELECT u FROM Patient AS u WHERE u.username = '" + username + "'", Patient.class);
        Patient ct = (Patient) query.getSingleResult();
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
