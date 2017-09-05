/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.PatientNeed;
import java.util.Vector;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessions.NeedManagementLocal;

/**
 *
 * @author Ada
 */
@WebService(serviceName = "NeedWS")
@Stateless()
public class NeedWS {

    @EJB
    private NeedManagementLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addGeneralNeed")
    @Oneway
    public void addGeneralNeed(@WebParam(name = "type") String type, @WebParam(name = "duration") long duration) {
        ejbRef.addGeneralNeed(type, duration);
    }

    @WebMethod(operationName = "getAllPatientNeed")
    public Vector<PatientNeed> getAllPatientNeed() {
        return ejbRef.getAllPatientNeed();
    }
    
}
