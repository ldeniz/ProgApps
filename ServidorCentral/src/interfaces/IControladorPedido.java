/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datatype.DataPedido;

/**
 *
 * @author sestefan
 */
public interface IControladorPedido {

    /**
     * El sistema recuerda el cliente seleccionado.
     *
     * @param nickName
     * @throws java.lang.Exception
     */
    public void seleccionarCliente(String nickName) throws Exception;

    /**
     * El sistema recuerda el restaurante seleccionado.
     *
     * @param nickName
     * @throws java.lang.Exception
     */
    public void seleccionarRestaurante(String nickName) throws Exception;

    /**
     * El sistema recuerda el producto seleccionado y su restaurante y su
     * cantidad.
     *
     * @param nickName
     * @param nombreProducto
     * @param cantidad
     * @throws java.lang.Exception
     */
    public void seleccionarProducto(String nickName, String nombreProducto, int cantidad) throws Exception;

    /**
     * El nuevo pedido es ingresado al sistema
     *
     * @return
     */
    public DataPedido finalizarPedido();

    /**
     *
     */
    public void listarPedidos();

}
