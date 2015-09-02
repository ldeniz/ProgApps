/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataIndividual;
import datatype.DataProducto;

/**
 *
 * @author sestefan
 */
public class Individual extends Producto {

    public Individual(String nombre, String descripcion, String rutaImagen, StockProduco stock, String nickName, String tipoProducto) {
        super(nombre, descripcion, rutaImagen, stock, nickName, tipoProducto);
    }

    @Override
    public DataProducto obtenerDatosProducto() {
        DataProducto dataIndividual = new DataIndividual(getNombre(), getDescripcion(), getRutaImagen(), getStock().obtenerDatosStockProducto(), getNickName(), getTipoProducto());
        return dataIndividual;
    }

}
