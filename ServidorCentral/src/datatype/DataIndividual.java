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
public class DataIndividual extends DataProducto {

    public DataIndividual(String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName) {
        super(nombre, descripcion, rutaImagen, stock, nickName);
    }

    public DataIndividual(String nombre, String descripcion, String rutaImagen) {
        super(nombre, descripcion, rutaImagen);
    }

    public DataIndividual(String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName, String tipoProducto) {
        super(nombre, descripcion, rutaImagen, stock, nickName, tipoProducto);
    }

    public DataIndividual(String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName, String tipoProducto, ArrayList<DataPedido> pedidos) {
        super(nombre, descripcion, rutaImagen, stock, nickName, tipoProducto, pedidos);
    }

    public DataIndividual(String nombre, String descripcion, String rutaImagen, DataStockProducto dataStockProducto) {
        super(nombre, descripcion, rutaImagen, dataStockProducto);
    }

}
