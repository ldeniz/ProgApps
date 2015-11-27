
package proxy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ControladorProductoPublicador", targetNamespace = "http://servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControladorProductoPublicador {


    /**
     * 
     * @return
     *     returns proxy.DataIndividualArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorProductoPublicador/listarProductosIndividualesRequest", output = "http://servidor/ControladorProductoPublicador/listarProductosIndividualesResponse")
    public DataIndividualArray listarProductosIndividuales();

    /**
     * 
     * @return
     *     returns proxy.DataPromocionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorProductoPublicador/listarProductosPromocionRequest", output = "http://servidor/ControladorProductoPublicador/listarProductosPromocionResponse")
    public DataPromocionArray listarProductosPromocion();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorProductoPublicador/cargarDatosProducto2Request", output = "http://servidor/ControladorProductoPublicador/cargarDatosProducto2Response")
    public void cargarDatosProducto2(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "CargarDatosModificarProducto2")
    @Action(input = "http://servidor/ControladorProductoPublicador/CargarDatosModificarProducto2Request", output = "http://servidor/ControladorProductoPublicador/CargarDatosModificarProducto2Response")
    public void cargarDatosModificarProducto2(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        int arg4,
        @WebParam(name = "arg5", partName = "arg5")
        boolean arg5);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorProductoPublicador/limpiarMemoriaRequest", output = "http://servidor/ControladorProductoPublicador/limpiarMemoriaResponse")
    public void limpiarMemoria();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorProductoPublicador/seleccionarRestauranteRequest", output = "http://servidor/ControladorProductoPublicador/seleccionarRestauranteResponse")
    public void seleccionarRestaurante(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorProductoPublicador/cargarDatosProductoRequest", output = "http://servidor/ControladorProductoPublicador/cargarDatosProductoResponse")
    public void cargarDatosProducto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        float arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3);

    /**
     * 
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorProductoPublicador/altaProductoRequest", output = "http://servidor/ControladorProductoPublicador/altaProductoResponse")
    public void altaProducto();

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://servidor/ControladorProductoPublicador/seleccionarProductoRequest", output = "http://servidor/ControladorProductoPublicador/seleccionarProductoResponse")
    public void seleccionarProducto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1);

    /**
     * 
     * @return
     *     returns proxy.DataProductoArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorProductoPublicador/listarProductosRequest", output = "http://servidor/ControladorProductoPublicador/listarProductosResponse")
    public DataProductoArray listarProductos();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorProductoPublicador/existeProductoRequest", output = "http://servidor/ControladorProductoPublicador/existeProductoResponse")
    public boolean existeProducto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod(operationName = "CargarDatosModificarProducto")
    @Action(input = "http://servidor/ControladorProductoPublicador/CargarDatosModificarProductoRequest", output = "http://servidor/ControladorProductoPublicador/CargarDatosModificarProductoResponse")
    public void cargarDatosModificarProducto(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        float arg4);

    /**
     * 
     */
    @WebMethod(operationName = "ModificarProducto")
    @Action(input = "http://servidor/ControladorProductoPublicador/ModificarProductoRequest", output = "http://servidor/ControladorProductoPublicador/ModificarProductoResponse")
    public void modificarProducto();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns proxy.DataProducto
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/ControladorProductoPublicador/obtenerDatosRestauranteNombreRequest", output = "http://servidor/ControladorProductoPublicador/obtenerDatosRestauranteNombreResponse")
    public DataProducto obtenerDatosRestauranteNombre(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

}