
package ru.lab.apps.client;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.lab.apps.client package. 
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

    private static final QName _AddApp_QNAME = new QName("http://service.service.apps.lab.ru/", "addApp");
    private static final QName _AddAppResponse_QNAME = new QName("http://service.service.apps.lab.ru/", "addAppResponse");
    private static final QName _GetAllApps_QNAME = new QName("http://service.service.apps.lab.ru/", "getAllApps");
    private static final QName _GetAllAppsResponse_QNAME = new QName("http://service.service.apps.lab.ru/", "getAllAppsResponse");
    private static final QName _GetAppById_QNAME = new QName("http://service.service.apps.lab.ru/", "getAppById");
    private static final QName _GetAppByIdResponse_QNAME = new QName("http://service.service.apps.lab.ru/", "getAppByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.lab.apps.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddApp }
     * 
     * @return
     *     the new instance of {@link AddApp }
     */
    public AddApp createAddApp() {
        return new AddApp();
    }

    /**
     * Create an instance of {@link AddAppResponse }
     * 
     * @return
     *     the new instance of {@link AddAppResponse }
     */
    public AddAppResponse createAddAppResponse() {
        return new AddAppResponse();
    }

    /**
     * Create an instance of {@link GetAllApps }
     * 
     * @return
     *     the new instance of {@link GetAllApps }
     */
    public GetAllApps createGetAllApps() {
        return new GetAllApps();
    }

    /**
     * Create an instance of {@link GetAllAppsResponse }
     * 
     * @return
     *     the new instance of {@link GetAllAppsResponse }
     */
    public GetAllAppsResponse createGetAllAppsResponse() {
        return new GetAllAppsResponse();
    }

    /**
     * Create an instance of {@link GetAppById }
     * 
     * @return
     *     the new instance of {@link GetAppById }
     */
    public GetAppById createGetAppById() {
        return new GetAppById();
    }

    /**
     * Create an instance of {@link GetAppByIdResponse }
     * 
     * @return
     *     the new instance of {@link GetAppByIdResponse }
     */
    public GetAppByIdResponse createGetAppByIdResponse() {
        return new GetAppByIdResponse();
    }

    /**
     * Create an instance of {@link App }
     * 
     * @return
     *     the new instance of {@link App }
     */
    public App createApp() {
        return new App();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddApp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddApp }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.apps.lab.ru/", name = "addApp")
    public JAXBElement<AddApp> createAddApp(AddApp value) {
        return new JAXBElement<>(_AddApp_QNAME, AddApp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAppResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.apps.lab.ru/", name = "addAppResponse")
    public JAXBElement<AddAppResponse> createAddAppResponse(AddAppResponse value) {
        return new JAXBElement<>(_AddAppResponse_QNAME, AddAppResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllApps }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllApps }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.apps.lab.ru/", name = "getAllApps")
    public JAXBElement<GetAllApps> createGetAllApps(GetAllApps value) {
        return new JAXBElement<>(_GetAllApps_QNAME, GetAllApps.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllAppsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllAppsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.apps.lab.ru/", name = "getAllAppsResponse")
    public JAXBElement<GetAllAppsResponse> createGetAllAppsResponse(GetAllAppsResponse value) {
        return new JAXBElement<>(_GetAllAppsResponse_QNAME, GetAllAppsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAppById }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.apps.lab.ru/", name = "getAppById")
    public JAXBElement<GetAppById> createGetAppById(GetAppById value) {
        return new JAXBElement<>(_GetAppById_QNAME, GetAppById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAppByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.service.apps.lab.ru/", name = "getAppByIdResponse")
    public JAXBElement<GetAppByIdResponse> createGetAppByIdResponse(GetAppByIdResponse value) {
        return new JAXBElement<>(_GetAppByIdResponse_QNAME, GetAppByIdResponse.class, null, value);
    }

}
