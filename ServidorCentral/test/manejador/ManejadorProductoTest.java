/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCategoria;
import datatype.DataDireccion;
import datatype.DataIndividual;
import datatype.DataProducto;
import datatype.DataStockProducto;
import datatype.DataPromocion;
import datatype.DataRestaurante;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class ManejadorProductoTest {
    
    public ManejadorProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ManejadorCategoria ic = ManejadorCategoria.getInstance();
        ManejadorProducto ip = ManejadorProducto.getInstance();
        ManejadorUsuario iu = ManejadorUsuario.getInstance();
       
        ic.ingresarCategoria(new DataCategoria("pizas"));    
        DataDireccion dataDire = new DataDireccion("Gallinal", "123", "1");
        String[] imagen = {"/home/jose/Imagnes/a.png"};
        DataRestaurante dataRestaurante = new DataRestaurante(imagen, "CocinaItaliana", "cocinaitaliana@hotmail.com", "Cocina Italiana", "abc123", dataDire);

        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();
        dataCategorias = ic.listarCategorias();
        iu.ingresarUsuario(dataRestaurante, dataCategorias);

      
        Calendar c = Calendar.getInstance();
        c.set(2000, 12, 20);
        DataStockProducto dp = new DataStockProducto(100, 200,c);
        DataIndividual dataIndividual = new DataIndividual("Rabioles con tuco","Carne pica, panceta", "/home/a.png",dp,"LoDelPepe");

        //ip.ingresarProducto(dataIndividual);
    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class ManejadorProducto.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ManejadorProducto expResult =  ManejadorProducto.getInstance();
        ManejadorProducto result = ManejadorProducto.getInstance();
        assertNotNull(result);
       // assertEquals(expResult,result);
    }

    /**
     * Test of ingresarProducto method, of class ManejadorProducto.
     */
    @Test
    public void testIngresarProducto_DataIndividual() {
        System.out.println("ingresarProducto");
        DataIndividual dataIndividual = null;
        ManejadorProducto instance = null;
        instance.ingresarProducto(dataIndividual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarProducto method, of class ManejadorProducto.
     */
    @Test
    public void testIngresarProducto_DataPromocion() {
        System.out.println("ingresarProducto");
        DataPromocion dataPromocion = null;
        ManejadorProducto instance = null;
        instance.ingresarProducto(dataPromocion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeProducto method, of class ManejadorProducto.
     */
    @Test
    public void testExisteProducto() {
        System.out.println("existeProducto");
        String nickName = "muzza";
        String nombreProducto = "pizza";
        ManejadorProducto instance = ManejadorProducto.getInstance();
        boolean expResult = true;
        boolean result = instance.existeProducto(nickName, nombreProducto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listarProductos method, of class ManejadorProducto.
     */
    @Test
    public void testListarProductos() {
        System.out.println("listarProductos");
        ManejadorProducto instance = null;
        ArrayList<DataProducto> expResult = null;
        ArrayList<DataProducto> result = instance.listarProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDatosProducto method, of class ManejadorProducto.
     */
    @Test
    public void testObtenerDatosProducto() {
        System.out.println("obtenerDatosProducto");
        String nickName = "";
        String nombre = "";
        ManejadorProducto instance = null;
        DataProducto expResult = null;
        DataProducto result = instance.obtenerDatosProducto(nickName, nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}