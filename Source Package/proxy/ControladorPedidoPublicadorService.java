
package proxy;

import proxy.ControladorPedidoPublicador;
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
@WebServiceClient(name = "ControladorPedidoPublicadorService", targetNamespace = "http://servidor/", wsdlLocation = "http://localhost:9128/pedido?wsdl")
public class ControladorPedidoPublicadorService
    extends Service
{

    private final static URL CONTROLADORPEDIDOPUBLICADORSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONTROLADORPEDIDOPUBLICADORSERVICE_EXCEPTION;
    private final static QName CONTROLADORPEDIDOPUBLICADORSERVICE_QNAME = new QName("http://servidor/", "ControladorPedidoPublicadorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9128/pedido?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONTROLADORPEDIDOPUBLICADORSERVICE_WSDL_LOCATION = url;
        CONTROLADORPEDIDOPUBLICADORSERVICE_EXCEPTION = e;
    }

    public ControladorPedidoPublicadorService() {
        super(__getWsdlLocation(), CONTROLADORPEDIDOPUBLICADORSERVICE_QNAME);
    }

    public ControladorPedidoPublicadorService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTROLADORPEDIDOPUBLICADORSERVICE_QNAME, features);
    }

    public ControladorPedidoPublicadorService(URL wsdlLocation) {
        super(wsdlLocation, CONTROLADORPEDIDOPUBLICADORSERVICE_QNAME);
    }

    public ControladorPedidoPublicadorService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTROLADORPEDIDOPUBLICADORSERVICE_QNAME, features);
    }

    public ControladorPedidoPublicadorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControladorPedidoPublicadorService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ControladorPedidoPublicador
     */
    @WebEndpoint(name = "ControladorPedidoPublicadorPort")
    public ControladorPedidoPublicador getControladorPedidoPublicadorPort() {
        return super.getPort(new QName("http://servidor/", "ControladorPedidoPublicadorPort"), ControladorPedidoPublicador.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ControladorPedidoPublicador
     */
    @WebEndpoint(name = "ControladorPedidoPublicadorPort")
    public ControladorPedidoPublicador getControladorPedidoPublicadorPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servidor/", "ControladorPedidoPublicadorPort"), ControladorPedidoPublicador.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTROLADORPEDIDOPUBLICADORSERVICE_EXCEPTION!= null) {
            throw CONTROLADORPEDIDOPUBLICADORSERVICE_EXCEPTION;
        }
        return CONTROLADORPEDIDOPUBLICADORSERVICE_WSDL_LOCATION;
    }

}
