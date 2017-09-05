
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

    private final static QName _AddGeneralNeed_QNAME = new QName("http://ws/", "addGeneralNeed");
    private final static QName _GetAllPatientNeed_QNAME = new QName("http://ws/", "getAllPatientNeed");
    private final static QName _GetAllPatientNeedResponse_QNAME = new QName("http://ws/", "getAllPatientNeedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddGeneralNeed }
     * 
     */
    public AddGeneralNeed createAddGeneralNeed() {
        return new AddGeneralNeed();
    }

    /**
     * Create an instance of {@link GetAllPatientNeed }
     * 
     */
    public GetAllPatientNeed createGetAllPatientNeed() {
        return new GetAllPatientNeed();
    }

    /**
     * Create an instance of {@link GetAllPatientNeedResponse }
     * 
     */
    public GetAllPatientNeedResponse createGetAllPatientNeedResponse() {
        return new GetAllPatientNeedResponse();
    }

    /**
     * Create an instance of {@link PatientNeed }
     * 
     */
    public PatientNeed createPatientNeed() {
        return new PatientNeed();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGeneralNeed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "addGeneralNeed")
    public JAXBElement<AddGeneralNeed> createAddGeneralNeed(AddGeneralNeed value) {
        return new JAXBElement<AddGeneralNeed>(_AddGeneralNeed_QNAME, AddGeneralNeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPatientNeed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllPatientNeed")
    public JAXBElement<GetAllPatientNeed> createGetAllPatientNeed(GetAllPatientNeed value) {
        return new JAXBElement<GetAllPatientNeed>(_GetAllPatientNeed_QNAME, GetAllPatientNeed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPatientNeedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getAllPatientNeedResponse")
    public JAXBElement<GetAllPatientNeedResponse> createGetAllPatientNeedResponse(GetAllPatientNeedResponse value) {
        return new JAXBElement<GetAllPatientNeedResponse>(_GetAllPatientNeedResponse_QNAME, GetAllPatientNeedResponse.class, null, value);
    }

}
