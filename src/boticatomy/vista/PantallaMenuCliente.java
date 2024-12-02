
package boticatomy.vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PantallaMenuCliente extends javax.swing.JFrame {

    public PantallaMenuCliente() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Logo_Botica.png")).getImage());
        setTitle("Botica Tomy - Launcher Cliente");
        this.setResizable(false);  // Línea para deshabilitar el redimensionamiento
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar ventana al iniciar
        this.setMinimumSize(new Dimension(1280, 800)); // Tamaño mínimo de la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoMenuCliente();
        btnPedido = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jLabelFondoGuía = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPedido.setBorder(null);
        btnPedido.setBorderPainted(false);
        btnPedido.setContentAreaFilled(false);
        btnPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedido.setFocusPainted(false);
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 300, 125, 50));

        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 665, 265, 60));

        jLabelFondoGuía.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_MenuCliente.png"))); // NOI18N
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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // Mostrar un cuadro de diálogo de confirmación
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea cerrar sesión?", "Confirmar Cierre de Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Verificar la respuesta del usuario
        if (respuesta == JOptionPane.YES_OPTION) {
            // Obtener una instancia de la ventana de inicio de sesión (Interfaz) y mostrarla
            Login loginWindow = Login.getInstancia();
            loginWindow.setVisible(true);
            // Cerrar la ventana actual
            this.dispose();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        // Obtener una instancia de la ventana de Pedido y mostrarla
        PantallaPedido pp = new PantallaPedido();
        pp.setVisible(true);
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_btnPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaMenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnPedido;
    private javax.swing.JLabel jLabelFondoGuía;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    class FondoMenuCliente extends JPanel {
        private Image imagen;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            imagen = new ImageIcon(getClass().getResource("/boticatomy/vista/img_pantallas/Fondo_Panel.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }

}
