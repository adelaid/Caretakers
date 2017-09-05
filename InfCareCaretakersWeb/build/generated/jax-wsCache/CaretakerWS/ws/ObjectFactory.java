
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

    private final static QName _AddCaretaker_QNAME = new QName("http://ws/", "addCaretaker");
    private final static QName _GetAllCaretakersSchedule_QNAME = new QName("http://ws/", "getAllCaretakersSchedule");
    private final static QName _GetAllCaretakersScheduleResponse_QNAME = new QName("http://ws/", "getAllCaretakersScheduleResponse");
    private final static QName _GetCaretaker_QNAME = new QName("http://ws/", "getCaretaker");
    private final static QName _GetCaretakerResponse_QNAME = new QName("http://ws/", "getCaretakerResponse");
    private final static QName _SetVisit_QNAME = new QName("http://ws/", "setVisit");
    private final static QName _UserExists_QNAME = new QName("http://ws/", "userExists");
    private final static QName _UserExistsResponse_QNAME = new QName("http://ws/", "userExistsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCaretaker }
     * 
     */
    public AddCaretaker createAddCaretaker() {
        return new AddCaretaker();
    }

    /**
     * Create an instance of {@link GetAllCaretakersSchedule }
     * 
     */
    public GetAllCaretakersSchedule createGetAllCaretakersSchedule() {
        return new GetAllCaretakersSchedule();
    }

    /**
     * Create an instance of {@link GetAllCaretakersScheduleResponse }
     * 
     */
    public GetAllCaretakersScheduleResponse createGetAllCaretakersScheduleResponse() {
        return new GetAllCaretakersScheduleResponse();
    }

    /**
     * Create an instance of {@link GetCaretaker }
     * 
     */
    public GetCaretaker createGetCaretaker() {
        return new GetCaretaker();
    }

    /**
     * Create an instance of {@link GetCaretakerResponse }
     * 
     */
    public GetCaretakerResponse createGetCaretakerResponse() {
        return new GetCaretakerResponse();
    }

    /**
     * Create an instance of {@link SetVisit }
     * 
     */
    public SetVisit createSetVisit() {
        return new SetVisit();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCaretaker }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "addCaretaker")
    public JAXBElement<AddCaretaker> createAddCaretaker(AddCaretaker value) {
        return new JAXBElement<AddCaretaker>(_AddCaretaker_QNAME, AddCaretaker.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCaretakersSchedule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllCaretakersSchedule")
    public JAXBElement<GetAllCaretakersSchedule> createGetAllCaretakersSchedule(GetAllCaretakersSchedule value) {
        return new JAXBElement<GetAllCaretakersSchedule>(_GetAllCaretakersSchedule_QNAME, GetAllCaretakersSchedule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCaretakersScheduleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllCaretakersScheduleResponse")
    public JAXBElement<GetAllCaretakersScheduleResponse> createGetAllCaretakersScheduleResponse(GetAllCaretakersScheduleResponse value) {
        return new JAXBElement<GetAllCaretakersScheduleResponse>(_GetAllCaretakersScheduleResponse_QNAME, GetAllCaretakersScheduleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaretaker }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getCaretaker")
    public JAXBElement<GetCaretaker> createGetCaretaker(GetCaretaker value) {
        return new JAXBElement<GetCaretaker>(_GetCaretaker_QNAME, GetCaretaker.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaretakerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getCaretakerResponse")
    public JAXBElement<GetCaretakerResponse> createGetCaretakerResponse(GetCaretakerResponse value) {
        return new JAXBElement<GetCaretakerResponse>(_GetCaretakerResponse_QNAME, GetCaretakerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetVisit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "setVisit")
    public JAXBElement<SetVisit> createSetVisit(SetVisit value) {
        return new JAXBElement<SetVisit>(_SetVisit_QNAME, SetVisit.class, null, value);
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
