/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataComentario;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author sestefan
 */
public class Comentario implements Serializable {

    String comentario;
    float puntaje;
    Calendar fecha;

    public Comentario(String comentario, float puntaje) {
        this.comentario = comentario;
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public DataComentario obtenerDatosComentario() {
        DataComentario dc = new DataComentario(comentario, puntaje, fecha);
        return dc;
    }

}
