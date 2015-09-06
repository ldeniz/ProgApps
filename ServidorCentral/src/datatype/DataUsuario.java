package datatype;

import java.util.ArrayList;

/**
 *
 * @author sestefan
 */
public abstract class DataUsuario {

    private String nickname;
    private String mail;
    private String nombre;
    private String pass;
    private DataDireccion direccion;
    private ArrayList<DataPedido> pedidos;

    public DataUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion) {
        this.nickname = nickname;
        this.mail = mail;
        this.nombre = nombre;
        this.pass = pass;
        this.direccion = direccion;
    }

    public DataUsuario(String nickname, String mail, String nombre, String pass, DataDireccion direccion, ArrayList<DataPedido> pedidos) {
        this.nickname = nickname;
        this.mail = mail;
        this.nombre = nombre;
        this.pass = pass;
        this.direccion = direccion;
        this.pedidos = pedidos;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMail() {
        return mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public DataDireccion getDireccion() {
        return direccion;
    }

    public ArrayList<DataPedido> getPedidos() {
        return pedidos;
    }

}
