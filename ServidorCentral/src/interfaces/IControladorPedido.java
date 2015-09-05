/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author sestefan
 */
public interface IControladorPedido {
    
    

    /**
     * El sistema recuerda el producto seleccionado y su restaurante y su cantidad.
     * @param nickName
     * @param nombreProducto
     * @param cantidad 
     */
    public void seleccionarProducto(String nickName, String nombreProducto, int cantidad);    
    
    
    
    /**
     * 
     */
    public void listarPedidos();

}
