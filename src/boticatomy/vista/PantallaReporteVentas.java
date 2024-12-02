
package boticatomy.vista;

import boticatomy.controlador.UsuarioActual;
import boticatomy.modelo.Conexion;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PantallaReporteVentas extends javax.swing.JFrame {

    public PantallaReporteVentas() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Logo_Botica.png")).getImage());
        setTitle("Botica Tomy - Launcher");
        this.setResizable(false);  // Línea para deshabilitar el redimensionamiento
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar
        this.setMinimumSize(new Dimension(1280, 800)); // Tamaño mínimo de la ventana
        // Inicializar la tabla y cargar datos
        cargarReportes();

        // Configurar la tabla para escuchar eventos de selección
        tblReportes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tblReportes.getSelectedRow();
                    if (selectedRow != -1) {
                        int idReporte = (int) tblReportes.getValueAt(selectedRow, 0);
                        cargarReporteHtml(idReporte);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoMenuTrabajador();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        editorPaneReporte = new javax.swing.JEditorPane();
        btnImprimir = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        jLabelFondoGuía = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IdReporte", "IdVenta", "TipoVenta", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReportes);
        if (tblReportes.getColumnModel().getColumnCount() > 0) {
            tblReportes.getColumnModel().getColumn(0).setResizable(false);
            tblReportes.getColumnModel().getColumn(1).setResizable(false);
            tblReportes.getColumnModel().getColumn(2).setResizable(false);
            tblReportes.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 410, 410));

        jScrollPane2.setViewportView(editorPaneReporte);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 220, 360, 410));

        btnImprimir.setBackground(new java.awt.Color(244, 250, 251));
        btnImprimir.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(23, 34, 77));
        btnImprimir.setBorder(null);
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setFocusPainted(false);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 640, 265, 50));

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

        jLabelFondoGuía.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_ReporteVentas.png"))); // NOI18N
        jPanel1.add(jLabelFondoGuía, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        try {
            // Intentar imprimir el contenido del JEditorPane
            boolean completo = editorPaneReporte.print();
            if (completo) {
                // Mensaje de éxito
                JOptionPane.showMessageDialog(null, "Impresión completa.", "Resultado de la impresión", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mensaje de cancelación
                JOptionPane.showMessageDialog(null, "Impresión cancelada.", "Resultado de la impresión", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            // Mensaje de error
            JOptionPane.showMessageDialog(null, "Error de impresión: " + pe.getMessage(), "Resultado de la impresión", JOptionPane.ERROR_MESSAGE);
            pe.printStackTrace();
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cargarReportes() {
        DefaultTableModel model = (DefaultTableModel) tblReportes.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        try (Connection con = Conexion.getConexion()) { // Usar la clase Conexion para obtener la conexión
            if (con != null) {
                String sql = "SELECT ID_REP, ID_VEN, TIP_VEN, FEC_REP FROM REPORTE_VENTAS";
                try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        int idReporte = rs.getInt("ID_REP");
                        int idVenta = rs.getInt("ID_VEN");
                        String tipoVenta = rs.getString("TIP_VEN");
                        Timestamp fechaReporte = rs.getTimestamp("FEC_REP");
                        model.addRow(new Object[]{idReporte, idVenta, tipoVenta, fechaReporte});
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarReporteHtml(int idReporte) {
        try (Connection con = Conexion.getConexion()) { // Usar la clase Conexion para obtener la conexión
            if (con != null) {
                String sql = "SELECT REPORTE FROM REPORTE_VENTAS WHERE ID_REP = ?";
                try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                    pstmt.setInt(1, idReporte);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            String htmlContent = rs.getString("REPORTE");
                            editorPaneReporte.setContentType("text/html");
                            editorPaneReporte.setText(htmlContent);
                        } else {
                            System.out.println("No se encontró el reporte con ID: " + idReporte);
                        }
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(PantallaReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaReporteVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaReporteVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JEditorPane editorPaneReporte;
    private javax.swing.JLabel jLabelFondoGuía;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblReportes;
    // End of variables declaration//GEN-END:variables

    class FondoMenuTrabajador extends JPanel {
        private Image imagen;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            imagen = new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Panel.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
