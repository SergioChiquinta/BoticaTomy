
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

public class PantallaPedido extends javax.swing.JFrame {
    
    private DefaultTableModel modeloTablaPedido;

    public PantallaPedido() {
        initComponents();
        configurarModeloTabla();
        cmbMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMedicamentosActionPerformed(evt);
            }
        });
        setIconImage(new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Logo_Botica.png")).getImage());
        setTitle("Botica Tomy - Launcher");
        this.setResizable(false);  // Línea para deshabilitar el redimensionamiento
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar
        this.setMinimumSize(new Dimension(1280, 800)); // Tamaño mínimo de la ventana
        // Deshabilitar la edición de los campos que deben llenarse automáticamente
        txtPrecioUni.setEnabled(false);
    }
    
    private void cmbMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedItem = (String) cmbMedicamentos.getSelectedItem();
        if (selectedItem != null) {
            String idMedicamento = selectedItem.split(" - ")[0];
            double precioUnitario = obtenerPrecioMedicamento(idMedicamento);
            txtPrecioUni.setText(String.valueOf(precioUnitario));
        }
    }
    
    private void configurarModeloTabla() {
        modeloTablaPedido = new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Medicamento", "Cantidad", "Precio Uni.", "Precio Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        tblPedido.setModel(modeloTablaPedido);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoMenuTrabajador();
        cmbMedicamentos = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioUni = new javax.swing.JTextField();
        scrollTablaPedido = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnRealizarPedido = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnVolverMenu = new javax.swing.JButton();
        jLabelFondoGuía = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbMedicamentos.setBackground(new java.awt.Color(255, 255, 255));
        cmbMedicamentos.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        cmbMedicamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un medicamento" }));
        cmbMedicamentos.setBorder(null);
        jPanel1.add(cmbMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 225, 305, 40));
        cargarMedicamentos();

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtCantidad.setBorder(null);
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(915, 225, 90, 40));

        txtPrecioUni.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioUni.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtPrecioUni.setText("0.0");
        txtPrecioUni.setBorder(null);
        jPanel1.add(txtPrecioUni, new org.netbeans.lib.awtextra.AbsoluteConstraints(1173, 226, 90, 40));

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Medicamento", "Cantidad", "Precio Uni.", "Precio Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTablaPedido.setViewportView(tblPedido);
        if (tblPedido.getColumnModel().getColumnCount() > 0) {
            tblPedido.getColumnModel().getColumn(0).setResizable(false);
            tblPedido.getColumnModel().getColumn(1).setResizable(false);
            tblPedido.getColumnModel().getColumn(2).setResizable(false);
            tblPedido.getColumnModel().getColumn(3).setResizable(false);
            tblPedido.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(scrollTablaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 750, 310));

        btnAgregar.setBackground(new java.awt.Color(244, 250, 251));
        btnAgregar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(23, 34, 77));
        btnAgregar.setBorder(null);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 600, 125, 47));

        btnRealizarPedido.setBackground(new java.awt.Color(244, 250, 251));
        btnRealizarPedido.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnRealizarPedido.setForeground(new java.awt.Color(23, 34, 77));
        btnRealizarPedido.setBorder(null);
        btnRealizarPedido.setContentAreaFilled(false);
        btnRealizarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRealizarPedido.setFocusPainted(false);
        btnRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRealizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 600, 263, 47));

        btnQuitar.setBackground(new java.awt.Color(244, 250, 251));
        btnQuitar.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(23, 34, 77));
        btnQuitar.setBorder(null);
        btnQuitar.setContentAreaFilled(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.setFocusPainted(false);
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 600, 125, 47));

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

        jLabelFondoGuía.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Pedido.png"))); // NOI18N
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        agregarMedicamento();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        quitarMedicamento();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoActionPerformed
        // TODO add your handling code here:
        realizarPedido();
    }//GEN-LAST:event_btnRealizarPedidoActionPerformed

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
        try (Connection conn = Conexion.getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ID_MED, NOM_MED, PRE_MED, STO_MED FROM MEDICAMENTO")) {
            
            while (rs.next()) {
                int stock = rs.getInt("STO_MED");
                String item = rs.getString("ID_MED") + " - " + rs.getString("NOM_MED") + " (Stock: " + stock + ")";
                if (stock > 0) {
                    cmbMedicamentos.addItem(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private double obtenerPrecioMedicamento(String idMedicamento) {
        double precio = 0.0;
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT PRE_MED FROM MEDICAMENTO WHERE ID_MED = ?")) {
            ps.setString(1, idMedicamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    precio = rs.getDouble("PRE_MED");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return precio;
    }
    
    private void agregarMedicamento() {
        String selectedItem = (String) cmbMedicamentos.getSelectedItem();

        // Verificar si se seleccionó un medicamento válido
        if (selectedItem != null && !selectedItem.equals("Seleccione un medicamento")) {
            if (!txtCantidad.getText().isEmpty() && !txtPrecioUni.getText().isEmpty()) {
                try {
                    String idMedicamento = selectedItem.split(" - ")[0];
                    String nombreMedicamento = selectedItem.split(" - ")[1].split(" \\(Stock: ")[0];
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    double precioUnitario = Double.parseDouble(txtPrecioUni.getText());
                    double precioTotal = cantidad * precioUnitario;

                    modeloTablaPedido.addRow(new Object[]{idMedicamento, nombreMedicamento, cantidad, precioUnitario, precioTotal});
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos para la cantidad y el precio unitario.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un medicamento válido.", "Selección inválida", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void quitarMedicamento() {
        int selectedRow = tblPedido.getSelectedRow();
        if (selectedRow >= 0) {
            modeloTablaPedido.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }

    private void realizarPedido() {
        if (tblPedido.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, agregue productos antes de realizar el pedido.");
            return;
        }

        try (Connection con = Conexion.getConexion()) {
            con.setAutoCommit(false);

            String dniCliente = obtenerDniCliente();
            if (dniCliente == null) {
                con.rollback();
                return;
            }

            int idVenta = insertarVenta(con, dniCliente);
            if (idVenta == 0) {
                con.rollback();
                return;
            }

            double totalVenta = procesarProductosSeleccionados(con, idVenta);
            actualizarTotalVenta(con, idVenta, totalVenta);
            insertarFactura(con, idVenta, totalVenta);
            generarYAlmacenarReporte(con, idVenta, dniCliente, totalVenta);
            actualizarComboBoxMedicamentos(con);

            con.commit();
            JOptionPane.showMessageDialog(this, "Pedido realizado con éxito.");

            DefaultTableModel model = (DefaultTableModel) tblPedido.getModel();
            model.setRowCount(0);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al realizar el pedido: " + e.getMessage());
        }
    }

    private String obtenerDniCliente() {
        String dniCliente = UsuarioActual.getInstancia().getDni();
        if (dniCliente == null || dniCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ha encontrado el DNI del cliente.");
            return null;
        }
        if (!dniCliente.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "El DNI debe ser numérico.");
            return null;
        }
        return dniCliente;
    }
    
    private int insertarVenta(Connection con, String dniCliente) throws SQLException {
        String sqlVenta = "INSERT INTO VENTA (DNI_CLI, TOT_VEN) VALUES (?, 0)";
        try (PreparedStatement psVenta = con.prepareStatement(sqlVenta, Statement.RETURN_GENERATED_KEYS)) {
            psVenta.setString(1, dniCliente);
            psVenta.executeUpdate();
            try (ResultSet rs = psVenta.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    private double procesarProductosSeleccionados(Connection con, int idVenta) throws SQLException {
        double totalVenta = 0.0;
        String sqlDetalleVenta = "INSERT INTO DETALLE_VENTA (ID_VEN, ID_MED, CAN_DET, PRE_UNI) VALUES (?, ?, ?, ?)";
        String sqlActualizarStock = "UPDATE MEDICAMENTO SET STO_MED = STO_MED - ? WHERE ID_MED = ?";

        try (PreparedStatement psDetalleVenta = con.prepareStatement(sqlDetalleVenta);
             PreparedStatement psActualizarStock = con.prepareStatement(sqlActualizarStock)) {

            for (int i = 0; i < tblPedido.getRowCount(); i++) {
                try {
                    int idMedicamento = Integer.parseInt(tblPedido.getValueAt(i, 0).toString());
                    String nombreMedicamento = (String) tblPedido.getValueAt(i, 1);
                    int cantidad = Integer.parseInt(tblPedido.getValueAt(i, 2).toString());
                    double precioUnitario = Double.parseDouble(tblPedido.getValueAt(i, 3).toString());

                    psDetalleVenta.setInt(1, idVenta);
                    psDetalleVenta.setInt(2, idMedicamento);
                    psDetalleVenta.setInt(3, cantidad);
                    psDetalleVenta.setDouble(4, precioUnitario);
                    psDetalleVenta.addBatch();

                    psActualizarStock.setInt(1, cantidad);
                    psActualizarStock.setInt(2, idMedicamento);
                    psActualizarStock.addBatch();

                    totalVenta += precioUnitario * cantidad;
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw e;
                }
            }

            psDetalleVenta.executeBatch();
            psActualizarStock.executeBatch();
        }

        return totalVenta;
    }
    
    private void actualizarTotalVenta(Connection con, int idVenta, double totalVenta) throws SQLException {
        String sqlActualizarTotal = "UPDATE VENTA SET TOT_VEN = ? WHERE ID_VEN = ?";
        try (PreparedStatement psActualizarTotal = con.prepareStatement(sqlActualizarTotal)) {
            psActualizarTotal.setDouble(1, totalVenta);
            psActualizarTotal.setInt(2, idVenta);
            psActualizarTotal.executeUpdate();
        }
    }

    private void insertarFactura(Connection con, int idVenta, double totalVenta) throws SQLException {
        String sqlFactura = "INSERT INTO FACTURA (ID_VEN, TOT_FAC, EST_FAC) VALUES (?, ?, ?)";
        try (PreparedStatement psFactura = con.prepareStatement(sqlFactura)) {
            psFactura.setInt(1, idVenta);
            psFactura.setDouble(2, totalVenta);
            psFactura.setString(3, "Pendiente");
            psFactura.executeUpdate();
        }
    }

    private void generarYAlmacenarReporte(Connection con, int idVenta, String dniCliente, double totalVenta) throws SQLException {
        String reporteHtml = generarReporteHtml(con, idVenta, dniCliente, totalVenta);
        String sqlReporteVenta = "INSERT INTO REPORTE_VENTAS (ID_VEN, TIP_VEN, REPORTE) VALUES (?, ?, ?)";
        try (PreparedStatement psReporteVenta = con.prepareStatement(sqlReporteVenta)) {
            psReporteVenta.setInt(1, idVenta);
            psReporteVenta.setString(2, "Venta");
            psReporteVenta.setString(3, reporteHtml);
            psReporteVenta.executeUpdate();
        }
    }

    // Método para generar el reporte HTML de la venta
    private String generarReporteHtml(Connection con, int idVenta, String dniCliente, double totalVenta) throws SQLException {
        StringBuilder html = new StringBuilder();
        html.append("<html><head>")
            .append("<style>")
            .append("body { font-family: Arial, sans-serif; }")
            .append("h1 { color: #333; }")
            .append("h2 { color: #333; }")
            .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
            .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
            .append("th { background-color: #f2f2f2; }")
            .append("tr:nth-child(even) { background-color: #f9f9f9; }")
            .append("tr:hover { background-color: #f1f1f1; }")
            .append("p { margin: 5px 0; }")
            .append("</style>")
            .append("</head><body>");

        html.append("<h1>Reporte de Venta</h1>");
        html.append("<p><strong>ID Venta:</strong> ").append(idVenta).append("</p>");
        html.append("<p><strong>DNI Cliente:</strong> ").append(dniCliente).append("</p>");
        html.append("<p><strong>Total Venta:</strong> S/. ").append(totalVenta).append("</p>");
        html.append("<p><strong>Fecha de Venta:</strong> ").append(new java.util.Date()).append("</p>");
        html.append("<h2>Detalles de los Productos</h2>");

        String sqlDetalleVenta = "SELECT m.NOM_MED, dv.CAN_DET, dv.PRE_UNI " +
                                 "FROM DETALLE_VENTA dv " +
                                 "JOIN MEDICAMENTO m ON dv.ID_MED = m.ID_MED " +
                                 "WHERE dv.ID_VEN = ?";
        try (PreparedStatement psDetalleVenta = con.prepareStatement(sqlDetalleVenta)) {
            psDetalleVenta.setInt(1, idVenta);
            try (ResultSet rs = psDetalleVenta.executeQuery()) {
                html.append("<table>");
                html.append("<tr><th>Producto</th><th>Cantidad</th><th>Precio Unitario</th><th>Total</th></tr>");
                while (rs.next()) {
                    String nombreProducto = rs.getString("NOM_MED");
                    int cantidad = rs.getInt("CAN_DET");
                    double precioUnitario = rs.getDouble("PRE_UNI");
                    double totalProducto = cantidad * precioUnitario;
                    html.append("<tr>")
                        .append("<td>").append(nombreProducto).append("</td>")
                        .append("<td>").append(cantidad).append("</td>")
                        .append("<td>").append(precioUnitario).append("</td>")
                        .append("<td>").append(totalProducto).append("</td>")
                        .append("</tr>");
                }
                html.append("</table>");
            }
        }

        html.append("</body></html>");
        return html.toString();
    }

    private void actualizarComboBoxMedicamentos(Connection con) {
        try {
            // Consulta SQL para obtener los medicamentos y sus stock actuales
            String sql = "SELECT ID_MED, NOM_MED, STO_MED FROM MEDICAMENTO";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Limpiar el JComboBox antes de agregar los nuevos items
            cmbMedicamentos.removeAllItems();

            // Agregar los medicamentos con su stock actual al JComboBox
            while (rs.next()) {
                String idMedicamento = rs.getString("ID_MED");
                String nombreMedicamento = rs.getString("NOM_MED");
                int stock = rs.getInt("STO_MED");

                // Formato: ID_MED - Nombre Medicamento (Stock: cantidad)
                cmbMedicamentos.addItem(idMedicamento + " - " + nombreMedicamento + " (Stock: " + stock + ")");
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el stock de medicamentos: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRealizarPedido;
    private javax.swing.JButton btnVolverMenu;
    private javax.swing.JComboBox<String> cmbMedicamentos;
    private javax.swing.JLabel jLabelFondoGuía;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTablaPedido;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecioUni;
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
