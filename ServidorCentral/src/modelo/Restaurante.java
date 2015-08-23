/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataDireccion;

/**
 *
 * @author sestefan
 */
public class Restaurante extends Usuario{
    
    private String[] rutaImagen;

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
    
    
}
