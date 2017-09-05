
package ws;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "VisitWS", targetNamespace = "http://ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface VisitWS {


    /**
     * 
     * @return
     *     returns java.util.List<ws.Visit>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllVisits", targetNamespace = "http://ws/", className = "ws.GetAllVisits")
    @ResponseWrapper(localName = "getAllVisitsResponse", targetNamespace = "http://ws/", className = "ws.GetAllVisitsResponse")
    @Action(input = "http://ws/VisitWS/getAllVisitsRequest", output = "http://ws/VisitWS/getAllVisitsResponse")
    public List<Visit> getAllVisits();

    /**
     * 
     * @param visitId
     * @param grade
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "giveGrade", targetNamespace = "http://ws/", className = "ws.GiveGrade")
    @Action(input = "http://ws/VisitWS/giveGrade")
    public void giveGrade(
        @WebParam(name = "grade", targetNamespace = "")
        int grade,
        @WebParam(name = "visitId", targetNamespace = "")
        Long visitId);

    /**
     * 
     * @param visitId
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "confirmVisit", targetNamespace = "http://ws/", className = "ws.ConfirmVisit")
    @Action(input = "http://ws/VisitWS/confirmVisit")
    public void confirmVisit(
        @WebParam(name = "visitId", targetNamespace = "")
        Long visitId);

    /**
     * 
     * @param username
     * @return
     *     returns java.util.List<ws.Visit>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVisitsByPatient", targetNamespace = "http://ws/", className = "ws.GetVisitsByPatient")
    @ResponseWrapper(localName = "getVisitsByPatientResponse", targetNamespace = "http://ws/", className = "ws.GetVisitsByPatientResponse")
    @Action(input = "http://ws/VisitWS/getVisitsByPatientRequest", output = "http://ws/VisitWS/getVisitsByPatientResponse")
    public List<Visit> getVisitsByPatient(
        @WebParam(name = "username", targetNamespace = "")
        String username);

}
