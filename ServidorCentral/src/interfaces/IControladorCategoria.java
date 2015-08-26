package interfaces;

import datatype.DataCategoria;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Estefan
 */
public interface IControladorCategoria {

    /**
     * El sistema recuerda la agrupación de datos en un DataCategoria
     *
     * @param nombre
     */
    public void altaCategoria(String nombre);

    public boolean existeCategoria(String nombre);

    public ArrayList<DataCategoria> listarCategorias();
}
