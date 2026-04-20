package com.techbridge.btm.view.form;

/**
 *
 * @author Surky
 */
public class FormComparar extends javax.swing.JPanel {

    /**
     * Creates new form FormJugadores
     */
    public FormComparar() {
        initComponents();
        jTable1.getTableHeader().setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setBackground(new java.awt.Color(33, 83, 126)); 
                setForeground(java.awt.Color.WHITE); //  blanca

                setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));

                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255, 50)));

                return this;
            }
        });

        if (jTable1.getParent() != null) {
            jTable1.getParent().setBackground(java.awt.Color.WHITE);
        }

        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);

        jTable1.setGridColor(new java.awt.Color(200, 200, 200));

        jTable1.setRowHeight(30);

        jTable1.getTableHeader().setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setBackground(new java.awt.Color(33, 83, 126));
                setForeground(java.awt.Color.WHITE);

                setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));

                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255, 50)));

                return this;
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Obtenemos exactamente en qué fila y columna se hizo el clic
                int filaAfectada = jTable1.rowAtPoint(evt.getPoint());
                int columnaAfectada = jTable1.columnAtPoint(evt.getPoint());

                if (columnaAfectada == 7 && filaAfectada >= 0) {

                    //  tomsmos el valor de la celda 
                    Object valorCelda = jTable1.getValueAt(filaAfectada, 1);
                    // si ta vacia
                    if (valorCelda == null || valorCelda.toString().trim().isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(
                                null,
                                "La celda está vacía. No hay ningún jugador para eliminar en esta fila.",
                                "Aviso",
                                javax.swing.JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }

                    String nombreJugador = valorCelda.toString();
                    int opcion = javax.swing.JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás absolutamente seguro de eliminar a " + nombreJugador + " del sistema?\nEsta acción borrará todos sus contratos y no se puede deshacer.",
                            "Eliminar Jugador",
                            javax.swing.JOptionPane.YES_NO_OPTION,
                            javax.swing.JOptionPane.ERROR_MESSAGE
                    );

                    //Si el usuario dice "Si"
                    if (opcion == javax.swing.JOptionPane.YES_OPTION) {
                        // boolean exito = controller.eliminarJugador(nombreJugador);

                        //aqui para borrar de la bd
                        // if(exito) javax.swing.table.DefaultTableModel) jTable1.getModel()).removeRow(filaAfectada)
                        //    javax.swing.JOptionPane.showMessageDialog(null, "Jugador eliminado.")
                        // }
                        System.out.println(" Jugador " + nombreJugador + " eliminado (Simulación).");
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJugadoresExistentes = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header22 = new com.techbridge.btm.view.components.Header2();
        header24 = new com.techbridge.btm.view.components.Header2();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        roundPanel3 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header23 = new com.techbridge.btm.view.components.Header2();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxBuscador2 = new com.techbridge.btm.view.dashboard.swing.ComboBoxBuscador();
        roundPanel4 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header21 = new com.techbridge.btm.view.components.Header2();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboBoxBuscador1 = new com.techbridge.btm.view.dashboard.swing.ComboBoxBuscador();
        roundPanel5 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        buttonMenu1 = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();

        setBackground(new java.awt.Color(242, 241, 246));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setOpaque(false);

        pnlJugadoresExistentes.setBackground(new java.awt.Color(255, 255, 255));

        header22.setBackground(new java.awt.Color(33, 83, 126));

        header24.setBackground(new java.awt.Color(33, 83, 126));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Historial Completo de Transferencias");

        javax.swing.GroupLayout header24Layout = new javax.swing.GroupLayout(header24);
        header24.setLayout(header24Layout);
        header24Layout.setHorizontalGroup(
            header24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header24Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header24Layout.setVerticalGroup(
            header24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout header22Layout = new javax.swing.GroupLayout(header22);
        header22.setLayout(header22Layout);
        header22Layout.setHorizontalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        header22Layout.setVerticalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ESTADÍSTICA", "JUGADOR A", "JUGADOR B", "DIFERENCIA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlJugadoresExistentesLayout = new javax.swing.GroupLayout(pnlJugadoresExistentes);
        pnlJugadoresExistentes.setLayout(pnlJugadoresExistentesLayout);
        pnlJugadoresExistentesLayout.setHorizontalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addGroup(pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(header22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlJugadoresExistentesLayout.setVerticalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addComponent(header22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Comparar Jugadores");

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        header23.setBackground(new java.awt.Color(33, 83, 126));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jugador B");

        javax.swing.GroupLayout header23Layout = new javax.swing.GroupLayout(header23);
        header23.setLayout(header23Layout);
        header23Layout.setHorizontalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(57, 57, 57))
        );
        header23Layout.setVerticalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Seleccionar Jugador");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel8))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(comboBoxBuscador2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addComponent(header23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(comboBoxBuscador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        roundPanel4.setBackground(new java.awt.Color(255, 255, 255));

        header21.setBackground(new java.awt.Color(33, 83, 126));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jugador A");

        javax.swing.GroupLayout header21Layout = new javax.swing.GroupLayout(header21);
        header21.setLayout(header21Layout);
        header21Layout.setHorizontalGroup(
            header21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header21Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header21Layout.setVerticalGroup(
            header21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Seleccionar Jugador");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGroup(roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7))
                    .addGroup(roundPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(comboBoxBuscador1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addComponent(header21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(comboBoxBuscador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        roundPanel5.setBackground(new java.awt.Color(191, 39, 57));

        buttonMenu1.setText("Actualizar comparacion");
        buttonMenu1.addActionListener(this::buttonMenu1ActionPerformed);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(buttonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addComponent(buttonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)))
                .addGap(18, 18, 18)
                .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMenu1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu buttonMenu1;
    private com.techbridge.btm.view.dashboard.swing.ComboBoxBuscador comboBoxBuscador1;
    private com.techbridge.btm.view.dashboard.swing.ComboBoxBuscador comboBoxBuscador2;
    private com.techbridge.btm.view.components.Header2 header21;
    private com.techbridge.btm.view.components.Header2 header22;
    private com.techbridge.btm.view.components.Header2 header23;
    private com.techbridge.btm.view.components.Header2 header24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlJugadoresExistentes;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel3;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel4;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel5;
    // End of variables declaration//GEN-END:variables
}
