/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataCategoria;
import datatype.DataRestaurante;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sebastián Estefan
 */
public class Categoria implements Serializable {

    private String nombre;
    private ArrayList<Restaurante> restaurantes;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.restaurantes = new ArrayList<>();
    }

    public Categoria(String nombre, ArrayList<Restaurante> restaurantes) {
        this.nombre = nombre;
        this.restaurantes = restaurantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public void agregarRestaurante(Restaurante r) {
        restaurantes.add(r);
    }

    public DataCategoria obtenerDatosCategoria() {
        ArrayList<DataRestaurante> dr = new ArrayList<>();
        for (Restaurante r : restaurantes) {
            dr.add((DataRestaurante) r.obtenerDatosUsuario());
        }
        return new DataCategoria(nombre, dr);
    }

}
