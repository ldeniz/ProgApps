/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataComentario implements Serializable {

    String comentario;
    float puntaje;
    Calendar fecha;

    public DataComentario() {
    }

    public DataComentario(String comentario, float puntaje, Calendar fecha) {
        this.comentario = comentario;
        this.puntaje = puntaje;
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

}
