/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataDireccion;
import datatype.DataProducto;
import fabrica.Fabrica;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
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
        
        IControladorProducto cp = Fabrica.getInstance().obtenerControladorProducto();
        cp.limpiarMemoria();
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
        String nombre = "Promo1";
        String descripcion = "Hasta las 20hs";
        int descuento = 30;
        String rutaImagen = "/home/jose/a.png";
        ControladorProducto instance = new ControladorProducto();
        instance.seleccionarRestaurante("Bar17");
        instance.cargarDatosProducto(nombre, descripcion, descuento, rutaImagen);       
        instance.altaProducto();

        assertTrue(instance.existeProducto("Bar17", nombre));
       
    }

    /**
     * Test of seleccionarProducto method, of class ControladorProducto.
     */
    @Test
    public void testSeleccionarProducto() {
        System.out.println("seleccionarProducto");
        String nombre = "Faina";
        String descripcion = "Queso";
        float precio = 30.1F;
        String rutaImagen = "/home/jose/f.png";
        
        //Verificamos que el producto fue dado de alta correctamente,
        ControladorProducto instance = new ControladorProducto();
        instance.seleccionarRestaurante("Bar17");
        instance.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
        instance.altaProducto();
        
        //Verficamos que deje seleccionar un producto que si existe.
        try{
            instance.seleccionarProducto(nombre, 1);
            assertTrue(true);
        }
        catch (Exception ex)
        {
          assertTrue(false); 
        }
        
        //Verficamos que no deje seleccionar un producto que no existe.
        try{
            instance.seleccionarProducto("prueba", 1);
            assertTrue(false);
        }
        catch (Exception ex)
        {
          assertTrue(true); 
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of obtenerCantidadProductoIndividual method, of class ControladorProducto.
     */
    

    /**
     * Test of altaProducto method, of class ControladorProducto.
     */
    @Test
    public void testAltaProducto() {
        System.out.println("altaProducto");
        String nombre = "Faina";
        String descripcion = "Queso";
        float precio = 30.1F;
        String rutaImagen = "/home/jose/f.png";
        
        //Verificamos que el producto fue dado de alta correctamente,
        ControladorProducto instance = new ControladorProducto();
        
        instance.seleccionarRestaurante("Bar17");
        
        //Verificamos que si deja de dar alta un producto sin cargar datos.
        try{
            instance.altaProducto();
            assertTrue(false);
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }
        //Deveria dejar de alta el productos con los datos cargados.
        instance.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
        instance.altaProducto();
        assertTrue(instance.existeProducto("Bar17", nombre));
        
        

    }

    /**
     * Test of existeProducto method, of class ControladorProducto.
     */
    @Test
    public void testExisteProducto() {
        System.out.println("existeProducto");
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
        assertFalse(instance.existeProducto("Bar", nombre));     
    }    

    

    /**
     * Test of limpiarMemoria method, of class ControladorProducto.
     */
    @Test
    public void testLimpiarMemoria() {
        System.out.println("limpiarMemoria");
        ControladorProducto instance = new ControladorProducto();

        String nombre = "Faina";
        String descripcion = "Queso";
        float precio = 30.1F;
        String rutaImagen = "/home/jose/f.png";
        
        //Verificamos que el producto fue dado de alta correctamente,
        instance.seleccionarRestaurante("Bar17");
       
        
        instance.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
        instance.altaProducto();       
       
        
        int descuento = 50;
        instance.seleccionarRestaurante("Bar17");  
        instance.seleccionarProducto("Faina", 2);
        instance.cargarDatosProducto("FainaPromo","FainaPromo", descuento, "/home/a.png");
        instance.limpiarMemoria();
        instance.altaProducto(); //Deberia producir una expetion.
    }

    
    /**
     * Test of obtenerDatosRestauranteNombre method, of class ControladorProducto.
     */
    @Test
    public void testObtenerDatosRestauranteNombre() {
        System.out.println("obtenerDatosRestauranteNombre");
        String nombre = "Faina";
        String nickName = "Bar17";
        String descripcion = "Queso";
        float precio = 30.1F;
        String rutaImagen = "/home/jose/f.png";
        
        //Verificamos que el producto fue dado de alta correctamente,
        ControladorProducto instance = new ControladorProducto();
        instance.seleccionarRestaurante(nickName);
        instance.cargarDatosProducto(nombre, descripcion, precio, rutaImagen);
        instance.altaProducto();
        datatype.DataProducto result = instance.obtenerDatosRestauranteNombre(nickName, nombre);
        
        assertEquals(nombre, result.getNombre());
    
    
    }  
}