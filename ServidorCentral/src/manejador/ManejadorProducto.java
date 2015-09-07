/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import modelo.Individual;
import modelo.Pedido;
import modelo.Producto;
import modelo.Promocion;

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
     * @param individual
     */
    public void ingresarProducto(Individual individual) {

        String nickName = individual.getNickName();
        HashMap value;
        value = productos.get(nickName);
        if (value == null) {
            value = new HashMap();
        }
        value.put(individual.getNombre(), individual);
        productos.put(nickName, value);
        individuales.put(nickName, value);
    }

    public void ingresarProducto(Promocion promocion) {

        String nickName = promocion.getNickName();
        HashMap<String, Individual> hi = individuales.get(nickName);
        HashMap value;
        value = productos.get(nickName);
        if (value == null) {
            value = new HashMap();
        }
        value.put(promocion.getNombre(), promocion);
        productos.put(nickName, value);
        promociones.put(nickName, value);
    }

    public boolean existeProducto(String nickName, String nombreProducto) {
        HashMap hm = productos.get(nickName);
        return hm != null && hm.containsKey(nombreProducto);
    }

    public void agregarPedido(String nickName, String nombreProducto, int cantidad, Pedido p) {
        HashMap hm = productos.get(nickName);
        Producto producto = (Producto) hm.get(nombreProducto);
        producto.agregarPedido(p, cantidad);
    }

    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> lproductos = null;
        Collection cp = productos.values();
        if (!cp.isEmpty()) {
            lproductos = new ArrayList<>();
            for (Iterator it = cp.iterator(); it.hasNext();) {
                HashMap mp = (HashMap) it.next();
                ArrayList<Producto> lp = new ArrayList<>(mp.values());
                for (Producto p : lp) {
                    lproductos.add(p);
                }
                lp.clear();
            }
        }
        return lproductos;
    }

    public Producto obtenerProducto(String nickName, String nombre) {
        HashMap<String, Producto> hm = productos.get(nickName);
        Producto p = hm.get(nombre);
        return p;
    }

    public ArrayList<Producto> listarProductos(String nickName) {
        ArrayList<Producto> lproductos = null;
        HashMap<String, Producto> pr = productos.get(nickName);
        if (!pr.isEmpty()) {
            lproductos = new ArrayList<>();
            ArrayList<Producto> lp = new ArrayList<>(pr.values());
            for (Producto p : lp) {
                lproductos.add(p);
            }
            lp.clear();
        }
        return lproductos;
    }

    public void limpiarMemoria() {
        productos.clear();
        individuales.clear();
        promociones.clear();
    }

}
