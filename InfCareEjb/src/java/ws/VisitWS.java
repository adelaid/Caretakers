/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.Visit;
import java.util.Vector;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessions.VisitManagementLocal;

/**
 *
 * @author Ada
 */
@WebService(serviceName = "VisitWS")
@Stateless()
public class VisitWS {

    @EJB
    private VisitManagementLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getVisitsByPatient")
    public Vector<Visit> getVisitsByPatient(@WebParam(name = "username") String username) {
        return ejbRef.getVisitsByPatient(username);
    }
    
    @WebMethod(operationName = "getAllVisits")
    public Vector<Visit> getAllVisits() {
        return ejbRef.getAllVisits();
    }
    
     @WebMethod(operationName = "giveGrade")
     @Oneway
    public void giveGrade(@WebParam(name = "grade") int grade,@WebParam(name = "visitId") Long visitId) {
         ejbRef.giveGrade(grade, visitId);
    }
    
      @WebMethod(operationName = "confirmVisit")
     @Oneway
    public void confirmVisit(@WebParam(name = "visitId")Long visitId){
         ejbRef.confirmVisit( visitId);
    }
    
    
}
