/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import interfaces.IControladorCategoria;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import sun.java2d.loops.SurfaceType;
import datatype.DataDireccion;
import java.util.ArrayList;
import datatype.DataCategoria;
import java.util.Date;
import datatype.DataCliente;

/**
 *
 * @author jose
 */
public class FabricaTest {
    
    public FabricaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
    
        
        System.out.println("obtenerControladorUsuario");      
        Fabrica instance = Fabrica.getInstance();
        IControladorCategoria icc = instance.obtenerControladorCategoria();
        icc.altaCategoria("Minutas");
        IControladorUsuario icu = instance.obtenerControladorUsuario();
        DataDireccion direccion = new DataDireccion("Lafinur","3426","2");
        icu.seleccionarCategoria("Minutas");
        String [] rutaImagen = {"/home/jose/imagenes/a.png","/home/jose/imagenes/b.png"};        
        icu.CargarDatosUsuario("elrey","elreydelaminutas@hotmail.com", "El rey de las minutas", "elrey123", direccion, rutaImagen);    
        icu.altaUsuario();
        boolean prueba ;
        prueba = icu.existeUsuario("elrey");
    }
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
    @Test
     public void testObtenerControladorProducto() 
     {
         Fabrica instance =  Fabrica.getInstance();
         IControladorProducto icp = instance.obtenerControladorProducto();
         boolean existe;

        icp.seleccionarRestaurante("elrey");
        icp.cargarDatosProducto("Croqueta","De arroz y queso", 30, "/home/jose/a.png");
        icp.altaProducto();
        existe = icp.existeProducto("elrey", "Croqueta");
        assertTrue(existe);

        icp.seleccionarRestaurante("elrey");
        icp.cargarDatosProducto("Empanada","Queso y Jamon", 35, "/home/jose/b.png");
        icp.altaProducto();
        existe = icp.existeProducto("elrey", "Empanada");
        assertTrue(existe);

        icp.seleccionarRestaurante("elrey");       
        icp.cargarDatosProducto("3y3","Empanada y Corqueta", 25, "/home/jose/c.png");      
        
        icp.altaProducto();
        existe = icp.existeProducto("elrey", "3y3");

        assertTrue(existe);
        

         
     }        

    /**
     * Test of getInstance method, of class Fabrica.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Fabrica expResult = Fabrica.getInstance();
        Fabrica result = Fabrica.getInstance();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of obtenerControladorCategoria method, of class Fabrica.
     */
    @Test
    public void testObtenerControladorCategoria() {
        System.out.println("obtenerControladorCategoria");
        Fabrica instance = Fabrica.getInstance();        
        IControladorCategoria icc = instance.obtenerControladorCategoria();
        boolean existe = false;
        
        icc.altaCategoria("Armenia");
        existe = icc.existeCategoria("Armenia");
        assertTrue(existe);
        
        ArrayList<DataCategoria> dcResult = icc.listarCategorias();
        ArrayList<DataCategoria> dcExpResult = new ArrayList<DataCategoria>();
        DataCategoria dc1 = new  DataCategoria("Armenia");
        DataCategoria dc2 = new  DataCategoria("Minutas");
        dcExpResult.add(dc1);
        dcExpResult.add(dc2);
        String nombre;
        String nombreExp;

        for(int x=0; x<dcResult.size(); x++)
        {
           nombre = dcResult.get(x).getNombre();           
           nombreExp = dcExpResult.get(x).getNombre();
           assertEquals(nombreExp, nombre);
        }
        
    }

    /**
     * Test of obtenerControladorUsuario method, of class Fabrica.
     */
    @Test
    public void testObtenerControladorUsuario() throws Exception {
        System.out.println("obtenerControladorUsuario");
        Fabrica instance = Fabrica.getInstance();
        IControladorUsuario icu =  instance.obtenerControladorUsuario();
        
        //Damos de alta un cliente
        Date date = new Date(1988, 12, 05);
        DataDireccion direccion = new DataDireccion("Pedernal","2145","2");
        icu.CargarDatosUsuario("Jose","jose@hotmail.com", "pepe", "pepe123",direccion,"Villa",date, "/home/jose/d.png");
        icu.altaUsuario();
       
        boolean existe = true;
        existe = icu.existeUsuario("pepe","jose@hotmail.com");        
        assertTrue(existe);
        
        DataDireccion dire = new DataDireccion("Rivera","2000","0");
        String [] rutaImagen = {"/home/jose/imagenes/a.png","/home/jose/imagenes/b.png"};  
        icu.seleccionarCategoria("Minutas");
       
        icu.CargarDatosUsuario("elrey","elreydelaminutas@hotmail.com", "El rey de las minutas", "elrey123", dire, rutaImagen);
        icu.altaUsuario();
        existe = icu.existeUsuario("elrey","elreydelaminutas@hotmail.com");        
        assertTrue(existe);
        
        /*ArrayList<DataCliente> dcResult = icu.listarClientes();
        ArrayList<DataCliente> dcExpResult = new ArrayList<>();
        
        DataCliente dc = new DataCliente("Villa", date,"/home/jose/d.png", "pepe", "jose@hotmail.com","Jose", "pepe123", direccion);
        dcExpResult.add(dc);
        for(int x=0; x<dcResult.size(); x++)
        {
            
            assertTrue(dcExpResult.get(x).getApellido().equals(dcResult.get(x).getApellido()));
            assertTrue(dcExpResult.get(x).getMail().equals(dcResult.get(x).getMail()));
            assertTrue(dcExpResult.get(x).getRutaImagen().equals(dcResult.get(x).getRutaImagen()));
        }
        
        boolean exption = false;
        String [] rutaImagen = {"/home/jose/imagenes/a.png","/home/jose/imagenes/b.png"};        
        try {    
            icu.CargarDatosUsuario("elrey","elreydelaminutas@hotmail.com", "El rey de las minutas", "elrey123", direccion, rutaImagen);
        } catch (Exception ex) {            
            exption = true;
        }
        assertTrue(exption);*/
        
       
        
        
}
}