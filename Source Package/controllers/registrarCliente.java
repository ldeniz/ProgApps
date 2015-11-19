/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mathi
 */
public class registrarCliente extends HttpServlet {

    
    
        

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, Exception {
        HttpSession objSesion = request.getSession();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String nickname = request.getParameter("nickname");
        String mail = request.getParameter("mail");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String pass = request.getParameter("pass");
        String direccion = request.getParameter("direccion");
        String rutaImagen = "";
        Date nacimiento = formatter.parse(request.getParameter("nacimiento"));
        out.println(nacimiento);

        Calendar cal = Calendar.getInstance();
        cal.setTime(nacimiento);

        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int anio = cal.get(Calendar.YEAR);

        try {
            /*
            ARREGLAR ESTO!
            
            
            ARREGLAR ESTO!
            
            
            ARREGLAR ESTO!
            
            u.CargarDatosUsuario(nickname, mail, nombre, pass, new DataDireccion(direccion), apellido, new Date(anio, mes, dia), rutaImagen);
            u.altaUsuario();
            out.println("LLEGO A CARGAR EL USUARIO");
                    */
            out.println(dia);
            out.println(mes);
            out.println(anio);

        } catch (Exception ex) {
            Logger.getLogger(registrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/home").forward(request, response);
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
