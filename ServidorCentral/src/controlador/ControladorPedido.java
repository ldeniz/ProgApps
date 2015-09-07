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
import modelo.StockProducto;

/**
 *
 * @author sestefan
 */
public class ControladorPedido implements IControladorPedido {

    private String nickNameCliente;
    private String nickNameRestaurante;
    private Pedido pedido;
    private ArrayList<PedidoProduco> productos;

    public ControladorPedido() {
        productos = new ArrayList<>();
    }

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
        StockProducto sp = p.getStock();
        if (sp.getCantidad() < cantidad) {
            throw new Exception("La cantidad de productos '" + nickName
                    + "' es menor a la solicitada");
        }
        PedidoProduco pp = new PedidoProduco(cantidad, sp);
        productos.add(pp);
    }

    @Override
    public DataPedido finalizarPedido() {
        float precioTotal = 0;
        pedido = new Pedido();
        pedido.setEstado(EnumEstado.PREPARACION);
        pedido.setPedidoProducos(productos);
        pedido.setFechaPedido(Calendar.getInstance(new Locale("es", "uy")));
        pedido.setNickNameCliente(nickNameCliente);
        pedido.setNickNameRestaurante(nickNameRestaurante);

        ManejadorPedido mp = ManejadorPedido.getInstance();
        mp.ingresarPedido(pedido);

        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        mu.agregarPedidoUsuario(nickNameCliente, pedido);
        mu.agregarPedidoUsuario(nickNameRestaurante, pedido);

        ManejadorProducto mpr = ManejadorProducto.getInstance();
        StockProducto sp;
        for (PedidoProduco pp : productos) {
            sp = pp.getStockProduco();
            mpr.agregarPedido(nickNameRestaurante, sp.getNombreProducto(),
                    pp.getCantidad(), pedido);
            precioTotal += sp.getPrecio() * pp.getCantidad();
        }
        pedido.setPrecioTotal(precioTotal);
        return pedido.obtenerDatosPedido();
    }

    @Override
    public ArrayList<DataPedido> listarPedidos() {
        ManejadorPedido mp = ManejadorPedido.getInstance();
        ArrayList<Pedido> lpedidos = mp.listarPedidos();
        ArrayList<DataPedido> ldp = new ArrayList<>();
        if (!lpedidos.isEmpty()) {
            for (Pedido p : lpedidos) {
                ldp.add(p.obtenerDatosPedido());
            }
        }
        return ldp;
    }

}
