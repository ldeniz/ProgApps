/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataDireccion;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public class Restaurante extends Usuario implements Serializable {

    private String[] rutaImagen;
    private ArrayList<Categoria> categorias;

    public Restaurante(String[] rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.rutaImagen = rutaImagen;
    }

    public String[] getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String[] rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

}
