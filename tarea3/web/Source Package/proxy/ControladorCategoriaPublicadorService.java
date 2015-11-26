
package proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ControladorCategoriaPublicadorService", targetNamespace = "http://servidor/", wsdlLocation = "http://localhost:9128/categoria?wsdl")
public class ControladorCategoriaPublicadorService
    extends Service
{

    private final static URL CONTROLADORCATEGORIAPUBLICADORSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONTROLADORCATEGORIAPUBLICADORSERVICE_EXCEPTION;
    private final static QName CONTROLADORCATEGORIAPUBLICADORSERVICE_QNAME = new QName("http://servidor/", "ControladorCategoriaPublicadorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9128/categoria?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONTROLADORCATEGORIAPUBLICADORSERVICE_WSDL_LOCATION = url;
        CONTROLADORCATEGORIAPUBLICADORSERVICE_EXCEPTION = e;
    }

    public ControladorCategoriaPublicadorService() {
        super(__getWsdlLocation(), CONTROLADORCATEGORIAPUBLICADORSERVICE_QNAME);
    }

    public ControladorCategoriaPublicadorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTROLADORCATEGORIAPUBLICADORSERVICE_QNAME, features);
    }

    public ControladorCategoriaPublicadorService(URL wsdlLocation) {
        super(wsdlLocation, CONTROLADORCATEGORIAPUBLICADORSERVICE_QNAME);
    }

    public ControladorCategoriaPublicadorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTROLADORCATEGORIAPUBLICADORSERVICE_QNAME, features);
    }

    public ControladorCategoriaPublicadorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControladorCategoriaPublicadorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ControladorCategoriaPublicador
     */
    @WebEndpoint(name = "ControladorCategoriaPublicadorPort")
    public ControladorCategoriaPublicador getControladorCategoriaPublicadorPort() {
        return super.getPort(new QName("http://servidor/", "ControladorCategoriaPublicadorPort"), ControladorCategoriaPublicador.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ControladorCategoriaPublicador
     */
    @WebEndpoint(name = "ControladorCategoriaPublicadorPort")
    public ControladorCategoriaPublicador getControladorCategoriaPublicadorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servidor/", "ControladorCategoriaPublicadorPort"), ControladorCategoriaPublicador.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTROLADORCATEGORIAPUBLICADORSERVICE_EXCEPTION!= null) {
            throw CONTROLADORCATEGORIAPUBLICADORSERVICE_EXCEPTION;
        }
        return CONTROLADORCATEGORIAPUBLICADORSERVICE_WSDL_LOCATION;
    }

}
