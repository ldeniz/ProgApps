/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataDireccion;
import datatype.DataIndividual;
import datatype.DataIndividualPromocion;
import datatype.DataProducto;
import datatype.DataStockProducto;
import datatype.DataPromocion;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.Categoria;
import modelo.Individual;
import modelo.Restaurante;
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
       
        ic.ingresarCategoria(new Categoria("pizas"));    
        ic.ingresarCategoria(new Categoria("vinos"));    

        DataDireccion dataDire = new DataDireccion("Gallinal", "123", "1");
        String[] imagen = {"/home/jose/Imagnes/a.png"};
        Restaurante dataRestaurante = new Restaurante(imagen, "CocinaItaliana", "cocinaitaliana@hotmail.com", "Cocina Italiana", "abc123", dataDire);

        iu.ingresarUsuario(dataRestaurante);

        Calendar c = Calendar.getInstance();
        c.set(2000, 12, 20);
        DataStockProducto dp = new DataStockProducto(100, 200,c);
        /*DataIndividual dataIndividual = new DataIndividual("Rabioles con tuco","Carne pica, panceta", "/home/a.png",dp,"CocinaItaliana");
        ip.ingresarProducto(dataIndividual);
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(2015, 8, 20);
        DataStockProducto dpvino = new DataStockProducto(100, 300,c);
        DataIndividual di = new DataIndividual("Vino Tinto","Vino tinto del Carmen", "/home/vino.png",dpvino,"CocinaItaliana");
        ip.ingresarProducto(di);*/
    
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
        ManejadorProducto expResult = ManejadorProducto.getInstance();
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
        Individual dataIndividual = null;
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
        ManejadorProducto instance = ManejadorProducto.getInstance();
        
        Calendar c = Calendar.getInstance();
        c.set(2000, 12, 20);
        DataStockProducto dp = new DataStockProducto(100, 200,c);
        DataIndividual di1 = new DataIndividual("Rabioles con tuco","Carne pica, panceta", "/home/a.png",dp,"CocinaItaliana");
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(2015, 8, 20);
        DataStockProducto dpvino = new DataStockProducto(100, 300,c);
        DataIndividual di2 = new DataIndividual("Vino Tinto","Vino tinto del Carmen", "/home/vino.png",dpvino,"CocinaItaliana");
        
        DataIndividualPromocion dip1 = new DataIndividualPromocion(2,di1);
        DataIndividualPromocion dip2 = new DataIndividualPromocion(2, di2);
        ArrayList<DataIndividualPromocion> promocion = new ArrayList<>();
        promocion.add(dip1);
        promocion.add(dip2);
        
        Calendar cal = Calendar.getInstance();
        calendario.set(2015,9 ,6);        
        DataStockProducto pStock = new DataStockProducto(50, 150, cal);  
                
        DataPromocion dpromocion = new DataPromocion(50, true, promocion, "Pasta y Vino", "Vino tinto y rabioles", "/home/b.png", pStock, "CocinaItaliana");
      
        instance.ingresarProducto(dpromocion);
        
        assertTrue(instance.existeProducto("CocinaItaliana","Pasta y Vino"));
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
        ManejadorProducto instance = ManejadorProducto.getInstance();
        ArrayList<DataProducto> expResult =  new ArrayList<>();
        ManejadorUsuario insProd = ManejadorUsuario.getInstance();
//        ArrayList<DataProducto> result = instance.listarProductos("CocinaItaliana");
        
            
        Calendar c = Calendar.getInstance();
        c.set(2000, 12, 20);
        DataStockProducto dp = new DataStockProducto(100, 200,c);
        DataIndividual di1 = new DataIndividual("Rabioles con tuco","Carne pica, panceta", "/home/a.png",dp,"CocinaItaliana");
        
        Calendar calendario = Calendar.getInstance();
        calendario.set(2015, 8, 20);
        DataStockProducto dpvino = new DataStockProducto(100, 300,c);
        DataIndividual di2 = new DataIndividual("Vino Tinto","Vino tinto del Carmen", "/home/vino.png",dpvino,"CocinaItaliana");
        
        DataIndividualPromocion dip1 = new DataIndividualPromocion(2,di1);
        DataIndividualPromocion dip2 = new DataIndividualPromocion(2, di2);
        ArrayList<DataIndividualPromocion> promocion = new ArrayList<>();
        promocion.add(dip1);
        promocion.add(dip2);
        
        Calendar cal = Calendar.getInstance();
        calendario.set(2015,9 ,6);        
        DataStockProducto pStock = new DataStockProducto(50, 150, cal);  
                
        DataPromocion dpromocion = new DataPromocion(50, true, promocion, "Pasta y Vino", "Vino tinto y rabioles", "/home/b.png", pStock, "CocinaItaliana");
      
        expResult.add(di2);
        expResult.add(dpromocion);
        expResult.add(di1);
        
//        System.out.print(expResult+" "+result);
//        for(int x=0; x<result.size(); x++)
//        {
//            assertEquals(expResult.get(x).getNombre(),result.get(x).getNombre());
//        }
    }
    /**
     * Test of obtenerDatosProducto method, of class ManejadorProducto.
     */
    @Test
    public void testObtenerDatosProducto() {
        System.out.println("obtenerDatosProducto");
        String nickName = "CocinaItaliana";
        String nombre = "Rabioles con tuco";
        ManejadorProducto instance = ManejadorProducto.getInstance();
        
        Calendar c = Calendar.getInstance();
        c.set(2000, 12, 20);
        DataStockProducto dp = new DataStockProducto(100, 200,c);
        DataIndividual dataIndividual = new DataIndividual("Rabioles con tuco","Carne pica, panceta", "/home/a.png",dp,"CocinaItaliana");

        
        DataProducto result = instance.obtenerDatosProducto(nickName, nombre);
        
        assertTrue(dataIndividual.getNickName().equals(result.getNickName()));
        assertTrue(dataIndividual.getNombre().equals(result.getNombre()));
        assertTrue(dataIndividual.getRutaImagen().equals(result.getRutaImagen()));
        assertTrue(dataIndividual.getDescripcion().equals(result.getDescripcion()));
    }
  
}
