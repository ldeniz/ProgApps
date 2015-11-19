/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataPedido;
import datatype.DataPedidoProduco;
import datatype.EnumEstado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author sestefan
 */
public class Pedido implements Serializable {

    private String nickNameCliente;
    private String nickNameRestaurante;
    private int numero;
    private Calendar fechaPedido;
    private float precioTotal;
    private EnumEstado estado;
    private ArrayList<Calendar> historial;
    private ArrayList<PedidoProduco> pedidoProducos;
    private Comentario comentario;

    public Pedido() {
        pedidoProducos = new ArrayList<>();
        historial = new ArrayList<>();
    }

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

    public String getNickNameCliente() {
        return nickNameCliente;
    }

    public void setNickNameCliente(String nickNameCliente) {
        this.nickNameCliente = nickNameCliente;
    }

    public String getNickNameRestaurante() {
        return nickNameRestaurante;
    }

    public void setNickNameRestaurante(String nickNameRestaurante) {
        this.nickNameRestaurante = nickNameRestaurante;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public ArrayList<Calendar> getHistorial() {        
        return historial;
    }

    public void setHistorial(ArrayList<Calendar> historial) {
        this.historial = historial;
    }
    
    public void setFechaCambioEstado(Calendar fecha){
        historial.add(fecha);
    }

    public void agregarProducto(PedidoProduco producto) {
        pedidoProducos.add(producto);
    }

    public DataPedido obtenerDatosPedido() {
        ArrayList<DataPedidoProduco> ldpp = new ArrayList<>();
        for (PedidoProduco pp : pedidoProducos) {
            ldpp.add(pp.obtenerDatosPedidoProducto());
        }
        DataPedido dp;
        if (comentario == null) {
            dp = new DataPedido(nickNameCliente, nickNameRestaurante, numero, fechaPedido, precioTotal, estado, ldpp);
        } else {
            dp = new DataPedido(nickNameCliente, nickNameRestaurante, numero, fechaPedido, precioTotal, estado, historial, ldpp, comentario.obtenerDatosComentario());
        }
        return dp;
    }

}
