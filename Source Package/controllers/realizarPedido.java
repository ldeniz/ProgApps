/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import proxy.ControladorPedidoPublicador;
import proxy.ControladorPedidoPublicadorService;
import proxy.IntArray;
import proxy.StringArray;

/**
 *
 * @author Mathi
 */
public class realizarPedido extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ControladorPedidoPublicadorService service = new ControladorPedidoPublicadorService();
        ControladorPedidoPublicador pd = service.getControladorPedidoPublicadorPort();

        String cliente = (String) request.getSession().getAttribute("usuario_logueado");
        String restaurante = request.getParameter("restaurante");
        String productos = request.getParameter("productos");

        try {
//            pd.seleccionarCliente(cliente);
//            pd.seleccionarRestaurante(restaurante);

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

        } catch (Exception ex) {
            Logger.getLogger(realizarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(report);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.write(report);
        out.flush();
        out.close();
    }

}
