/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Home.initSession;
import java.io.FileNotFoundException;
import servidor.DataCategoria;
import servidor.DataPedido;
import servidor.DataRestaurante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.ControladorCategoriaPublicador;
import servidor.ControladorCategoriaPublicadorService;
import servidor.ControladorPedidoPublicador;
import servidor.ControladorPedidoPublicadorService;
import servidor.ControladorUsuarioPublicador;
import servidor.ControladorUsuarioPublicadorService;
import servidor.DataCategoriaArray;
import servidor.DataPedidoArray;
import servidor.DataRestauranteArray;

/**
 *
 * @author Mathi
 */
public class Restaurantes extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, Exception {
        initSession(req);

        String restaurante = req.getParameter("restaurante");
        if (restaurante == null) {

        } else {
            ControladorUsuarioPublicadorService service =  new ControladorUsuarioPublicadorService();
            ControladorUsuarioPublicador iUsr = service.getControladorUsuarioPublicadorPort();
            DataRestaurante resto = (DataRestaurante) iUsr.obtenerUsuario(restaurante);
            req.setAttribute("datosRes", resto);

            ControladorPedidoPublicadorService service2 =  new ControladorPedidoPublicadorService();
            ControladorPedidoPublicador ldp = service2.getControladorPedidoPublicadorPort();
            /*DataPedidoArray ldp = icp.listarPedidos(restaurante);
            if (ldp != null && !ldp.isEmpty()) {
                req.setAttribute("datosPedidoRes", ldp);
            }*/
        }

        req.getRequestDispatcher("/WEB-INF/home/restaurantes.jsp").
                forward(req, resp);
    }

    static public DataCategoriaArray getCategorias(HttpServletRequest request) throws FileNotFoundException {
        ControladorCategoriaPublicadorService service2 =  new ControladorCategoriaPublicadorService();
        ControladorCategoriaPublicador cCat = service2.getControladorCategoriaPublicadorPort();
        DataCategoriaArray categorias = cCat.listarCategorias();
        return categorias;
    }

    static public DataRestauranteArray getRestaurantes(HttpServletRequest request, String resto) throws Exception {
        ControladorUsuarioPublicadorService service =  new ControladorUsuarioPublicadorService();
        ControladorUsuarioPublicador iUsr = service.getControladorUsuarioPublicadorPort();
        if (resto == null) {
            DataRestauranteArray restaurantes = iUsr.listarRestaurantes();
            return restaurantes;
        } else {
            DataRestauranteArray restaurantes = iUsr.listarRestaurantes2(resto);
            return restaurantes;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
