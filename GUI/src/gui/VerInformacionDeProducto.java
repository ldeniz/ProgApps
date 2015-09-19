/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.VerInformacionDeRestaurante.VIDR;
import static gui.VerInformacionDeRestaurante.restaurantes;
import datatype.DataIndividual;
import datatype.DataIndividualPromocion;
import datatype.DataPedido;
import datatype.DataProducto;
import datatype.DataPromocion;
import datatype.DataRestaurante;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorPedido;
import interfaces.IControladorProducto;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Mathi
 */
public class VerInformacionDeProducto extends javax.swing.JInternalFrame {
    private DataProducto ProductoSeleccionadoResto = null;
    private DataRestaurante RestauranteSeleccionadoResto;
    IControladorProducto cp = Fabrica.getInstance().obtenerControladorProducto();
    IControladorPedido cPed = Fabrica.getInstance().obtenerControladorPedido();
    HashMap<Integer, DataProducto> elProducto = new HashMap<>();
    Properties propiedades = new Properties();
    /**
     * Creates new form VerInformacionDeProducto
     */
    public VerInformacionDeProducto() {
        //Carga Archivo de Propiedades ----------------------
        
        InputStream entrada = null;
        try {               
            entrada = this.getClass().getResourceAsStream("/Resources/config.properties");
            propiedades.load(entrada);
            } 
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        
        
        System.out.println(VerInformacionDeRestaurante.VIDR);
        //---------------------------------------------------
        initComponents();
        if(VIDR){
        //SE FIJA SI HAY ALGO SELECCIONADO EN EL OTRO FORMULARIO:
        VerInformacionDeRestaurante.productosRestaurante.getSelectedIndex();
        
        int index = VerInformacionDeRestaurante.productosRestaurante.getSelectedIndex();
        
        
        ProductoSeleccionadoResto = (DataProducto) VerInformacionDeRestaurante.modeloProductos.getElementAt(index);
        System.out.println(ProductoSeleccionadoResto.getNombre());
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)VerInformacionDeRestaurante.restaurantes.getLastSelectedPathComponent();
        if ((node != null) && (node.isLeaf())){
        RestauranteSeleccionadoResto =(DataRestaurante)node.getUserObject();
        System.out.println(RestauranteSeleccionadoResto.getNickname());
        }
        
        
        
        //---------------------
        
        
        if (ProductoSeleccionadoResto!= null){
            jScrollPane1.hide();
             //se limpian los campos
            int k = modeloTablaPedidosDeProducto.getRowCount();
            for (int i = k-1; i >=0 ; i--) {
                modeloTablaPedidosDeProducto.removeRow(i);    
            }
             k = modeloTablaProdPromo.getRowCount();
            for (int i = k-1; i >=0 ; i--) {
                modeloTablaProdPromo.removeRow(i);    
            }
            nombreProducto.setText("");
            RestauranteProducto.setText("");
            descripcionProducto.setText("");
            tipoProducto.setText("");
            estadoProducto.setText("");
            descuentoProducto.setText("");
            precio.setText("");
            
            
            
            
            imagenProducto.setIcon(new ImageIcon());

            
            general.removeAll();        
            
            
            
            if (ProductoSeleccionadoResto.getRutaImagen() == null){
               Image image = Toolkit.getDefaultToolkit().createImage(propiedades.getProperty("productoPorDefecto"));
               Icon warnIcon = new ImageIcon(image.getScaledInstance(145, 129, image.SCALE_DEFAULT));
               imagenProducto.setIcon(warnIcon);
               imagenProducto.validate();
               System.out.println("Carga la por defecto "+propiedades.getProperty("productoPorDefecto"));
            }
            else{
               Image image = Toolkit.getDefaultToolkit().createImage(ProductoSeleccionadoResto.getRutaImagen());
               Icon warnIcon = new ImageIcon(image.getScaledInstance(145, 129, image.SCALE_DEFAULT));
               imagenProducto.setIcon(warnIcon);
               imagenProducto.validate();
               System.out.println("Carga la imagen "+ProductoSeleccionadoResto.getRutaImagen());
            }
            
            
            
            nombreProducto.setText(ProductoSeleccionadoResto.getNombre());
            RestauranteProducto.setText(ProductoSeleccionadoResto.getNickName());
            descripcionProducto.setText(ProductoSeleccionadoResto.getDescripcion());
            tipoProducto.setText(ProductoSeleccionadoResto.getTipoProducto());
            precio.setText(Float.toString(ProductoSeleccionadoResto.getStock().getPrecio()));
            
            switch (ProductoSeleccionadoResto.getTipoProducto()) {
            case "individual":
                general.add(individual);

                break;
            case "promocion":                
                general.add(promocion);
                DataPromocion prodPromocion = (DataPromocion) ProductoSeleccionadoResto;
                descuentoProducto.setText(Integer.toString(prodPromocion.getDescuento())+"%");
                if (prodPromocion.isActiva())
                    estadoProducto.setText("Activa");
                else
                    estadoProducto.setText("Inactiva");
                
                //CARGAR LISTA DE PRODUCTOS INDIVIDUALES
                ArrayList<DataIndividualPromocion> productosIndividuales = prodPromocion.getIndividualPromocion(); // productos incluidos en la promo
                for (DataIndividualPromocion p : productosIndividuales) {
                    String[] fila = new String[3];
                    fila[0] = p.getIndividual().getNombre();
                    fila[1] = ((Integer)p.getCantidad()).toString();
                    modeloTablaProdPromo.addRow(fila);
                }
                
                
                
                break;
            }    
            //CARGAR LISTA DE PEDIDOS 
                ArrayList<DataPedido> pedidos = ProductoSeleccionadoResto.getPedidos();
                for (DataPedido p : pedidos) {
 
                    String[] fila = new String[3];
                    fila[0] = p.getNickNameCliente();
                    fila[1] = Float.toString(p.getPrecioTotal());
                    Calendar FechaPedido = p.getFechaPedido();
                    int diaHoy = FechaPedido.get(Calendar.DAY_OF_MONTH);
                    int mes=FechaPedido.get(Calendar.MONTH);
                    int año =FechaPedido.get(Calendar.YEAR);
                    fila[2] = (diaHoy)+"/"+(mes)+"/"+(año);
                     
                    
                    
                    modeloTablaPedidosDeProducto.addRow(fila);

                }
            general.repaint();
            general.revalidate();  
            ProductoSeleccionadoResto = null;
        }
        }
        
        
        
        
        
        //-----------------------
        
        
        ArrayList<DataProducto> productos = cp.listarProductos();
        System.out.println("LISTA VIENE VACIA: "+cp.listarProductos().isEmpty());
        for (DataProducto p : productos) {
            String[] fila = new String[3];
            fila[0] = p.getNombre();
            fila[1] = p.getNickName();
            fila[2] = p.getDescripcion();
            
            elProducto.put(modeloTablaProductos.getRowCount(), p);
            
            modeloTablaProductos.addRow(fila);
            
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        modeloTablaProductos = new DefaultTableModel(); modeloTablaProductos.addColumn("Producto"); modeloTablaProductos.addColumn("Restaurante"); modeloTablaProductos.addColumn("Descripción");
        productos = new javax.swing.JTable(){     public boolean isCellEditable(int row, int column) {         return (column == 23 );     } };
        jLabel2 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RestauranteProducto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descripcionProducto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tipoProducto = new javax.swing.JLabel();
        imagenProducto = new javax.swing.JLabel();
        jButtonCancelar3 = new javax.swing.JButton();
        general = new javax.swing.JPanel();
        individual = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        promocion = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        estadoProducto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        descuentoProducto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        modeloTablaProdPromo = new DefaultTableModel();
        modeloTablaProdPromo.addColumn("Producto");
        modeloTablaProdPromo.addColumn("Cantidad");
        productosDePromocion = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return (column == 23 );
            }
        };
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        modeloTablaPedidosDeProducto = new DefaultTableModel();
        modeloTablaPedidosDeProducto.addColumn("Cliente");
        modeloTablaPedidosDeProducto.addColumn("Precio total");
        modeloTablaPedidosDeProducto.addColumn("Fecha");
        pedidosDeProducto = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column) {
                return (column == 23 );
            }
        };
        jLabel10 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Productos del Sistema:");

        productos.setModel(modeloTablaProductos);
        productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre");

        nombreProducto.setText("Nickname");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Restaurante");

        RestauranteProducto.setText("Restaurante");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descripción");

        descripcionProducto.setText("Descripcion");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tipo");

        tipoProducto.setText("Tipo");

        imagenProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButtonCancelar3.setText("Cancelar");
        jButtonCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelar3ActionPerformed(evt);
            }
        });

        general.setLayout(new java.awt.CardLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Precio");

        precio.setText("Descripcion");

        javax.swing.GroupLayout individualLayout = new javax.swing.GroupLayout(individual);
        individual.setLayout(individualLayout);
        individualLayout.setHorizontalGroup(
            individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(individualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(precio)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        individualLayout.setVerticalGroup(
            individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(individualLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(precio))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        general.add(individual, "card3");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Estado");

        estadoProducto.setText("Estado");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Descuento");

        descuentoProducto.setText("Descuento");

        productosDePromocion.setModel(modeloTablaProdPromo);
        jScrollPane2.setViewportView(productosDePromocion);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Productos de la Promoción");

        javax.swing.GroupLayout promocionLayout = new javax.swing.GroupLayout(promocion);
        promocion.setLayout(promocionLayout);
        promocionLayout.setHorizontalGroup(
            promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promocionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(promocionLayout.createSequentialGroup()
                        .addGroup(promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(46, 46, 46)
                        .addGroup(promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estadoProducto)
                            .addComponent(descuentoProducto)))
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        promocionLayout.setVerticalGroup(
            promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(promocionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(estadoProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(promocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(descuentoProducto))
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        general.add(promocion, "card2");

        pedidosDeProducto.setModel(modeloTablaPedidosDeProducto);
        jScrollPane3.setViewportView(pedidosDeProducto);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Pedidos del Producto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoProducto)
                                    .addComponent(descripcionProducto)
                                    .addComponent(RestauranteProducto)
                                    .addComponent(nombreProducto))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 249, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar3)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(general, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(478, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(RestauranteProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(descripcionProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tipoProducto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar3)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(302, 302, 302)
                    .addComponent(general, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelar3ActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelar3ActionPerformed

    private void productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosMouseClicked
                int index = productos.getSelectedRow();
        String idproducto = (String) productos.getValueAt(index, 0);
        String restaurante = (String) productos.getValueAt(index, 1);
       
        if (index != -1){
            
             //se limpian los campos
            int k = modeloTablaPedidosDeProducto.getRowCount();
            for (int i = k-1; i >=0 ; i--) {
                modeloTablaPedidosDeProducto.removeRow(i);    
            }
             k = modeloTablaProdPromo.getRowCount();
            for (int i = k-1; i >=0 ; i--) {
                modeloTablaProdPromo.removeRow(i);    
            }
            nombreProducto.setText("");
            RestauranteProducto.setText("");
            descripcionProducto.setText("");
            tipoProducto.setText("");
            estadoProducto.setText("");
            descuentoProducto.setText("");
            precio.setText("");
            
            
            
            
            imagenProducto.setIcon(new ImageIcon());

            
            DataProducto productoSeleccionado = elProducto.get(productos.getSelectedRow());
            general.removeAll();        
            
            
            
            if (productoSeleccionado.getRutaImagen() == null){
               Image image = Toolkit.getDefaultToolkit().createImage(propiedades.getProperty("productoPorDefecto"));
               Icon warnIcon = new ImageIcon(image.getScaledInstance(145, 129, image.SCALE_DEFAULT));
               imagenProducto.setIcon(warnIcon);
               imagenProducto.validate();
               System.out.println("Carga la por defecto "+propiedades.getProperty("productoPorDefecto"));
            }
            else{
               Image image = Toolkit.getDefaultToolkit().createImage(productoSeleccionado.getRutaImagen());
               Icon warnIcon = new ImageIcon(image.getScaledInstance(145, 129, image.SCALE_DEFAULT));
               imagenProducto.setIcon(warnIcon);
               imagenProducto.validate();
               System.out.println("Carga la imagen "+productoSeleccionado.getRutaImagen());
            }
            
            
            
            nombreProducto.setText(productoSeleccionado.getNombre());
            RestauranteProducto.setText(productoSeleccionado.getNickName());
            descripcionProducto.setText(productoSeleccionado.getDescripcion());
            tipoProducto.setText(productoSeleccionado.getTipoProducto());
            precio.setText(Float.toString(productoSeleccionado.getStock().getPrecio()));
            
            switch (productoSeleccionado.getTipoProducto()) {
            case "individual":
                general.add(individual);

                break;
            case "promocion":                
                general.add(promocion);
                DataPromocion prodPromocion = (DataPromocion) productoSeleccionado;
                descuentoProducto.setText(Integer.toString(prodPromocion.getDescuento())+"%");
                if (prodPromocion.isActiva())
                    estadoProducto.setText("Activa");
                else
                    estadoProducto.setText("Inactiva");
                
                //CARGAR LISTA DE PRODUCTOS INDIVIDUALES
                ArrayList<DataIndividualPromocion> productosIndividuales = prodPromocion.getIndividualPromocion(); // productos incluidos en la promo
                for (DataIndividualPromocion p : productosIndividuales) {
                    String[] fila = new String[3];
                    fila[0] = p.getIndividual().getNombre();
                    fila[1] = ((Integer)p.getCantidad()).toString();
                    modeloTablaProdPromo.addRow(fila);
                }
                
               
                
                break;
            }    
             //CARGAR LISTA DE PEDIDOS 
               ArrayList<DataPedido> pedidos = productoSeleccionado.getPedidos();
                for (DataPedido p : pedidos) {
 
                    String[] fila = new String[3];
                    fila[0] = p.getNickNameCliente();
                    fila[1] = Float.toString(p.getPrecioTotal());
                    Calendar FechaPedido = p.getFechaPedido();
                    int diaHoy = FechaPedido.get(Calendar.DAY_OF_MONTH);
                    int mes=FechaPedido.get(Calendar.MONTH);
                    int año =FechaPedido.get(Calendar.YEAR);
                    fila[2] = (diaHoy)+"/"+(mes)+"/"+(año);
                    modeloTablaPedidosDeProducto.addRow(fila);
                }
            general.repaint();
            general.revalidate();    
        }                                               
    }//GEN-LAST:event_productosMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RestauranteProducto;
    private javax.swing.JLabel descripcionProducto;
    private javax.swing.JLabel descuentoProducto;
    private javax.swing.JLabel estadoProducto;
    private javax.swing.JPanel general;
    private javax.swing.JLabel imagenProducto;
    private javax.swing.JPanel individual;
    private javax.swing.JButton jButtonCancelar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nombreProducto;
    private javax.swing.JTable pedidosDeProducto;
    private DefaultTableModel modeloTablaPedidosDeProducto;
    private javax.swing.JLabel precio;
    private javax.swing.JTable productos;
    private DefaultTableModel modeloTablaProductos;
    private javax.swing.JTable productosDePromocion;
    private DefaultTableModel modeloTablaProdPromo;
    private javax.swing.JPanel promocion;
    private javax.swing.JLabel tipoProducto;
    // End of variables declaration//GEN-END:variables
}
