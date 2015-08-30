/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataIndividual;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataStockProducto;
import interfaces.IControladorProducto;
import java.util.ArrayList;
import manejador.ManejadorProducto;
import manejador.ManejadorUsuario;

/**
 *
 * @author sestefan
 */
public class ControladorProducto implements IControladorProducto {

    private DataRestaurante dataRestaurante;
    private DataProducto dataProducto;
    private DataStockProducto dataStockProducto;
    private ArrayList<DataIndividual> productosPromocion;
    private String tipo;

    @Override
    public void cargarDatosProducto(String nombre, String descripcion, String nicknameRestaurante, float precio) {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        dataRestaurante = (DataRestaurante) mu.obtenerDataUsuario(nicknameRestaurante);
        dataProducto = new DataIndividual(nombre, descripcion, nombre);
        dataStockProducto = new DataStockProducto(1, precio);
        tipo = "individual";
    }

    @Override
    public void cargarDatosProducto(String nombre, String descripcion, String nicknameRestaurante, float descuento, String rutaImagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionarProducto(String nombre, int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerCantidadProductoIndividual(String nickName, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaProducto() {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        switch (tipo) {
            case "individual":
                mp.ingresarProducto((DataIndividual) dataProducto);
                break;
        }
    }

    @Override
    public boolean existeProducto(String nickName, String nombre) {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        return mp.existeProducto(nickName, nombre);
    }

}
