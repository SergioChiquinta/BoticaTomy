
package boticatomy.vista;

import boticatomy.controlador.UsuarioActual;
import boticatomy.modelo.Conexion;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class PantallaInventario extends javax.swing.JFrame {

    public PantallaInventario() {
        initComponents();
        cargarMedicamentos();
        setIconImage(new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Logo_Botica.png")).getImage());
        setTitle("Botica Tomy - Launcher");
        this.setResizable(false);  // Línea para deshabilitar el redimensionamiento
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar
        this.setMinimumSize(new Dimension(1280, 800)); // Tamaño mínimo de la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPantallaInventario();
        btnActualizarStock = new javax.swing.JButton();
        btnInsertarMedicamento = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicamentos = new javax.swing.JTable();
        btnVolverMenu = new javax.swing.JButton();
        jLabelFondoGuía = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizarStock.setBackground(new java.awt.Color(244, 250, 251));
        btnActualizarStock.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnActualizarStock.setForeground(new java.awt.Color(23, 34, 77));
        btnActualizarStock.setBorder(null);
        btnActualizarStock.setContentAreaFilled(false);
        btnActualizarStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarStock.setFocusPainted(false);
        btnActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarStockActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 600, 263, 47));

        btnInsertarMedicamento.setBackground(new java.awt.Color(244, 250, 251));
        btnInsertarMedicamento.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnInsertarMedicamento.setForeground(new java.awt.Color(23, 34, 77));
        btnInsertarMedicamento.setBorder(null);
        btnInsertarMedicamento.setContentAreaFilled(false);
        btnInsertarMedicamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertarMedicamento.setFocusPainted(false);
        btnInsertarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarMedicamentoActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 600, 263, 47));

        tblMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Medicamento", "Código", "Precio Unitario", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tblMedicamentos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 750, 350));

        btnVolverMenu.setBackground(new java.awt.Color(244, 250, 251));
        btnVolverMenu.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnVolverMenu.setForeground(new java.awt.Color(23, 34, 77));
        btnVolverMenu.setBorder(null);
        btnVolverMenu.setContentAreaFilled(false);
        btnVolverMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverMenu.setFocusPainted(false);
        btnVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(756, 706, 265, 60));

        jLabelFondoGuía.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Inventario.png"))); // NOI18N
        jPanel1.add(jLabelFondoGuía, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarStockActionPerformed
        // TODO add your handling code here:
        actualizarStock();
    }//GEN-LAST:event_btnActualizarStockActionPerformed

    private void btnInsertarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarMedicamentoActionPerformed
        // TODO add your handling code here:
        insertarMedicamento();
    }//GEN-LAST:event_btnInsertarMedicamentoActionPerformed

    private void btnVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuActionPerformed
        // Obtener el tipo de usuario desde la instancia singleton
        String tipoUsuario = UsuarioActual.getInstancia().getTipoUsuario().trim();
        System.out.println("Tipo de usuario: '" + tipoUsuario + "'"); // Imprimir para depuración
        UsuarioActual usuarioActual = UsuarioActual.getInstancia();
        // Realizar la comparación del tipo de usuario
        if ("Cliente".equalsIgnoreCase(tipoUsuario)) {
            PantallaMenuCliente pmCliente = new PantallaMenuCliente();
            pmCliente.setVisible(true);
        } else if ("Trabajador".equalsIgnoreCase(tipoUsuario)) {
            PantallaMenuTrabajador pmTrab = new PantallaMenuTrabajador();
            pmTrab.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de usuario no reconocido");
        }
        dispose(); // Cerrar la ventana actual
    }//GEN-LAST:event_btnVolverMenuActionPerformed

    private void cargarMedicamentos() {
        DefaultTableModel model = (DefaultTableModel) tblMedicamentos.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ID_MED, NOM_MED, COD_MED, PRE_MED, STO_MED FROM MEDICAMENTO")) {

            while (rs.next()) {
                int id = rs.getInt("ID_MED");
                String nombre = rs.getString("NOM_MED");
                String codigo = rs.getString("COD_MED");
                double precio = rs.getDouble("PRE_MED");
                int stock = rs.getInt("STO_MED");
                model.addRow(new Object[]{id, nombre, codigo, precio, stock});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los medicamentos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertarMedicamento() {
        String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del medicamento:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre del medicamento no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String precioStr = JOptionPane.showInputDialog(this, "Ingrese el precio unitario:");
        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio unitario debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String stockStr = JOptionPane.showInputDialog(this, "Ingrese el stock:");
        int stock;
        try {
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El stock debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement()) {

            // Obtener el próximo ID de la tabla MEDICAMENTO
            ResultSet rs = stmt.executeQuery("SELECT MAX(ID_MED) FROM MEDICAMENTO");
            int nextId = (rs.next() ? rs.getInt(1) + 1 : 1);
            String codigo = String.format("MED%03d", nextId);

            // Insertar el nuevo medicamento
            String sql = "INSERT INTO MEDICAMENTO (NOM_MED, COD_MED, PRE_MED, STO_MED) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, codigo);
                pstmt.setDouble(3, precio);
                pstmt.setInt(4, stock);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Medicamento insertado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al insertar el medicamento.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Recargar la tabla de medicamentos
        cargarMedicamentos();
    }

    private void actualizarStock() {
        int selectedRow = tblMedicamentos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un medicamento para actualizar el stock.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String idStr = tblMedicamentos.getValueAt(selectedRow, 0).toString();
        int id = Integer.parseInt(idStr);

        String stockStr = JOptionPane.showInputDialog(this, "Ingrese el nuevo stock:");
        int stock;
        try {
            stock = Integer.parseInt(stockStr);
            if (stock < 0) {
                throw new NumberFormatException("El stock no puede ser negativo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El stock debe ser un número válido y no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = Conexion.getConexion()) {
            String sql = "UPDATE MEDICAMENTO SET STO_MED = ? WHERE ID_MED = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, stock);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Stock actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el stock.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Recargar la tabla de medicamentos
        cargarMedicamentos();
    }

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
            java.util.logging.Logger.getLogger(PantallaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JButton btnInsertarMedicamento;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JLabel jLabelFondoGuía;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedicamentos;
    // End of variables declaration//GEN-END:variables

    class FondoPantallaInventario extends JPanel {
        private Image imagen;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            imagen = new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Panel.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
