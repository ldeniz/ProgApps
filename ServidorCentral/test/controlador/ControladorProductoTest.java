/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataDireccion;
import datatype.DataProducto;
import fabrica.Fabrica;
import java.util.ArrayList;
import manejador.ManejadorProducto;
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
    public void setUp() throws Exception {
        ControladorCategoria cc = new ControladorCategoria();
        ControladorUsuario cu = new ControladorUsuario();
      
        cc.altaCategoria("Minutas");  
        
                   
        String [] rutaImagen = {"/home/jose/a.png"}; 
        cu.seleccionarCategoria("Minutas");
        
        DataDireccion direccion = new DataDireccion("Buenos Aires","222","1");
        cu.CargarDatosUsuario("Bar17", "bar17@gmail.com", "Bar 17", "bar123",direccion,rutaImagen);
        cu.altaUsuario();
        
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
        String nombre = "Faina";
        String descripcion = "Queso";
        float precio = 30.1F;
        String rutaImagen = "/home/jose/f.png";
        
        //Verificamos que el producto fue dado de alta correctamente,
        ControladorProducto instance = new ControladorProducto();
        instance.seleccionarRestaurante("Bar17");
        instance.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
        instance.altaProducto();
        assertTrue(instance.existeProducto("Bar17", nombre));
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
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarProducto method, of class ControladorProducto.
     */
    @Test
      @Ignore
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
    

    /**
     * Test of altaProducto method, of class ControladorProducto.
     */
    @Test
      @Ignore
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
       
    }    

   
}