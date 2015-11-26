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
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import proxy.ControladorPedidoPublicador;
import proxy.ControladorPedidoPublicadorService;
import proxy.Exception_Exception;
import proxy.IntArray;
import proxy.StringArray;

/**
 *
 * @author Mathi
 */
public class realizarPedido extends HttpServlet {

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
        URL url = new URL(propiedades.getProperty("pedidoUrl"));
        ControladorPedidoPublicadorService service = new ControladorPedidoPublicadorService(url);
        ControladorPedidoPublicador pd = service.getControladorPedidoPublicadorPort();

        String cliente = (String) request.getSession().getAttribute("usuario_logueado");
        String restaurante = request.getParameter("restaurante");
        String productos = request.getParameter("productos");

        try {

            JSONArray jsonArray = new JSONArray(productos);
            IntArray cant = new IntArray();
            List<Integer> lint = cant.getItem();
            StringArray prod = new StringArray();
            List<String> lstring = prod.getItem();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject producto = jsonArray.getJSONObject(i);
                lint.add(Integer.parseInt(producto.getString("cantidad")));
                lstring.add(producto.getString("prod"));

            }
            pd.realizarPedido(cliente, restaurante, prod, cant);

        } catch (JSONException | NumberFormatException | Exception_Exception ex) {
        }

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.flush();
        }
    }

}
