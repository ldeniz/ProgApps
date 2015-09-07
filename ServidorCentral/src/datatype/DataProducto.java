/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public abstract class DataProducto {

    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private DataStockProducto stock;
    private String nickName;
    private String tipoProducto;
    private ArrayList<DataPedido> pedidos;

    public DataProducto(String nombre, String descripcion, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }

    public DataProducto(String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.nickName = nickName;
    }

    public DataProducto(String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName, String tipoProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.nickName = nickName;
        this.tipoProducto = tipoProducto;
    }

    public DataProducto(String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName, String tipoProducto, ArrayList<DataPedido> pedidos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.nickName = nickName;
        this.tipoProducto = tipoProducto;
        this.pedidos = pedidos;
    }

    public DataProducto(String nombre, String descripcion, String rutaImagen, DataStockProducto dataStockProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = dataStockProducto;
    }

    public DataProducto(String nombre, String descripcion, String rutaImagen, String nickName) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.nickName = nickName;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public DataStockProducto getStock() {
        return stock;
    }

    public String getNickName() {
        return nickName;
    }

    public ArrayList<DataPedido> getPedidos() {
        return pedidos;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
