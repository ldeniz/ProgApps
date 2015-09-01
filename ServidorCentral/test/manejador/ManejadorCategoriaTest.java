/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import datatype.DataCategoria;
import datatype.DataRestaurante;
import datatype.DataDireccion;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Restaurante;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;



/**
 *
 * @author jose
 */
public class ManejadorCategoriaTest {

    public ManejadorCategoriaTest() {
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
        
        //DataDireccion dataDireccion = new DataDireccion("Artigas",2345,1);
       // String[] imagen = {"/home/jose/Imagenes/a.png"};
       // DataRestaurante dataRestaurante = new DataRestaurante(imagen,"Bar 17","bar17@hotmail.com","Bar 17 SRL","pass122",dataDireccion);
        ///ManejadorUsuario instance = ManejadorUsuario.getInstance();
      //  instance.ingresarUsuario(dataRestaurante, null);
    }   

    @After
    public void tearDown() {
   
    }

    /**
     * Test of getInstance method, of class ManejadorCategoria.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ManejadorCategoria a = ManejadorCategoria.getInstance();
        assertSame(a,ManejadorCategoria.getInstance());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of existeCategoriaNombre method, of class ManejadorCategoria.
     */
    @Test
    public void testExisteCategoriaNombre() {
        System.out.println("existeCategoriaNombre");
        String nombre = "pizas";
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        boolean expResult = true;
        boolean result = instance.existeCategoriaNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarCategoria method, of class ManejadorCategoria.
     */
    @Test
    public void testIngresarCategoria() {
        System.out.println("testIngresarCategoria");
        DataCategoria dataCategoria = new DataCategoria("polleria");
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        instance.ingresarCategoria(dataCategoria);

        boolean expResult = true;
        boolean result = instance.existeCategoriaNombre("polleria");      
        assertEquals(expResult, result);
        

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listarCategorias method, of class ManejadorCategoria.
     */
    @Test
    public void testListarCategorias() {
        System.out.println("testListarCategorias");
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        ArrayList<DataCategoria> result = instance.listarCategorias();
        
        
        DataCategoria dataCategoria = new DataCategoria("polleria");
        instance.ingresarCategoria(dataCategoria);
        
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> resultado = new ArrayList<String>();

        expResult.add("polleria");
        expResult.add("pizas");

        for (int x = 0; x < result.size(); x++) {
            resultado.add(result.get(x).getNombre());
        }

        assertEquals(expResult, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("fallo.");
    }

    /**
     * Test of obtenerCategoria method, of class ManejadorCategoria.
     */
    /*@Test
    @Ignore
    public void testObtenerCategoria() {
        System.out.println("obtenerCategoria");
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        assertSame(instance.obtenerCategoria("pizas"), instance.obtenerCategoria("pizas"));

    }*/

    /**
     * Test of agregarRestaurante method, of class ManejadorCategoria.
     */
    @Test
    public void testAgregarRestaurante() {
        System.out.println("agregarRestaurante");
        String nombre = "pizas";
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        DataDireccion dataDireccion = new DataDireccion("Artigas","2334","2");
        String[] imagen = {"/home/jose/Imagenes/a.png"};
        
        ArrayList<DataRestaurante> restaurantes = new ArrayList<>();
        boolean resultado = false;
        boolean expResult = true;
        
       
        Restaurante r = new  Restaurante(imagen,"Bar17","bar17@hotmail.com","Bar17SRL","pass122",dataDireccion);

        instance.agregarRestaurante(nombre, r);
        
        ArrayList<DataCategoria> result = instance.listarCategorias();
        
     
        for (int x = 0; x < result.size(); x++) 
        {
           System.out.print(result.get(x).getNombre());
           
           boolean c = new String("pizas").equals(result.get(x).getNombre()) ;
           if(c == true)
           {
              restaurantes  = result.get(x).getDataRestaurantes();         
              break;
           }
        }
        
        
        
        
            
         for (int y = 0; y< restaurantes.size(); y++)
         {
            System.out.print(restaurantes.get(y).getNombre());
            if(new String("Bar17SRL").equals(restaurantes.get(y).getNombre()) == true)
            {
                resultado = true;
            }
         }
        
        assertEquals(expResult, resultado);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}


