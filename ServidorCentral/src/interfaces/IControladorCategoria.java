package interfaces;

import datatype.DataCategoria;
import datatype.DataRestaurante;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorCategoria {

    /**
     * Impacta la nueva categoría en el sistema
     *
     * @param nombre
     */
    public void altaCategoria(String nombre);

    /**
     * Devuelve true si una categoría de nombre 'nombre' existe en el sistema.
     *
     * @param nombre
     * @return
     */
    public boolean existeCategoria(String nombre);

    /**
     * Retorna una lista con las categorías existentes en el sistema.
     *
     * @return
     */
    public ArrayList<DataCategoria> listarCategorias();
    
    
    /**
     * Regresa una lista de restaurantes dada la categoria 'categoria'
     * @param categoria
     * @return 
     * @throws java.lang.Exception 
     */
    public ArrayList<DataRestaurante> listarRestaurantes(String categoria) throws Exception;

}
