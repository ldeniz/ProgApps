/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.XMLGregorianCalendar;
import proxy.ControladorUsuarioPublicador;
import proxy.ControladorUsuarioPublicadorService;
import proxy.DataDireccion;

/**
 *
 * @author Mathi
 */
public class registrarCliente extends HttpServlet {

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
                entrada = registrarCliente.class.getResourceAsStream("/Resources/config.properties");
                try {
                    propiedades.load(entrada);
                } catch (IOException ex1) {
                    Logger.getLogger(registrarCliente.class.getName()).log(Level.SEVERE, null, ex1);
                }

            }
        }
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String nickname = request.getParameter("nickname");
        String mail = request.getParameter("mail");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("direccion");
        String rutaImagen = "";
        Date nacimiento = formatter.parse(request.getParameter("nacimiento"));

        Calendar cal = Calendar.getInstance();
        cal.setTime(nacimiento);

        XMLGregorianCalendar fechaNacimiento = new XMLGregorianCalendarImpl((GregorianCalendar) cal);

        DataDireccion dd = new DataDireccion();
        dd.setCalle(direccion);

        try {
            loadProperties();
            URL url = new URL(propiedades.getProperty("usuarioUrl"));
            ControladorUsuarioPublicadorService cups = new ControladorUsuarioPublicadorService(url);
            ControladorUsuarioPublicador cup = cups.getControladorUsuarioPublicadorPort();
            cup.registrarCliente(mail, nickname, pass, dd, nombre, apellido, fechaNacimiento, rutaImagen);
        } catch (Exception ex) {
        }
        request.getRequestDispatcher("/home").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ex) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ex) {
        }
    }

}
