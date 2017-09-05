
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConfirmVisit_QNAME = new QName("http://ws/", "confirmVisit");
    private final static QName _GetAllVisits_QNAME = new QName("http://ws/", "getAllVisits");
    private final static QName _GetAllVisitsResponse_QNAME = new QName("http://ws/", "getAllVisitsResponse");
    private final static QName _GetVisitsByPatient_QNAME = new QName("http://ws/", "getVisitsByPatient");
    private final static QName _GetVisitsByPatientResponse_QNAME = new QName("http://ws/", "getVisitsByPatientResponse");
    private final static QName _GiveGrade_QNAME = new QName("http://ws/", "giveGrade");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmVisit }
     * 
     */
    public ConfirmVisit createConfirmVisit() {
        return new ConfirmVisit();
    }

    /**
     * Create an instance of {@link GetAllVisits }
     * 
     */
    public GetAllVisits createGetAllVisits() {
        return new GetAllVisits();
    }

    /**
     * Create an instance of {@link GetAllVisitsResponse }
     * 
     */
    public GetAllVisitsResponse createGetAllVisitsResponse() {
        return new GetAllVisitsResponse();
    }

    /**
     * Create an instance of {@link GetVisitsByPatient }
     * 
     */
    public GetVisitsByPatient createGetVisitsByPatient() {
        return new GetVisitsByPatient();
    }

    /**
     * Create an instance of {@link GetVisitsByPatientResponse }
     * 
     */
    public GetVisitsByPatientResponse createGetVisitsByPatientResponse() {
        return new GetVisitsByPatientResponse();
    }

    /**
     * Create an instance of {@link GiveGrade }
     * 
     */
    public GiveGrade createGiveGrade() {
        return new GiveGrade();
    }

    /**
     * Create an instance of {@link Visit }
     * 
     */
    public Visit createVisit() {
        return new Visit();
    }

    /**
     * Create an instance of {@link Caretaker }
     * 
     */
    public Caretaker createCaretaker() {
        return new Caretaker();
    }

    /**
     * Create an instance of {@link TimeReference }
     * 
     */
    public TimeReference createTimeReference() {
        return new TimeReference();
    }

    /**
     * Create an instance of {@link Patient }
     * 
     */
    public Patient createPatient() {
        return new Patient();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmVisit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "confirmVisit")
    public JAXBElement<ConfirmVisit> createConfirmVisit(ConfirmVisit value) {
        return new JAXBElement<ConfirmVisit>(_ConfirmVisit_QNAME, ConfirmVisit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVisits }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllVisits")
    public JAXBElement<GetAllVisits> createGetAllVisits(GetAllVisits value) {
        return new JAXBElement<GetAllVisits>(_GetAllVisits_QNAME, GetAllVisits.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllVisitsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllVisitsResponse")
    public JAXBElement<GetAllVisitsResponse> createGetAllVisitsResponse(GetAllVisitsResponse value) {
        return new JAXBElement<GetAllVisitsResponse>(_GetAllVisitsResponse_QNAME, GetAllVisitsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVisitsByPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getVisitsByPatient")
    public JAXBElement<GetVisitsByPatient> createGetVisitsByPatient(GetVisitsByPatient value) {
        return new JAXBElement<GetVisitsByPatient>(_GetVisitsByPatient_QNAME, GetVisitsByPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVisitsByPatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getVisitsByPatientResponse")
    public JAXBElement<GetVisitsByPatientResponse> createGetVisitsByPatientResponse(GetVisitsByPatientResponse value) {
        return new JAXBElement<GetVisitsByPatientResponse>(_GetVisitsByPatientResponse_QNAME, GetVisitsByPatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GiveGrade }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "giveGrade")
    public JAXBElement<GiveGrade> createGiveGrade(GiveGrade value) {
        return new JAXBElement<GiveGrade>(_GiveGrade_QNAME, GiveGrade.class, null, value);
    }

}
