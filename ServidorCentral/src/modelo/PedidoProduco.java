/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataPedidoProduco;

/**
 *
 * @author sestefan
 */
public class PedidoProduco {

    private int cantidad;
    private StockProduco stockProduco;

    public PedidoProduco(int cantidad, StockProduco stockProduco) {
        this.cantidad = cantidad;
        this.stockProduco = stockProduco;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public StockProduco getStockProduco() {
        return stockProduco;
    }

    public void setStockProduco(StockProduco stockProduco) {
        this.stockProduco = stockProduco;
    }

    public DataPedidoProduco obtenerDatosPedidoProducto() {
        return new DataPedidoProduco(cantidad, stockProduco.obtenerDatosStockProducto());

    }

}
