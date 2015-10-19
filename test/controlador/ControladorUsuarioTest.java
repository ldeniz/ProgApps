/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.crypto.provider.ARCFOURCipher;
import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import datatype.DataCategoria;
import datatype.DataIndividual;
import datatype.DataStockProducto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import manejador.ManejadorUsuario;
import modelo.Individual;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author jose
 */
public class ControladorUsuarioTest {
    
    public ControladorUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        ControladorUsuario instance = new ControladorUsuario();
        ControladorProducto instanceProducto = new  ControladorProducto();
        
        DataDireccion direccion = new DataDireccion("Rivera","1000","22");
        String[] rutaImagen = {"/home/jose/a.png", "/hpme/jose/b.png"};
        
        //Restaurante
        ControladorCategoria cc = new ControladorCategoria();
        cc.altaCategoria("Minutas");
        instance.seleccionarCategoria("Minutas");
        
        instance.CargarDatosUsuario("pepe", "pepe@homail.com","Avenida Bar","pepe123", direccion,rutaImagen);       
        instance.altaUsuario();
        
        //Cliente
        Date date = new Date(1988, 12, 05);
        String imagen = "/home/jose/c.png";
        instance.CargarDatosUsuario("Pablo","pablo@hotmail.com","Pablo","123",direccion,"Perez",date,imagen);
        instance.altaUsuario();
        
        float precio = (float)98.5; 
        instanceProducto.seleccionarRestaurante("pepe");
        instanceProducto.cargarDatosProducto("Pizza", "Sala de tomate CONAPROLE", precio, "/home/pepe/piza.png");
        instanceProducto.altaProducto();

    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of CargarDatosUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testCargarDatosUsuario_8args() {
        System.out.println("CargarDatosUsuario");
        String nickname = "";
        String mail = "";
        String nombre = "";
        String pass = "";
        DataDireccion direccion = null;
        String apellido = "";
        Date fechaNacimiento = null;
        String rutaImagen = "";
        ControladorUsuario instance = new ControladorUsuario();
        instance.CargarDatosUsuario(nickname, mail, nombre, pass, direccion, apellido, fechaNacimiento, rutaImagen);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CargarDatosUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testCargarDatosUsuario_6args() throws Exception {
        System.out.println("CargarDatosUsuario");
        String nickname = "";
        String mail = "";
        String nombre = "";
        String pass = "";
        DataDireccion direccion = null;
        String[] rutaImagen = null;
        ControladorUsuario instance = new ControladorUsuario();
        instance.CargarDatosUsuario(nickname, mail, nombre, pass, direccion, rutaImagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarCategoria method, of class ControladorUsuario.
     */
    @Test
    public void testSeleccionarCategoria() {
        System.out.println("seleccionarCategoria");
        ControladorUsuario instance = new ControladorUsuario();
        instance.seleccionarCategoria("Minutas");
        ArrayList<DataRestaurante>  dr = instance.listarRestaurantes();
        String restaurante = "Avenida Bar";
        for(int x=0; x<dr.size(); x++)
        {
              assertTrue(restaurante.equals(dr.get(x).getNombre()));
        }    
    }

    /**
     * Test of existeUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testExisteUsuario_String() {
        System.out.println("existeUsuario");
        String nickname = "";
        ControladorUsuario instance = new ControladorUsuario();
        boolean expResult = false;
        boolean result = instance.existeUsuario(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testExisteUsuario_String_String() {
        System.out.println("existeUsuario");
        String nickname = "";
        String mail = "";
        ControladorUsuario instance = new ControladorUsuario();
        boolean expResult = false;
        boolean result = instance.existeUsuario(nickname, mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testAltaUsuario() {
        System.out.println("altaUsuario");
        ControladorUsuario instance = new ControladorUsuario();
        instance.altaUsuario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiarMemoria method, of class ControladorUsuario.
     */
    @Test
    @Ignore
    public void testLimpiarMemoria() {
        System.out.println("limpiarMemoria");
        ControladorUsuario instance = new ControladorUsuario();
        instance.limpiarMemoria();        
        instance.seleccionarCategoria("Minutas");
        ArrayList<DataRestaurante> listarRestaurantes = instance.listarRestaurantes();
    }

    /**
     * Test of listarClientes method, of class ControladorUsuario.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        ControladorUsuario instance = new ControladorUsuario();
        ArrayList<DataCliente> expResult = null;
        ArrayList<DataCliente> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarRestaurantes method, of class ControladorUsuario.
     */
    @Test
    public void testListarRestaurantes() {
        System.out.println("listarRestaurantes");
        ControladorUsuario instance = new ControladorUsuario();
        ArrayList<DataRestaurante> expResult = null;
        ArrayList<DataRestaurante> result = instance.listarRestaurantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsaurios method, of class ControladorUsuario.
     */
    @Test
    public void testListarUsaurios() {
        System.out.println("listarUsaurios");
        ControladorUsuario instance = new ControladorUsuario();
        ArrayList<DataUsuario> expResult = new ArrayList<>();
        ArrayList<DataUsuario> result = instance.listarUsaurios();
        
        
        DataDireccion direccion = new DataDireccion("Rivera","1000","22");
      
        DataCliente dc2 = new DataCliente(null, null,null,"pepe", "pepe@homail.com", "Avenida Bar", "pepe123",direccion);

        DataCliente dc1 = new DataCliente(null, null,null,"Pablo","pablo@hotmail.com", "Pablo","123", direccion);
        
        expResult.add(dc1);
        expResult.add(dc2);
        for(int x=0; x<result.size(); x++)
        {
            assertTrue(expResult.get(x).getNickname().equals(result.get(x).getNickname()));    
            assertTrue(expResult.get(x).getNombre().equals(result.get(x).getNombre()));
            assertTrue(expResult.get(x).getMail().equals(result.get(x).getMail()));
            assertTrue(expResult.get(x).getPass().equals(result.get(x).getPass()));
        }
    }
    /**
     * Test of listarProductos method, of class ControladorUsuario.
     */
    @Test
    public void testListarProductos() {
        System.out.println("listarProductos");
        String nickName = "pepe";
        ControladorUsuario instance = new ControladorUsuario();
        ArrayList<DataProducto> expResult = new ArrayList<>();
        ArrayList<DataProducto> result = instance.listarProductos(nickName);
        
        float precio = (float)98.5; 
        DataStockProducto st = new DataStockProducto(100,precio);
        DataIndividual di = new DataIndividual("Pizza","Sala de tomate CONAPROLE","/home/pepe/piza.png", st,nickName);
        expResult.add(di);
        
        for(int x=0; x<result.size(); x++)
        {
            assertTrue(expResult.get(x).getNombre().equals(result.get(x).getNombre()));
            assertTrue(expResult.get(x).getNickName().equals(result.get(x).getNickName()));
            assertTrue(expResult.get(x).getDescripcion().equals(result.get(x).getDescripcion()));
            assertTrue(expResult.get(x).getRutaImagen().equals(result.get(x).getRutaImagen()));
            
        }
        
        
                
                
        
        
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
    
}
