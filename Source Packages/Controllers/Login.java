/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import Exceptions.UsuarioNoEncontrado;
import Model.EstadoSesion;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manejador.ManejadorUsuario;
import modelo.Cliente;
import modelo.Usuario;

/**
 * @author Igui
 */
public class Login extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        ManejadorUsuario mu = ManejadorUsuario.getInstance();
        
        
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;

        Cliente usr = (Cliente) mu.obtenerUsuario(login);
        if(!usr.getPass().equals(password))
            nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        else {
            nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
            // setea el usuario logueado
            request.getSession().setAttribute("usuario_logueado", usr.getMail());
        }
		
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	static public Usuario getUsuarioLogueado(HttpServletRequest request)
			throws UsuarioNoEncontrado
	{
            ManejadorUsuario mu = ManejadorUsuario.getInstance();
		return mu.obtenerUsuario(
				(String) request.getSession().getAttribute("usuario_logueado")
			);
	}

     /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
