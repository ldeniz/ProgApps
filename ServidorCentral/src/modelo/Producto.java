/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataProducto;
import java.io.Serializable;

/**
 *
 * @author sestefan
 */
public abstract class Producto implements Serializable {

    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private StockProduco stock;
    private Restaurante restaurante;

    public Producto(String nombre, String descripcion, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public Producto(String nombre, String descripcion, String rutaImagen, StockProduco stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
    }

    public Producto(String nombre, String descripcion, String rutaImagen, StockProduco stock, Restaurante restaurante) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.restaurante = restaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public StockProduco getStock() {
        return stock;
    }

    public void setStock(StockProduco stock) {
        this.stock = stock;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public abstract DataProducto obtenerDatosProducto();

}
