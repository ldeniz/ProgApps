/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCategoria;
import datatype.DataRestaurante;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Categoria;
import modelo.Restaurante;

/**
 *
 * @author Sebastián Estefan
 */
public class ManejadorCategoria {

    private static ManejadorCategoria instancia;
    private final HashMap<String, Categoria> categorias;

    private ManejadorCategoria() {
        categorias = new HashMap<>();
    }

    public static ManejadorCategoria getInstance() {
        if (instancia == null) {
            instancia = new ManejadorCategoria();
        }
        return instancia;
    }

    public boolean existeCategoriaNombre(String nombre) {
        return categorias.containsKey(nombre);
    }

    /**
     *
     * @param dataCategoria
     */
    public void ingresarCategoria(DataCategoria dataCategoria) {
        String nombre = dataCategoria.getNombre();
        Categoria c = new Categoria(nombre);
        categorias.put(nombre, c);
    }

    /**
     * Retorna una estructura de DataCategorias
     *
     * @return
     */
    public ArrayList<DataCategoria> listarCategorias() {
        ArrayList<DataCategoria> dataCategorias = null;
        if (!categorias.isEmpty()) {
            dataCategorias = new ArrayList<>();
            for (Categoria c : categorias.values()) {
                dataCategorias.add(c.obtenerDatosCategoria());
            }
        }
        return dataCategorias;
    }

    /**
     *
     * @param nombre
     * @param r
     */
    public void agregarRestaurante(String nombre, Restaurante r) {
        Categoria c = categorias.get(nombre);
        c.agregarRestaurante(r);
    }

}
