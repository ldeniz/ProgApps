/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.EnumEstado;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorPedido;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sestefan
 */
public class ServidorCentral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IControladorCategoria c = Fabrica.getInstance().obtenerControladorCategoria();
        IControladorUsuario u = Fabrica.getInstance().obtenerControladorUsuario();
        IControladorProducto p = Fabrica.getInstance().obtenerControladorProducto();
        IControladorPedido pd = Fabrica.getInstance().obtenerControladorPedido();

        c.altaCategoria("pizzas");
        String[] rutaImagen = {"a", "b"};
        u.seleccionarCategoria("pizzas");
        try {
            u.CargarDatosUsuario("acabar", "a@b.c", "Aca Bar", "123", new DataDireccion("a", "b", "c"), rutaImagen);
        } catch (Exception ex) {
            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.altaUsuario();
        p.seleccionarRestaurante("acabar");
        p.cargarDatosProducto("musa", "pizza con muzzarella", (float) 150.0, "1");
        p.altaProducto();
        p.limpiarMemoria();
        p.seleccionarRestaurante("acabar");
        p.cargarDatosProducto("faina", "faina", (float) 75.0, "2");
        p.altaProducto();
        p.limpiarMemoria();

        ArrayList<DataProducto> ldp = p.listarProductos();
        for (DataProducto dp : ldp) {
            System.out.println(dp.getNickName());
            System.out.println(dp.getNombre());
            System.out.println(dp.getTipoProducto());

        }

        p.seleccionarRestaurante("acabar");
        p.cargarDatosProducto("promo pizza", "pizza y faina", 25, "c");
        p.seleccionarProducto("musa", 1);
        p.seleccionarProducto("faina", 1);
        boolean b = p.existeProducto("acabar", "faina");
        p.altaProducto();

        ldp.clear();
        ldp = p.listarProductos();
        for (DataProducto dp : ldp) {
            System.out.println(dp.getNickName());
            System.out.println(dp.getNombre());
            System.out.println(dp.getTipoProducto());
        }

        ArrayList<DataCategoria> ldc = c.listarCategorias();
        for (DataCategoria dc : ldc) {
            ArrayList<DataRestaurante> ldr = dc.getDataRestaurantes();
            for (DataRestaurante dr : ldr) {
                System.out.println("Categoria: " + dc.getNombre() + ", Bar: " + dr.getNombre());
            }
        }

        String nickName = "acabar";
        ldp = u.listarProductos(nickName);
        for (DataProducto dp : ldp) {
            System.out.println("Bar: " + dp.getNickName() + ", Producto: " + dp.getNombre() + ", Tipo: " + dp.getTipoProducto() + ", Precio: " + dp.getStock().getPrecio());
        }

        System.out.println("Modifico promo");

        p.seleccionarRestaurante(nickName);
        p.CargarDatosModificarProducto("promo pizza", "pizza + faina", "bajo la pizza locooo", "c", 30, true);
        p.ModificarProducto();
        p.CargarDatosModificarProducto("musa", "muzza", "fsadfas", "a", 200);
        p.ModificarProducto();

        ldp.clear();

        ldp = u.listarProductos(nickName);
        for (DataProducto dp : ldp) {
            System.out.println("Bar: " + dp.getNickName() + ", Producto: " + dp.getNombre() + ", Tipo: " + dp.getTipoProducto() + ", Precio: " + dp.getStock().getPrecio());
        }

//        Armar un pedido
        u.CargarDatosUsuario("costas", "gcostas@gmail.com", "Gerardo", "1234",
                new DataDireccion("Av. Italia", "2078", null), "Costas",
                new Date(1983, 11, 15), "sda");
        u.altaUsuario();
        u.CargarDatosUsuario("roro", "rcotelo@yahoo.com", "Rodrigo", "  1234",
                new DataDireccion("Pdte. Berro", "1548", null), "Cotelo",
                new Date(1975, 8, 2), "sda");
        u.altaUsuario();
        try {
            pd.seleccionarCliente("costas");
        } catch (Exception ex) {
            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarRestaurante("acabar");
        } catch (Exception ex) {
            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarProducto("acabar", "promo pizza", 1);
            pd.seleccionarProducto("acabar", "musa", 1);
        } catch (Exception ex) {
            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        DataPedido dp = pd.finalizarPedido();
        System.out.println("Número Pedido: " + dp.getNumero());
        System.out.println("Precio total: " + dp.getPrecioTotal());

        ArrayList<DataCliente> listarClientes = u.listarClientes();

        for (DataCliente dc : listarClientes) {
            ArrayList<DataPedido> lpc = dc.getPedidos();
            if (!lpc.isEmpty()) {
                for (DataPedido dped : lpc) {
                    System.out.println(dped.getNumero());
                    System.out.println(dped.getEstado());
                    System.out.println(dped.getPrecioTotal());
                }
            }
        }

        System.out.println("Actualizo pedido");

        pd.seleccionarPedido(1);
        pd.seleccionarEstado(EnumEstado.ENVIADO);
        try {
            pd.actualizarPedido();
        } catch (Exception ex) {
            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        listarClientes = u.listarClientes();

        for (DataCliente dc : listarClientes) {
            ArrayList<DataPedido> lpc = dc.getPedidos();
            if (!lpc.isEmpty()) {
                for (DataPedido dped : lpc) {
                    System.out.println(dped.getNumero());
                    System.out.println(dped.getEstado());
                    System.out.println(dped.getPrecioTotal());
                }
            }
        }

        pd.seleccionarPedido(1);
        pd.seleccionarEstado(EnumEstado.RECIBIDO);
        try {
            pd.actualizarPedido();
        } catch (Exception ex) {
            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Elimino pedido");
        pd.seleccionarPedido(1);
        pd.cancelarPedido();

        listarClientes = u.listarClientes();

        for (DataCliente dc : listarClientes) {
            ArrayList<DataPedido> lpc = dc.getPedidos();
            if (!lpc.isEmpty()) {
                for (DataPedido dped : lpc) {
                    System.out.println(dped.getNumero());
                    System.out.println(dped.getEstado());
                    System.out.println(dped.getPrecioTotal());
                }
            }
        }

    }

}
