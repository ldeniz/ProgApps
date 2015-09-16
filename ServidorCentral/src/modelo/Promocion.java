/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataIndividualPromocion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataPromocion;
import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public class Promocion extends Producto {

    private int descuento;
    private boolean activa;
    private ArrayList<IndividualPromocion> individualPromocion;

    public Promocion(int descuento, boolean activa, ArrayList<IndividualPromocion> individualPromocion, String nombre, String descripcion, String rutaImagen, StockProducto stock, String nickName, String tipoProducto) {
        super(nombre, descripcion, rutaImagen, stock, nickName, tipoProducto);
        this.descuento = descuento;
        this.activa = activa;
        this.individualPromocion = individualPromocion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public ArrayList<IndividualPromocion> getIndividualPromocion() {
        return individualPromocion;
    }

    public void setIndividualPromocion(ArrayList<IndividualPromocion> individualPromocion) {
        this.individualPromocion = individualPromocion;
    }

    @Override
    public DataProducto obtenerDatosProducto() {
        ArrayList<DataIndividualPromocion> dataIndividualPromocion = new ArrayList<>();
        for (IndividualPromocion ip : individualPromocion) {
            dataIndividualPromocion.add(ip.obtenerDatosIndividualPromocion());
        }
        ArrayList<DataPedido> ldp = new ArrayList<DataPedido>();
        if (!this.getPedidos().isEmpty()) {
            for (Pedido p : this.getPedidos()) {
                ldp.add(p.obtenerDatosPedido());
            }
        }
        DataProducto dataPromocion = new DataPromocion(descuento, activa, dataIndividualPromocion, getNombre(), getDescripcion(), getRutaImagen(), getStock().obtenerDatosStockProducto(), getNickName(), getTipoProducto(), ldp);
        return dataPromocion;
    }

}
