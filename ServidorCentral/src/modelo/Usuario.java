/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datatype.DataDireccion;
import java.io.Serializable;

/**
 *
 * @author sestefan
 */
public abstract class Usuario implements Serializable {

    private String nickname;
    private String mail;
    private String nombre;
    private String pass;
    private DataDireccion direccion;

    public Usuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        this.nickname = nickname;
        this.mail = mail;
        this.nombre = nombre;
        this.pass = pass;
        this.direccion = direccion;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public DataDireccion getDireccion() {
        return direccion;
    }

    public void setDireccion(DataDireccion direccion) {
        this.direccion = direccion;
    }

}
