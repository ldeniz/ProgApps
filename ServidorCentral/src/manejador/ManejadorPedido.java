/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import java.util.LinkedList;
import modelo.Comentario;
import modelo.Pedido;

/**
 *
 * @author sestefan
 */
public class ManejadorPedido {

    private static ManejadorPedido instancia;
    private LinkedList<Pedido> pedidos;

    private ManejadorPedido() {
        pedidos = new LinkedList<>();
    }

    public static ManejadorPedido getInstance() {
        if (instancia == null) {
            instancia = new ManejadorPedido();
        }
        return instancia;
    }

    public void ingresarPedido(Pedido p) {
        p.setNumero(pedidos.size() + 1);
        pedidos.add(p);
    }

    public Pedido obtenerPedido(int numero) {
        return pedidos.get(numero - 1);
    }

    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> lpedido = new ArrayList<>();
        for (Pedido p : pedidos) {
            lpedido.add(p);
        }
        return lpedido;
    }

    public void borrarPedido(Pedido p) {
        pedidos.remove(p);
    }

}
