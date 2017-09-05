/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import domain.Need;
import domain.Patient;
import domain.TimeReference;
import java.util.Vector;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessions.PatientManagementLocal;

/**
 *
 * @author Ada
 */
@WebService(serviceName = "PatientWS")
@Stateless()
public class PatientWS {

    @EJB
    private PatientManagementLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "setNeed")
    @Oneway
    public void setNeed(@WebParam(name = "desc") String desc, @WebParam(name = "lastVisit") String lastVisit, @WebParam(name = "minP") int minP, @WebParam(name = "maxP") int maxP, @WebParam(name = "needType") String needType, @WebParam(name = "username") String username, @WebParam(name = "timerefId") Long timerefId) {
        ejbRef.setNeed(desc, lastVisit, minP, maxP, needType, username, timerefId );
    }

    @WebMethod(operationName = "getAllNeeds")
    public Vector<Need> getAllNeeds() {
        return ejbRef.getAllNeeds();
    }

    @WebMethod(operationName = "getNeed")
    public Need getNeed(@WebParam(name = "type") String type) {
        return ejbRef.getNeed(type);
    }

    @WebMethod(operationName = "addPatient")
    @Oneway
    public void addPatient(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "city") String city, @WebParam(name = "street") String street, @WebParam(name = "streetNo") String streetNo) {
        ejbRef.addPatient(firstName, lastName, email, username, password, city, street, streetNo);
    }

    @WebMethod(operationName = "getPatient")
    public Patient getPatient(@WebParam(name = "username") String username) {
        return ejbRef.getPatient(username);
    }

    @WebMethod(operationName = "userExists")
    public boolean userExists(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.userExists(username, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllPatientsSchedule")
    public Vector<TimeReference>  getAllPatientsSchedule() {
        //TODO write your implementation code here:
        return ejbRef.getAllPatientsSchedule();
    }
    
    
    
}
