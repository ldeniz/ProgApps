/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controlador.ControladorProducto;
import datatype.DataIndividual;
import datatype.DataProducto;
import datatype.DataPromocion;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 *
 * @author sestefan
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorProductoPublicador {

    private Endpoint endpoint = null;

    //Constructor
    public ControladorProductoPublicador() {
    }

    //Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9128/producto", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod()
    public DataIndividual[] listarProductosIndividuales() {
        ControladorProducto cp = new ControladorProducto();
        ArrayList<DataIndividual> ldc = cp.listarProductosIndividuales();
        DataIndividual[] var = new DataIndividual[ldc.size()];
        var = ldc.toArray(var);
        return var;
    }

    @WebMethod
    public DataPromocion[] listarProductosPromocion() {
        ControladorProducto cp = new ControladorProducto();
        ArrayList<DataPromocion> ldc = cp.listarProductosPromociones();
        DataPromocion[] var = new DataPromocion[ldc.size()];
        var = ldc.toArray(var);
        return var;
    }

    @WebMethod
    public void cargarDatosProducto(String nombre, String descripcion, float precio, String rutaImagen) {
        ControladorProducto cp = new ControladorProducto();
        cp.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
    }

    @WebMethod
    public void cargarDatosProducto(String nombre, String descripcion, int descuento, String rutaImagen) {
        ControladorProducto cp = new ControladorProducto();
        cp.CargarDatosModificarProducto(nombre, nombre, descripcion, rutaImagen, descuento, true);
    }

    @WebMethod
    public boolean existeProducto(String nickName, String nombre) {
        ControladorProducto cp = new ControladorProducto();
        return cp.existeProducto(nickName, nombre);
    }

    @WebMethod
    public void seleccionarRestaurante(String nickName) {
        ControladorProducto cp = new ControladorProducto();
        cp.seleccionarRestaurante(nickName);
    }

    @WebMethod
    public void seleccionarProducto(String nombre, int cantidad) {
        ControladorProducto cp = new ControladorProducto();
        cp.seleccionarProducto(nombre, cantidad);
    }

    @WebMethod
    public DataProducto obtenerDatosRestauranteNombre(String nickName, String nombre) {
        ControladorProducto cp = new ControladorProducto();
        return cp.obtenerDatosRestauranteNombre(nickName, nombre);
    }

    @WebMethod
    public void CargarDatosModificarProducto(String mombreViejo, String nombre, String descripcion,
            String rutaImagen, float precio) {
        ControladorProducto cp = new ControladorProducto();
        cp.CargarDatosModificarProducto(nombre, nombre, descripcion, rutaImagen, precio);
    }

    @WebMethod
    public void CargarDatosModificarProducto(String mombreViejo, String nombre, String descripcion,
            String rutaImagen, int descuento, boolean activa) {
        ControladorProducto cp = new ControladorProducto();
        cp.CargarDatosModificarProducto(nombre, nombre, descripcion, rutaImagen, descuento, activa);
    }

    @WebMethod
    public void altaProducto() {
        ControladorProducto cp = new ControladorProducto();
        cp.altaProducto();
    }

    @WebMethod
    public void ModificarProducto() {
        ControladorProducto cp = new ControladorProducto();
        cp.ModificarProducto();
    }

    @WebMethod
    public DataProducto[] listarProductos() {
        ControladorProducto cp = new ControladorProducto();
        ArrayList<DataProducto> ldp = cp.listarProductos();
        DataProducto[] var = new DataProducto[ldp.size()];
        var = ldp.toArray(var);
        return var;
    }

    @WebMethod
    public void limpiarMemoria(){
        ControladorProducto cp = new ControladorProducto();
        cp.limpiarMemoria();
    }
}
