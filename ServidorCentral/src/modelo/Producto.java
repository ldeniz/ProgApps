/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataProducto;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public abstract class Producto implements Serializable {

    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private StockProduco stock;
    private String nickName;
    private String tipoProducto;
    private ArrayList<Pedido> pedidos;

    public Producto(String nombre, String descripcion, String rutaImagen, StockProduco stock, String nickName, String tipoProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.stock = stock;
        this.nickName = nickName;
        this.tipoProducto = tipoProducto;
        pedidos = new ArrayList<>();
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void agregarPedido(Pedido p, int cantidad) {
        this.pedidos.add(p);
        int cantidadAnterior = stock.getCantidad();
        stock.setCantidad(cantidadAnterior - cantidad);

    }

    public abstract DataProducto obtenerDatosProducto();

}
