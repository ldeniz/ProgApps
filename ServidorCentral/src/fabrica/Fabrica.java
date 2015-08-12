/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fabrica;

import controlador.ControladorCategoria;
import interfaces.IControladorCategoria;

/**
 *
 * @author Sebastián Estefan
 */
public class Fabrica {
    private static Fabrica instancia;

    private Fabrica(){

    }

    public static Fabrica getInstance(){
        if (instancia == null)
            instancia = new Fabrica();
        return instancia;
    }

    /**
     * Retorna una interfaz de Controlador de Categoria
     * @return
     */
    public IControladorCategoria obtenerControladorCategoria(){
        ControladorCategoria cc = new ControladorCategoria();
        return (IControladorCategoria) cc;
    }
}
