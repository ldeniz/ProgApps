/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorcentral;

import datatype.DataDireccion;
import datatype.DataProducto;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import java.util.ArrayList;

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
        u.CargarDatosUsuario("acabar", "a@b.c", "Aca Bar", "123", new DataDireccion("a", "b", "c"), rutaImagen);
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
    }

}
