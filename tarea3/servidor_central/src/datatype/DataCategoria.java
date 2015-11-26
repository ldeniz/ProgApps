/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Sebastián Estefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCategoria implements Serializable {

    private String nombre;
    private ArrayList<DataRestaurante> dataRestaurantes;

    public DataCategoria() {
    }

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDataRestaurantes(ArrayList<DataRestaurante> dataRestaurantes) {
        this.dataRestaurantes = dataRestaurantes;
    }

}
