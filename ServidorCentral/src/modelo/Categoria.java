/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataCategoria;
import java.io.Serializable;

/**
 *
 * @author Sebastián Estefan
 */
public class Categoria implements Serializable {

    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DataCategoria obtenerDatosCategoria() {
        return new DataCategoria(nombre);
    }

}
