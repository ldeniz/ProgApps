/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataStockProducto {

    private String nickNameRestaurante;
    private String nombreProducto;
    private int cantidad;
    private float precio;
    private Calendar fecha;

    public DataStockProducto() {
    }

    public DataStockProducto(String nickNameRestaurante, String nombreProducto, int cantidad, float precio, Calendar fecha) {
        this.nickNameRestaurante = nickNameRestaurante;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    public DataStockProducto(int cantidad, float precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public String getNickNameRestaurante() {
        return nickNameRestaurante;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNickNameRestaurante(String nickNameRestaurante) {
        this.nickNameRestaurante = nickNameRestaurante;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

}
