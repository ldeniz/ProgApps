/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import datatype.DataPedido;
import fabrica.Fabrica;
import interfaces.IControladorPedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author Mathi
 */
public class comentarPedido extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
        {
            IControladorPedido pd = Fabrica.getInstance().obtenerControladorPedido();
            
            
            String comentario = request.getParameter("comentario");
            int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
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