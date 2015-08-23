/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCliente;
import datatype.DataRestaurante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
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
    public void ingresarCliente(DataCliente dataCliente) {
        Cliente c = new Cliente(dataCliente.getApellido(), dataCliente.getFechaNacimiento(), dataCliente.getRutaImagen(), dataCliente.getNickname(), dataCliente.getMail(), dataCliente.getNombre(), dataCliente.getPass(), dataCliente.getDireccion());
        clientes.put(c.getNickname(), c);
        //Lo agrego a la colección de usuarios por nickname y mail
        usuariosNick.put(c.getNickname(), c);
        usuariosMail.put(c.getMail(), c);
    }

    /**
     *
     * @param dataRestaurante
     */
    public void ingresarRestaurante(DataRestaurante dataRestaurante) {
        Restaurante r = new Restaurante(dataRestaurante.getRutaImagen(), dataRestaurante.getNickname(), dataRestaurante.getMail(), dataRestaurante.getNombre(), dataRestaurante.getPass(), dataRestaurante.getDireccion());
        restaurantes.put(r.getNickname(), r);
        //Lo agrego a la colección de usuarios
        usuariosNick.put(r.getNickname(), r);
        usuariosMail.put(r.getMail(), r);
    }
    
    public boolean existeUsuarioNickName(String nickname){
        return usuariosNick.containsKey(nickname);
    }
    
    public boolean existeUsuarioMail(String mail){
        return usuariosMail.containsKey(mail);
    }
    
    public boolean existeUsuario(String nickname, String mail){
        return usuariosNick.containsKey(nickname) || usuariosMail.containsKey(mail);
    }

    public ArrayList<DataCliente> listarClientes() {
        ArrayList<DataCliente> dataClientes = null;
        if (!clientes.isEmpty()) {
            dataClientes = new ArrayList<>();
            for (Entry<String, Cliente> entry : clientes.entrySet()) {
                Cliente c = entry.getValue();
                dataClientes.add(new DataCliente(c.getApellido(), c.getFechaNacimiento(), c.getRutaImagen(), c.getNickname(), c.getMail(), c.getNombre(), c.getPass(), c.getDireccion()));
            }
        }
        return dataClientes;
    }
}
