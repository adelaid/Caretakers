/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Visit;
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
public class VisitManagement implements VisitManagementLocal {

    @PersistenceContext(unitName = "InfCareEjbPU")
    private EntityManager em;
    
    public void confirmVisit(Long visitId){
     String sQuery = "UPDATE Visit p SET p.confirmed = :cookieUUID "+
                 "WHERE p.id = :userID";
     Query query= em.createQuery(sQuery );
     query.setParameter("cookieUUID", "YES");
     query.setParameter("userID", visitId);
     query.executeUpdate();
    }
    
    
 public Vector<Visit> getVisitsByPatient(String username){
            Query query = em.createQuery("SELECT u FROM Visit AS u WHERE u.patient.username = '" + username + "'", Visit.class);
        //Query query = em.createQuery("SELECT tl FROM TimeReference tl",TimeReference.class);
       Vector<Visit> tr=(Vector<Visit>) query.getResultList();
   //   em.find(TimeReference.class, query);
       for(int i=0;i<tr.size();i++){
           System.out.println(tr.get(i).getPatient().getFirstName());
         //  em.find(TimeReference.class, query);
       }
       return tr;
}
 
 
 @Override
    public Vector<Visit> getAllVisits() {
        Query query = em.createQuery("SELECT u FROM Visit AS u ", Visit.class);
        //Query query = em.createQuery("SELECT tl FROM TimeReference tl",TimeReference.class);
        Vector<Visit> vi = (Vector<Visit>) query.getResultList();
        //   em.find(TimeReference.class, query);
        for (int i = 0; i < vi.size(); i++) {
           // System.out.println("test" +tr.get(i).getCt().getTimeReference().get(0).getStartTime());
            //  em.find(TimeReference.class, query);
        }
        
        return (Vector<Visit>) query.getResultList();
    }
 
 public void giveGrade(int grade, Long visitId){
 String sQuery = "UPDATE Visit p SET p.grade = :cookieUUID "+
                 "WHERE p.id = :userID";
     Query query= em.createQuery(sQuery );
     query.setParameter("cookieUUID", grade);
     query.setParameter("userID", visitId);
     query.executeUpdate();
 }

    public void persist(Object object) {
        em.persist(object);
    }
}