/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import controlador.ControladorCategoria;
import controlador.ControladorPedido;
import controlador.ControladorProducto;
import controlador.ControladorUsuario;
import java.util.LinkedList;

/**
 *
 * @author Sebastián Estefan
 */
public class ManejadorControlador {

    private static ManejadorControlador instancia;
    private final LinkedList<ControladorCategoria> categorias;
    private final LinkedList<ControladorPedido> pedidos;
    private final LinkedList<ControladorProducto> productos;
    private final LinkedList<ControladorUsuario> usuarios;

    private ManejadorControlador() {
        categorias = new LinkedList<>();
        pedidos = new LinkedList<>();
        productos = new LinkedList<>();
        usuarios = new LinkedList<>();
    }

    public static ManejadorControlador getInstance() {
        if (instancia == null) {
            instancia = new ManejadorControlador();
        }
        return instancia;
    }

    /**
     * 
     */
    public int getNewCategoriaControllerId(){
        ControladorCategoria cc = new ControladorCategoria();
        categorias.add(cc);
        return categorias.size();
    }
    
    public int getNewPedidoControllerId(){
        ControladorPedido cp = new ControladorPedido();
        pedidos.add(cp);
        return pedidos.size();
    }
    
    public int getNewProductoControllerId(){
        ControladorProducto cp = new ControladorProducto();
        productos.add(cp);
        return productos.size();
    }
    
    public int getNewUsuarioControllerId(){
//        ControladorUsuario cu 
        return 0;
    }
    
    /**
     * 
     */
    public void removeCategoriaControllerId(){
        
    }
    
    public void removePedidoControllerId(){
        
    }
    
    public void removeProductoControllerId(){
        
    }
    
    public void removeUsuarioControllerId(){
        
    }

}
