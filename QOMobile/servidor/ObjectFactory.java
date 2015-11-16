
package servidor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servidor package. 
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

    private final static QName _Exception_QNAME = new QName("http://servidor/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link DataRestauranteArray }
     * 
     */
    public DataRestauranteArray createDataRestauranteArray() {
        return new DataRestauranteArray();
    }

    /**
     * Create an instance of {@link DataRestaurante }
     * 
     */
    public DataRestaurante createDataRestaurante() {
        return new DataRestaurante();
    }

    /**
     * Create an instance of {@link DataPedidoProduco }
     * 
     */
    public DataPedidoProduco createDataPedidoProduco() {
        return new DataPedidoProduco();
    }

    /**
     * Create an instance of {@link DataUsuario }
     * 
     */
    public DataUsuario createDataUsuario() {
        return new DataUsuario();
    }

    /**
     * Create an instance of {@link DataCategoriaArray }
     * 
     */
    public DataCategoriaArray createDataCategoriaArray() {
        return new DataCategoriaArray();
    }

    /**
     * Create an instance of {@link DataProducto }
     * 
     */
    public DataProducto createDataProducto() {
        return new DataProducto();
    }

    /**
     * Create an instance of {@link DataStockProducto }
     * 
     */
    public DataStockProducto createDataStockProducto() {
        return new DataStockProducto();
    }

    /**
     * Create an instance of {@link DataComentario }
     * 
     */
    public DataComentario createDataComentario() {
        return new DataComentario();
    }

    /**
     * Create an instance of {@link DataCategoria }
     * 
     */
    public DataCategoria createDataCategoria() {
        return new DataCategoria();
    }

    /**
     * Create an instance of {@link DataPedido }
     * 
     */
    public DataPedido createDataPedido() {
        return new DataPedido();
    }

    /**
     * Create an instance of {@link DataDireccion }
     * 
     */
    public DataDireccion createDataDireccion() {
        return new DataDireccion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
