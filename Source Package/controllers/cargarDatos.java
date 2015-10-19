/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import datatype.DataDireccion;
import datatype.EnumEstado;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorPedido;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import model.EstadoSesion;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
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
public class cargarDatos extends HttpServlet {

    Properties propiedades = new Properties();

    /**
     * inicializa la sesión si no estaba creada
     *
     * @param request
     */
    public static void initSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("paginas_navegadas") == null) {
            session.setAttribute("paginas_navegadas", 0);
        }
        if (session.getAttribute("estado_sesion") == null) {
            session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
        }
    }

    /**
     * Devuelve el estado de la sesión
     *
     * @param request
     * @return
     */
    public static EstadoSesion getEstado(HttpServletRequest request) {
        return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        initSession(req);

        //------------------
        // CARGAR DATOS DE PRUEBA
        IControladorCategoria c = Fabrica.getInstance().obtenerControladorCategoria();
        IControladorUsuario u = Fabrica.getInstance().obtenerControladorUsuario();
        IControladorProducto p = Fabrica.getInstance().obtenerControladorProducto();
        IControladorPedido pd = Fabrica.getInstance().obtenerControladorPedido();

        //Carga Archivo de Propiedades ----------------------
        InputStream entrada = null;
        try {
            entrada = this.getClass().getResourceAsStream("/Resources/config.properties");
            propiedades.load(entrada);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //---------------------------------------------------
        u.CargarDatosUsuario("costas", "gcostas@gmail.com", "Gerardo", "costas123",
                new DataDireccion("Av. Italia", "2078", "n/a"), "Costas",
                new Date(1983, 11, 15), propiedades.getProperty("rutaDeCargaWeb") + "costas.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("roro", "rcotelo@yahoo.com", "Rodrigo", "12elroro",
                new DataDireccion("Pdte. Berro", "1548", "n/a"), "Cotelo",
                new Date(1975, 8, 2), propiedades.getProperty("rutaDeCargaWeb") + "roro.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("chechi", "cgarrido@hotmail.com", "Cecilia", "ch4321",
                new DataDireccion("Gral. Urquiza", "1548", "n/a"), "Garrido",
                new Date(1987, 9, 12), propiedades.getProperty("rutaDeCargaWeb") + "chechi.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("andy", "agarcia@gmail.com", "Andrea", "andy_la1",
                new DataDireccion("Dr. Manuel Albo ", "4512", "n/a"), "García",
                new Date(1951, 7, 28), propiedades.getProperty("rutaDeCargaWeb") + "andy.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("weiss", "aweiss@hotmail.com", "Adrian", "223_aweis",
                new DataDireccion("Monte Caseros ", "5615", "n/a"), "Weiss",
                new Date(1978, 12, 23), propiedades.getProperty("rutaDeCargaWeb") + "weiss.jpg");
        u.altaUsuario();

        c.altaCategoria("Chivitos");
        c.altaCategoria("Minutas");
        c.altaCategoria("Parrilla");
        c.altaCategoria("Pizzas");
        c.altaCategoria("Empanadas");
        c.altaCategoria("Milanesas");
        c.altaCategoria("Ensaladas");
        c.altaCategoria("Pastas");
        c.altaCategoria("Comida China");
        c.altaCategoria("Picadas");
        c.altaCategoria("Woks");
        c.altaCategoria("Comica Mexicana");
        c.altaCategoria("Entradas");
        c.altaCategoria("Bebidas");
        c.altaCategoria("Sushi");

        String[] rutaImagen = null;
        u.seleccionarCategoria("Chivitos");
        u.seleccionarCategoria("Minutas");
        u.seleccionarCategoria("Parrilla");
        u.seleccionarCategoria("Pizzas");
        try {
            u.CargarDatosUsuario("mera", "mera@hotmail.com", "Pizzeria Mera", "123",
                    new DataDireccion("Av. 8 de Octubre", "2074", null), rutaImagen);
        } catch (Exception ex) {
            //Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.altaUsuario();
        u.limpiarMemoria();

        String[] rutaImagen2 = {propiedades.getProperty("rutaDeCargaWeb") + "BR1.png", "b"};
        u.seleccionarCategoria("Chivitos");
        u.seleccionarCategoria("Milanesas");
        u.seleccionarCategoria("Pastas");
        u.seleccionarCategoria("Pizzas");
        try {
            u.CargarDatosUsuario("rossell", "bar.rossel@gmail.com", "Bar Rossell", "123",
                    new DataDireccion("Bvar. Artigas ", "1601", null), rutaImagen2);
        } catch (Exception ex) {
            //    Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.altaUsuario();
        u.limpiarMemoria();

        String[] rutaImagen3 = {propiedades.getProperty("rutaDeCargaWeb") + "EB1.png", "b"};
        u.seleccionarCategoria("Empanadas");
        try {
            u.CargarDatosUsuario("bocatti", "bocatti@gmail.com", "Empanadas Bocatti", "123",
                    new DataDireccion("18 de julio ", "2138", null), rutaImagen3);
        } catch (Exception ex) {
            //  Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.altaUsuario();
        u.limpiarMemoria();

        String[] rutaImagen4 = {propiedades.getProperty("rutaDeCargaWeb") + "WB1.jpg", "b"};
        u.seleccionarCategoria("Woks");
        u.seleccionarCategoria("Comida China");
        u.seleccionarCategoria("Pastas");
        try {
            u.CargarDatosUsuario("winb", "wok.in.box@hotmail.com", "Wok in Box", "123",
                    new DataDireccion("Libertad ", "2535", null), rutaImagen4);
        } catch (Exception ex) {
            //Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.altaUsuario();
        u.limpiarMemoria();

        //INDIVIDUALES
        p.seleccionarRestaurante("mera");
        p.cargarDatosProducto("Asado", "Asado a la parrilla", (float) 225.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Milanesa de Carne", "Con lechuga, tomate, mayonesa y fritas", (float) 180.0, propiedades.getProperty("rutaDeCargaWeb") + "MCM.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Chivito Canadiense", "Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas", (float) 305.0, propiedades.getProperty("rutaDeCargaWeb") + "CCM.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Pizza 2 Gustos", "Pizza con dos gustos a elección", (float) 130.0, null);
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("rossell");
        p.cargarDatosProducto("Chivito al plato", "Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas", (float) 324.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Milanesa a caballo", "Milanesa con dos huevos fritos acompañado de fritas", (float) 270.0, propiedades.getProperty("rutaDeCargaWeb") + "MCR.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Pizza con 2 gustos", "Pizza con dos gustos a elección", (float) 103.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Agnolotis", "Agnolotis de jamón y queso", (float) 225.0, propiedades.getProperty("rutaDeCargaWeb") + "PAR.jpg");
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("bocatti");
        p.cargarDatosProducto("Empanada de Carne", "Carne, aceitunas, huevo duro, condimentos", (float) 44.0, propiedades.getProperty("rutaDeCargaWeb") + "ECB.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Empanada Americana", "Carne, panceta y huevo duro", (float) 44.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Empanada QyC", "Empanada de Queso y Cebolla", (float) 44.0, propiedades.getProperty("rutaDeCargaWeb") + "EQB.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Empanada Capresse", "Queso, tomate y albahaca", (float) 44.0, propiedades.getProperty("rutaDeCargaWeb") + "ECA.jpg");
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("winb");
        p.cargarDatosProducto("Thai wok", "Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.", (float) 240.0, propiedades.getProperty("rutaDeCargaWeb") + "TWW.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("China wok", "Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.", (float) 240.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Classic wok de pollo", "Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.", (float) 230.0, propiedades.getProperty("rutaDeCargaWeb") + "CPW.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Classic wok de cerdo", "Cerdo, vegetales mixtos, jengibre, salsa de ostras y ralladura de lima, acompañado de tallarines o arroz.", (float) 230.0, null);
        p.altaProducto();
        p.limpiarMemoria();

        //PROMOCIONES
        p.seleccionarRestaurante("mera");
        p.cargarDatosProducto("ChiviPizza", "Chivito y Pizza", 20, null);
        p.seleccionarProducto("Chivito Canadiense", 1);
        p.seleccionarProducto("Pizza 2 Gustos", 1);
        p.altaProducto();
        p.limpiarMemoria();

        p.cargarDatosProducto("MilaAsado", "3 Milanesas + 1 Asado para compartir", 30, null);
        p.seleccionarProducto("Milanesa de Carne", 3);
        p.seleccionarProducto("Asado", 1);
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("rossell");
        p.cargarDatosProducto("MilaPizza", "2 Milanesas a caballo + 1 Pizzas 2 gustos", 10, null);
        p.seleccionarProducto("Milanesa a caballo", 2);
        p.seleccionarProducto("Pizza con 2 gustos", 1);
        p.altaProducto();
        p.limpiarMemoria();

        //PEDIDOS
        //PEDIDOS
        try {
            pd.seleccionarCliente("costas");
        } catch (Exception ex) {
            //Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarRestaurante("bocatti");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarProducto("bocatti", "Empanada de Carne", 1);
            pd.seleccionarProducto("bocatti", "Empanada Americana", 2);
            pd.seleccionarProducto("bocatti", "Empanada QyC", 2);
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        pd.finalizarPedido();
        pd.limpiarMermoria();
        //--------
        try {
            pd.seleccionarCliente("roro");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarRestaurante("mera");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarProducto("mera", "Asado", 3);
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        pd.finalizarPedido();
        pd.limpiarMermoria();

        pd.seleccionarPedido(2);
        pd.seleccionarEstado(EnumEstado.ENVIADO);
        try {
            pd.actualizarPedido();
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--------
        try {
            pd.seleccionarCliente("chechi");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarRestaurante("winb");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarProducto("winb", "Thai wok", 2);
            pd.seleccionarProducto("winb", "China wok", 3);
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        pd.finalizarPedido();
        pd.limpiarMermoria();

        pd.seleccionarPedido(3);
        pd.seleccionarEstado(EnumEstado.RECIBIDO);
        try {
            pd.actualizarPedido();
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--------
        try {
            pd.seleccionarCliente("andy");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarRestaurante("mera");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarProducto("mera", "Chivito Canadiense", 4);
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        pd.finalizarPedido();
        pd.limpiarMermoria();

        pd.seleccionarPedido(4);
        pd.seleccionarEstado(EnumEstado.RECIBIDO);
        try {
            pd.actualizarPedido();
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        //--------
        try {
            pd.seleccionarCliente("weiss");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarRestaurante("rossell");
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pd.seleccionarProducto("rossell", "Agnolotis", 1);
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        pd.finalizarPedido();
        pd.limpiarMermoria();

        pd.seleccionarPedido(5);
        pd.seleccionarEstado(EnumEstado.RECIBIDO);
        try {
            pd.actualizarPedido();
        } catch (Exception ex) {
//            Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pd.agregarComentario(3, "Si bien el thai wok y el china wok están ricos, me cobraron 60$ de envío y eso no estaba aclarado y no pueden hacerlo. Me dejó muy molesto.", 2);
        } catch (Exception ex) {
//            Logger.getLogger(cargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pd.agregarComentario(5, "Los Agnolotis llegaron un poco fríos y demoraron más de la cuenta. Espero mejoren. De todas formas, muy ricos.", 3);
        } catch (Exception ex) {
            Logger.getLogger(cargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pd.agregarComentario(6, "Tanto la milanesa como el chivito llegaron 3 horas tarde!, obviamente helados!!, un desastre, nunca más pido ahí.", 1);
        } catch (Exception ex) {
            Logger.getLogger(cargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pd.agregarComentario(7, "Todo llegó en hora. El chivito y la milanesa a caballo estaban un poco aceitosos, pero más allá de eso se comió rico y en abundancia.", 4);
        } catch (Exception ex) {
            Logger.getLogger(cargarDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-------------
        switch (getEstado(req)) {

            case NO_LOGIN:
                // hace que se ejecute el jsp sin cambiar la url
                req.getRequestDispatcher("/WEB-INF/home/index.jsp").
                        forward(req, resp);
                break;
            case LOGIN_INCORRECTO:
                // hace que se ejecute el jsp sin cambiar la url
                req.getRequestDispatcher("/WEB-INF/home/index.jsp").
                        forward(req, resp);
                break;
            case LOGIN_CORRECTO:
                // manda una redirección a otra URL (cambia la URL)
                //resp.sendRedirect("/perfil");
                req.getRequestDispatcher("/WEB-INF/home/index.jsp").
                        forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
}
