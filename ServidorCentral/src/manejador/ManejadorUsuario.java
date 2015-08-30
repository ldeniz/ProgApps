/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import java.util.ArrayList;
import java.util.HashMap;
import modelo.Cliente;
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
     * @param dataCliente
     */
    public void ingresarUsuario(DataCliente dataCliente) {
        Cliente c = new Cliente(dataCliente.getApellido(), dataCliente.getFechaNacimiento(), dataCliente.getRutaImagen(), dataCliente.getNickname(), dataCliente.getMail(),
                dataCliente.getNombre(), dataCliente.getPass(), dataCliente.getDireccion());
        clientes.put(c.getNickname(), c);
        //Lo agrego a la colección de usuarios por nickname y mail
        usuariosNick.put(c.getNickname(), c);
        usuariosMail.put(c.getMail(), c);
    }

    /**
     *
     * @param dataRestaurante
     */
    public void ingresarUsuario(DataRestaurante dataRestaurante) {
        Restaurante r = new Restaurante(dataRestaurante.getRutaImagen(), dataRestaurante.getNickname(), dataRestaurante.getMail(), dataRestaurante.getNombre(), dataRestaurante.getPass(), dataRestaurante.getDireccion());
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        for (DataCategoria dc : dataRestaurante.getDataCategorias()) {
            r.agregarCategoria(mc.obtenerCategoria(dc.getNombre()));
        }
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
    
    public DataUsuario obtenerDataUsuario(String nickName){
        Usuario u = usuariosNick.get(nickName);
        return u.obtenerDatosUsuario();
    }

    public ArrayList<DataUsuario> listarUsuarios() {
        ArrayList<DataUsuario> dataUsuarios = null;
        if (!usuariosNick.isEmpty()) {
            dataUsuarios = new ArrayList<>();
            ArrayList<Usuario> lu;
            lu = new ArrayList<>(usuariosNick.values());
            for (Usuario u : lu) {
                dataUsuarios.add(u.obtenerDatosUsuario());
            }
            lu.clear();
        }
        return dataUsuarios;
    }

    public ArrayList<DataRestaurante> listarRestaurantes() {
        ArrayList<DataRestaurante> dataUsuarios = null;
        if (!restaurantes.isEmpty()) {
            dataUsuarios = new ArrayList<>();
            ArrayList<Usuario> lu;
            lu = new ArrayList<>(restaurantes.values());
            for (Usuario u : lu) {
                dataUsuarios.add((DataRestaurante) u.obtenerDatosUsuario());
            }
            lu.clear();
        }
        return dataUsuarios;

    }

    public ArrayList<DataCliente> listarClientes() {
        ArrayList<DataCliente> dataUsuarios = null;
        if (!clientes.isEmpty()) {
            dataUsuarios = new ArrayList<>();
            ArrayList<Usuario> lu;
            lu = new ArrayList<>(clientes.values());
            for (Usuario u : lu) {
                dataUsuarios.add((DataCliente) u.obtenerDatosUsuario());
            }
            lu.clear();
        }
        return dataUsuarios;

    }

}
