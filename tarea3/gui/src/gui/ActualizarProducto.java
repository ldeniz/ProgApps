/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datatype.DataIndividualPromocion;
import datatype.DataProducto;
import datatype.DataPromocion;
import fabrica.Fabrica;
import interfaces.IControladorProducto;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mathi
 */
public class ActualizarProducto extends javax.swing.JInternalFrame {
    IControladorProducto cp = Fabrica.getInstance().obtenerControladorProducto();
    HashMap<Integer, DataProducto> elProducto = new HashMap<>();
    Properties propiedades = new Properties();
    DataProducto productoSeleccionado;
    
    private
        String imagenSrc,NombreArchivo,outFile;

    /**
     * Creates new form ActualizarProducto
     */
    public ActualizarProducto() {
        imagenSrc="";
        NombreArchivo="";
        outFile="";
         //Carga Archivo de Propiedades ----------------------
        
        InputStream entrada = null;
        try {               
            entrada = this.getClass().getResourceAsStream("/Resources/config.properties");
            propiedades.load(entrada);
            } 
        catch (IOException ex) {
            ex.printStackTrace();
        } 
        //---------------------------------------------------
        initComponents();
        
        ArrayList<DataProducto> productos = cp.listarProductos();
        
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

        losRadio = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionProducto = new javax.swing.JTextArea();
        PanelGenerico1 = new javax.swing.JPanel();
        panelIndividual1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        precioProducto = new javax.swing.JTextField();
        panelPromocion = new javax.swing.JPanel();
        jRadioButtonActivado = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        descuentoProducto = new javax.swing.JTextField();
        jRadioButtonDesactivado = new javax.swing.JRadioButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        imagenProducto = new javax.swing.JLabel();
        jButtonImage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        modeloTablaProductos = new DefaultTableModel(); modeloTablaProductos.addColumn("Producto"); modeloTablaProductos.addColumn("Restaurante"); modeloTablaProductos.addColumn("Descripción");
        productos = new javax.swing.JTable(){     public boolean isCellEditable(int row, int column) {         return (column == 23 );     } };

        setTitle("Actualizar Producto");

        jLabel1.setText("Productos");

        jLabel2.setText("Nombre");

        jLabel3.setText("Descripción");

        descripcionProducto.setColumns(20);
        descripcionProducto.setRows(5);
        jScrollPane2.setViewportView(descripcionProducto);

        PanelGenerico1.setLayout(new java.awt.CardLayout());

        jLabel6.setText("Precio");

        javax.swing.GroupLayout panelIndividual1Layout = new javax.swing.GroupLayout(panelIndividual1);
        panelIndividual1.setLayout(panelIndividual1Layout);
        panelIndividual1Layout.setHorizontalGroup(
            panelIndividual1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIndividual1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );
        panelIndividual1Layout.setVerticalGroup(
            panelIndividual1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIndividual1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIndividual1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        PanelGenerico1.add(panelIndividual1, "card2");

        losRadio.add(jRadioButtonActivado);
        jRadioButtonActivado.setText("Activado");

        jLabel7.setText("Descuento (%)");

        losRadio.add(jRadioButtonDesactivado);
        jRadioButtonDesactivado.setText("Desactivado");

        javax.swing.GroupLayout panelPromocionLayout = new javax.swing.GroupLayout(panelPromocion);
        panelPromocion.setLayout(panelPromocionLayout);
        panelPromocionLayout.setHorizontalGroup(
            panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromocionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descuentoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jRadioButtonActivado)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonDesactivado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPromocionLayout.setVerticalGroup(
            panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPromocionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPromocionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(descuentoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButtonActivado)
                    .addComponent(jRadioButtonDesactivado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelGenerico1.add(panelPromocion, "card3");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabel4.setText("Imagen");

        imagenProducto.setBackground(new java.awt.Color(0, 0, 0));
        imagenProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButtonImage.setText("Seleccionar Imagen");
        jButtonImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImageActionPerformed(evt);
            }
        });

        productos.setModel(modeloTablaProductos);
        productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCancelar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jButtonActualizar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(nombreProducto))
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonImage))
                                    .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PanelGenerico1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(imagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(335, 335, 335)
                    .addComponent(PanelGenerico1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImageActionPerformed
       FileFilter filter = new FileNameExtensionFilter("Imagenes (.jpg .png)","jpg", "png");

        JFileChooser elegirImagen = new JFileChooser();
        elegirImagen.setAcceptAllFileFilterUsed(false);
        elegirImagen.addChoosableFileFilter(filter);
        int opt = elegirImagen.showOpenDialog(jButtonImage);

        
        if (opt == JFileChooser.APPROVE_OPTION) {
            imagenSrc = elegirImagen.getSelectedFile().getPath();
            NombreArchivo = elegirImagen.getSelectedFile().getName(); 
            if(!imagenSrc.isEmpty()){   

                //Carga Archivo de Propiedades ----------------------
                Properties propiedades = new Properties();
                InputStream entrada = null;
                try {               
                    entrada = this.getClass().getResourceAsStream("/Resources/config.properties");
                    propiedades.load(entrada);
                    } 
                catch (IOException ex) {
                    ex.printStackTrace();
                } 
                //---------------------------------------------------
                
                
                
            
            }
        }
    }//GEN-LAST:event_jButtonImageActionPerformed

    private void productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosMouseClicked
        int index = productos.getSelectedRow();
        String idproducto = (String) productos.getValueAt(index, 0);
        String restaurante = (String) productos.getValueAt(index, 1);
        
        
        jRadioButtonActivado.setSelected(true);
        jRadioButtonDesactivado.setSelected(false);
        nombreProducto.setText("");
        descripcionProducto.setText("");
        precioProducto.setText("");
        descuentoProducto.setText("");
        PanelGenerico1.removeAll();    
        
        if (index != -1){

            imagenProducto.setIcon(new ImageIcon());

            productoSeleccionado = elProducto.get(productos.getSelectedRow());
            

            if (productoSeleccionado.getRutaImagen() == null){
                Image image = Toolkit.getDefaultToolkit().createImage(propiedades.getProperty("productoPorDefecto"));
                Icon warnIcon = new ImageIcon(image.getScaledInstance(imagenProducto.getWidth(), imagenProducto.getHeight(), image.SCALE_DEFAULT));
                imagenProducto.setIcon(warnIcon);
                imagenProducto.validate();
                System.out.println("Carga la por defecto "+propiedades.getProperty("productoPorDefecto"));
            }
            else{
                Image image = Toolkit.getDefaultToolkit().createImage(productoSeleccionado.getRutaImagen());
                Icon warnIcon = new ImageIcon(image.getScaledInstance(imagenProducto.getWidth(), imagenProducto.getHeight(), image.SCALE_DEFAULT));
                imagenProducto.setIcon(warnIcon);
                imagenProducto.validate();
                System.out.println("Carga la imagen "+productoSeleccionado.getRutaImagen());
            }

            nombreProducto.setText(productoSeleccionado.getNombre());
            descripcionProducto.setText(productoSeleccionado.getDescripcion());
            
            System.out.println("PRDUCTO "+productoSeleccionado.getTipoProducto());    
            switch (productoSeleccionado.getTipoProducto()) {
            case "individual":
                PanelGenerico1.add(panelIndividual1);
                precioProducto.setText(Float.toString(productoSeleccionado.getStock().getPrecio()));
                break;
            case "promocion":                
                PanelGenerico1.add(panelPromocion);
                DataPromocion prodPromocion = (DataPromocion) productoSeleccionado;
                descuentoProducto.setText(Integer.toString(prodPromocion.getDescuento()));
                if (prodPromocion.isActiva()){
                    jRadioButtonActivado.setSelected(true);
                    jRadioButtonDesactivado.setSelected(false);
                }
                else{
                    jRadioButtonActivado.setSelected(false);
                    jRadioButtonDesactivado.setSelected(true);
                }
                                
                break;
            }    
            PanelGenerico1.repaint();
            PanelGenerico1.revalidate();
        }
    }//GEN-LAST:event_productosMouseClicked

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed

        boolean actualizar = false;
        outFile = productoSeleccionado.getRutaImagen();
        System.out.println("LA IAMGEN TIENE: "+imagenSrc);
        if(!imagenSrc.isEmpty()){
        try{
                     
            String inFile = imagenSrc;

            String Extension = NombreArchivo.substring(NombreArchivo.lastIndexOf("."),NombreArchivo.length());
            outFile = propiedades.getProperty("imagenesProductos")+nombreProducto.getText()+"-"+productoSeleccionado.getNickName()+Extension;

            System.out.println(inFile);
            System.out.println(outFile);

            FileInputStream fis = new FileInputStream(inFile); //inFile -> Archivo a copiar
            FileOutputStream fos = new FileOutputStream(outFile); //outFile -> Copia del archivo

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            inChannel.transferTo(0, inChannel.size(), outChannel);
            fis.close();
            fos.close();

           }catch (IOException ioe) {
            System.err.println("Error al Generar Copia");
           }
        }     
        
        if("".equals(nombreProducto.getText())){
            JOptionPane.showMessageDialog(this, "El nombre del producto no puede estar vacío", "", JOptionPane.WARNING_MESSAGE);
        }
        else if((cp.existeProducto(productoSeleccionado.getNickName(),nombreProducto.getText())) && !nombreProducto.getText().equals(productoSeleccionado.getNombre())) {
            
               JOptionPane.showMessageDialog(this, "Ya existe un producto con ese nombre en este Restaurante", "", JOptionPane.WARNING_MESSAGE); 
            
        }
        else{
               if(!(productoSeleccionado.getTipoProducto()=="promocion"))
               {
                   if ("".equals(precioProducto.getText())){
                       JOptionPane.showMessageDialog(this, "El precio del producto no puede estar vacío", "", JOptionPane.WARNING_MESSAGE);
                   }
                   else if(!precioProducto.getText().matches("[-+]?\\d*\\.?\\d+")){
                       JOptionPane.showMessageDialog(this, "El precio del producto debe ser numérico", "", JOptionPane.WARNING_MESSAGE);
                   }
                   else{
                        String aux = precioProducto.getText();
                        Float price = Float.parseFloat(aux);
      
                        cp.seleccionarRestaurante(productoSeleccionado.getNickName());
                        cp.CargarDatosModificarProducto(productoSeleccionado.getNombre(),nombreProducto.getText(),descripcionProducto.getText(),outFile,price);
                        cp.ModificarProducto();
                        actualizar = true;
                        JOptionPane.showMessageDialog(this,"Producto INDIVIDUAL actualizado");
                   }
               }
               else{ //promocion
                   if("".equals(descuentoProducto.getText())){
                       
                       JOptionPane.showMessageDialog(this, "El descuento no puede ser vacío", "", JOptionPane.WARNING_MESSAGE);
                   }
                   else if(!descuentoProducto.getText().matches("[-+]?\\d*\\.?\\d+")) {
                       JOptionPane.showMessageDialog(this, "El descuento del producto debe ser numérico", "", JOptionPane.WARNING_MESSAGE);
                                         
                   }
                   else{
                       Integer desc;
                       String aux = descuentoProducto.getText();
                       desc = Integer.parseInt(aux);
                       boolean act;
                       if (jRadioButtonActivado.isSelected())
                           act = true;
                       else
                           act = false;
                       

                       
                       System.out.println("seleccionarRestaurante: "+productoSeleccionado.getNickName());
                       System.out.println("CargarDatosModificarProducto: "+nombreProducto.getText()+" , "+descripcionProducto.getText()+" , "+outFile+" , "+desc+" , "+act);
                       cp.seleccionarRestaurante(productoSeleccionado.getNickName());
                       cp.CargarDatosModificarProducto(productoSeleccionado.getNombre(),nombreProducto.getText(),descripcionProducto.getText(),outFile,desc,act);
                       cp.ModificarProducto();
                       actualizar = true;
                       
                       JOptionPane.showMessageDialog(this,"Producto PROMOCION actualizado");
                   }
               }
        }
        if (actualizar){
            actualizar = false;
            nombreProducto.setText("");
            descripcionProducto.setText("");
            descuentoProducto.setText("");
            precioProducto.setText("");
            imagenSrc = "";
            imagenProducto.setIcon(new ImageIcon());
            int k = modeloTablaProductos.getRowCount();
            for (int i = k-1; i >= 0; i--) {
                modeloTablaProductos.removeRow(i);    
            }
            ArrayList<DataProducto> productos = cp.listarProductos();
            for (DataProducto p : productos) {
            String[] fila = new String[3];
            fila[0] = p.getNombre();
            fila[1] = p.getNickName();
            fila[2] = p.getDescripcion();
            
            elProducto.put(modeloTablaProductos.getRowCount(), p);
            
            modeloTablaProductos.addRow(fila);
            
            
        }
        PanelGenerico1.removeAll();
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGenerico1;
    private javax.swing.JTextArea descripcionProducto;
    private javax.swing.JTextField descuentoProducto;
    private javax.swing.JLabel imagenProducto;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonActivado;
    private javax.swing.JRadioButton jRadioButtonDesactivado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup losRadio;
    private javax.swing.JTextField nombreProducto;
    private javax.swing.JPanel panelIndividual1;
    private javax.swing.JPanel panelPromocion;
    private javax.swing.JTextField precioProducto;
    private javax.swing.JTable productos;
    private DefaultTableModel modeloTablaProductos;
    // End of variables declaration//GEN-END:variables
}
