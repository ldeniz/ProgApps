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
import java.util.Calendar;
import manejador.ManejadorProducto;
import manejador.ManejadorUsuario;
import modelo.Individual;
import modelo.IndividualPromocion;
import modelo.Producto;
import modelo.Promocion;
import modelo.StockProducto;

/**
 *
 * @author sestefan
 */
public class ControladorProducto implements IControladorProducto {

    private String nickName;
    private DataProducto dataProducto;
    private DataStockProducto dataStockProducto;
    private ArrayList<DataIndividualPromocion> productosPromocion = new ArrayList<>();

    private DataProducto dataProductoModificado;
    private String nombreViejo;

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
    public void altaProducto() {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        Producto p;
        String nombre;
        String descripcion;
        String tipoProducto;
        String rutaImagen;
        switch (dataProducto.getTipoProducto()) {
            case "individual":
                DataIndividual dataIndividual = (DataIndividual) dataProducto;
                nombre = dataIndividual.getNombre();
                descripcion = dataIndividual.getDescripcion();
                tipoProducto = dataIndividual.getTipoProducto();
                rutaImagen = dataIndividual.getRutaImagen();

                int cantidad = dataStockProducto.getCantidad();
                float precio = dataStockProducto.getPrecio();
                Calendar fecha = dataStockProducto.getFecha();

                StockProducto stockProduco = new StockProducto(nickName, nombre, cantidad, precio, fecha);

                p = new Individual(nombre, descripcion, rutaImagen, stockProduco, nickName, tipoProducto);

                mu.agregarProductoRestaurante(p);
                mp.ingresarProducto((Individual) p);
                break;
            case "promocion":
                precio = 0;
                DataPromocion dataPromocion = (DataPromocion) dataProducto;
                nombre = dataPromocion.getNombre();
                tipoProducto = dataPromocion.getTipoProducto();
                descripcion = dataPromocion.getDescripcion();
                rutaImagen = dataPromocion.getRutaImagen();
                int descuento = dataPromocion.getDescuento();
                boolean activa = dataPromocion.isActiva();
                String nickName = dataPromocion.getNickName();
                DataStockProducto dataStockProducto = dataPromocion.getStock();
                ArrayList<DataIndividualPromocion> dataIndividualPromociones = dataPromocion.getIndividualPromocion();

                DataIndividual di;
                IndividualPromocion ip;
                ArrayList<IndividualPromocion> individualPromociones = new ArrayList<>();

                for (DataIndividualPromocion d : dataIndividualPromociones) {
                    di = d.getIndividual();
                    Individual i = (Individual) mp.obtenerProducto(nickName,
                            di.getNombre());
                    ip = new IndividualPromocion(d.getCantidad(), i);
                    individualPromociones.add(ip);
                    stockProduco = i.getStock();
                    precio += stockProduco.getPrecio();
                }

                cantidad = dataStockProducto.getCantidad();
                fecha = dataStockProducto.getFecha();
                precio = precio - ((precio * descuento) / 100);
                stockProduco = new StockProducto(nickName, nombre, cantidad, precio, fecha);
                Promocion promocion = new Promocion(descuento, activa, individualPromociones, nombre, descripcion, rutaImagen, stockProduco, nickName, tipoProducto);

                mp.ingresarProducto(promocion);
                mu.agregarProductoRestaurante(promocion);
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
        if(!dataProductos.isEmpty()){
            for (Producto p : productos) {
                dataProductos.add(p.obtenerDatosProducto());
            }
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
    public DataProducto obtenerDatosRestauranteNombre(String nickName, String nombre) {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        Producto p = mp.obtenerProducto(nickName, nombre);
        return p.obtenerDatosProducto();
    }

    @Override
    public void CargarDatosModificarProducto(String mombreAnt, String nombre, String descripcion,
            String rutaImagen, float precio) {
        this.nombreViejo = mombreAnt;
        dataProductoModificado = new DataIndividual(nombre, descripcion, rutaImagen, new DataStockProducto(0, precio));
    }

    @Override
    public void CargarDatosModificarProducto(String mombreAnt, String nombre, String descripcion,
            String rutaImagen, int descuento, boolean activa) {
        this.nombreViejo = mombreAnt;
        dataProductoModificado = new DataPromocion(descuento, activa, nombre, descripcion,
                rutaImagen, nickName);
    }

    @Override
    public void ModificarProducto() {
        ManejadorProducto mp = ManejadorProducto.getInstance();
        Producto p = mp.obtenerProducto(nickName, nombreViejo);
        p.setNombre(dataProductoModificado.getNombre());
        p.setDescripcion(dataProductoModificado.getDescripcion());
        p.setRutaImagen(dataProductoModificado.getRutaImagen());
        float precio = 0;
        StockProducto sp;
        switch (p.getTipoProducto()) {
            case "promocion":
                Promocion pr = (Promocion) p;
                DataPromocion dataPromocion = (DataPromocion) dataProductoModificado;
                pr.setActiva(dataPromocion.isActiva());
                if (pr.getDescuento() != dataPromocion.getDescuento()) {
                    pr.setDescuento(dataPromocion.getDescuento());
                    for (IndividualPromocion ip : pr.getIndividualPromocion()) {
                        sp = ip.getIndividual().getStock();
                        precio += sp.getPrecio();
                    }
                    precio = precio - ((precio * pr.getDescuento()) / 100);
                    sp = pr.getStock();
                    sp.setPrecio(precio);
                }
                break;
            case "individual":
                Individual i = (Individual) p;
                sp = i.getStock();
                DataIndividual di = (DataIndividual) dataProductoModificado;
                sp.setPrecio(di.getStock().getPrecio());
                break;
        }

    }

}
