/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datatype.DataPedido;
import datatype.EnumEstado;
import java.util.ArrayList;

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
     * El sistema recuerda el número de pedido.
     *
     * @param numero
     */
    public void seleccionarPedido(int numero);

    /**
     *
     * @param estado
     */
    public void seleccionarEstado(EnumEstado estado);

    /**
     * El nuevo pedido es ingresado al sistema
     *
     * @return
     */
    public DataPedido finalizarPedido();

    /**
     *
     * @throws java.lang.Exception
     */
    public void actualizarPedido() throws Exception;

    /**
     *
     */
    public void cancelarPedido();

    /**
     *
     * @return
     */
    public ArrayList<DataPedido> listarPedidos();
    
    
    /**
     * Agrega un comentario al pedido, y recalcula el puntaje del restaurante.
     * El puntaje puede ser entre 1 y 5. Cualquier valor diferente genera una excepción.
     * Si el pedido está en un estado distinto a RECIBIDO el sistema lanza una excepción.
     * @param numPedido
     * @param comentario
     * @param puntaje 
     * @throws java.lang.Exception 
     */
    public void agregarComentario(int numPedido, String comentario, int puntaje) throws Exception;
    
    /**
     * Libera la memoria del sistema
     */
    public void limpiarMermoria();

}
