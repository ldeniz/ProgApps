/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import static controllers.Home.initSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author Igui
 */
public class usuario extends HttpServlet {
   // private IControladorUsuario iUsr = Fabrica.getInstance().obtenerControladorUsuario();
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, Exception {
		initSession(request);        
                
                
               /*  String nick = (String)req.getSession().getAttribute("usuario_logueado");
                 req.setAttribute("usuario", nick);
                */
                 
		 request.getRequestDispatcher("/WEB-INF/home/usuario.jsp").
						forward(request, response);
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
