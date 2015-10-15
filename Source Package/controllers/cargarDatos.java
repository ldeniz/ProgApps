/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import datatype.DataDireccion;
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
	 * @param request
	 * @return 
	 */
	public static EstadoSesion getEstado(HttpServletRequest request)
	{
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

        u.CargarDatosUsuario("mathi", "gcostas@gmail.com", "Gerardo", "1234",
                new DataDireccion("Av. Italia", "2078", null), "gcostas@gmail.com",
                new Date(1983, 11, 15), propiedades.getProperty("rutaDeCarga") + "costas.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("roro", "rcotelo@yahoo.com", "Rodrigo", "  1234",
                new DataDireccion("Pdte. Berro", "1548", null), "Cotelo",
                new Date(1975, 8, 2), propiedades.getProperty("rutaDeCarga") + "roro.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("chechi", "cgarrido@hotmail.com", "Cecilia", "  1234",
                new DataDireccion("Gral. Urquiza", "1548", null), "Garrido",
                new Date(1987, 9, 12), propiedades.getProperty("rutaDeCarga") + "chechi.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("andy", "agarcia@gmail.com", "Andrea", "  1234",
                new DataDireccion("Dr. Manuel Albo ", "4512", null), "García",
                new Date(1951, 7, 28), propiedades.getProperty("rutaDeCarga") + "andy.jpg");
        u.altaUsuario();
        u.CargarDatosUsuario("weiss", "aweiss@hotmail.com", "Adrian", "  1234",
                new DataDireccion("Monte Caseros ", "5615", null), "Weiss",
                new Date(1978, 12, 23), propiedades.getProperty("rutaDeCarga") + "weiss.jpg");
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

        String[] rutaImagen2 = {propiedades.getProperty("rutaDeCarga") + "BR1.png", "b"};
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

        String[] rutaImagen3 = {propiedades.getProperty("rutaDeCarga") + "EB1.png", "b"};
        u.seleccionarCategoria("Empanadas");
        try {
            u.CargarDatosUsuario("bocatti", "bocatti@gmail.com", "Empanadas Bocatti", "123",
                    new DataDireccion("18 de julio ", "2138", null), rutaImagen3);
        } catch (Exception ex) {
            //  Logger.getLogger(ServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.altaUsuario();
        u.limpiarMemoria();

        String[] rutaImagen4 = {propiedades.getProperty("rutaDeCarga") + "WB1.jpg", "b"};
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
        p.cargarDatosProducto("Milanesa de Carne", "Con lechuga, tomate, mayonesa y fritas", (float) 180.0, propiedades.getProperty("rutaDeCarga") + "MCM.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Chivito Canadiense", "Lomito, jamón, muzza, tomate, aceitunas, panceta, huevo, morrón y fritas", (float) 305.0, propiedades.getProperty("rutaDeCarga") + "CCM.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Pizza 2 Gustos", "Pizza con dos gustos a elección", (float) 130.0, null);
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("rossell");
        p.cargarDatosProducto("Chivito al plato", "Ensalada rusa, mixta, huevo, jamón, muzza, panceta, aceitunas y fritas", (float) 324.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Milanesa a caballo", "Milanesa con dos huevos fritos acompañado de fritas", (float) 270.0, propiedades.getProperty("rutaDeCarga") + "MCR.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Pizza con 2 gustos", "Pizza con dos gustos a elección", (float) 103.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Agnolotis", "Agnolotis de jamón y queso", (float) 225.0, propiedades.getProperty("rutaDeCarga") + "PAR.jpg");
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("bocatti");
        p.cargarDatosProducto("Empanada de Carne", "Carne, aceitunas, huevo duro, condimentos", (float) 44.0, propiedades.getProperty("rutaDeCarga") + "ECB.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Empanada Americana", "Carne, panceta y huevo duro", (float) 44.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Empanada QyC", "Empanada de Queso y Cebolla", (float) 44.0, propiedades.getProperty("rutaDeCarga") + "EQB.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Empanada Capresse", "Queso, tomate y albahaca", (float) 44.0, propiedades.getProperty("rutaDeCarga") + "ECA.jpg");
        p.altaProducto();
        p.limpiarMemoria();

        p.seleccionarRestaurante("winb");
        p.cargarDatosProducto("Thai wok", "Cerdo, calamares, sweet chili, salsa de ostras, maní y jugo de lima, acompañado de tallarines o arroz.", (float) 240.0, propiedades.getProperty("rutaDeCarga") + "TWW.jpg");
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("China wok", "Tempura de cerdo, vegetales mixtos, almendras, salsa de soja y naranja, acompañado de tallarines o arroz.", (float) 240.0, null);
        p.altaProducto();
        p.limpiarMemoria();
        p.cargarDatosProducto("Classic wok de pollo", "Pollo, vegetales mixtos, salsa agridulce, salsa de soja y cebollita de verdeo, acompañado de tallarines o arroz.", (float) 230.0, propiedades.getProperty("rutaDeCarga") + "CPW.jpg");
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

        
                    
               //-------------
                
                
                
		switch(getEstado(req)){
                    
                    
                    
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
