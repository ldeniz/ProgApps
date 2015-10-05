/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Mathi
 */
public class realizarPedido extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
        {
            IControladorPedido pd = Fabrica.getInstance().obtenerControladorPedido();
            
            String cliente = request.getParameter("cliente");
            String productos = request.getParameter("productos");
            
            
            
            
            try {
                pd.seleccionarCliente(cliente);
            } catch (Exception ex) {
                Logger.getLogger(realizarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                pd.seleccionarRestaurante("bocatti");
            } catch (Exception ex) {
                Logger.getLogger(realizarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pd.seleccionarProducto("bocatti", "Empanada de Carne", 1);
            } catch (Exception ex) {
                Logger.getLogger(realizarPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
                pd.finalizarPedido();
            
            ArrayList<DataPedido> lPedido = pd.listarPedidos();
            //String report = "";
           // for (DataPedido pedido : lPedido) {
           //      report = report+'/'+pedido.getNickNameCliente()+'-'+pedido.getNickNameRestaurante()+'-'+Integer.toString(pedido.getNumero());
                        
           // }
            
            
            String report = "";
           
            

            System.out.println(report);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.write(report);
            out.flush();
            out.close();
        }
	
	
	
    
}
