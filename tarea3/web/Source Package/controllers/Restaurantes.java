/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Home.initSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proxy.ControladorCategoriaPublicador;
import proxy.ControladorCategoriaPublicadorService;
import proxy.ControladorPedidoPublicador;
import proxy.ControladorPedidoPublicadorService;
import proxy.ControladorUsuarioPublicador;
import proxy.ControladorUsuarioPublicadorService;
import proxy.DataCategoriaArray;
import proxy.DataPedido;
import proxy.DataRestaurante;
import proxy.DataRestauranteArray;

/**
 *
 * @author Mathi
 */
public class Restaurantes extends HttpServlet {

    private static Properties propiedades = null;

    private static void loadProperties() {
        if (propiedades == null) {
            propiedades = new Properties();
        }
        if (propiedades.isEmpty()) {
            try {
                InputStream entrada;
                entrada = Restaurantes.class.getResourceAsStream("/Resources/config.properties");
                propiedades.load(entrada);
            } catch (IOException ex) {
            }
        }
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, Exception {
        initSession(req);

        String restaurante = req.getParameter("restaurante");
        if (restaurante == null) {

        } else {
            loadProperties();
            ControladorUsuarioPublicadorService service = new ControladorUsuarioPublicadorService(new URL(propiedades.getProperty("usuarioUrl")));
            ControladorUsuarioPublicador iUsr = service.getControladorUsuarioPublicadorPort();
            DataRestaurante resto = (DataRestaurante) iUsr.obtenerUsuario(restaurante);
            req.setAttribute("datosRes", resto);

            ControladorPedidoPublicadorService service2 = new ControladorPedidoPublicadorService(new URL(propiedades.getProperty("pedidoUrl")));
            ControladorPedidoPublicador icp = service2.getControladorPedidoPublicadorPort();
            List<DataPedido> ldp = icp.listarPedidos2(restaurante).getItem();
            if (ldp != null && !ldp.isEmpty()) {
                req.setAttribute("datosPedidoRes", ldp);
            }
        }

        req.getRequestDispatcher("/WEB-INF/home/restaurantes.jsp").
                forward(req, resp);
    }

    static public DataCategoriaArray getCategorias(HttpServletRequest request) throws FileNotFoundException, MalformedURLException {
        loadProperties();
        URL url = new URL(propiedades.getProperty("categoriaUrl"));
        ControladorCategoriaPublicadorService service2 = new ControladorCategoriaPublicadorService(url);
        ControladorCategoriaPublicador cCat = service2.getControladorCategoriaPublicadorPort();
        DataCategoriaArray categorias = cCat.listarCategorias();
        return categorias;
    }

    static public DataRestauranteArray getRestaurantes(HttpServletRequest request, String resto) throws Exception {
        loadProperties();
        String url = propiedades.getProperty("usuarioUrl");
        ControladorUsuarioPublicadorService service = new ControladorUsuarioPublicadorService(new URL(url));
        ControladorUsuarioPublicador iUsr = service.getControladorUsuarioPublicadorPort();

        if (resto == null) {
            DataRestauranteArray restaurantes = iUsr.listarRestaurantes();
            return restaurantes;
        } else {
            DataRestauranteArray restaurantes = iUsr.listarRestaurantes2(resto);
            return restaurantes;
        }

    }

    static public byte[] getImagen(HttpServletRequest request, String rutaImagen) throws Exception {
        loadProperties();
        ControladorUsuarioPublicadorService service = new ControladorUsuarioPublicadorService(new URL(propiedades.getProperty("usuarioUrl")));
        ControladorUsuarioPublicador iUsr = service.getControladorUsuarioPublicadorPort();

        return iUsr.getImage(rutaImagen);

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
