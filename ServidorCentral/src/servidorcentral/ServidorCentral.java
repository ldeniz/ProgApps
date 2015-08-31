/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral;

import datatype.DataCategoria;
import datatype.DataDireccion;
import datatype.DataProducto;
import datatype.DataRestaurante;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
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

        }

        p.seleccionarRestaurante("acabar");
        p.cargarDatosProducto("promo pizza", "pizza y faina", 25, "c");
        p.seleccionarProducto("musa", 1);
        p.seleccionarProducto("faina", 1);
        p.altaProducto();

        ldp.clear();
        ldp = p.listarProductos();
        for (DataProducto dp : ldp) {
            System.out.println(dp.getNickName());
            System.out.println(dp.getNombre());
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
            System.out.println("Bar: " + dp.getNickName() + ", Producto: " + dp.getNombre());
        }
    }

}
