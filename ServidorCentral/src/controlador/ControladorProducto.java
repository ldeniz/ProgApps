/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataIndividual;
import datatype.DataIndividualPromocion;
import datatype.DataProducto;
import datatype.DataPromocion;
import datatype.DataStockProducto;
import interfaces.IControladorProducto;
import java.util.ArrayList;
import manejador.ManejadorProducto;

/**
 *
 * @author sestefan
 */
public class ControladorProducto implements IControladorProducto {

    private String nickName;
    private DataProducto dataProducto;
    private DataStockProducto dataStockProducto;
    private ArrayList<DataIndividualPromocion> productosPromocion = new ArrayList<>();

    @Override
    public void cargarDatosProducto(String nombre, String descripcion, float precio, String rutaImagen) {
        dataStockProducto = new DataStockProducto(1, precio);
        dataProducto = new DataIndividual(nombre, descripcion, rutaImagen, dataStockProducto, nickName, "individual");
    }

    @Override
    public void cargarDatosProducto(String nombre, String descripcion, int descuento, String rutaImagen) {
        dataStockProducto = new DataStockProducto(1, 0);
        dataProducto = new DataPromocion(descuento, true, productosPromocion, nombre, descripcion, rutaImagen, dataStockProducto, nickName, "promocion");
    }

    @Override
    public void seleccionarProducto(String nombre, int cantidad) {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        DataIndividual di = (DataIndividual) mp.obtenerDatosProducto(nickName, nombre);
        DataIndividualPromocion dip = new DataIndividualPromocion(cantidad, di);
        productosPromocion.add(dip);
    }

    @Override
    public int obtenerCantidadProductoIndividual(String nickName, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altaProducto() {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        switch (dataProducto.getTipoProducto()) {
            case "individual":
                mp.ingresarProducto((DataIndividual) dataProducto);
                break;
            case "promocion":
                mp.ingresarProducto((DataPromocion) dataProducto);
                break;
        }
    }

    @Override
    public boolean existeProducto(String nickName, String nombre) {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        return mp.existeProducto(nickName, nombre);
    }

    @Override
    public ArrayList<DataProducto> listarProductos() {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        return mp.listarProductos();
    }

    @Override
    public void limpiarMemoria() {
        productosPromocion.clear();
    }

    @Override
    public void seleccionarRestaurante(String nickName) {
        this.nickName = nickName;
    }

}
