/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import controlador.ControladorCategoria;
import datatype.DataCategoria;
import datatype.DataRestaurante;
import java.util.ArrayList;
import javax.jws.WebMethod;
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
public class ControladorCategoriaPublicador {

    private Endpoint endpoint = null;

    //Constructor
    public ControladorCategoriaPublicador() {
    }

    //Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar() {
        endpoint = Endpoint.publish("http://localhost:9128/categoria", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void altaCategoria(String nombre) {
        ControladorCategoria cc = new ControladorCategoria();
        cc.altaCategoria(nombre);
    }

    @WebMethod
    public boolean existeCategoria(String nombre) {
        ControladorCategoria cc = new ControladorCategoria();
        return cc.existeCategoria(nombre);
    }

    @WebMethod()
    public DataCategoria[] listarCategorias() {
        ControladorCategoria cc = new ControladorCategoria();
        ArrayList<DataCategoria> ldc = cc.listarCategorias();
        DataCategoria[] var = new DataCategoria[ldc.size()];
        var = ldc.toArray(var);
        return var;
    }

    @WebMethod
    public DataRestaurante[] listarRestaurantes(String categoria) throws Exception {
        ControladorCategoria cc = new ControladorCategoria();
        ArrayList<DataRestaurante> ldr = cc.listarRestaurantes(categoria);
        DataRestaurante[] dr = new DataRestaurante[ldr.size()];
        return ldr.toArray(dr);
    }
}
