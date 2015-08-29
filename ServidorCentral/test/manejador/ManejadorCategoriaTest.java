/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCategoria;
import java.util.ArrayList;
import modelo.Categoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        n.ingresarCategoria(new DataCategoria("jose"));
    
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
        ManejadorCategoria expResult = null;
        ManejadorCategoria result = ManejadorCategoria.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeCategoriaNombre method, of class ManejadorCategoria.
     */
    @Test
    public void testExisteCategoriaNombre() {
        System.out.println("existeCategoriaNombre");
        String nombre = "jose";
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
        System.out.println("ingresarCategoria");
        DataCategoria dataCategoria = new DataCategoria("pepe");
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        instance.ingresarCategoria(dataCategoria);
        
        boolean expResult = true;
        boolean result = instance.existeCategoriaNombre("pepe");
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listarCategorias method, of class ManejadorCategoria.
     */
    @Test
    public void testListarCategorias() {
        System.out.println("listarCategorias");
        ManejadorCategoria instance = null;
        ArrayList<DataCategoria> expResult = null;
        ArrayList<DataCategoria> result = instance.listarCategorias();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCategoria method, of class ManejadorCategoria.
     */
    @Test
    public void testObtenerCategoria() {
       System.out.println("obtenerCategoria");  
       ManejadorCategoria instance = ManejadorCategoria.getInstance();    
       assertSame(instance.obtenerCategoria("jose"), instance.obtenerCategoria("jose"));
        
    }
    
}
