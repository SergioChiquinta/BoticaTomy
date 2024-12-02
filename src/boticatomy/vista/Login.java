
package boticatomy.vista;

import boticatomy.controlador.UsuarioActual;
import boticatomy.controlador.UsuarioControlador;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame {

    private static Login instancia;
    FondoLogin FondoLogin = new FondoLogin();
    UsuarioControlador usuarioControlador = new UsuarioControlador(); // Instancia del controlador
    
    public Login() {
        this.setContentPane(FondoLogin);
        initComponents();
        checkbox1.addItemListener(evt -> checkboxMostrarContraseña(evt));
        txtContraseña.setEchoChar('•'); // Ocultar texto con "•"
        checkbox1.addItemListener(new java.awt.event.ItemListener() { //Funcionalidad para el checkbox contraseña se actualice
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxMostrarContraseña(evt);
            }
        });
        txtContraseña.setEchoChar('•'); // Ocultar texto con "•"
        setIconImage(new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Logo_Botica.png")).getImage());
        setTitle("Botica Tomy - Launcher");
        this.setResizable(false);  // Línea para deshabilitar el redimensionamiento
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar
        this.setMinimumSize(new Dimension(1280, 800)); // Tamaño mínimo de la ventana
    }
    
    public static Login getInstancia() {
        // Verificar si la instancia de la clase Login es nula
        if (instancia == null) {
            // Si es nula, crear una nueva instancia de la clase Login
            instancia = new Login();
        }
        // Devolver la instancia única de la clase Login
        return instancia;
    }

    private void login() {
        String correoOusuario = txtCorreo.getText();
        String contraseña = new String(txtContraseña.getPassword());

        try {
            boolean autenticado = usuarioControlador.autenticar(correoOusuario, contraseña);
            if (autenticado) {
                // Obtener el tipo de usuario desde la instancia singleton
                String tipoUsuario = UsuarioActual.getInstancia().getTipoUsuario().trim();
                System.out.println("Tipo de usuario: '" + tipoUsuario + "'"); // Imprimir para depuración
                UsuarioActual usuarioActual = UsuarioActual.getInstancia();
                JOptionPane.showMessageDialog(this, "¡Bienvenido " + usuarioActual.getNombreUsuario() + "!");
                LimpiarCampos();
                // Abrir la siguiente pantalla
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
            } else {
                JOptionPane.showMessageDialog(this, "Correo, nombre de usuario o contraseña incorrectos");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos");
        }
    }

    private void LimpiarCampos() {
        txtCorreo.setText("");
        txtContraseña.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new FondoLogin();
        btnLogin = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        checkbox1 = new java.awt.Checkbox();
        jLabelFondoGuíaLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnLogin.setBackground(new java.awt.Color(244, 250, 251));
        btnLogin.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(23, 34, 77));
        btnLogin.setToolTipText("");
        btnLogin.setBorder(null);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 264;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(43, 752, 0, 0);
        jPanel1.add(btnLogin, gridBagConstraints);

        txtCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreo.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(107, 105, 105));
        txtCorreo.setBorder(null);
        txtCorreo.setSelectionColor(new java.awt.Color(107, 105, 105));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 345;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 712, 0, 0);
        jPanel1.add(txtCorreo, gridBagConstraints);

        btnRegistro.setBackground(new java.awt.Color(244, 250, 251));
        btnRegistro.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(23, 34, 77));
        btnRegistro.setBorder(null);
        btnRegistro.setContentAreaFilled(false);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setFocusPainted(false);
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 40;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(150, 943, 0, 0);
        jPanel1.add(btnRegistro, gridBagConstraints);

        txtContraseña.setBackground(new java.awt.Color(255, 255, 255));
        txtContraseña.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(107, 105, 105));
        txtContraseña.setBorder(null);
        txtContraseña.setSelectionColor(new java.awt.Color(107, 105, 105));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 345;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 712, 0, 0);
        jPanel1.add(txtContraseña, gridBagConstraints);

        checkbox1.setBackground(new java.awt.Color(255, 255, 255));
        checkbox1.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        checkbox1.setForeground(new java.awt.Color(0, 0, 0));
        checkbox1.setLabel(" Ver Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = -4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 925, 0, 0);
        jPanel1.add(checkbox1, gridBagConstraints);

        jLabelFondoGuíaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Login.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabelFondoGuíaLogin, gridBagConstraints);

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

    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Funcionalidad del botón mediante el llamado al método login
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // Crear una nueva instancia de la ventana de registro
        Registro registro = new Registro();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void checkboxMostrarContraseña(java.awt.event.ItemEvent evt) {                                          
        // Verificar si el checkbox está seleccionado
        if (checkbox1.getState()) {
            // Si está seleccionado, mostrar la contraseña en texto claro
            txtContraseña.setEchoChar((char) 0);
        } else {
            // Si no está seleccionado, ocultar la contraseña usando un carácter de asterisco
            txtContraseña.setEchoChar('•');
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistro;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JLabel jLabelFondoGuíaLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    
    class FondoLogin extends JPanel {
        private Image imagen;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            imagen = new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Panel.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
