/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.Caretaker;
import domain.TimeReference;
import java.util.Vector;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessions.CaretakerManagementLocal;

/**
 *
 * @author Ada
 */
@WebService(serviceName = "CaretakerWS")
@Stateless()
public class CaretakerWS {
    
    @EJB
    private CaretakerManagementLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addCaretaker")
    @Oneway
    public void addCaretaker(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        ejbRef.addCaretaker(firstName, lastName, email, username, password);
    }
    
    @WebMethod(operationName = "getCaretaker")
    public Caretaker getCaretaker(@WebParam(name = "username") String username) {
        return ejbRef.getCaretaker(username);
    }
    
    @WebMethod(operationName = "userExists")
    public boolean userExists(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.userExists(username, password);
    }
    
    @WebMethod(operationName = "getAllCaretakersSchedule")
    public Vector<TimeReference> getAllCaretakersSchedule() {
        //TODO write your implementation code here:
        return ejbRef.getAllCaretakersSchedule();
    }

    /**
     * Web service operation
     * @param ctkId
     * @param patientId
     * @param dateV
     * @param timeRefId
     * @param matchtot
     */
    @WebMethod(operationName = "setVisit")
    @Oneway
    public void setVisit(@WebParam(name = "ctkId") long ctkId, @WebParam(name = "patientId") long patientId, @WebParam(name = "dateV") String dateV,@WebParam(name = "timeRefId") Long timeRefId, @WebParam(name = "matchtot") int matchtot) {
        ejbRef.setVisit(ctkId, patientId, dateV, timeRefId, matchtot);
    }
    
}
