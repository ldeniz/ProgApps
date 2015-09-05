/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.EnumEstado;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author sestefan
 */
public class Pedido {

    private int numero;
    private Calendar fechaPedido;
    private float precioTotal;
    private EnumEstado estado;
    private ArrayList<PedidoProduco> pedidoProducos;

    public Pedido(int numero, Calendar fechaPedido, float precioTotal, EnumEstado estado, ArrayList<PedidoProduco> pedidoProducos) {
        this.numero = numero;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.pedidoProducos = pedidoProducos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Calendar fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public EnumEstado getEstado() {
        return estado;
    }

    public void setEstado(EnumEstado estado) {
        this.estado = estado;
    }

    public ArrayList<PedidoProduco> getPedidoProducos() {
        return pedidoProducos;
    }

    public void setPedidoProducos(ArrayList<PedidoProduco> pedidoProducos) {
        this.pedidoProducos = pedidoProducos;
    }

}
