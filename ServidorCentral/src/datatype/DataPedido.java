/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author sestefan
 */
public class DataPedido {

    private String nickNameCliente;
    private String nickNameRestaurante;
    private int numero;
    private Calendar fechaPedido;
    private float precioTotal;
    private EnumEstado estado;
    private ArrayList<DataPedidoProduco> dataPedidoProducos;

    public DataPedido(String nickNameCliente, String nickNameRestaurante, int numero, Calendar fechaPedido, float precioTotal, EnumEstado estado, ArrayList<DataPedidoProduco> dataPedidoProducos) {
        this.nickNameCliente = nickNameCliente;
        this.nickNameRestaurante = nickNameRestaurante;
        this.numero = numero;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.dataPedidoProducos = dataPedidoProducos;
    }

    public String getNickNameCliente() {
        return nickNameCliente;
    }

    public String getNickNameRestaurante() {
        return nickNameRestaurante;
    }

    public int getNumero() {
        return numero;
    }

    public Calendar getFechaPedido() {
        return fechaPedido;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public EnumEstado getEstado() {
        return estado;
    }

    public ArrayList<DataPedidoProduco> getDataPedidoProducos() {
        return dataPedidoProducos;
    }

}
