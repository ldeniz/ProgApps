/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.Calendar;

/**
 *
 * @author sestefan
 */
public class DataComentario {

    String comentario;
    int puntaje;
    Calendar fecha;

    public DataComentario(String comentario, int puntaje, Calendar fecha) {
        this.comentario = comentario;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Calendar getFecha() {
        return fecha;
    }

}