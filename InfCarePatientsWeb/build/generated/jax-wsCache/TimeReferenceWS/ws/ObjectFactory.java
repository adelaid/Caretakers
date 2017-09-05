
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

    private final static QName _AddTimeReference_QNAME = new QName("http://ws/", "addTimeReference");
    private final static QName _GetTimeRef_QNAME = new QName("http://ws/", "getTimeRef");
    private final static QName _GetTimeRefResponse_QNAME = new QName("http://ws/", "getTimeRefResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddTimeReference }
     * 
     */
    public AddTimeReference createAddTimeReference() {
        return new AddTimeReference();
    }

    /**
     * Create an instance of {@link GetTimeRef }
     * 
     */
    public GetTimeRef createGetTimeRef() {
        return new GetTimeRef();
    }

    /**
     * Create an instance of {@link GetTimeRefResponse }
     * 
     */
    public GetTimeRefResponse createGetTimeRefResponse() {
        return new GetTimeRefResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTimeReference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "addTimeReference")
    public JAXBElement<AddTimeReference> createAddTimeReference(AddTimeReference value) {
        return new JAXBElement<AddTimeReference>(_AddTimeReference_QNAME, AddTimeReference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTimeRef")
    public JAXBElement<GetTimeRef> createGetTimeRef(GetTimeRef value) {
        return new JAXBElement<GetTimeRef>(_GetTimeRef_QNAME, GetTimeRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTimeRefResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getTimeRefResponse")
    public JAXBElement<GetTimeRefResponse> createGetTimeRefResponse(GetTimeRefResponse value) {
        return new JAXBElement<GetTimeRefResponse>(_GetTimeRefResponse_QNAME, GetTimeRefResponse.class, null, value);
    }

}
