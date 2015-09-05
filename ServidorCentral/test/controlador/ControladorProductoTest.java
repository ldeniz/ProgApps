/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataProducto;
import java.util.ArrayList;
import manejador.ManejadorProducto;
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
public class ControladorProductoTest {
    
    public ControladorProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cargarDatosProducto method, of class ControladorProducto.
     */
    @Test
    public void testCargarDatosProducto_4args_1() {
        System.out.println("cargarDatosProducto");
        String nombre = "";
        String descripcion = "";
        float precio = 0.0F;
        String rutaImagen = "";
        ControladorProducto instance = new ControladorProducto();
        instance.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarDatosProducto method, of class ControladorProducto.
     */
    @Test
    public void testCargarDatosProducto_4args_2() {
        System.out.println("cargarDatosProducto");
        String nombre = "";
        String descripcion = "";
        int descuento = 0;
        String rutaImagen = "";
        ControladorProducto instance = new ControladorProducto();
        instance.cargarDatosProducto(nombre, descripcion, descuento, rutaImagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarProducto method, of class ControladorProducto.
     */
    @Test
    public void testSeleccionarProducto() {
        System.out.println("seleccionarProducto");
        String nombre = "";
        int cantidad = 0;
        ControladorProducto instance = new ControladorProducto();
        instance.seleccionarProducto(nombre, cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerCantidadProductoIndividual method, of class ControladorProducto.
     */
    @Test
    public void testObtenerCantidadProductoIndividual() {
        System.out.println("obtenerCantidadProductoIndividual");
        String nickName = "";
        String nombre = "";
        ControladorProducto instance = new ControladorProducto();
        int expResult = 0;
        int result = instance.obtenerCantidadProductoIndividual(nickName, nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altaProducto method, of class ControladorProducto.
     */
    @Test
    public void testAltaProducto() {
        System.out.println("altaProducto");
        ControladorProducto instance = new ControladorProducto();
        instance.altaProducto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeProducto method, of class ControladorProducto.
     */
    @Test
    public void testExisteProducto() {
        System.out.println("existeProducto");
        String nickName = "";
        String nombre = "";
        ControladorProducto instance = new ControladorProducto();
        boolean expResult = false;
        boolean result = instance.existeProducto(nickName, nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarProductos method, of class ControladorProducto.
     */
    @Test
    public void testListarProductos() {
            System.out.println("listarProductos");


            ManejadorProducto mp = ManejadorProducto.getInstance();
            ArrayList<DataProducto> lista = new ArrayList<>(); 
            lista = mp.listarProductos();

            ControladorProducto instance = new ControladorProducto();
            ArrayList<DataProducto> expResult = mp.listarProductos();
            ArrayList<DataProducto> result = instance.listarProductos();
            assertEquals(expResult, result);
    }

    /**
     * Test of limpiarMemoria method, of class ControladorProducto.
     */
    @Test
    public void testLimpiarMemoria() {
        /*
            System.out.println("limpiarMemoria");
       
        ArrayList<DataIndividualPromocion> productosPromocion = new ArrayList<>();
       ManejadorProducto mp = ManejadorProducto.getInstance();
      ArrayList<DataProducto> lista = new ArrayList<>(); 
      lista = mp.listarProductos();
       productosPromocion.clear();
       
       ControladorProducto instance = new ControladorProducto();
       instance.limpiarMemoria();*/
    }

    /**
     * Test of seleccionarRestaurante method, of class ControladorProducto.
     */
    @Test
    public void testSeleccionarRestaurante() {
        System.out.println("seleccionarRestaurante");
        String nickName = "";
        ControladorProducto instance = new ControladorProducto();
        instance.seleccionarRestaurante(nickName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}