/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.TimeReference;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessions.TimeReferenceManagementLocal;

/**
 *
 * @author Ada
 */
@WebService(serviceName = "TimeReferenceWS")
@Stateless()
public class TimeReferenceWS {

    @EJB
    private TimeReferenceManagementLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addTimeReference")
    @Oneway
    public void addTimeReference(@WebParam(name = "caretakerId") Long caretakerId, @WebParam(name = "startTime") String startTime, @WebParam(name = "endTime") String endTime, @WebParam(name="isPatient") boolean isPatient) {
        ejbRef.addTimeReference(caretakerId, startTime, endTime, isPatient);
    }

    /**
     * Web service operation
     * @param trId
     * @return 
     */
    @WebMethod(operationName = "getTimeRef")
    public TimeReference getTimeRef(@WebParam(name = "trId") long trId) {
        //TODO write your implementation code here:
        return ejbRef.getTimeRef(trId);
    }
    
}
