
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

    private final static QName _AddPatient_QNAME = new QName("http://ws/", "addPatient");
    private final static QName _GetAllNeeds_QNAME = new QName("http://ws/", "getAllNeeds");
    private final static QName _GetAllNeedsResponse_QNAME = new QName("http://ws/", "getAllNeedsResponse");
    private final static QName _GetAllPatientsSchedule_QNAME = new QName("http://ws/", "getAllPatientsSchedule");
    private final static QName _GetAllPatientsScheduleResponse_QNAME = new QName("http://ws/", "getAllPatientsScheduleResponse");
    private final static QName _GetNeed_QNAME = new QName("http://ws/", "getNeed");
    private final static QName _GetNeedResponse_QNAME = new QName("http://ws/", "getNeedResponse");
    private final static QName _GetPatient_QNAME = new QName("http://ws/", "getPatient");
    private final static QName _GetPatientResponse_QNAME = new QName("http://ws/", "getPatientResponse");
    private final static QName _SetNeed_QNAME = new QName("http://ws/", "setNeed");
    private final static QName _UserExists_QNAME = new QName("http://ws/", "userExists");
    private final static QName _UserExistsResponse_QNAME = new QName("http://ws/", "userExistsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPatient }
     * 
     */
    public AddPatient createAddPatient() {
        return new AddPatient();
    }

    /**
     * Create an instance of {@link GetAllNeeds }
     * 
     */
    public GetAllNeeds createGetAllNeeds() {
        return new GetAllNeeds();
    }

    /**
     * Create an instance of {@link GetAllNeedsResponse }
     * 
     */
    public GetAllNeedsResponse createGetAllNeedsResponse() {
        return new GetAllNeedsResponse();
    }

    /**
     * Create an instance of {@link GetAllPatientsSchedule }
     * 
     */
    public GetAllPatientsSchedule createGetAllPatientsSchedule() {
        return new GetAllPatientsSchedule();
    }

    /**
     * Create an instance of {@link GetAllPatientsScheduleResponse }
     * 
     */
    public GetAllPatientsScheduleResponse createGetAllPatientsScheduleResponse() {
        return new GetAllPatientsScheduleResponse();
    }

    /**
     * Create an instance of {@link GetNeed }
     * 
     */
    public GetNeed createGetNeed() {
        return new GetNeed();
    }

    /**
     * Create an instance of {@link GetNeedResponse }
     * 
     */
    public GetNeedResponse createGetNeedResponse() {
        return new GetNeedResponse();
    }

    /**
     * Create an instance of {@link GetPatient }
     * 
     */
    public GetPatient createGetPatient() {
        return new GetPatient();
    }

    /**
     * Create an instance of {@link GetPatientResponse }
     * 
     */
    public GetPatientResponse createGetPatientResponse() {
        return new GetPatientResponse();
    }

    /**
     * Create an instance of {@link SetNeed }
     * 
     */
    public SetNeed createSetNeed() {
        return new SetNeed();
    }

    /**
     * Create an instance of {@link UserExists }
     * 
     */
    public UserExists createUserExists() {
        return new UserExists();
    }

    /**
     * Create an instance of {@link UserExistsResponse }
     * 
     */
    public UserExistsResponse createUserExistsResponse() {
        return new UserExistsResponse();
    }

    /**
     * Create an instance of {@link Need }
     * 
     */
    public Need createNeed() {
        return new Need();
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
     * Create an instance of {@link TimeReference }
     * 
     */
    public TimeReference createTimeReference() {
        return new TimeReference();
    }

    /**
     * Create an instance of {@link Caretaker }
     * 
     */
    public Caretaker createCaretaker() {
        return new Caretaker();
    }

    /**
     * Create an instance of {@link Visit }
     * 
     */
    public Visit createVisit() {
        return new Visit();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "addPatient")
    public JAXBElement<AddPatient> createAddPatient(AddPatient value) {
        return new JAXBElement<AddPatient>(_AddPatient_QNAME, AddPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNeeds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllNeeds")
    public JAXBElement<GetAllNeeds> createGetAllNeeds(GetAllNeeds value) {
        return new JAXBElement<GetAllNeeds>(_GetAllNeeds_QNAME, GetAllNeeds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllNeedsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllNeedsResponse")
    public JAXBElement<GetAllNeedsResponse> createGetAllNeedsResponse(GetAllNeedsResponse value) {
        return new JAXBElement<GetAllNeedsResponse>(_GetAllNeedsResponse_QNAME, GetAllNeedsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPatientsSchedule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllPatientsSchedule")
    public JAXBElement<GetAllPatientsSchedule> createGetAllPatientsSchedule(GetAllPatientsSchedule value) {
        return new JAXBElement<GetAllPatientsSchedule>(_GetAllPatientsSchedule_QNAME, GetAllPatientsSchedule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPatientsScheduleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllPatientsScheduleResponse")
    public JAXBElement<GetAllPatientsScheduleResponse> createGetAllPatientsScheduleResponse(GetAllPatientsScheduleResponse value) {
        return new JAXBElement<GetAllPatientsScheduleResponse>(_GetAllPatientsScheduleResponse_QNAME, GetAllPatientsScheduleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNeed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getNeed")
    public JAXBElement<GetNeed> createGetNeed(GetNeed value) {
        return new JAXBElement<GetNeed>(_GetNeed_QNAME, GetNeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNeedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getNeedResponse")
    public JAXBElement<GetNeedResponse> createGetNeedResponse(GetNeedResponse value) {
        return new JAXBElement<GetNeedResponse>(_GetNeedResponse_QNAME, GetNeedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPatient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getPatient")
    public JAXBElement<GetPatient> createGetPatient(GetPatient value) {
        return new JAXBElement<GetPatient>(_GetPatient_QNAME, GetPatient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPatientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getPatientResponse")
    public JAXBElement<GetPatientResponse> createGetPatientResponse(GetPatientResponse value) {
        return new JAXBElement<GetPatientResponse>(_GetPatientResponse_QNAME, GetPatientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetNeed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "setNeed")
    public JAXBElement<SetNeed> createSetNeed(SetNeed value) {
        return new JAXBElement<SetNeed>(_SetNeed_QNAME, SetNeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserExists }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "userExists")
    public JAXBElement<UserExists> createUserExists(UserExists value) {
        return new JAXBElement<UserExists>(_UserExists_QNAME, UserExists.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserExistsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "userExistsResponse")
    public JAXBElement<UserExistsResponse> createUserExistsResponse(UserExistsResponse value) {
        return new JAXBElement<UserExistsResponse>(_UserExistsResponse_QNAME, UserExistsResponse.class, null, value);
    }

}
