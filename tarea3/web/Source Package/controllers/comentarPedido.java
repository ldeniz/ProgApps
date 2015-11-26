/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proxy.ControladorPedidoPublicador;
import proxy.ControladorPedidoPublicadorService;

/**
 *
 * @author Mathi
 */
public class comentarPedido extends HttpServlet {

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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        loadProperties();
        URL url = new URL(propiedades.getProperty("usuarioUrl"));
        ControladorPedidoPublicadorService service = new ControladorPedidoPublicadorService(url);
        ControladorPedidoPublicador pd = service.getControladorPedidoPublicadorPort();

        String comentario = request.getParameter("comentario");
        float puntuacion = Float.parseFloat(request.getParameter("puntuacion"));
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));

        try {

            pd.agregarComentario(idPedido, comentario, puntuacion);

        } catch (Exception ex) {
        }

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.flush();
        }
    }

}
