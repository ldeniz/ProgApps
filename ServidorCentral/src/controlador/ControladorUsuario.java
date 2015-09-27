/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Date;
import manejador.ManejadorCategoria;
import manejador.ManejadorUsuario;
import modelo.Cliente;
import modelo.Restaurante;
import modelo.Usuario;

/**
 *
 * @author sestefan
 */
public class ControladorUsuario implements IControladorUsuario {

    private ArrayList<DataCategoria> dataCategorias;
    private DataUsuario dataUsuario;
    private String tipo;

    @Override
    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String apellido, Date fechaNacimiento, String rutaImagen) {
        dataUsuario = new DataCliente(apellido, fechaNacimiento, rutaImagen, nickname, mail, nombre, pass, direccion);
        tipo = "cliente";
    }

    @Override
    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String[] rutaImagen) throws Exception {
        if (dataCategorias == null) {
            throw new Exception("Debes seleccionar al menos una categoría.");
        }
        dataUsuario = new DataRestaurante(rutaImagen, nickname, mail, nombre, pass, direccion);
        tipo = "restaurante";
    }

    @Override
    public void seleccionarCategoria(String name) {
        if (dataCategorias == null) {
            dataCategorias = new ArrayList<>();
        }
        dataCategorias.add(new DataCategoria(name));
    }

    @Override
    public boolean existeUsuario(String nickname) {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        return mu.existeUsuarioNickName(nickname);
    }

    @Override
    public boolean existeUsuario(String nickname, String mail) {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        return mu.existeUsuario(nickname, mail);
    }

    @Override
    public void altaUsuario() {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        Usuario u = null;
        switch (tipo) {
            case "cliente":
                DataCliente dc = (DataCliente) dataUsuario;
                u = new Cliente(dc.getApellido(), dc.getFechaNacimiento(),
                        dc.getRutaImagen(), dc.getNickname(), dc.getMail(),
                        dc.getNombre(), dc.getPass(), dc.getDireccion());
                mu.ingresarUsuario((Cliente) u);
                break;
            case "restaurante":
                DataRestaurante dr = (DataRestaurante) dataUsuario;
                u = new Restaurante(dr.getRutaImagen(), dr.getNickname(),
                        dr.getMail(), dr.getNombre(), dr.getPass(), dr.getDireccion());
                ManejadorCategoria mc = ManejadorCategoria.getInstance();
                for (DataCategoria data : dataCategorias) {
                    mc.agregarRestaurante(data.getNombre(), (Restaurante) u);
                }
                mu.ingresarUsuario((Restaurante) u);
                break;
        }
    }

    @Override
    public void limpiarMemoria() {
        if (dataCategorias != null) {
            dataCategorias.clear();
        }
        dataUsuario = null;
    }

    @Override
    public ArrayList<DataCliente> listarClientes() {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        ArrayList<Cliente> clientes = mu.listarClientes();
        ArrayList<DataCliente> dataUsuarios = new ArrayList<>();
        if (!clientes.isEmpty()) {
            for (Usuario u : clientes) {
                dataUsuarios.add((DataCliente) u.obtenerDatosUsuario());
            }
        }
        return dataUsuarios;
    }

    @Override
    public ArrayList<DataRestaurante> listarRestaurantes() {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        ArrayList<Restaurante> restaurantes = mu.listarRestaurantes();
        ArrayList<DataRestaurante> dataUsuarios = new ArrayList<>();
        if (!restaurantes.isEmpty()) {
            for (Usuario u : restaurantes) {
                dataUsuarios.add((DataRestaurante) u.obtenerDatosUsuario());
            }
        }
        return dataUsuarios;
    }

    @Override
    public ArrayList<DataUsuario> listarUsaurios() {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        ArrayList<Usuario> usuarios = mu.listarUsuarios();
        ArrayList<DataUsuario> dataUsuarios = null;
        if (!usuarios.isEmpty()) {
            dataUsuarios = new ArrayList<>();
            for (Usuario u : usuarios) {
                dataUsuarios.add(u.obtenerDatosUsuario());
            }
        }
        return dataUsuarios;
    }

    @Override
    public ArrayList<DataProducto> listarProductos(String nickName) {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        Restaurante r = mu.obtenerRestaurante(nickName);
        DataRestaurante dr = (DataRestaurante) r.obtenerDatosUsuario();
        return dr.getDataProductos();
    }

    @Override
    public ArrayList<DataPedido> listarPedidosCliente(String nickName) {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        Cliente c = (Cliente) mu.obtenerUsuario(nickName);
        DataCliente dc = (DataCliente) c.obtenerDatosUsuario();
        return dc.getPedidos();
    }

    @Override
    public DataUsuario obtenerUsuario(String nickName) throws Exception {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        Usuario u = mu.obtenerUsuario(nickName);
        if (u == null) {
            throw new Exception("No existe usuario " + nickName);
        }
        return u.obtenerDatosUsuario();
    }

}
