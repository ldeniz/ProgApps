/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.UsuarioNoEncontrado;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proxy.ControladorUsuarioPublicador;
import proxy.ControladorUsuarioPublicadorService;
import proxy.DataUsuario;

public class Login extends HttpServlet {

    private static Properties propiedades = null;

    private static void loadProperties() {
        if (propiedades == null) {
            propiedades = new Properties();
        }
        if (propiedades.isEmpty()) {
            try {
                FileInputStream file = new FileInputStream("./config.properties");
                propiedades.load(file);
            } catch (IOException ex) {
                InputStream entrada;
                entrada = Login.class.getResourceAsStream("/Resources/config.properties");
                try {
                    propiedades.load(entrada);
                } catch (IOException ex1) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex1);
                }

            }
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
        loadProperties();
        URL url = new URL(propiedades.getProperty("usuarioUrl"));
        ControladorUsuarioPublicadorService service = new ControladorUsuarioPublicadorService(url);
        ControladorUsuarioPublicador port = service.getControladorUsuarioPublicadorPort();

        if (port.existeUsuario(login)) {

            // chequea contraseña
            DataUsuario usr = port.obtenerUsuario(login);

            if (!usr.getPass().equals(password)) {
                nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
            } else {
                nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
                // setea el usuario logueado
                request.getSession().setAttribute("usuario_logueado", usr.getNickname());
            }
        } else {
            nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
        }

        objSesion.setAttribute("estado_sesion", nuevoEstado);

        // redirige a la página principal para que luego rediriga a la página
        // que corresponde
        request.getRequestDispatcher("/home").forward(request, response);
    }

    /**
     * Devuelve el usuario logueado
     *
     * @param request
     * @return
     * @throws UsuarioNoEncontrado
     */
    static public DataUsuario getUsuarioLogueado(HttpServletRequest request)
            throws UsuarioNoEncontrado, Exception {

        loadProperties();
        URL url = new URL(propiedades.getProperty("usuarioUrl"));
        ControladorUsuarioPublicadorService service = new ControladorUsuarioPublicadorService(url);
        ControladorUsuarioPublicador port = service.getControladorUsuarioPublicadorPort();
        return port.obtenerUsuario(
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
