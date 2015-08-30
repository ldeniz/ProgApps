/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataUsuario;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sestefan
 */
public class Cliente extends Usuario implements Serializable {

    private String apellido;
    private Date fechaNacimiento;
    private String rutaImagen;

    public Cliente(String apellido, Date fechaNacimiento, String rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.rutaImagen = rutaImagen;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public DataUsuario obtenerDatosUsuario() {
        DataUsuario dataUsuario = new DataCliente(apellido, fechaNacimiento, rutaImagen, this.getNickname(), this.getMail(), this.getNombre(), this.getPass(), this.getDireccion());
        return dataUsuario;
    }

}
