/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.LinkedList;
import modelo.Pedido;

/**
 *
 * @author sestefan
 */
public class ManejadorPedido {

    private static ManejadorPedido instancia;
    private LinkedList<Pedido> pedidos;

    private ManejadorPedido() {
    }

    public static ManejadorPedido getInstance() {
        if (instancia == null) {
            instancia = new ManejadorPedido();
        }
        return instancia;
    }

}
