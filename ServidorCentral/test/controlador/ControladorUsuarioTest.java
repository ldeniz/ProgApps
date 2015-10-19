/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataCliente;
import datatype.DataDireccion;
import datatype.DataProducto;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import datatype.DataIndividual;
import datatype.DataStockProducto;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Date;
import manejador.ManejadorUsuario;
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
        IControladorUsuario cu = Fabrica.getInstance().obtenerControladorUsuario();
        cu.limpiarMemoria();
        
    }

    /**
     * Test of CargarDatosUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testCargarDatosUsuario_8args() {
        System.out.println("CargarDatosUsuario");
        String nickname = "pepe88";
        String mail = "jose@hotmail.com";
        String nombre = "Jose";
        String pass = "pepe123";
        DataDireccion direccion = new DataDireccion("Isidro Revert","1234","233");
        String apellido = "Villalba";
        Date fechaNacimiento = new Date(1988,10,12) ;
        String rutaImagen = "/home/jose/a.png";
        ControladorUsuario instance = new ControladorUsuario();
        instance.CargarDatosUsuario(nickname, mail, nombre, pass, direccion, apellido, fechaNacimiento, rutaImagen);
        instance.altaUsuario();
        assertTrue(instance.existeUsuario(nickname));
    }

    /**
     * Test of CargarDatosUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testCargarDatosUsuario_6args() throws Exception
    {
        System.out.println("CargarDatosUsuario");
        String nickname = "chinchu";
        String mail = "china@hotmail.com";
        String nombre = "comida china";
        String pass = "china1234";
        DataDireccion direccion = new DataDireccion("Chanchin", "1233", "001");
        String[] rutaImagen = {"/home/jose/a.png", "/hpme/jose/b.png"};
        ControladorUsuario instance = new ControladorUsuario();
        
        //Verificamos si verfica la expeciones que se produce al no seleccionar la categoria.
        try{
            instance.CargarDatosUsuario(nickname, mail, nombre, pass, direccion, rutaImagen);
            assertTrue(false);
        }
        catch(Exception ex)
        {
            assertTrue(true);
        }
    }

    
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

    
    @Test
    public void testExisteUsuario_String() {
        System.out.println("existeUsuario");
        String nickname = "pepe";
        ControladorUsuario instance = new ControladorUsuario();
        boolean expResult = true;
        boolean result = instance.existeUsuario(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class ControladorUsuario.
     */
    @Test
    public void testExisteUsuario_String_String() {
        System.out.println("existeUsuario");
        String nickname = "pepe";
        String mail = "pepe@homail.com";
        ControladorUsuario instance = new ControladorUsuario();
        boolean expResult = true;
        boolean result = instance.existeUsuario(nickname, mail);
        assertEquals(expResult, result);
      
    }
   
 
   

   
    @Test
    @Ignore
    public void testListarClientes() {
        System.out.println("listarClientes");
        ControladorUsuario instance = new ControladorUsuario();
        ArrayList<DataCliente> expResult = null;
        ArrayList<DataCliente> result = instance.listarClientes();
        assertEquals(expResult, result);       
    }

    @Test
    public void testListarUsaurios() {
        System.out.println("listarUsaurios");
        ControladorUsuario instance = new ControladorUsuario();
        ArrayList<DataUsuario> expResult = new ArrayList<>();
        ArrayList<DataUsuario> result = instance.listarUsaurios();
        
        
        DataDireccion direccion = new DataDireccion("Rivera","1000","22");
        Date fc =new Date(1988, 12, 10);
        
   
        DataCliente dc2 = new DataCliente("Villa", fc,"ruta","pepe", "pepe@homail.com", "Avenida Bar", "pepe123",direccion);

        DataCliente dc1 = new DataCliente("Villa", fc,"ruta","Pablo","pablo@hotmail.com", "Pablo","123", direccion);
       
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
    }

    @Test
    public void testListarRestaurante()throws Exception {       
        System.out.println("listarRestaurante");
        ControladorUsuario instance = new ControladorUsuario();
        String padron;
        int x;

        padron = "Minutas";
        ArrayList<DataRestaurante> ldr = instance.listarRestaurantes(padron);

        for( x=0; x<ldr.size(); x++)
        {
            assertTrue(ldr.get(x).toString().equals("Avenida Bar"));
        }

        padron = "Avenida Bar";
        ldr = instance.listarRestaurantes(padron);

        for(x=0; x<ldr.size(); x++)
        {
            assertTrue(ldr.get(x).toString().equals("Avenida Bar"));
        }

        padron = "pepe";
        ldr = instance.listarRestaurantes(padron);

        for(x=0; x<ldr.size(); x++)
        {
            assertTrue(ldr.get(x).toString().equals("Avenida Bar"));
        }


        padron = "Pizza";
        ldr = instance.listarRestaurantes(padron);

        for(x=0; x<ldr.size(); x++)
        {
            assertTrue(ldr.get(x).toString().equals("Avenida Bar"));
        }
    }
    
    @Test
    public void obtenerUsuarioTest() throws Exception
    {
       ControladorUsuario instance = new ControladorUsuario();
       String nickName = "pepe";
       DataDireccion direccion = new DataDireccion("Rivera","1000","22");
       DataUsuario du = instance.obtenerUsuario(nickName);
     
       
        assertEquals(du.getDireccion().getCalle(),direccion.getCalle());
        assertEquals(du.getDireccion().getNumero_puerta(), direccion.getNumero_puerta());
        assertEquals(du.getDireccion().getApto(),direccion.getApto());
        assertEquals(du.getNickname(),nickName);
        assertEquals(du.getMail(),"pepe@homail.com");
        assertEquals(du.getNombre(), "Avenida Bar");
        assertEquals(du.getPass(), "pepe123");
        
        try
        {   
            nickName = "prueba";
            du = instance.obtenerUsuario(nickName) ;
            assertTrue(false);
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }
    }
 
    @Test
    public void limpiearMemoriaTest() throws Exception
    {
        ControladorCategoria cc = new ControladorCategoria();
        ControladorUsuario instance = new ControladorUsuario();
        IControladorUsuario cu = Fabrica.getInstance().obtenerControladorUsuario();
      
        cc.altaCategoria("Minutas");
        instance.seleccionarCategoria("Minutas"); 
        
        
        DataDireccion direccion = new DataDireccion("Rivera","1000","22");
        String[] rutaImagen = {"/home/jose/a.png", "/hpme/jose/b.png"};
       
        instance.CargarDatosUsuario("pepe", "pepe@homail.com","Avenida Bar","pepe123", direccion,rutaImagen);       
        
        instance.limpiarMemoria(); //Borra los datos cargados por lo cuañ no se podra de dar de alta el nuevo usuario

        try{
            instance.altaUsuario();
            assertTrue(false);
        }
        catch(Exception ex)
        {
            assertTrue(true);
        }

    }
    
}
