/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controlador.ControladorPedido;
import datatype.DataPedido;
import datatype.EnumEstado;
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
public class ControladorPedidoPublicador {

    private Endpoint endpoint = null;

    //Constructor
    public ControladorPedidoPublicador() {
    }

    //Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9128/pedido", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void seleccionarCliente(String nickName) throws Exception {
        ControladorPedido cp = new ControladorPedido();
        cp.seleccionarCliente(nickName);
    }

    @WebMethod
    public void seleccionarRestaurante(String nickName) throws Exception {
        ControladorPedido cp = new ControladorPedido();
        cp.seleccionarRestaurante(nickName);
    }

    @WebMethod
    public void seleccionarProducto(String nickName, String nombreProducto, int cantidad) throws Exception {
        ControladorPedido cp = new ControladorPedido();
        cp.seleccionarProducto(nickName, nombreProducto, cantidad);
    }

    @WebMethod
    public void seleccionarPedido(int numero) {
        ControladorPedido cp = new ControladorPedido();
        cp.seleccionarPedido(numero);
    }

    @WebMethod
    public void seleccionarEstado(EnumEstado estado) {
        ControladorPedido cp = new ControladorPedido();
        cp.seleccionarEstado(estado);
    }

    @WebMethod
    public DataPedido finalizarPedido() {
        ControladorPedido cp = new ControladorPedido();
        return cp.finalizarPedido();
    }

    @WebMethod
    public void actualizarPedido() throws Exception {
        ControladorPedido cp = new ControladorPedido();
        cp.actualizarPedido();
    }

    @WebMethod
    public void cancelarPedido() {
        ControladorPedido cp = new ControladorPedido();
        cp.cancelarPedido();
    }

    @WebMethod
    public DataPedido[] listarPedidos() {
        ControladorPedido cp = new ControladorPedido();
        ArrayList<DataPedido> ldp = cp.listarPedidos();
        DataPedido[] var = new DataPedido[ldp.size()];
        var = ldp.toArray(var);
        return var;
    }

    @WebMethod
    public DataPedido[] listarPedidos2(String nickNameRestaurante) throws Exception{
        ControladorPedido cp = new ControladorPedido();
        ArrayList<DataPedido> ldp = cp.listarPedidos(nickNameRestaurante);
        DataPedido[] var = new DataPedido[ldp.size()];
        var = ldp.toArray(var);
        return var;
    }

    @WebMethod
    public void agregarComentario(int numPedido, String comentario, float puntaje) throws Exception{
        ControladorPedido cp = new ControladorPedido();
        cp.agregarComentario(numPedido, comentario, puntaje);
    }

    @WebMethod
    public void limpiarMermoria() {
        ControladorPedido cp = new ControladorPedido();
        cp.limpiarMermoria();
    }

}
