/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataStockProducto;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author sestefan
 */
public class StockProduco implements Serializable {

    private int cantidad;
    private float precio;
    private Calendar fecha;

    public StockProduco(int cantidad, float precio, Calendar fecha) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public DataStockProducto obtenerDatosStockProducto() {
        return new DataStockProducto(cantidad, precio, fecha);
    }

}
