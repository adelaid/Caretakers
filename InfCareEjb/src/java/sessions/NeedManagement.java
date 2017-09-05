/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import domain.Need;
import domain.Patient;
import domain.PatientNeed;
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
public class NeedManagement implements NeedManagementLocal {

    @PersistenceContext(unitName = "InfCareEjbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      @Override
    public void addGeneralNeed(String type, long duration) {
        Need n=new Need();
        n.setDuration(duration);
        n.setType(type);
        
       em.persist(n);
        
    }
    
     public Vector<PatientNeed> getAllPatientNeed(){
      // Query query = em.createQuery("SELECT u FROM PatientNeed AS u WHERE u.patientId IS NOT NULL", PatientNeed.class);
     
            Query query = em.createQuery("SELECT u FROM PatientNeed AS u ", PatientNeed.class);
        //Query query = em.createQuery("SELECT tl FROM TimeReference tl",TimeReference.class);
       Vector<PatientNeed> tr=(Vector<PatientNeed>) query.getResultList();
   //   em.find(TimeReference.class, query);
       for(int i=0;i<tr.size();i++){
           System.out.println(tr.get(i).getDescription());
         //  em.find(TimeReference.class, query);
       }
       
       
        return (Vector<PatientNeed>) query.getResultList();
    }
    
  
    
//   public Vector<Need> getAllNeeds(){
//       Query query = em.createQuery("SELECT u FROM Need ", Need.class);
//        //Query query = em.createQuery("SELECT tl FROM TimeReference tl",TimeReference.class);
//       Vector<Need> tr=(Vector<Need>) query.getResultList();
//   //   em.find(TimeReference.class, query);
//       for(int i=0;i<tr.size();i++){
//           System.out.println(tr.get(i).getType());
//         //  em.find(TimeReference.class, query);
//       }
//       
//       
//        return (Vector<Need>) query.getResultList();
//    }

    public void persist(Object object) {
        em.persist(object);
    }
}
