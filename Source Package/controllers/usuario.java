/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import datatype.DataUsuario;
import exceptions.UsuarioNoEncontrado;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import java.io.IOException;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Igui
 */
public class usuario extends HttpServlet {
    private IControladorUsuario iUsr = Fabrica.getInstance().obtenerControladorUsuario();
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, Exception {
        HttpSession objSesion = request.getSession();
        
        
       
        
        String login = request.getParameter("nickname");
   
       
        if(iUsr.existeUsuario(login)){
                
            DataUsuario usr = iUsr.obtenerUsuario(login);	
            objSesion.setAttribute("usuario", usr);
            request.getRequestDispatcher("/usuario").forward(request, response);
        }   
    } 
	


     @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
