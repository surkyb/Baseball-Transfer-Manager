package com.techbridge.btm.view.form;

/**
 *
 * @author Surky
 */
public class FormInicio extends javax.swing.JPanel {

    /**
     * Creates new form FormJugadores
     */
    public FormInicio() {
        initComponents();
        com.techbridge.btm.controller.DashboardController dashboard = new com.techbridge.btm.controller.DashboardController();
        
        lblTotalJugadores.setText(String.valueOf(dashboard.getTotalJugadores()));
    lblTotalEquipos.setText(String.valueOf(dashboard.getTotalEquipos()));
    lblTotalTransacciones.setText(String.valueOf(dashboard.getTotalTransacciones()));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tarjetaDegradado3 = new com.techbridge.btm.view.components.TarjetaDegradado();
        jLabel2 = new javax.swing.JLabel();
        lblTotalEquipos = new javax.swing.JLabel();
        tarjetaDegradado4 = new com.techbridge.btm.view.components.TarjetaDegradado();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalJugadores = new javax.swing.JLabel();
        tarjetaDegradado5 = new com.techbridge.btm.view.components.TarjetaDegradado();
        jLabel5 = new javax.swing.JLabel();
        lblTotalTransacciones = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        imageAvatar1 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        imageAvatar2 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        imageAvatar3 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        imageAvatar4 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText(" ¡Bienvenido, Manager!");

        tarjetaDegradado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Equipos registrados");
        tarjetaDegradado3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        lblTotalEquipos.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalEquipos.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalEquipos.setText("1");
        tarjetaDegradado3.add(lblTotalEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 50, 40));

        tarjetaDegradado4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total de jugadores");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        lblTotalJugadores.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalJugadores.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalJugadores.setText("1");

        javax.swing.GroupLayout tarjetaDegradado4Layout = new javax.swing.GroupLayout(tarjetaDegradado4);
        tarjetaDegradado4.setLayout(tarjetaDegradado4Layout);
        tarjetaDegradado4Layout.setHorizontalGroup(
            tarjetaDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarjetaDegradado4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(tarjetaDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tarjetaDegradado4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        tarjetaDegradado4Layout.setVerticalGroup(
            tarjetaDegradado4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarjetaDegradado4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total de Transacciones");

        lblTotalTransacciones.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalTransacciones.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalTransacciones.setText("1");

        javax.swing.GroupLayout tarjetaDegradado5Layout = new javax.swing.GroupLayout(tarjetaDegradado5);
        tarjetaDegradado5.setLayout(tarjetaDegradado5Layout);
        tarjetaDegradado5Layout.setHorizontalGroup(
            tarjetaDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarjetaDegradado5Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(tarjetaDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tarjetaDegradado5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tarjetaDegradado5Layout.createSequentialGroup()
                        .addComponent(lblTotalTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        tarjetaDegradado5Layout.setVerticalGroup(
            tarjetaDegradado5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tarjetaDegradado5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(lblTotalTransacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("HOME");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("CON MUCHO AMOR BY: TECHBRIDGE");

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/logoBTM-removebg-preview.png"))); // NOI18N

        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/logoBTM-removebg-preview.png"))); // NOI18N
        imageAvatar1.add(imageAvatar2);
        imageAvatar2.setBounds(-60, -2, 60, 0);

        imageAvatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/logoBTM-removebg-preview.png"))); // NOI18N

        imageAvatar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/logoBTM-removebg-preview.png"))); // NOI18N
        imageAvatar3.add(imageAvatar4);
        imageAvatar4.setBounds(-60, -2, 60, 0);

        imageAvatar1.add(imageAvatar3);
        imageAvatar3.setBounds(0, 0, 0, 0);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/Captura de pantalla 2026-04-19 212947.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tarjetaDegradado3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(tarjetaDegradado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(56, 56, 56)
                        .addComponent(tarjetaDegradado5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(459, 459, 459))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tarjetaDegradado4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarjetaDegradado3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarjetaDegradado5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(208, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar1;
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar2;
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar3;
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTotalEquipos;
    private javax.swing.JLabel lblTotalJugadores;
    private javax.swing.JLabel lblTotalTransacciones;
    private com.techbridge.btm.view.components.TarjetaDegradado tarjetaDegradado3;
    private com.techbridge.btm.view.components.TarjetaDegradado tarjetaDegradado4;
    private com.techbridge.btm.view.components.TarjetaDegradado tarjetaDegradado5;
    // End of variables declaration//GEN-END:variables
}
