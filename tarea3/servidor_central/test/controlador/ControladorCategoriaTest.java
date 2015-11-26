/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datatype.DataDireccion;
import datatype.DataRestaurante;
import fabrica.Fabrica;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class ControladorCategoriaTest {
    
    public ControladorCategoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
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


    @Test
    public void testListarRestaurantes() throws Exception {
        System.out.println("listarRestaurantes");
        String categoria = "Minutas";
        ControladorCategoria instance = new ControladorCategoria();
        ArrayList<DataRestaurante> result = instance.listarRestaurantes(categoria);
       
        assertEquals(result.size(), 1);
        
        //Verificamos si verificamos si se produce la exption al no exisitir la categoria.
        try{
            result = instance.listarRestaurantes("ComidaChina");
            assertTrue(false);
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }
    }
}
