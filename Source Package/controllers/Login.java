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
public class Login extends HttpServlet {
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
        
        
       
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;
      
       
            if(iUsr.existeUsuario(login)){
                
		// chequea contraseña
		
			DataUsuario usr = iUsr.obtenerUsuario(login);

			if(!usr.getPass().equals(password))
				nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
			else {
				nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
				// setea el usuario logueado
				request.getSession().setAttribute("usuario_logueado", usr.getNickname());
			}
            }else{
                nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
            }
		
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
        request.getRequestDispatcher("/home").forward(request, response);
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	static public DataUsuario getUsuarioLogueado(HttpServletRequest request)
			throws UsuarioNoEncontrado, Exception
	{
	IControladorUsuario iUsr = Fabrica.getInstance().obtenerControladorUsuario();	
            return iUsr.obtenerUsuario(
				(String) request.getSession().getAttribute("usuario_logueado")
			);
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
