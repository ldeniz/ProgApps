/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datatype.DataCategoria;
import datatype.DataCliente;
import datatype.DataProducto;
import datatype.DataRestaurante;
import fabrica.Fabrica;
import interfaces.IControladorCategoria;
import interfaces.IControladorPedido;
import interfaces.IControladorProducto;
import interfaces.IControladorUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Mathi
 */
public class GenerarPedido extends javax.swing.JInternalFrame {

    private Object[][] dataClientes;
    private IControladorUsuario iUsr = Fabrica.getInstance().obtenerControladorUsuario();
    private IControladorProducto iProd = Fabrica.getInstance().obtenerControladorProducto();
    private IControladorPedido iPed = Fabrica.getInstance().obtenerControladorPedido();
    ;
    
    private DefaultTreeModel modelo;
    private DataRestaurante restSelected;

    private DefaultListModel modeloOut = new DefaultListModel();
    private DefaultTableModel modeloIn = (new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Producto", "Cantidad"
            }
    ));
    private Object dpc;

    /**
     * Creates new form GenerarPedido
     */
    public GenerarPedido() {

        //LISTAR LOS CLIENTES
        ArrayList<Object[]> temp = new ArrayList();
        ArrayList<DataCliente> clientes = iUsr.listarClientes();
        Object[] current;

        for (DataCliente c : clientes) {
            current = new Object[]{c.getNickname(), c.getMail(), c};
            temp.add(current);
        }

        dataClientes = temp.toArray(new Object[temp.size()][3]);

        //LISTAR LOS RESTAURANTES
        IControladorCategoria cCat = Fabrica.getInstance().obtenerControladorCategoria();

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Categorias");
        modelo = new DefaultTreeModel(root);
        JTree tree = new JTree(modelo);

        List<DataCategoria> categorias = cCat.listarCategorias();
        DefaultMutableTreeNode aux;

        for (DataCategoria cat : categorias) {

            if (!cat.getDataRestaurantes().isEmpty()) {
                aux = new DefaultMutableTreeNode(cat.getNombre());
                root.add(aux);
                for (DataRestaurante rest : cat.getDataRestaurantes()) {
                    aux.add(new DefaultMutableTreeNode(rest));
                }
            }
        }

        initComponents();

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
        jTableClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        restaurantes = new javax.swing.JTree(modelo);
        jLabel3 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        panelPromocion = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        modeloProductos =new DefaultListModel();
        listaProductos = new javax.swing.JList(){    public boolean isCellEditable(int row, int column) {         return (column == 23 );     }};
        jButtonAgregar = new javax.swing.JButton();
        jButtonQuitar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaProductos2 = new javax.swing.JTable(){     public boolean isCellEditable(int row, int column) {         return (column == 23 );     } };
        cantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setTitle("Generar Pedido");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Seleccione un Cliente:");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel( dataClientes,  new String [] { "Nickname", "Mail" }){
            public boolean isCellEditable(int row, int column) {
                return (column == 23 );
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Seleccione un Restaurante:");

        restaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restaurantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(restaurantes);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Seleccione los Productos:");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        listaProductos.setModel(modeloProductos);
        jScrollPane5.setViewportView(listaProductos);

        jButtonAgregar.setText(">>");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonQuitar.setText("<<");
        jButtonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarActionPerformed(evt);
            }
        });

        listaProductos2.setModel(modeloIn);
        jScrollPane3.setViewportView(listaProductos2);

        cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidad.setText("1");
        cantidad.setToolTipText("");

        jLabel8.setText("Cantidad");

        javax.swing.GroupLayout panelPromocionLayout = new javax.swing.GroupLayout(panelPromocion);
        panelPromocion.setLayout(panelPromocionLayout);
        panelPromocionLayout.setHorizontalGroup(
            panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromocionLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonQuitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
        );
        panelPromocionLayout.setVerticalGroup(
            panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromocionLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPromocionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonQuitar)
                        .addGap(23, 23, 23)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRegistrar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(panelPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPromocion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        int index = listaProductos.getSelectedIndex();
        if (index != -1) {
            String[] fila = new String[2];
            fila[0] = (String) modeloProductos.getElementAt(index);
            fila[1] = this.cantidad.getText();
            modeloIn.addRow(fila);
            modeloProductos.remove(index);
            this.cantidad.setText("1");

        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jButtonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarActionPerformed
        int index = listaProductos2.getSelectedRow();
        if (index != -1) {
            modeloProductos.addElement(modeloIn.getValueAt(index, 0));
            modeloIn.removeRow(index);

        }
    }//GEN-LAST:event_jButtonQuitarActionPerformed

    private void restaurantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantesMouseClicked
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) restaurantes.getLastSelectedPathComponent();
        if ((node != null) && (node.isLeaf())) {
            restSelected = (DataRestaurante) node.getUserObject();
            ArrayList<DataProducto> productos = restSelected.getDataProductos();

            modeloProductos.clear();

            while (modeloIn.getRowCount() != 0) {
                modeloIn.removeRow(0);
            }

            for (DataProducto p : productos) {
                modeloProductos.addElement(p.getNombre());
            }
        }
    }//GEN-LAST:event_restaurantesMouseClicked

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        int i = jTableClientes.getSelectedRow();
        DataCliente c = (DataCliente) dataClientes[i][2];
        String clienteSeleccionado = c.getNickname();
        String restauranteSeleccionado = restSelected.getNickname();
        
        if ("".equals(clienteSeleccionado)) 
            JOptionPane.showMessageDialog(this,"Debe seleccionar un cliente");
         
        else if ("".equals(restauranteSeleccionado))
            JOptionPane.showMessageDialog(this,"Debe seleccionar un restaurante");
        
        else if (modeloIn.getRowCount() == 0)
            JOptionPane.showMessageDialog(this,"Debe seleccionar al menos un producto");
            
        else{
                        
            int cantProductos = modeloIn.getRowCount();
            int j = 0;
            String aux1 = (String) modeloIn.getValueAt(j, 1);
            while ((j < cantProductos) && (!"".equals(aux1))) {
                aux1 = (String) modeloIn.getValueAt(j, 1);
                j++;
            }
            if ("".equals(aux1)) {
                JOptionPane.showMessageDialog(this,"Debe seleccionar las cantidades que desea para todos los productos");
            }else{
                try {
                    iPed.seleccionarCliente(clienteSeleccionado);
                } catch (Exception ex) {
                    Logger.getLogger(GenerarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    iPed.seleccionarRestaurante(restSelected.getNickname());
                } catch (Exception ex) {
                    Logger.getLogger(GenerarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int p = 0; p < cantProductos; p++) {
                    String prod = (String) modeloIn.getValueAt(p, 0);
                    String aux = (String) modeloIn.getValueAt(p, 1);
                    int cant = Integer.parseInt(aux);
                    try {
                        System.out.println("Seagrega Producto: "+prod+" con cantidad "+cant);
                        iPed.seleccionarProducto(restauranteSeleccionado, prod, cant);
                    } catch (Exception ex) {
                        Logger.getLogger(GenerarPedido.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    iPed.finalizarPedido();    


                    String mensaje = "PEDIDO EN CAMINO!!\n\nEl pedido de "+clienteSeleccionado+" a "+restauranteSeleccionado+" se solicitó correctamente";



                    JOptionPane.showMessageDialog(this,mensaje);
                    this.setVisible(false);
                    
                    
                    
            }
            
            
            
        }        
                
    }//GEN-LAST:event_jButtonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonQuitar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JList listaProductos;
    private DefaultListModel modeloProductos;
    private javax.swing.JTable listaProductos2;
    private javax.swing.JPanel panelPromocion;
    private javax.swing.JTree restaurantes;
    // End of variables declaration//GEN-END:variables
}
