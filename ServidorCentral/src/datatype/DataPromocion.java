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

    private float descuento;
    private boolean activa;
    private ArrayList<DataIndividualPromocion> individualPromocion;

    public DataPromocion(float descuento, boolean activa, ArrayList<DataIndividualPromocion> individualPromocion, String nombre, String descripcion, String rutaImagen, DataStockProducto stock, DataRestaurante dataRestaurante) {
        super(nombre, descripcion, rutaImagen, stock, dataRestaurante);
        this.descuento = descuento;
        this.activa = activa;
        this.individualPromocion = individualPromocion;
    }

    public float getDescuento() {
        return descuento;
    }

    public boolean isActiva() {
        return activa;
    }

    public ArrayList<DataIndividualPromocion> getIndividualPromocion() {
        return individualPromocion;
    }

}
