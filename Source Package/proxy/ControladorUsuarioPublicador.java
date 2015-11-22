
package proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ControladorUsuarioPublicador", targetNamespace = "http://servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControladorUsuarioPublicador {


    /**
     * 
     * @return
     *     returns client.DataUsuarioArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarUsuariosRequest", output = "http://servidor/ControladorUsuarioPublicador/listarUsuariosResponse")
    public DataUsuarioArray listarUsuarios();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod(operationName = "CargarDatosUsuario2")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/CargarDatosUsuario2Request", output = "http://servidor/ControladorUsuarioPublicador/CargarDatosUsuario2Response", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://servidor/ControladorUsuarioPublicador/CargarDatosUsuario2/Fault/Exception")
    })
    public void cargarDatosUsuario2(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        DataDireccion arg4,
        @WebParam(name = "arg5", partName = "arg5")
        StringArray arg5)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/existeUsuario2Request", output = "http://servidor/ControladorUsuarioPublicador/existeUsuario2Response")
    public boolean existeUsuario2(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns client.DataUsuario
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/obtenerUsuarioRequest", output = "http://servidor/ControladorUsuarioPublicador/obtenerUsuarioResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://servidor/ControladorUsuarioPublicador/obtenerUsuario/Fault/Exception")
    })
    public DataUsuario obtenerUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns client.DataRestauranteArray
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarRestaurantes2Request", output = "http://servidor/ControladorUsuarioPublicador/listarRestaurantes2Response", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://servidor/ControladorUsuarioPublicador/listarRestaurantes2/Fault/Exception")
    })
    public DataRestauranteArray listarRestaurantes2(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param fileName
     * @return
     *     returns byte[]
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/getImageRequest", output = "http://servidor/ControladorUsuarioPublicador/getImageResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://servidor/ControladorUsuarioPublicador/getImage/Fault/Exception")
    })
    public byte[] getImage(
        @WebParam(name = "fileName", partName = "fileName")
        String fileName)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     */
    @WebMethod(operationName = "CargarDatosUsuario")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/CargarDatosUsuarioRequest", output = "http://servidor/ControladorUsuarioPublicador/CargarDatosUsuarioResponse")
    public void cargarDatosUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        DataDireccion arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        XMLGregorianCalendar arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorUsuarioPublicador/altaUsuarioRequest", output = "http://servidor/ControladorUsuarioPublicador/altaUsuarioResponse")
    public void altaUsuario();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorUsuarioPublicador/seleccionarCategoriaRequest", output = "http://servidor/ControladorUsuarioPublicador/seleccionarCategoriaResponse")
    public void seleccionarCategoria(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorUsuarioPublicador/limpiarMemoriaRequest", output = "http://servidor/ControladorUsuarioPublicador/limpiarMemoriaResponse")
    public void limpiarMemoria();

    /**
     * 
     * @return
     *     returns client.DataRestauranteArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarRestaurantesRequest", output = "http://servidor/ControladorUsuarioPublicador/listarRestaurantesResponse")
    public DataRestauranteArray listarRestaurantes();

    /**
     * 
     * @param arg0
     * @return
     *     returns client.DataProductoArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarProductosRequest", output = "http://servidor/ControladorUsuarioPublicador/listarProductosResponse")
    public DataProductoArray listarProductos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns client.DataClienteArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarClientesRequest", output = "http://servidor/ControladorUsuarioPublicador/listarClientesResponse")
    public DataClienteArray listarClientes();

    /**
     * 
     * @param arg0
     * @return
     *     returns client.DataPedidoArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarPedidosClienteRequest", output = "http://servidor/ControladorUsuarioPublicador/listarPedidosClienteResponse")
    public DataPedidoArray listarPedidosCliente(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/existeUsuarioRequest", output = "http://servidor/ControladorUsuarioPublicador/existeUsuarioResponse")
    public boolean existeUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns client.DataCategoriaArray
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorUsuarioPublicador/listarCategoriasRequest", output = "http://servidor/ControladorUsuarioPublicador/listarCategoriasResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://servidor/ControladorUsuarioPublicador/listarCategorias/Fault/Exception")
    })
    public DataCategoriaArray listarCategorias(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws Exception_Exception
    ;

}
