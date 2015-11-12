/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataPedido {

    private String nickNameCliente;
    private String nickNameRestaurante;
    private int numero;
    private Calendar fechaPedido;
    private float precioTotal;
    private EnumEstado estado;
    private ArrayList<DataPedidoProduco> dataPedidoProducos;
    private DataComentario dataComentario;

    public DataPedido() {
    }

    public DataPedido(String nickNameCliente, String nickNameRestaurante, int numero, Calendar fechaPedido, float precioTotal, EnumEstado estado, ArrayList<DataPedidoProduco> dataPedidoProducos) {
        this.nickNameCliente = nickNameCliente;
        this.nickNameRestaurante = nickNameRestaurante;
        this.numero = numero;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.dataPedidoProducos = dataPedidoProducos;
    }

    public DataPedido(String nickNameCliente, String nickNameRestaurante, int numero, Calendar fechaPedido, float precioTotal, EnumEstado estado, ArrayList<DataPedidoProduco> dataPedidoProducos, DataComentario dataComentario) {
        this.nickNameCliente = nickNameCliente;
        this.nickNameRestaurante = nickNameRestaurante;
        this.numero = numero;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
        this.estado = estado;
        this.dataPedidoProducos = dataPedidoProducos;
        this.dataComentario = dataComentario;
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

    public DataComentario getDataComentario() {
        return dataComentario;
    }

    public void setNickNameCliente(String nickNameCliente) {
        this.nickNameCliente = nickNameCliente;
    }

    public void setNickNameRestaurante(String nickNameRestaurante) {
        this.nickNameRestaurante = nickNameRestaurante;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFechaPedido(Calendar fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void setEstado(EnumEstado estado) {
        this.estado = estado;
    }

    public void setDataPedidoProducos(ArrayList<DataPedidoProduco> dataPedidoProducos) {
        this.dataPedidoProducos = dataPedidoProducos;
    }

    public void setDataComentario(DataComentario dataComentario) {
        this.dataComentario = dataComentario;
    }

}
