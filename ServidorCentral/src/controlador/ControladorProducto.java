/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataIndividual;
import datatype.DataIndividualPromocion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataPromocion;
import datatype.DataStockProducto;
import interfaces.IControladorProducto;
import java.util.ArrayList;
import java.util.Calendar;
import manejador.ManejadorProducto;
import manejador.ManejadorUsuario;
import modelo.Individual;
import modelo.Producto;
import modelo.StockProduco;

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
        DataIndividual di = (DataIndividual) mp.obtenerProducto(nickName, nombre).obtenerDatosProducto();
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
        Producto p;
        switch (dataProducto.getTipoProducto()) {
            case "individual":
                DataIndividual dataIndividual = (DataIndividual) dataProducto;
                String nombre = dataIndividual.getNombre();
                String descripcion = dataIndividual.getDescripcion();
                String tipoProducto = dataIndividual.getTipoProducto();
                String rutaImagen = dataIndividual.getRutaImagen();

                int cantidad = dataStockProducto.getCantidad();
                float precio = dataStockProducto.getPrecio();
                Calendar fecha = dataStockProducto.getFecha();

                StockProduco stockProduco = new StockProduco(nickName, nombre, cantidad, precio, fecha);

                p = new Individual(nombre, descripcion, rutaImagen, stockProduco, nickName, tipoProducto);

                ManejadorUsuario mu = ManejadorUsuario.getInstance();
                mu.agregarProductoRestaurante(p);
                mp.ingresarProducto((Individual) p);
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
        ArrayList<Producto> productos = mp.listarProductos();
        ArrayList<DataProducto> dataProductos = new ArrayList<>();
        for (Producto p : productos) {
            dataProductos.add(p.obtenerDatosProducto());
        }
        return dataProductos;
    }

    @Override
    public void limpiarMemoria() {
        productosPromocion.clear();
    }

    @Override
    public void seleccionarRestaurante(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public ArrayList<DataPedido> listarPedidosProducto(String nickName, String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
