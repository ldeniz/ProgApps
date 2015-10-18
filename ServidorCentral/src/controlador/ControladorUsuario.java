/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataComentario;
import datatype.DataDireccion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import manejador.ManejadorCategoria;
import manejador.ManejadorUsuario;
import modelo.Categoria;
import modelo.Cliente;
import modelo.Producto;
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

    @Override
    public ArrayList<DataComentario> listarComentariosRestaurante(String nickNameRestaurante) throws Exception {
        return null;
    }

    @Override
    public ArrayList<DataCategoria> listarCategorias(String nickNameRestaurante) throws Exception {
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        ArrayList<Categoria> lc = mc.listarCategorias();
        ArrayList<DataCategoria> ldc = null;
        if (lc.size() > 0) {
            ldc = new ArrayList<>();
        }
        for (Categoria c : lc) {
            ArrayList<Restaurante> lr = c.getRestaurantes();
            for (Restaurante r : lr) {
                if (r.getNickname().equals(nickNameRestaurante)) {
                    ldc.add(c.obtenerDatosCategoria());
                }
            }
        }
        return ldc;
    }

    @Override
    public ArrayList<DataRestaurante> listarRestaurantes(String patron) throws Exception {
        HashMap<String, DataRestaurante> ldr = new HashMap<>();
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        /**
         * 1) Busco por nombre de restaurante 2) Busco por sus categoria 3)
         * Busco por sus producto Nota: En caso de que el restoran exista en el
         * conjunto, ingnoro agregarlo
         */
        ArrayList<Restaurante> lr = mu.listarRestaurantes();
        for (Restaurante r : lr) {
            if (r.getNombre().toUpperCase().contains(patron.toUpperCase())) {
                if (!ldr.containsKey(r.getNickname())) {
                    ldr.put(r.getNickname(), (DataRestaurante) r.obtenerDatosUsuario());
                }
            }
            ArrayList<DataCategoria> ldc = listarCategorias(r.getNickname());
            for (DataCategoria dc : ldc) {
                if (dc.getNombre().toUpperCase().contains(patron.toUpperCase())) {
                    if (!ldr.containsKey(r.getNickname())) {
                        ldr.put(r.getNickname(), (DataRestaurante) r.obtenerDatosUsuario());
                    }
                }
            }
            ArrayList<Producto> ldp = r.getProductos();
            for (Producto p : ldp) {
                if (p.getNombre().toUpperCase().contains(patron.toUpperCase())) {
                    if (!ldr.containsKey(r.getNickname())) {
                        ldr.put(r.getNickname(), (DataRestaurante) r.obtenerDatosUsuario());
                    }
                }
            }

        }
        return new ArrayList<>(ldr.values());
    }

}
