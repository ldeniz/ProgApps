package datatype;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author sestefan
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuario {

    private String nickname;
    private String mail;
    private String nombre;
    private String pass;
    private DataDireccion direccion;
    private ArrayList<DataPedido> pedidos;

    public DataUsuario() {
    }

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

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDireccion(DataDireccion direccion) {
        this.direccion = direccion;
    }

    public void setPedidos(ArrayList<DataPedido> pedidos) {
        this.pedidos = pedidos;
    }

}
