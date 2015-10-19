/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataDireccion;
import java.util.ArrayList;
import modelo.Categoria;
import modelo.Restaurante;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author jose
 */
import org.junit.Test;

//Running test cases in order of method names in ascending order
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
        n.ingresarCategoria(new Categoria("pizas"));

        //DataDireccion dataDireccion = new DataDireccion("Artigas",2345,1);
        // String[] imagen = {"/home/jose/Imagenes/a.png"};
        // DataRestaurante dataRestaurante = new DataRestaurante(imagen,"Bar 17","bar17@hotmail.com","Bar 17 SRL","pass122",dataDireccion);
        ///ManejadorUsuario instance = ManejadorUsuario.getInstance();
        //  instance.ingresarUsuario(dataRestaurante, null);
    }

    @After
    public void tearDown() {
        ManejadorCategoria n = ManejadorCategoria.getInstance();
        n.limpiarMemoria();

    }

    /**
     * Test of getInstance method, of class ManejadorCategoria.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ManejadorCategoria a = ManejadorCategoria.getInstance();
        assertSame(a, ManejadorCategoria.getInstance());
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
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        instance.ingresarCategoria(new Categoria("polleria"));

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
        ArrayList<Categoria> result = instance.listarCategorias();

        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> resultado = new ArrayList<String>();

        expResult.add("pizas");

        for (int x = 0; x < result.size(); x++) {
            resultado.add(result.get(x).getNombre());
        }

        assertEquals(expResult, resultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("fallo.");
    }

   
    @Test
    public void testAgregarRestaurante() {
        System.out.println("agregarRestaurante");
        String nombre = "pizas";
        ManejadorCategoria instance = ManejadorCategoria.getInstance();
        DataDireccion dataDireccion = new DataDireccion("Artigas", "2334", "2");
        String[] imagen = {"/home/jose/Imagenes/a.png"};

        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        boolean resultado = false;
        boolean expResult = true;

        Restaurante r = new Restaurante(imagen, "Bar17", "bar17@hotmail.com", "Bar17SRL", "pass122", dataDireccion);

        instance.agregarRestaurante(nombre, r);

        ArrayList<Categoria> result = instance.listarCategorias();

        for (int x = 0; x < result.size(); x++) {

            boolean c = new String("pizas").equals(result.get(x).getNombre());
            if (c == true) {
                restaurantes = result.get(x).getRestaurantes();
                break;
            }
        }

        for (int y = 0; y < restaurantes.size(); y++) {
            if (new String("Bar17SRL").equals(restaurantes.get(y).getNombre()) == true) {
                resultado = true;
            }
        }

        assertEquals(expResult, resultado);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
   
}
