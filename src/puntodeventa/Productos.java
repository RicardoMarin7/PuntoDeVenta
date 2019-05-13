/*
 * Hecho por Ricardo Marin
 */
package puntodeventa;

import puntodeventa.TextPrompt;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicListUI;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author Ricardo Marin
 */
public class Productos extends javax.swing.JFrame {
    PuntoDeVenta obj = new PuntoDeVenta();
    /**
     * Creates new form AñadirProducto
     */
    
    
    public Productos() {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        TextPrompt placeholder = new TextPrompt("Nombre del Producto",NombreProducto);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
        
        TextPrompt placeholder2 = new TextPrompt("Precio del Producto",PrecioProducto);
        placeholder2.changeAlpha(0.75f);
        placeholder2.changeStyle(Font.ITALIC);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuClick = new javax.swing.JPopupMenu();
        ModificarProducto = new javax.swing.JMenuItem();
        BorrarProducto = new javax.swing.JMenuItem();
        ID = new javax.swing.JTextField();
        ID_LB = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        ModNombreProducto = new javax.swing.JTextField();
        ModPrecioProducto = new javax.swing.JTextField();
        ModificarProductoLB = new javax.swing.JLabel();
        AñadirLB = new javax.swing.JLabel();
        NombreProducto = new javax.swing.JTextField();
        PrecioProducto = new javax.swing.JTextField();
        NombreLB = new javax.swing.JLabel();
        PrecioLB = new javax.swing.JLabel();
        Añadir = new javax.swing.JButton();
        Productos = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        Minimizar = new javax.swing.JLabel();
        Cerrar = new javax.swing.JLabel();
        NombreLB1 = new javax.swing.JLabel();
        PrecioLB1 = new javax.swing.JLabel();
        Barra = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        MenuClick.setBackground(new java.awt.Color(251, 177, 207));
        MenuClick.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        MenuClick.setForeground(new java.awt.Color(60, 38, 27));
        MenuClick.setBorder(null);
        MenuClick.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ModificarProducto.setBackground(new java.awt.Color(251, 177, 207));
        ModificarProducto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        ModificarProducto.setForeground(new java.awt.Color(60, 38, 27));
        ModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/orden.png"))); // NOI18N
        ModificarProducto.setText("Modificar Producto");
        ModificarProducto.setToolTipText("");
        ModificarProducto.setBorder(null);
        ModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarProductoActionPerformed(evt);
            }
        });
        MenuClick.add(ModificarProducto);

        BorrarProducto.setBackground(new java.awt.Color(251, 177, 207));
        BorrarProducto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        BorrarProducto.setForeground(new java.awt.Color(60, 38, 27));
        BorrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        BorrarProducto.setText("Borrar Producto");
        BorrarProducto.setBorder(null);
        BorrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BorrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarProductoActionPerformed(evt);
            }
        });
        MenuClick.add(BorrarProducto);

        setName("Añadir Producto"); // NOI18N
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID.setEditable(false);
        ID.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(60, 38, 27));
        ID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 110, 20));

        ID_LB.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        ID_LB.setForeground(new java.awt.Color(60, 38, 27));
        ID_LB.setText("ID:");
        getContentPane().add(ID_LB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 20, 20));

        Modificar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        Modificar.setForeground(new java.awt.Color(60, 38, 27));
        Modificar.setText("Modificar");
        Modificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 38, 27), 2, true));
        Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 90, 30));

        ModNombreProducto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        ModNombreProducto.setForeground(new java.awt.Color(60, 38, 27));
        ModNombreProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(ModNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 240, 20));

        ModPrecioProducto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        ModPrecioProducto.setForeground(new java.awt.Color(60, 38, 27));
        ModPrecioProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(ModPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 240, 20));

        ModificarProductoLB.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        ModificarProductoLB.setForeground(new java.awt.Color(60, 38, 27));
        ModificarProductoLB.setText("Modificar Producto");
        getContentPane().add(ModificarProductoLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 240, 30));

        AñadirLB.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        AñadirLB.setForeground(new java.awt.Color(60, 38, 27));
        AñadirLB.setText("Añadir Producto");
        getContentPane().add(AñadirLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 220, 30));

        NombreProducto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        NombreProducto.setForeground(new java.awt.Color(60, 38, 27));
        NombreProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(NombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 240, 20));

        PrecioProducto.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        PrecioProducto.setForeground(new java.awt.Color(60, 38, 27));
        PrecioProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(PrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 240, 20));

        NombreLB.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        NombreLB.setForeground(new java.awt.Color(60, 38, 27));
        NombreLB.setText("Nombre:");
        getContentPane().add(NombreLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 70, 20));

        PrecioLB.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        PrecioLB.setForeground(new java.awt.Color(60, 38, 27));
        PrecioLB.setText("Precio:");
        getContentPane().add(PrecioLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 60, 20));

        Añadir.setBackground(new java.awt.Color(255, 255, 255));
        Añadir.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        Añadir.setForeground(new java.awt.Color(60, 38, 27));
        Añadir.setText("Añadir");
        Añadir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 38, 27), 2, true));
        Añadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirActionPerformed(evt);
            }
        });
        getContentPane().add(Añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 90, 30));

        Productos.setBackground(new java.awt.Color(60, 38, 27));
        Productos.setForeground(new java.awt.Color(60, 38, 27));
        Productos.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 12)); // NOI18N

        TablaProductos.setAutoCreateRowSorter(true);
        TablaProductos.setBackground(new java.awt.Color(60, 38, 27));
        TablaProductos.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        TablaProductos.setForeground(new java.awt.Color(255, 255, 255));
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre del Producto", "Precio", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaProductos.setComponentPopupMenu(MenuClick);
        TablaProductos.setGridColor(new java.awt.Color(60, 38, 27));
        TablaProductos.setSelectionBackground(new java.awt.Color(78, 182, 172));
        TablaProductos.setSelectionForeground(new java.awt.Color(60, 38, 27));
        TablaProductos.getTableHeader().setResizingAllowed(false);
        TablaProductos.getTableHeader().setReorderingAllowed(false);
        Productos.setViewportView(TablaProductos);

        getContentPane().add(Productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 550, 410));

        Minimizar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        Minimizar.setForeground(new java.awt.Color(255, 255, 255));
        Minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png"))); // NOI18N
        Minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizarMouseClicked(evt);
            }
        });
        getContentPane().add(Minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, -1, 30));

        Cerrar.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 14)); // NOI18N
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png"))); // NOI18N
        Cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarMouseClicked(evt);
            }
        });
        getContentPane().add(Cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, 30));

        NombreLB1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        NombreLB1.setForeground(new java.awt.Color(60, 38, 27));
        NombreLB1.setText("Nombre:");
        getContentPane().add(NombreLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 20));

        PrecioLB1.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        PrecioLB1.setForeground(new java.awt.Color(60, 38, 27));
        PrecioLB1.setText("Precio:");
        getContentPane().add(PrecioLB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 60, 20));

        Barra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barra.jpg"))); // NOI18N
        getContentPane().add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirActionPerformed
        if(NombreProducto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"El nombre no puede estar vacio");
        }
        
        else if(PrecioProducto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El precio no puede estar vacio");
        }
        
        else{
            if(obj.isNumeric(PrecioProducto.getText())){
                if(obj.añadirProducto(NombreProducto.getText(), PrecioProducto.getText())){
                    JOptionPane.showMessageDialog(null, "Producto añadido con éxito.");
                    NombreProducto.setText("");
                    PrecioProducto.setText("");
                    TablaProductos.setModel(PuntoDeVenta.consultarProductos());
                }
                else
                    JOptionPane.showMessageDialog(null, "Error al añadir el producto");
            }
            
            else
                JOptionPane.showMessageDialog(null, "El precio solo debe contener numeros");
        }
    }//GEN-LAST:event_AñadirActionPerformed

    private void CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_CerrarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        TablaProductos.setModel(PuntoDeVenta.consultarProductos());
        TablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }//GEN-LAST:event_formWindowOpened

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        if(ID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione una fila despues haga click derecho para modificar");
        }
        
        else{
            if(ModNombreProducto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
            }
            else if(ModPrecioProducto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El campo precio no puede estar vacio");
            }
            else if(!obj.isNumeric(ModPrecioProducto.getText())){
                JOptionPane.showMessageDialog(null, "El precio solo debe contener numeros");
            }
            else{
                if(obj.modificarProducto(ID.getText(),ModNombreProducto.getText(),ModPrecioProducto.getText())){
                    JOptionPane.showMessageDialog(null, "Producto modificado con éxito");
                    ModNombreProducto.setText("");
                    ID.setText("");
                    PrecioProducto.setText("");
                    TablaProductos.setModel(PuntoDeVenta.consultarProductos());
                }
                else{
                    JOptionPane.showMessageDialog(null, "El producto no pudo modificarse");
                }
            }
        }
    }//GEN-LAST:event_ModificarActionPerformed

    private void MinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinimizarMouseClicked

    private void ModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarProductoActionPerformed
       if(TablaProductos.getSelectedRow()== -1){
           JOptionPane.showMessageDialog(null, "Seleccione una fila despues haga click derecho para modificar");
       }
       else{
           ID.setText(String.valueOf(TablaProductos.getModel().getValueAt(TablaProductos.getSelectedRow(),0)));
           ModNombreProducto.setText(String.valueOf(TablaProductos.getModel().getValueAt(TablaProductos.getSelectedRow(),1)));
           ModPrecioProducto.setText(String.valueOf(TablaProductos.getModel().getValueAt(TablaProductos.getSelectedRow(),2)));                   
           
       }
    }//GEN-LAST:event_ModificarProductoActionPerformed

    private void BorrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarProductoActionPerformed
        if(TablaProductos.getSelectedRow()== -1){
           JOptionPane.showMessageDialog(null, "Seleccione una fila despues haga click derecho para eliminar");
       }
       else{
            if(JOptionPane.showConfirmDialog(this,"Seguro que desea eliminar el producto:"+
                    TablaProductos.getModel().getValueAt(TablaProductos.getSelectedRow(),0)+"?") == 0){
                    if(PuntoDeVenta.borrarProducto(String.valueOf(TablaProductos.getModel().getValueAt(TablaProductos.getSelectedRow(),0)))){
                        JOptionPane.showMessageDialog(this, "El producto se ha borrado con éxito");
                        TablaProductos.setModel(PuntoDeVenta.consultarProductos());
                        UI.TablaProductos.setModel(PuntoDeVenta.consultarProductos());
                    }
                    else
                        JOptionPane.showMessageDialog(this, "El producto no se ha podido borrar");
            }
           
       }
    }//GEN-LAST:event_BorrarProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadir;
    private javax.swing.JLabel AñadirLB;
    private javax.swing.JLabel Barra;
    private javax.swing.JMenuItem BorrarProducto;
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel ID_LB;
    private javax.swing.JPopupMenu MenuClick;
    private javax.swing.JLabel Minimizar;
    private javax.swing.JTextField ModNombreProducto;
    private javax.swing.JTextField ModPrecioProducto;
    private javax.swing.JButton Modificar;
    private javax.swing.JMenuItem ModificarProducto;
    private javax.swing.JLabel ModificarProductoLB;
    private javax.swing.JLabel NombreLB;
    private javax.swing.JLabel NombreLB1;
    private javax.swing.JTextField NombreProducto;
    private javax.swing.JLabel PrecioLB;
    private javax.swing.JLabel PrecioLB1;
    private javax.swing.JTextField PrecioProducto;
    private javax.swing.JScrollPane Productos;
    public static javax.swing.JTable TablaProductos;
    // End of variables declaration//GEN-END:variables
}
