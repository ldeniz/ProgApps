
package interfaces;

import datatype.DataCategoria;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorCategoria {   

    public ArrayList<DataCategoria> listarCategorias();

    /**
     * El sistema recuerda la agrupación de datos en un DataCategoria
     * @param nombre
     */
    void altaCategoria(String nombre);

    public boolean existeCategoria(String nombre);

}
