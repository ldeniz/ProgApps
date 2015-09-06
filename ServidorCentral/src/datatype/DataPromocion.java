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
public class DataPromocion extends DataProducto {

    private int descuento;
    private boolean activa;
    private ArrayList<DataIndividualPromocion> individualPromocion;

    public DataPromocion(int descuento, boolean activa, ArrayList<DataIndividualPromocion> individualPromocion, String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName) {
        super(nombre, descripcion, rutaImagen, stock, nickName);
        this.descuento = descuento;
        this.activa = activa;
        this.individualPromocion = individualPromocion;
    }

    public DataPromocion(int descuento, boolean activa, ArrayList<DataIndividualPromocion> individualPromocion, String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName, String tipoProducto) {
        super(nombre, descripcion, rutaImagen, stock, nickName, tipoProducto);
        this.descuento = descuento;
        this.activa = activa;
        this.individualPromocion = individualPromocion;
    }

    public DataPromocion(int descuento, boolean activa, ArrayList<DataIndividualPromocion> individualPromocion, String nombre, String descripcion, String rutaImagen, DataStockProducto stock, String nickName, String tipoProducto, ArrayList<DataPedido> pedidos) {
        super(nombre, descripcion, rutaImagen, stock, nickName, tipoProducto, pedidos);
        this.descuento = descuento;
        this.activa = activa;
        this.individualPromocion = individualPromocion;
    }

    public int getDescuento() {
        return descuento;
    }

    public boolean isActiva() {
        return activa;
    }

    public ArrayList<DataIndividualPromocion> getIndividualPromocion() {
        return individualPromocion;
    }

}
