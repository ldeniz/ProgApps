/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controlador.ControladorUsuario;
import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataIndividual;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataPromocion;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

/**
 *
 * @author sestefan
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorUsuarioPublicador {

    private Endpoint endpoint = null;

    //Constructor
    public ControladorUsuarioPublicador() {
    }

    //Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9129/usuario", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod()
    public DataUsuario[] listarUsuarios() {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataUsuario> ldc = cu.listarUsaurios();
        DataUsuario[] var = new DataUsuario[ldc.size()];
        var = ldc.toArray(var);
        return var;
    }

    @WebMethod
    public void registrarCliente(
            @WebParam(name = "email") String mail,
            @WebParam(name = "nickName") String nickname,
            @WebParam(name = "password") String pass, @WebParam(name = "direccion") DataDireccion direccion,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "apellido") String apellido,
            @WebParam(name = "fechaNacimiento") Date fechaNacimiento,
            @WebParam(name = "nombreImagen") String rutaImagen) throws Exception {

        IControladorUsuario icu = Fabrica.getInstance().obtenerControladorUsuario();
        if (icu.existeUsuario(nickname, mail)) {
            throw new Exception("El usuario ya existe");
        } else {
            icu.CargarDatosUsuario(nickname, mail, nombre, pass, direccion, apellido, fechaNacimiento, rutaImagen);
            icu.altaUsuario();
            icu.limpiarMemoria();
        }
    }

    @WebMethod
    public boolean existeUsuario(String nickname) {
        ControladorUsuario cu = new ControladorUsuario();
        return cu.existeUsuario(nickname);
    }

    @WebMethod
    public boolean existeUsuario2(String nickname, String mail) {
        ControladorUsuario cu = new ControladorUsuario();
        return cu.existeUsuario(nickname, mail);
    }

    @WebMethod
    public DataCliente[] listarClientes() {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataCliente> ldc = cu.listarClientes();
        DataCliente[] var = new DataCliente[ldc.size()];
        var = ldc.toArray(var);
        return var;
    }

    @WebMethod
    public DataRestaurante[] listarRestaurantes() {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataRestaurante> ldr = cu.listarRestaurantes();
        DataRestaurante[] var = new DataRestaurante[ldr.size()];
        var = ldr.toArray(var);
        return var;
    }

    @WebMethod
    public DataProducto[] listarProductos(String nickName) {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataProducto> ldp = cu.listarProductos(nickName);
        DataProducto[] var = new DataProducto[ldp.size()];
        var = ldp.toArray(var);
        return var;
    }

    @WebMethod
    public DataIndividual[] listarProductosIndividuales(String nickName) {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataProducto> ldp = cu.listarProductos(nickName);
        ArrayList<DataIndividual> aux = new ArrayList<>();
        for (DataProducto p : ldp) {
            if ("individual".equals(p.getTipoProducto())) {
                aux.add((DataIndividual) p);
            }
        }
        DataIndividual[] var = new DataIndividual[aux.size()];
        var = aux.toArray(var);
        return var;
    }

    @WebMethod
    public DataPromocion[] listarProductosPromociones(String nickName) {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataProducto> ldp = cu.listarProductos(nickName);
        ArrayList<DataPromocion> aux = new ArrayList<>();
        for (DataProducto p : ldp) {
            if ("promocion".equals(p.getTipoProducto())) {
                aux.add((DataPromocion) p);
            }
        }
        DataPromocion[] var = new DataPromocion[aux.size()];
        var = aux.toArray(var);
        return var;
    }

    @WebMethod
    public DataPedido[] listarPedidosCliente(String nickName) {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataPedido> ldp = cu.listarPedidosCliente(nickName);
        DataPedido[] var = new DataPedido[ldp.size()];
        var = ldp.toArray(var);
        return var;
    }

    @WebMethod
    public DataUsuario obtenerUsuario(String nickName) throws Exception {
        ControladorUsuario cu = new ControladorUsuario();
        return cu.obtenerUsuario(nickName);
    }

    @WebMethod
    public DataCategoria[] listarCategorias(String nickNameRestaurante) throws Exception {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataCategoria> ldc = cu.listarCategorias(nickNameRestaurante);
        DataCategoria[] var = new DataCategoria[ldc.size()];
        var = ldc.toArray(var);
        return var;
    }

    @WebMethod
    public DataRestaurante[] listarRestaurantes2(String patron) throws Exception {
        ControladorUsuario cu = new ControladorUsuario();
        ArrayList<DataRestaurante> ldr = cu.listarRestaurantes(patron);
        DataRestaurante[] var = new DataRestaurante[ldr.size()];
        var = ldr.toArray(var);
        return var;
    }

    @WebMethod
    public byte[] getImage(@WebParam(name = "fileName") String name) throws Exception {
        byte[] byteArray = null;
        try {
            File f = new File(name);
            FileInputStream streamer = new FileInputStream(f);
            byteArray = new byte[streamer.available()];
            streamer.read(byteArray);
        } catch (Exception e) {
            throw e;
        }
        return byteArray;
    }

}
