/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.Date;

/**
 *
 * @author sestefan
 */
public class DataCliente extends DataUsuario {

    private String apellido;
    private Date fechaNacimiento;
    private String rutaImagen;

    public DataCliente(String apellido, Date fechaNacimiento, String rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.rutaImagen = rutaImagen;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

}
