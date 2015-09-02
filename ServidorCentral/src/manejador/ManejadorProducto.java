/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataIndividual;
import datatype.DataIndividualPromocion;
import datatype.DataProducto;
import datatype.DataPromocion;
import datatype.DataStockProducto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import modelo.Individual;
import modelo.IndividualPromocion;
import modelo.Producto;
import modelo.Promocion;
import modelo.StockProduco;

/**
 *
 * @author Sebastián Estefan
 */
public class ManejadorProducto {

    private static ManejadorProducto instancia;
    private final HashMap<String, HashMap<String, Producto>> productos;
    private final HashMap<String, HashMap<String, Individual>> individuales;
    private final HashMap<String, HashMap<String, Promocion>> promociones;

    private ManejadorProducto() {
        productos = new HashMap<>();
        individuales = new HashMap<>();
        promociones = new HashMap<>();
    }

    public static ManejadorProducto getInstance() {
        if (instancia == null) {
            instancia = new ManejadorProducto();
        }
        return instancia;
    }

    /**
     *
     * @param dataIndividual
     */
    public void ingresarProducto(DataIndividual dataIndividual) {

        String nickName = dataIndividual.getNickName();
        DataStockProducto dataStockProducto = dataIndividual.getStock();
        String nombre = dataIndividual.getNombre();
        String descripcion = dataIndividual.getDescripcion();
        String tipoProducto = dataIndividual.getTipoProducto();

        int cantidad = dataStockProducto.getCantidad();
        float precio = dataStockProducto.getPrecio();
        Calendar fecha = dataStockProducto.getFecha();

        HashMap value;

        StockProduco stockProduco = new StockProduco(cantidad, precio, fecha);

        Individual individual = new Individual(nombre, descripcion, nombre, stockProduco, nickName, tipoProducto);

        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        mu.agregarProductoRestaurante(nickName, individual);

        value = productos.get(nickName);
        if (value == null) {
            value = new HashMap();
        }
        value.put(dataIndividual.getNombre(), individual);
        productos.put(nickName, value);
        individuales.put(nickName, value);
    }

    public void ingresarProducto(DataPromocion dataPromocion) {

        String nombre = dataPromocion.getNombre();
        String tipoProducto = dataPromocion.getTipoProducto();
        String descricpion = dataPromocion.getDescripcion();
        String rutaImagen = dataPromocion.getRutaImagen();
        int descuento = dataPromocion.getDescuento();
        boolean activa = dataPromocion.isActiva();
        String nickName = dataPromocion.getNickName();
        DataStockProducto dataStockProducto = dataPromocion.getStock();
        ArrayList<DataIndividualPromocion> dataIndividualPromociones = dataPromocion.getIndividualPromocion();

        HashMap<String, Individual> hi = individuales.get(nickName);

        DataIndividual di;
        IndividualPromocion ip;
        ArrayList<IndividualPromocion> individualPromociones = new ArrayList<>();
        HashMap value;

        for (DataIndividualPromocion d : dataIndividualPromociones) {
            di = d.getIndividual();
            Individual i = hi.get(di.getNombre());
            ip = new IndividualPromocion(d.getCantidad(), i);
            individualPromociones.add(ip);
        }

        int cantidad = dataStockProducto.getCantidad();
        float precio = dataStockProducto.getPrecio();
        Calendar fecha = dataStockProducto.getFecha();
        StockProduco stockProduco = new StockProduco(cantidad, precio, fecha);
        Promocion promocion = new Promocion(descuento, activa, individualPromociones, nombre, descricpion, rutaImagen, stockProduco, nickName, tipoProducto);

        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        mu.agregarProductoRestaurante(nickName, promocion);

        value = productos.get(nickName);
        if (value == null) {
            value = new HashMap();
        }
        value.put(dataPromocion.getNombre(), promocion);
        productos.put(nickName, value);
        promociones.put(nickName, value);
    }

    public boolean existeProducto(String nickName, String nombreProducto) {
        HashMap hm = productos.get(nickName);
        return hm != null && hm.containsKey(nombreProducto);
    }

    public ArrayList<DataProducto> listarProductos() {
        ArrayList<DataProducto> dataProductos = null;
        Collection cp = productos.values();
        if (!cp.isEmpty()) {
            dataProductos = new ArrayList<>();
            for (Iterator it = cp.iterator(); it.hasNext();) {
                HashMap mp = (HashMap) it.next();
                ArrayList<Producto> lp = new ArrayList<>(mp.values());
                for (Producto p : lp) {
                    dataProductos.add(p.obtenerDatosProducto());
                }
            }
        }
        return dataProductos;
    }

    public DataProducto obtenerDatosProducto(String nickName, String nombre) {
        HashMap<String, Producto> hm = productos.get(nickName);
        Producto p = hm.get(nombre);
        return p.obtenerDatosProducto();
    }

}
