/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        
        ControladorPedidoPublicadorService service =  new ControladorPedidoPublicadorService();
        ControladorPedidoPublicador pd = service.getControladorPedidoPublicadorPort();
            
        String comentario = request.getParameter("comentario");
        float puntuacion = Float.parseFloat(request.getParameter("puntuacion"));
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));

        try {

            pd.agregarComentario(idPedido, comentario, puntuacion);

        } catch (Exception ex) {
            Logger.getLogger(comentarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

        //System.out.println(report);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.write(report);
        out.flush();
        out.close();
    }

}
