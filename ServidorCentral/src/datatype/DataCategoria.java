/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datatype;

/**
 *
 * @author Sebastián Estefan
 */
public class DataCategoria {
    private String nombre;

    public DataCategoria(String nombre) {        
        this.nombre = nombre;
    }    

    public String getNombre() {
        return nombre;
    }    

    @Override
    public String toString() {
        return nombre;
    }
}