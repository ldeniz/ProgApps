/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasoDeUso;

import controlador.ControladorUsuario;
import datatype.DataCategoria;
import datatype.DataDireccion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.EnumEstado;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorPedido;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
public class CancelarPedidoTest {
    
    public CancelarPedidoTest() {
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
        IControladorUsuario cu = new ControladorUsuario();
        IControladorPedido cp = Fabrica.getInstance().obtenerControladorPedido();
        IControladorProducto cpr = Fabrica.getInstance().obtenerControladorProducto();

        cc.altaCategoria("Minutas");  
        
                   
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
        cpr.seleccionarRestaurante("Bar17");
        float precio = (float)70.0;
        cpr.cargarDatosProducto("Mila Jacobo","Jamon y Queso",precio,  "/home/jose/milajacobo.png");
        cpr.altaProducto();
        
        int descuento = 50;
        cpr.seleccionarRestaurante("Bar17");      
        cpr.cargarDatosProducto("Jacobo 3x2","Milanesa Jacobo por tres", descuento, "dd");
        ArrayList<DataProducto> productos;
        productos = cpr.listarProductos();
        // cp.seleccionarProducto("Mila Jacobo", 1);
        cpr.altaProducto();        
        
       

        cu.listarClientes();
        cp.seleccionarCliente("pepe");
        ArrayList<DataCategoria> dc = cc.listarCategorias();
        //Falta un selecccioanar categoria.
        cp.seleccionarRestaurante("Bar17");
        
        cp.seleccionarProducto("Bar17", "Mila Jacobo", 1);
        DataPedido dp = cp.finalizarPedido();//Da error;
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void cancelarPedidosTest() {
        IControladorPedido cp = Fabrica.getInstance().obtenerControladorPedido();        
        cp.listarPedidos();
        cp.seleccionarPedido(1);
        cp.cancelarPedido();
       
        
        //Verificamos si el pedido existe.
        try
        {
            cp.listarPedidos();
            cp.seleccionarPedido(1);
            cp.cancelarPedido();
            assertTrue(false);
        }
        catch (Exception ex)
        {
            assertTrue(true);
        }
                
        
        

    }
}
