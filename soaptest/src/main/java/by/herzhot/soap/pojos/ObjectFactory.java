
package by.herzhot.soap.pojos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sawara.hitachi.com package. 
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

    private final static QName _UqcOrderReferServiceResponse_QNAME = new QName("http://com.hitachi.sawara/", "UqcOrderReferServiceResponse");
    private final static QName _UqcOrderReferService_QNAME = new QName("http://com.hitachi.sawara/", "UqcOrderReferService");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sawara.hitachi.com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UqcOrderReferServiceResponse }
     * 
     */
    public UqcOrderReferServiceResponse createUqcOrderReferServiceResponse() {
        return new UqcOrderReferServiceResponse();
    }

    /**
     * Create an instance of {@link UqcOrderReferService }
     * 
     */
    public UqcOrderReferService createUqcOrderReferService() {
        return new UqcOrderReferService();
    }

    /**
     * Create an instance of {@link UqcOrderReferResponse }
     * 
     */
    public UqcOrderReferResponse createUqcOrderReferResponse() {
        return new UqcOrderReferResponse();
    }

    /**
     * Create an instance of {@link CusconRequestCommonItem }
     * 
     */
    public CusconRequestCommonItem createCusconRequestCommonItem() {
        return new CusconRequestCommonItem();
    }

    /**
     * Create an instance of {@link CusconRequestSoStatus }
     * 
     */
    public CusconRequestSoStatus createCusconRequestSoStatus() {
        return new CusconRequestSoStatus();
    }

    /**
     * Create an instance of {@link CusconResponseCommonItem }
     * 
     */
    public CusconResponseCommonItem createCusconResponseCommonItem() {
        return new CusconResponseCommonItem();
    }

    /**
     * Create an instance of {@link UqcOrderReferRequest }
     * 
     */
    public UqcOrderReferRequest createUqcOrderReferRequest() {
        return new UqcOrderReferRequest();
    }

    /**
     * Create an instance of {@link CusconCommonHeader }
     * 
     */
    public CusconCommonHeader createCusconCommonHeader() {
        return new CusconCommonHeader();
    }

    /**
     * Create an instance of {@link CusconResponseSoStatus }
     * 
     */
    public CusconResponseSoStatus createCusconResponseSoStatus() {
        return new CusconResponseSoStatus();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UqcOrderReferServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.hitachi.sawara/", name = "UqcOrderReferServiceResponse")
    public JAXBElement<UqcOrderReferServiceResponse> createUqcOrderReferServiceResponse(UqcOrderReferServiceResponse value) {
        return new JAXBElement<UqcOrderReferServiceResponse>(_UqcOrderReferServiceResponse_QNAME, UqcOrderReferServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UqcOrderReferService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.hitachi.sawara/", name = "UqcOrderReferService")
    public JAXBElement<UqcOrderReferService> createUqcOrderReferService(UqcOrderReferService value) {
        return new JAXBElement<UqcOrderReferService>(_UqcOrderReferService_QNAME, UqcOrderReferService.class, null, value);
    }

}
