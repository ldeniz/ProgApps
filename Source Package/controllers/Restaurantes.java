/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Home.getEstado;
import static controllers.Home.initSession;
import datatype.DataCategoria;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import exceptions.UsuarioNoEncontrado;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mathi
 */
public class Restaurantes extends HttpServlet {
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception {
		initSession(req);
		
                String restaurante = req.getParameter("restaurante");
                if(restaurante == null) {
                    
                }else{
                    IControladorUsuario iUsr = Fabrica.getInstance().obtenerControladorUsuario();
                    DataRestaurante resto = (DataRestaurante) iUsr.obtenerUsuario(restaurante);
                    req.setAttribute("datosRes", resto);
                }
                
		req.getRequestDispatcher("/WEB-INF/home/restaurantes.jsp").
						forward(req, resp);
	}
	
    static public List<DataCategoria> getCategorias(HttpServletRequest request)
			
	{
            IControladorCategoria cCat = Fabrica.getInstance().obtenerControladorCategoria();
            List<DataCategoria> categorias= cCat.listarCategorias();
            return categorias;
	}
    
    static public ArrayList<DataRestaurante> getRestaurantes(HttpServletRequest request)
			
	{
            IControladorUsuario iUsr = Fabrica.getInstance().obtenerControladorUsuario();
            ArrayList<DataRestaurante> restaurantes = iUsr.listarRestaurantes();
            return restaurantes;
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
