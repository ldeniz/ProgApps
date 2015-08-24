/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manejador;

import datatype.DataCategoria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import modelo.Categoria;

/**
 *
 * @author Sebastián Estefan
 */
public class ManejadorCategoria {

    private static ManejadorCategoria instancia;
    private final HashMap<String, Categoria> categorias;

    private ManejadorCategoria(){
        categorias = new HashMap<>();
    }

    public static ManejadorCategoria getInstance(){
        if (instancia == null)
            instancia = new ManejadorCategoria();
        return instancia;
    }

    public boolean existeCategoriaNombre(String nombre){
        return categorias.containsKey(nombre);
    }

    /**
     *
     * @param dataCategoria
     */
    public void ingresarCategoria(DataCategoria dataCategoria){
        String nombre = dataCategoria.getNombre();
        Categoria c = new Categoria(nombre);
        categorias.put(nombre, c);
    }
    
    /**
     * Retorna una estructura de DataCategorias
     * @return
     */
    public ArrayList<DataCategoria> listarCategorias(){
        ArrayList<DataCategoria> dataCategorias = null;
        if (!categorias.isEmpty()){
            dataCategorias = new ArrayList<>();
            for (Entry<String, Categoria> entry : categorias.entrySet()) {
                Categoria c = entry.getValue();
                dataCategorias.add(new DataCategoria(c.getNombre()));
            }
        }
        return dataCategorias;
    }

    /**
     * 
     * @param nombre
     * @return 
     */
    Categoria obtenerCategoria(String nombre) {
        return categorias.get(nombre);
    }
}