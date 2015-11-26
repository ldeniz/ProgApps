/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasoDeUso;

import controlador.ControladorUsuario;
import datatype.DataDireccion;
import datatype.DataProducto;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import modelo.Producto;
/**
 *
 * @author root
 */
public class ModificarProductoTest {
    
    public ModificarProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        IControladorCategoria cc = Fabrica.getInstance().obtenerControladorCategoria();
        cc.altaCategoria("Minutas");  

        IControladorUsuario cu = new ControladorUsuario();           
        String [] rutaImagen = {"/home/jose/a.png"}; 
        cu.seleccionarCategoria("Minutas");

        DataDireccion direccion = new DataDireccion("Buenos Aires","222","1");
        cu.CargarDatosUsuario("Bar17", "bar17@gmail.com", "Bar 17", "bar123",direccion,rutaImagen);
        cu.altaUsuario();

        DataDireccion dire = new DataDireccion("Lafinur","222","1");
        Date date = new Date(1988, 12, 05);
        cu.CargarDatosUsuario("pepe","pepe88@hotmail.com","Jose","pepe1233",dire,"Villa",date,"/home/jose/pepe.png");
        cu.altaUsuario();      

        //Alta de producto individual
        IControladorProducto cp = Fabrica.getInstance().obtenerControladorProducto();
        cp.seleccionarRestaurante("Bar17");
        float precio = (float)70.0;
       
        cp.cargarDatosProducto("Mila Jacobo","Jamon y Queso",precio,  "/home/jose/milajacobo.png");
        cp.altaProducto();

        
        int descuento = 50;
        cp.seleccionarRestaurante("Bar17");  
        cp.seleccionarProducto("Mila Jacobo", 2);
        cp.cargarDatosProducto("Jacobo 3x2","Milanesa Jacobo por tres", descuento, "/home/a.png");
       
        cp.altaProducto();
    }
    
    @After
    public void tearDown() {
    }

   
     
    @Test
    public void CargarDatosModificarProductoTest()
    {   
        IControladorProducto cp = Fabrica.getInstance().obtenerControladorProducto();

        cp.seleccionarRestaurante("Bar17");
        float precio = (float)70.0;     
        
        cp.CargarDatosModificarProducto("Mila Jacobo","Milanesa", "De carne", "/home/jose/a.png", precio);
        cp.ModificarProducto();

        cp.seleccionarRestaurante("Bar17");      
        cp.CargarDatosModificarProducto("Jacobo 3x2","Mila 3x2" ,"De carne", "/home/jose/a.png",30,true);
        cp.ModificarProducto();
        assertFalse(cp.existeProducto("Bar17","Milanesa")); //Devuelve false;
        
        cp.seleccionarRestaurante("Bar17");      
        cp.CargarDatosModificarProducto("Jacobo 3x2","Mila 3x2" ,"De carne", "/home/jose/a.png",30,false);
        cp.ModificarProducto();
    }
}
