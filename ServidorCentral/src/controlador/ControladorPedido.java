/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataPedido;
import datatype.EnumEstado;
import interfaces.IControladorPedido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import manejador.ManejadorPedido;
import manejador.ManejadorProducto;
import manejador.ManejadorUsuario;
import modelo.Pedido;
import modelo.PedidoProduco;
import modelo.Producto;
import modelo.StockProduco;

/**
 *
 * @author sestefan
 */
public class ControladorPedido implements IControladorPedido {

    private String nickNameCliente;
    private String nickNameRestaurante;
    private Pedido pedido;
    private ArrayList<PedidoProduco> productos;

    @Override
    public void seleccionarCliente(String nickName) throws Exception {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        if (!mu.existeUsuarioNickName(nickName)) {
            throw new Exception("El cliente '" + nickName + "' no existe");
        }
        this.nickNameCliente = nickName;
    }

    @Override
    public void seleccionarRestaurante(String nickName) throws Exception {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        if (!mu.existeUsuarioNickName(nickName)) {
            throw new Exception("El restaurante '" + nickName + "' no existe");
        }
        this.nickNameRestaurante = nickName;
    }

    @Override
    public void seleccionarProducto(String nickName, String nombreProducto, int cantidad) throws Exception {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        Producto p = mp.obtenerProducto(nickName, nombreProducto);
        StockProduco sp = p.getStock();
        if (sp.getCantidad() > cantidad) {
            throw new Exception("La cantidad de productos '" + nickName
                    + "' es menor a la solicitada");
        }
        PedidoProduco pp = new PedidoProduco(cantidad, sp);
        productos.add(pp);
    }

    @Override
    public DataPedido finalizarPedido() {
        float precioTotal = 0;
        Pedido p = new Pedido();
        p.setEstado(EnumEstado.PREPARACION);
        p.setPedidoProducos(productos);
        p.setPrecioTotal(precioTotal);
        p.setFechaPedido(Calendar.getInstance(new Locale("es", "uy")));

        ManejadorPedido mp = ManejadorPedido.getInstance();
        mp.ingresarPedido(p);

        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        mu.agregarPedidoUsuario(nickNameCliente, p);
        mu.agregarPedidoUsuario(nickNameRestaurante, p);

        ManejadorProducto mpr = ManejadorProducto.getInstance();
        StockProduco sp;
        for (PedidoProduco pp : productos) {
            sp = pp.getStockProduco();
            mpr.agregarPedido(nickNameRestaurante, sp.getNombreProducto(),
                    pp.getCantidad(), p);
        }
        return p.obtenerDatosPedido();
    }

    @Override
    public void listarPedidos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
