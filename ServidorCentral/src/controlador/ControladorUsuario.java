/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Date;
import manejador.ManejadorUsuario;

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
    public void CargarDatosUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, String[] rutaImagen) {
        dataUsuario = new DataRestaurante(rutaImagen, dataCategorias, nickname, mail, nombre, pass, direccion);
        tipo = "restaurante";
    }

    @Override
    public void seleccionarCategoria(String name) {
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
    public boolean existeMail(String mail) {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        return mu.existeMail(mail);
    }

    @Override
    public void altaUsuario() {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        switch (tipo) {
            case "cliente":
                mu.ingresarUsuario((DataCliente) dataUsuario);
                break;
            case "restaurante":
                mu.ingresarUsuario((DataRestaurante) dataUsuario);
                break;
        }
    }

    @Override
    public void limpiarMemoria() {
        dataCategorias.clear();
        dataUsuario = null;
    }

    @Override
    public ArrayList<DataCliente> listarClientes() {
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        return mu.listarClientes();
    }

}
