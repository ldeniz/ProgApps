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
public class DataStockProducto {

    private int cantidad;
    private float precio;
    private Calendar fecha;

    public DataStockProducto(int cantidad, float precio, Calendar fecha) {
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

}
