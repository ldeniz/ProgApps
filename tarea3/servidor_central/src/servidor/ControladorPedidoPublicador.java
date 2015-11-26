/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controlador.ControladorPedido;
import datatype.DataPedido;
import datatype.EnumEstado;
import fabrica.Fabrica;
import interfaces.IControladorPedido;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
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
    public DataPedido realizarPedido(@WebParam(name = "nickNameCliente") String cliente,
            @WebParam(name = "nickNameRestaurante") String restaurante,
            @WebParam(name = "productos") String[] productos,
            @WebParam(name = "cantidades") int[] cantidades) throws Exception {
        IControladorPedido icp = Fabrica.getInstance().obtenerControladorPedido();
        try {
            icp.seleccionarCliente(cliente);
            icp.seleccionarRestaurante(restaurante);
            if (productos.length != cantidades.length) {
                throw new Exception("La cantidad de productos debe ser consistente.");
            } else {
                for (int x = 0; x < productos.length; x++) {
                    icp.seleccionarProducto(restaurante, productos[x], cantidades[x]);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        DataPedido dp = icp.finalizarPedido();
        icp.limpiarMermoria();
        return dp;
    }

    @WebMethod
    public void actualizarPedido(@WebParam(name = "numeroPedido") int numero,
            @WebParam(name = "nuevoEstadoPedido") EnumEstado estado) throws Exception {
        IControladorPedido icp = Fabrica.getInstance().obtenerControladorPedido();
        icp.seleccionarPedido(numero);
        icp.seleccionarEstado(estado);
        icp.actualizarPedido();
    }
    
    @WebMethod
    public void agregarComentario(
            @WebParam(name = "numeroPedido") int numero, 
            @WebParam(name = "comentario") String comentario,
            @WebParam(name = "puntuacion") float puntuacion) throws Exception{
        IControladorPedido icp = Fabrica.getInstance().obtenerControladorPedido();
        icp.agregarComentario(numero, comentario, puntuacion);
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
    public DataPedido[] listarPedidos2(String nickNameRestaurante) throws Exception {
        ControladorPedido cp = new ControladorPedido();
        ArrayList<DataPedido> ldp = cp.listarPedidos(nickNameRestaurante);
        DataPedido[] var = new DataPedido[ldp.size()];
        var = ldp.toArray(var);
        return var;
    }

}
