/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataProducto {

    private String nombre;
    private String descripcion;
    private String rutaImagen;
    private DataStockProducto stock;
    private String nickName;
    private String tipoProducto;
    private ArrayList<DataPedido> pedidos;

    public DataProducto() {
    }

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setStock(DataStockProducto stock) {
        this.stock = stock;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setPedidos(ArrayList<DataPedido> pedidos) {
        this.pedidos = pedidos;
    }

}
