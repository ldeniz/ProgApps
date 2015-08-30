/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejador;

import datatype.DataCliente;
import datatype.DataRestaurante;
import datatype.DataUsuario;
import java.util.ArrayList;
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
    }
    
    @After
    public void tearDown() {
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
        
        DataCliente dataCliente = new DataCliente;
        ManejadorUsuario instance = null;
        instance.ingresarUsuario(dataCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testIngresarUsuario_DataRestaurante() {
        System.out.println("ingresarUsuario");
        DataRestaurante dataRestaurante = null;
        ManejadorUsuario instance = null;
        instance.ingresarUsuario(dataRestaurante);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuarioNickName method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteUsuarioNickName() {
        System.out.println("existeUsuarioNickName");
        String nickname = "";
        ManejadorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.existeUsuarioNickName(nickname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteUsuario_String() {
        System.out.println("existeUsuario");
        String mail = "";
        ManejadorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.existeUsuario(mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeMail method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteMail() {
        System.out.println("existeMail");
        String mail = "";
        ManejadorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.existeMail(mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existeUsuario method, of class ManejadorUsuario.
     */
    @Test
    public void testExisteUsuario_String_String() {
        System.out.println("existeUsuario");
        String nickname = "";
        String mail = "";
        ManejadorUsuario instance = null;
        boolean expResult = false;
        boolean result = instance.existeUsuario(nickname, mail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarClientes method, of class ManejadorUsuario.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        ManejadorUsuario instance = null;
        ArrayList<DataCliente> expResult = null;
        ArrayList<DataCliente> result = instance.listarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarRestaurantes method, of class ManejadorUsuario.
     */
    @Test
    public void testListarRestaurantes() {
        System.out.println("listarRestaurantes");
        ManejadorUsuario instance = null;
        ArrayList<DataRestaurante> expResult = null;
        ArrayList<DataRestaurante> result = instance.listarRestaurantes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsuarios method, of class ManejadorUsuario.
     */
    @Test
    public void testListarUsuarios() {
        System.out.println("listarUsuarios");
        ManejadorUsuario instance = null;
        ArrayList<DataUsuario> expResult = null;
        ArrayList<DataUsuario> result = instance.listarUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
