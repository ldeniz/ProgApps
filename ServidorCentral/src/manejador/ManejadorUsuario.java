/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Producto;
import modelo.Restaurante;
import modelo.Usuario;

/**
 *
 * @author Sebastián Estefan
 */
public class ManejadorUsuario {

    private static ManejadorUsuario instancia;
    private final HashMap<String, Usuario> usuariosNick;
    private final HashMap<String, Usuario> usuariosMail;
    private final HashMap<String, Cliente> clientes;
    private final HashMap<String, Restaurante> restaurantes;

    private ManejadorUsuario() {
        usuariosNick = new HashMap<>();
        usuariosMail = new HashMap<>();
        clientes = new HashMap<>();
        restaurantes = new HashMap<>();
    }

    public static ManejadorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ManejadorUsuario();
        }
        return instancia;
    }

    /**
     *
     * @param cliente
     */
    public void ingresarUsuario(Cliente cliente) {
        clientes.put(cliente.getNickname(), cliente);
        //Lo agrego a la colección de usuarios por nickname y mail
        usuariosNick.put(cliente.getNickname(), cliente);
        usuariosMail.put(cliente.getMail(), cliente);
    }

    public void ingresarUsuario(Restaurante r) {
        restaurantes.put(r.getNickname(), r);
        //Lo agrego a la colección de usuarios
        usuariosNick.put(r.getNickname(), r);
        usuariosMail.put(r.getMail(), r);
    }

    public boolean existeUsuarioNickName(String nickname) {
        return usuariosNick.containsKey(nickname);
    }

    public boolean existeUsuario(String mail) {
        return usuariosMail.containsKey(mail);
    }

    public boolean existeUsuario(String nickname, String mail) {
        return usuariosNick.containsKey(nickname) || usuariosMail.containsKey(mail);
    }

    public Usuario obtenerUsuario(String nickName) {
        Usuario u = usuariosNick.get(nickName);
        return u;
    }

    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) usuariosNick.values();
    }

    public ArrayList<Restaurante> listarRestaurantes() {
        return (ArrayList<Restaurante>) restaurantes.values();
    }

    public ArrayList<Cliente> listarClientes() {
        return (ArrayList<Cliente>) clientes.values();
    }

    public void agregarProductoRestaurante(Producto producto) {
        Restaurante r = restaurantes.get(producto.getNickName());
        r.agregarProducto(producto);

    }
    
    public void agregarPedidoUsuario(String nickName, Pedido p){
        Usuario u = usuariosNick.get(nickName);
        u.agregarPedido(p);
    }

    public Restaurante obtenerRestaurante(String nickName) {
        Restaurante r = restaurantes.get(nickName);
        return r;
    }

    public void limpiarMemoria() {
        usuariosNick.clear();
        usuariosMail.clear();
        clientes.clear();
        restaurantes.clear();
    }

}
