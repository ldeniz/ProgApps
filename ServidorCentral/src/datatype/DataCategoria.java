/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.ArrayList;

/**
 *
 * @author Sebastián Estefan
 */
public class DataCategoria {

    private String nombre;
    private ArrayList<DataRestaurante> dataRestaurantes;

    public DataCategoria(String nombre) {
        this.nombre = nombre;
        this.dataRestaurantes = new ArrayList<>();
    }

    public DataCategoria(String nombre, ArrayList<DataRestaurante> dataRestaurantes) {
        this.nombre = nombre;
        this.dataRestaurantes = dataRestaurantes;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<DataRestaurante> getDataRestaurantes() {
        return dataRestaurantes;
    }

}
