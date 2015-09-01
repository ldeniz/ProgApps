/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import datatype.DataDireccion;
import java.util.ArrayList;
import modelo.Producto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Ignore;

/**
 *
 * @author jose
 */
public class ManejadorUsuarioTest {
    
    public ManejadorUsuarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
      ManejadorCategoria n = ManejadorCategoria.getInstance();
      n.ingresarCategoria(new DataCategoria("pizas"));
    
        //Damos de alta a un cliente
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        Date fecha = new Date(1988, 12, 05);
        DataDireccion dataDireccion = new DataDireccion("Artigas","3456","1");
        DataCliente dataCliente = new DataCliente("Vazquez",fecha,"/home/jose/Imagenes/a.png","tuerto","tuerto@hotmail.com", "Manuel","aa12233", dataDireccion);
        instance.ingresarUsuario(dataCliente);
        
        //Damos de alta a un restaurante
        DataDireccion dataDire = new DataDireccion("Artigas","3458","1");
        String[] imagen = {"/home/jose/Imagnes/a.png"};
        DataRestaurante dataRestaurante = new DataRestaurante( imagen,"EmapandasManuelita","EmapandasManuelita@hotmail.com","Emapandas Manuelita", "EmapandasManuelita",dataDire);
        
        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();
        dataCategorias = n.listarCategorias();
        instance.ingresarUsuario(dataRestaurante,dataCategorias);
    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class ManejadorUsuario.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ManejadorUsuario a = ManejadorUsuario.getInstance();
        assertSame(a, ManejadorUsuario.getInstance());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testIngresarUsuario_DataCliente() 
    {
        System.out.println("ingresarUsuario");
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        Date fecha = new Date(1988, 12, 05);
        DataDireccion dataDireccion = new DataDireccion("Artigas","3456","1");
        DataCliente dataCliente = new DataCliente("Villalba",fecha,"/home/jose/Imagenes/a.png","pepe","josevillalba@hotmail.com", "Jose","aa12233", dataDireccion);
        instance.ingresarUsuario(dataCliente);
        boolean result = instance.existeUsuarioNickName("pepe");
        assertTrue(result);    
    }

   @Test
    public void testIngresarUsuario_DataRestaurante() {
        System.out.println("ingresarUsuario");
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        ManejadorCategoria n = ManejadorCategoria.getInstance();
         
        DataDireccion dataDireccion = new DataDireccion("Artigas","3458","1");
        String[] imagen = {"/home/jose/Imagnes/a.png"};
        DataRestaurante dataRestaurante = new DataRestaurante( imagen,"BarArtigas","barArtigas@hotmail.com","Bar Artigas", "barArgias",dataDireccion);
        
        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();
        dataCategorias = n.listarCategorias();
        instance.ingresarUsuario(dataRestaurante,dataCategorias);
        boolean result = instance.existeUsuarioNickName("BarArtigas");
        assertTrue(result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuarioNickName method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteUsuarioNickName() {
        System.out.println("existeUsuarioNickName");
        String nickname = "tuerto";
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        boolean expResult = true;
        boolean result = instance.existeUsuarioNickName(nickname);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of existeUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteUsuario_String() {
        System.out.println("existeUsuario");
        String mail = "tuerto@hotmail.com";
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        boolean expResult = true;
        boolean result = instance.existeUsuario(mail);
        assertEquals(expResult, result);
    }

    /**
     * Test of existeMail method, of class ManejadorUsuario.
     */
    
    /*@Test
    @Ignore
    public void testExisteMail() {
        System.out.println("existeMail");
        String mail = "tuerto@hotmail.com";
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        boolean expResult = true;
        boolean result = instance.existeMail(mail);
        assertEquals(expResult, result);
        
    } */

    
    /**
     * Test of existeUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteUsuario_String_String() {
        System.out.println("existeUsuario");
        String nickname = "tuerto";
        String mail = "tuerto@hotmail.com";
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        boolean expResult = true;
        boolean result = instance.existeUsuario(nickname, mail);
        assertEquals(expResult, result);
    }

    /**
     * Test of listarClientes method, of class ManejadorUsuario.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        ArrayList<DataCliente> expResult = new  ArrayList<>();

        Date fecha = new Date(1988, 12, 05);
        DataDireccion dataDireccion = new DataDireccion("Artigas","3456","1");
        DataCliente dataCliente = new DataCliente("Vazquez",fecha,"/home/jose/Imagenes/a.png","tuerto","tuerto@hotmail.com", "Manuel","aa12233", dataDireccion);
        
        expResult.add(dataCliente);
        ArrayList<DataCliente> result = instance.listarClientes();
        
        boolean c = false;
        boolean cExp = true;
        if(result.size() == expResult.size())
        {
            for(int x=0;x<result.size(); x++)
            {
                //Verificamos que los nickName sean iguales si uno no lo es que la lista no fue devuelta correctamente
                
                c = expResult.get(x).getNickname().equals(result.get(x).getNickname());
                assertEquals(cExp, c);

                c = expResult.get(x).getApellido().equals(result.get(x).getApellido());
                assertEquals(cExp, c);

                c = expResult.get(x).getMail().equals(result.get(x).getMail());
                assertEquals(cExp, c);

                c = expResult.get(x).getNombre().equals(result.get(x).getNombre());      
                assertEquals(cExp, c);
                
                c = expResult.get(x).getPass().equals(result.get(x).getPass());      
                assertEquals(cExp, c);
                
                c = expResult.get(x).getRutaImagen().equals(result.get(x).getRutaImagen());      
                assertEquals(cExp, c);               

            }
        }
                    
        assertEquals(cExp, c);
       
    }

    /**
     * Test of listarRestaurantes method, of class ManejadorUsuario.
     */
    @Test
    //@Ignore
    public void testListarRestaurantes() {
        System.out.println("listarRestaurantes");
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        ArrayList<DataRestaurante> expResult = new ArrayList<>();
        ArrayList<DataRestaurante> result = instance.listarRestaurantes();
        
        DataDireccion dataDire = new DataDireccion("Artigas","3458","1");
        String[] image = {"/home/jose/Imagnes/a.png"};
        DataRestaurante dataRest = new DataRestaurante( image,"EmapandasManuelita","EmapandasManuelita@hotmail.com","Emapandas Manuelita", "EmapandasManuelita",dataDire);
        
        expResult.add(dataRest);
        
        
        boolean c = false;
        boolean cExp = true;
        if(result.size() == expResult.size())
        {
            for(int x=0;x<result.size(); x++)
            {
                c = expResult.get(x).getNickname().equals(result.get(x).getNickname());
                assertEquals(cExp, c);
                
                c = expResult.get(x).toString().equals(result.get(x).toString());
                assertEquals(cExp, c);
                
          

            }
        }
                    
        assertEquals(cExp, c);
    }

    /**
     * Test of listarUsuarios method, of class ManejadorUsuario.
     */
    @Test
    public void testListarUsuarios() {
        System.out.println("listarUsuarios");
        ManejadorUsuario instance = null;
        ArrayList<DataUsuario> expResult = null;
        ArrayList<DataUsuario> result = instance.listarUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testIngresarUsuario_DataRestaurante_ArrayList() {
        System.out.println("ingresarUsuario");
        DataRestaurante dataRestaurante = null;
        ArrayList<DataCategoria> ldc = null;
        ManejadorUsuario instance = null;
        instance.ingresarUsuario(dataRestaurante, ldc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDataUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testObtenerDataUsuario() {
        System.out.println("obtenerDataUsuario");
        String nickName = "";
        ManejadorUsuario instance = null;
        DataUsuario expResult = null;
        DataUsuario result = instance.obtenerDataUsuario(nickName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarProductoRestaurante method, of class ManejadorUsuario.
     */
    @Test
    public void testAgregarProductoRestaurante() {
        System.out.println("agregarProductoRestaurante");
        String nickName = "";
        Producto producto = null;
        ManejadorUsuario instance = null;
        instance.agregarProductoRestaurante(nickName, producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
   
    
}
