/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataDireccion;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import modelo.Categoria;
import modelo.Cliente;
import modelo.Restaurante;
import modelo.Usuario;
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
        n.ingresarCategoria(new Categoria("pizas"));

        //Damos de alta a un cliente
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        Date fecha = new Date(1988, 12, 05);
        DataDireccion dataDireccion = new DataDireccion("Artigas", "3456", "1");
        Cliente dataCliente = new Cliente("Vazquez", fecha, "/home/jose/Imagenes/a.png", "tuerto", "tuerto@hotmail.com", "Manuel", "aa12233", dataDireccion);
        instance.ingresarUsuario(dataCliente);

        //Damos de alta a un restaurante
        DataDireccion dataDire = new DataDireccion("Artigas", "3458", "1");
        String[] imagen = {"/home/jose/Imagnes/a.png"};
        Restaurante dataRestaurante = new Restaurante(imagen, "EmapandasManuelita", "EmapandasManuelita@hotmail.com", "Emapandas Manuelita", "EmapandasManuelita", dataDire);

        instance.ingresarUsuario(dataRestaurante);

    }

    @After
    public void tearDown() {
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        instance.limpiarMemoria();
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
    public void testIngresarUsuario_DataCliente() {
        System.out.println("ingresarUsuario");
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        Date fecha = new Date(1988, 12, 05);
        DataDireccion dataDireccion = new DataDireccion("Artigas", "3456", "1");
        Cliente dataCliente = new Cliente("Villalba", fecha, "/home/jose/Imagenes/a.png", "pepe", "josevillalba@hotmail.com", "Jose", "aa12233", dataDireccion);
        instance.ingresarUsuario(dataCliente);
        boolean result = instance.existeUsuarioNickName("pepe");
        assertTrue(result);
    }

    @Test
    public void testIngresarUsuario_DataRestaurante() {
        System.out.println("ingresarUsuario");
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        ManejadorCategoria n = ManejadorCategoria.getInstance();

        DataDireccion dataDireccion = new DataDireccion("Artigas", "3458", "1");
        String[] imagen = {"/home/jose/Imagnes/a.png"};
        Restaurante dataRestaurante = new Restaurante(imagen, "BarArtigas", "barArtigas@hotmail.com", "Bar Artigas", "barArgias", dataDireccion);

        instance.ingresarUsuario(dataRestaurante);
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
        ArrayList<Cliente> expResult = new ArrayList<>();

        Date fecha = new Date(1988, 12, 05);
        DataDireccion dataDireccion = new DataDireccion("Artigas", "3456", "1");
        Cliente dataCliente = new Cliente("Vazquez", fecha, "/home/jose/Imagenes/a.png", "tuerto", "tuerto@hotmail.com", "Manuel", "aa12233", dataDireccion);

        expResult.add(dataCliente);
        ArrayList<Cliente> result = instance.listarClientes();

        boolean c = false;
        boolean cExp = true;
        if (result.size() == expResult.size()) {
            for (int x = 0; x < result.size(); x++) {
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
        ArrayList<Restaurante> expResult = new ArrayList<>();
        ArrayList<Restaurante> result = instance.listarRestaurantes();

        DataDireccion dataDire = new DataDireccion("Artigas", "3458", "1");
        String[] image = {"/home/jose/Imagnes/a.png"};
        Restaurante dataRest = new Restaurante(image, "EmapandasManuelita", "EmapandasManuelita@hotmail.com", "Emapandas Manuelita", "EmapandasManuelita", dataDire);

        expResult.add(dataRest);

        boolean c = true;
        boolean cExp = true;
        if (result.size() == expResult.size()) {
            for (int x = 0; x < result.size(); x++) {
                c = expResult.get(x).getNickname().equals(result.get(x).getNickname());
                assertEquals(cExp, c);

                c = expResult.get(x).toString().equals(result.get(x).toString());
               // assertEquals(cExp, c);

                c = expResult.get(x).getMail().equals(result.get(x).getMail());
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
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        ArrayList<Usuario> expResult = null;
        expResult = new ArrayList<>();

        ArrayList<Usuario> result = instance.listarUsuarios();

        DataDireccion dataDire = new DataDireccion("Artigas", "3458", "1");
        Cliente dc = new Cliente(null, null, null, "EmapandasManuelita", "EmapandasManuelita@hotmail.com", "Emapandas Manuelita", "EmapandasManuelita", dataDire);

        DataDireccion dataDireccion = new DataDireccion("Artigas", "3456", "1");
        Cliente du = new Cliente(null, null, null, "tuerto", "tuerto@hotmail.com", "Manuel", "aa12233", dataDireccion);

        expResult.add(dc);
        expResult.add(du);

        for (int x = 0; x < result.size(); x++) {
            assertTrue(expResult.get(x).getNickname().equals(result.get(x).getNickname()));
            assertTrue(expResult.get(x).getNombre().equals(result.get(x).getNombre()));
            assertTrue(expResult.get(x).getMail().equals(result.get(x).getMail()));
            assertTrue(expResult.get(x).getPass().equals(result.get(x).getPass()));
        }

    }

    /**
     * Test of ingresarUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testIngresarUsuario_DataRestaurante_ArrayList() {
        System.out.println("ingresarUsuario");

        String[] imagen = {"/home/jose/imagen/a.jpj"};
        DataDireccion direccion = new DataDireccion("River", "2200", "2");
        Restaurante dataRestaurante = new Restaurante(imagen, "laesquina", "laesquina@hotmail.com", "La esquina de la milanesa", "esquinamila", direccion);

        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        instance.ingresarUsuario(dataRestaurante);
        assertTrue(instance.existeUsuarioNickName("laesquina"));
    }

    /**
     * Test of obtenerDataUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testObtenerDataUsuario() {
        System.out.println("obtenerDataUsuario");
        String nickName = "tuerto";
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
//        DataUsuario result = instance.obtenerDataUsuario(nickName);
//        assertTrue(nickName.equals(result.getNickname()));
    }

    /**
     * Test of agregarProductoRestaurante method, of class ManejadorUsuario.
     */
    @Ignore
    @Test
    public void testAgregarProductoRestaurante() {
        /*System.out.println("agregarProductoRestaurante");
         String nickName = "EmapandasManuelita";
         Calendar calendario = Calendar.getInstance();
         calendario.set(2000, 12, 23);
         StockProduco st = new StockProduco(200, 10, calendario);
         Individual producto = new Individual("Empanadas", "Con aceitunas", "/home/jose/imagena/a.jpg", st, "EmapandasManuelita", "Individual");
         ManejadorUsuario instance = ManejadorUsuario.getInstance();
         StockProduco dsp = new StockProduco(200, 20, calendario);
         Individual di = new Individual("Empanadas", "Con aceitunas", "/home/a.png", dsp, "EmapandasManuelita", "individual");
         ManejadorProducto instanceProduco = ManejadorProducto.getInstance();
         instanceProduco.ingresarProducto(di);
         boolean expResult;
         expResult = instanceProduco.existeProducto(nickName, "Empanadas");
         assertTrue(expResult);
         */
    }

    /**
     * Test of listarProductosRestaurante method, of class ManejadorUsuario.
     */
    @Ignore
    @Test
    public void testListarProductosRestaurante() {
//        String nickName = "EmapandasManuelita";
//        ManejadorProducto instance = ManejadorProducto.getInstance();
//        ArrayList<Producto> result = instance.listarProductos(nickName);
//        ArrayList<Producto> expResult = new ArrayList<>();
//
//        Calendar calendario = null;
//        StockProduco st = new StockProduco(200, 10, calendario);
//
//        Individual producto = new Individual("Empanadas", "Con aceitunas", "/home/jose/imagena/a.jpg", st, nickName, "individual");
//
//        expResult.add(producto);
//
//        for (int x = 0; x < result.size(); x++) {
//            assertTrue(expResult.get(x).getNombre().equals(result.get(x).getNombre()));
//            assertTrue(expResult.get(x).getRutaImagen().equals(result.get(x).getRutaImagen()));
//            assertTrue(expResult.get(x).getDescripcion().equals(result.get(x).getDescripcion()));
//        }

    }

    /**
     * Test of limpiarMemoria method, of class ManejadorUsuario.
     */
    @Test
    public void testLimpiarMemoria() {
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        instance.limpiarMemoria();
        ArrayList<Usuario> result = instance.listarUsuarios();
        assertFalse(instance.existeUsuarioNickName("tuerto"));

    }

    @Test
    public void testExisteUsuario() {
        ManejadorUsuario instance = ManejadorUsuario.getInstance();
        assertTrue(instance.existeUsuario("tuerto", "tuerto@hotmail.com"));
    }

}
