
package boticatomy.vista;

import boticatomy.modelo.UsuarioModeloRegistro;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;

public class Registro extends JFrame {
    
    // Declaración e inicialización del panel personalizado FondoRegistro
    FondoRegistro fondoRegistro = new FondoRegistro();

    // Constructor de la clase Registro
    public Registro() {
        // Establece fondoRegistro como el panel principal (ContentPane) del JFrame actual
        this.setContentPane(fondoRegistro);
        // Inicializa los componentes de la interfaz gráfica generados automáticamente
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Logo_Botica.png")).getImage());
        setTitle("Botica Tomy - Launcher");
        this.setResizable(false);  // Línea para deshabilitar el redimensionamiento
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar
        this.setMinimumSize(new Dimension(1280, 800)); // Tamaño mínimo de la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        txtTelefono1 = new javax.swing.JTextField();
        jPanel1 = new FondoRegistro();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnRegistrarse = new javax.swing.JButton();
        btnVolverLogin = new javax.swing.JButton();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabelFondoGuía = new javax.swing.JLabel();

        txtTelefono1.setEditable(false);
        txtTelefono1.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono1.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtTelefono1.setForeground(new java.awt.Color(107, 105, 105));
        txtTelefono1.setBorder(null);
        txtTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(107, 105, 105));
        txtNombre.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(122, 563, 0, 0);
        jPanel1.add(txtNombre, gridBagConstraints);

        txtApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(107, 105, 105));
        txtApellido.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(122, 67, 0, 0);
        jPanel1.add(txtApellido, gridBagConstraints);

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(107, 105, 105));
        txtCorreo.setBorder(null);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 563, 0, 0);
        jPanel1.add(txtCorreo, gridBagConstraints);

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(107, 105, 105));
        txtContraseña.setBorder(null);
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 563, 0, 0);
        jPanel1.add(txtContraseña, gridBagConstraints);

        txtDni.setBackground(new java.awt.Color(255, 255, 255));
        txtDni.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtDni.setForeground(new java.awt.Color(107, 105, 105));
        txtDni.setBorder(null);
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 67, 0, 0);
        jPanel1.add(txtDni, gridBagConstraints);

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(107, 105, 105));
        txtTelefono.setBorder(null);
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 290;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 67, 0, 0);
        jPanel1.add(txtTelefono, gridBagConstraints);

        btnRegistrarse.setBackground(new java.awt.Color(244, 250, 251));
        btnRegistrarse.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnRegistrarse.setForeground(new java.awt.Color(23, 34, 77));
        btnRegistrarse.setBorder(null);
        btnRegistrarse.setContentAreaFilled(false);
        btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarse.setFocusPainted(false);
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 260;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(45, 765, 0, 0);
        jPanel1.add(btnRegistrarse, gridBagConstraints);

        btnVolverLogin.setBackground(new java.awt.Color(244, 250, 251));
        btnVolverLogin.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnVolverLogin.setForeground(new java.awt.Color(23, 34, 77));
        btnVolverLogin.setBorder(null);
        btnVolverLogin.setContentAreaFilled(false);
        btnVolverLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolverLogin.setFocusPainted(false);
        btnVolverLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 160;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(130, 87, 0, 0);
        jPanel1.add(btnVolverLogin, gridBagConstraints);

        cmbTipo.setBackground(new java.awt.Color(244, 250, 251));
        cmbTipo.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(7, 44, 117));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Trabajador" }));
        cmbTipo.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 197;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 730, 0, 0);
        jPanel1.add(cmbTipo, gridBagConstraints);

        jLabelFondoGuía.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Registro.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabelFondoGuía, gridBagConstraints);

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

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        // Obtener y recortar los valores de los campos de texto
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String dni = txtDni.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contraseña = txtContraseña.getText().trim();
        String tipo = cmbTipo.getSelectedItem().toString(); 

        // Verificar si algún campo está vacío
        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty() ||
            correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
        } else {
            try {
                // Crear una instancia del usuario
                UsuarioModeloRegistro usuario = new UsuarioModeloRegistro(nombre, apellido, dni, telefono, correo, contraseña, tipo);
                // Intentar registrar el usuario con los datos proporcionados
                UsuarioModeloRegistro.registrarUsuario(usuario);
                JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
                LimpiarCampos();
                new Login().setVisible(true); // Mostrar la ventana de inicio de sesión
                dispose(); // Cerrar la ventana actual (de registro)
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al registrar el usuario");
            }
        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnVolverLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverLoginActionPerformed
        // Obtener la instancia de la ventana de inicio de sesión
        Login loginWindow = Login.getInstancia();
        // Hacer visible la ventana de inicio de sesión
        loginWindow.setVisible(true);
        // Cerrar la ventana actual (la ventana de registro)
        this.dispose();
    }//GEN-LAST:event_btnVolverLoginActionPerformed

    private void txtTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono1ActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void LimpiarCampos() {
        // Limpiar los campos del formulario de registro
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDni.setText("");
        txtCorreo.setText("");
        txtContraseña.setText("");
    }
    
    public static void main(String[] args) {
        new Registro().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnVolverLogin;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabelFondoGuía;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables

    class FondoRegistro extends JPanel {
        private Image imagen;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            imagen = new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Panel.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
