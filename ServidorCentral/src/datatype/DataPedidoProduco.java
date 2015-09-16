/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

/**
 *
 * @author sestefan
 */
public class DataPedidoProduco {

    private int cantidad;
    private DataStockProducto stockProduco;

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

}
