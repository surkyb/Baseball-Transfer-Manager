package com.techbridge.btm.view;

import com.techbridge.btm.view.event.EventMenu;
import com.techbridge.btm.view.form.FormAcercaDe;
import com.techbridge.btm.view.form.FormComparar;
import com.techbridge.btm.view.form.FormEquipos;
import com.techbridge.btm.view.form.FormEstadisticas;
import com.techbridge.btm.view.form.FormInicio;
import com.techbridge.btm.view.form.FormJugadores;
import com.techbridge.btm.view.form.FormTransferencias;
import java.awt.Color;
import java.awt.Component;

/**
 *
 * @author surky
 */
public class Dashboard extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard.class.getName());

    /**
     * Creates new form dashboardPruebaS
     */
   
    public Dashboard() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));

        EventMenu event = new EventMenu() {
            @Override
            public void selected(int index) {
                procesarNavegacion(index);
            }
        };

        miMenu2.initMenu(event);
        showForm(new FormInicio());

    }
    /**
     * Se encarga de enrutar la aplicación según el índice seleccionado en el menú lateral.
     */
    private void procesarNavegacion(int index) {
        switch (index) {
            case 0:
                showForm(new FormInicio());
                break;
            case 1:
                showForm(new FormJugadores());
                break;
            case 2: 
                showForm(new FormEquipos());
                break;
            case 3: 
                showForm(new FormTransferencias());
                break;
            case 4:
                showForm(new FormEstadisticas());
                break;
            case 5:
                showForm(new FormComparar());
                break;
            case 6:
                showForm(new FormAcercaDe());
                break;
            case 7:
                cerrarSesion();
                break;
            default: 
                break;
        }
    }

    /**
     * Maneja el flujo de seguridad para cerrar la sesión actual y volver al Login.
     */
    private void cerrarSesion() {
        int confirmacion = javax.swing.JOptionPane.showConfirmDialog(
                this, 
                "¿Estás seguro de que deseas cerrar sesión?",
                "Cerrar Sesión",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
            
            // Cerramos el Dashboard
            this.dispose();

            // Volvemos a instanciar el LoginJFrame
            java.awt.EventQueue.invokeLater(() -> {
                com.techbridge.btm.repository.UsuarioRepository repo = new com.techbridge.btm.repository.UsuarioRepositoryImpl();
                com.techbridge.btm.service.AuthService service = new com.techbridge.btm.service.AuthService(repo);
                com.techbridge.btm.controller.UsuarioController controller = new com.techbridge.btm.controller.UsuarioController(service);

                LoginJFrame loginView = new LoginJFrame(controller);
                loginView.setVisible(true);
            });
        }
    
    }
        private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header1 = new com.techbridge.btm.view.components.Header();
        miMenu2 = new com.techbridge.btm.view.components.Menu();
        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        roundPanel1.setBackground(new java.awt.Color(243, 241, 241));

        header1.setBackground(new java.awt.Color(255, 255, 255));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setForeground(new java.awt.Color(0, 0, 0));
        body.setToolTipText("");
        body.setOpaque(false);
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(miMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Dashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private com.techbridge.btm.view.components.Header header1;
    private com.techbridge.btm.view.components.Menu miMenu2;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
