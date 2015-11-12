/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPedidoProduco {

    private int cantidad;
    private DataStockProducto stockProduco;

    public DataPedidoProduco() {
    }

    public DataPedidoProduco(int cantidad, DataStockProducto stockProduco) {
        this.cantidad = cantidad;
        this.stockProduco = stockProduco;
    }

    public int getCantidad() {
        return cantidad;
    }

    public DataStockProducto getStockProduco() {
        return stockProduco;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setStockProduco(DataStockProducto stockProduco) {
        this.stockProduco = stockProduco;
    }

}
