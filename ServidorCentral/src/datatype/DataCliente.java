/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatype;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCliente extends DataUsuario {

    private String apellido;
    private Date fechaNacimiento;
    private String rutaImagen;

    public DataCliente() {
    }

    public DataCliente(String apellido, Date fechaNacimiento, String rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        super(nickname, mail, nombre, pass, direccion);
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.rutaImagen = rutaImagen;
    }

    public DataCliente(String apellido, Date fechaNacimiento, String rutaImagen, String nickname, String mail, String nombre, String pass, DataDireccion direccion, ArrayList<DataPedido> pedidos) {
        super(nickname, mail, nombre, pass, direccion, pedidos);
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

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

}
