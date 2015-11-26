/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasoDeUso;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import interfaces.IControladorPedido;

import interfaces.IControladorCategoria;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import controlador.*;
import datatype.DataDireccion;
import datatype.DataProducto;
import java.util.ArrayList;
import java.util.Date;
import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataPedido;
import datatype.EnumEstado;
import fabrica.Fabrica;
import java.util.Calendar;
import java.util.Locale;
import datatype.DataIndividual;
import datatype.DataPedidoProduco;
import datatype.DataStockProducto;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jose
 */
public class GenerarPedidoTest {
    
    public GenerarPedidoTest() {
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
       cp.cargarDatosProducto("Jacobo 3x2","Milanesa Jacobo por tres", descuento, "dd");
       ArrayList<DataProducto> productos;
       productos = cp.listarProductos();
       // cp.seleccionarProducto("Mila Jacobo", 1);
       cp.altaProducto();
       
    }
    
    @After
    public void tearDown() {
     
    }

  
    @Test
    public void generarPedidioIndividual() throws Exception {
        System.out.println("Case Generar Pedido Individual");

        IControladorPedido cp = Fabrica.getInstance().obtenerControladorPedido();

        IControladorUsuario cu = Fabrica.getInstance().obtenerControladorUsuario();
        IControladorCategoria cc = Fabrica.getInstance().obtenerControladorCategoria();

        cu.listarClientes();
        cp.seleccionarCliente("pepe");
        ArrayList<DataCategoria> dc = cc.listarCategorias();
        //Falta un selecccioanar categoria.
        cp.seleccionarRestaurante("Bar17");
        
        cp.seleccionarProducto("Bar17", "Mila Jacobo", 1);
        DataPedido dp = cp.finalizarPedido();//Da error;

        boolean result = false;

       if(EnumEstado.PREPARACION.compareTo(dp.getEstado())==0);
       {
           result = true;
       }
       assertTrue(result);

       result = dp.getPrecioTotal() == 70;
       assertTrue(result);

       result = 1 == dp.getDataPedidoProducos().get(0).getCantidad();
       assertTrue(result);

       Calendar calendario = Calendar.getInstance(new Locale("es", "uy"));

        if(calendario.compareTo(dp.getFechaPedido()) == 0)
        {
            result = true;
        }
        assertTrue(result);      
        
        //Vericamos si el pedido esta dado de alta en el cliente.
        ArrayList<DataPedido> listarPedidosCliente = cu.listarPedidosCliente("pepe");
        if(listarPedidosCliente.size() == 1)
        {
            assertTrue(true);
        }
        else
        {
            assertTrue(false);
        }
    }
    
    @Test
    public void listarPedidoTest() throws Exception
    {
        System.out.println("Case Listar Pedido");
        IControladorPedido cp = Fabrica.getInstance().obtenerControladorPedido();
        IControladorUsuario cu = Fabrica.getInstance().obtenerControladorUsuario();
        IControladorCategoria cc = Fabrica.getInstance().obtenerControladorCategoria();


        ArrayList<DataCliente> listarClientes = cu.listarClientes();
        cp.seleccionarCliente("pepe");
        ArrayList<DataCategoria> dc = cc.listarCategorias();
        //Falta un selecccioanar categoria.
        cp.seleccionarRestaurante("Bar17");
        cp.seleccionarProducto("Bar17", "Mila Jacobo", 1);
        DataPedido dp = cp.finalizarPedido();//
        ArrayList<DataCliente> listarCliente = cu.listarClientes();
        cp.seleccionarCliente("pepe");
        ArrayList<DataPedido> dataPedidoResult = cp.listarPedidos();
        Calendar calendario = Calendar.getInstance(new Locale("es", "uy"));
        float total=(float)70.0;
        
        DataStockProducto stock = new DataStockProducto("pepe","Mila Jacobo",10, total, calendario);
        
        DataPedidoProduco expDataPedido = new DataPedidoProduco(1, stock);
        ArrayList<DataPedidoProduco> productos = new ArrayList<>();
        productos.add(expDataPedido);
        
       
        DataPedido pedido = new DataPedido("pepe", "Bar17", 1, calendario, total, EnumEstado.PREPARACION, productos);
        ArrayList<DataPedido> expPedido = new ArrayList<>();
        expPedido.add(pedido);
        
        
        assertEquals(expPedido.get(0).getNumero(),dataPedidoResult.get(0).getNumero());        
    }
    
    @Test
    public void pruebasExeptionTest()
    {
        System.out.println("Test pruebasExeptionTest");
        IControladorPedido cp = Fabrica.getInstance().obtenerControladorPedido();
        IControladorCategoria cc = Fabrica.getInstance().obtenerControladorCategoria();
        IControladorUsuario cu = Fabrica.getInstance().obtenerControladorUsuario();
        try {
            cp.seleccionarRestaurante("Lo de chola");
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(true);
        }
        
        try {
            cp.seleccionarCliente("pedro");
            assertTrue(false);

        } catch (Exception ex) {
              assertTrue(true);
        }
        
        ArrayList<DataCategoria> dc = cc.listarCategorias();
        
        cu.seleccionarCategoria("Minutas");

        try {
            cp.seleccionarRestaurante("Bar17");
        } catch (Exception ex) {
            Logger.getLogger(GenerarPedidoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {
            cp.seleccionarProducto("Bar17", "Mila Jacobo", 200);
            assertTrue(true);
        } catch (Exception ex) {
              assertTrue(true);
        }
        
        try{
           cp.listarPedidos("Bar");
            assertTrue(false);
        }
        catch(Exception ex)
        {
            assertTrue(true);
        }

    }
    
}