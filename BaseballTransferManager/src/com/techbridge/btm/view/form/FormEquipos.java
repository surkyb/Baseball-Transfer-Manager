package com.techbridge.btm.view.form;

/**
 *
 * @author Surky
 */
public class FormEquipos extends javax.swing.JPanel implements com.techbridge.btm.view.EquipoViewInterface {

    private com.techbridge.btm.controller.EquipoController controller;

    /**
     * Creates new form FormJugadores
     */
    public FormEquipos() {
        initComponents();
        initTablaEquipos();
        initTablaRoster();

        com.techbridge.btm.repository.EquipoRepositoryImpl repo = new com.techbridge.btm.repository.EquipoRepositoryImpl();
        com.techbridge.btm.service.EquipoService service = new com.techbridge.btm.service.EquipoService(repo);
        this.controller = new com.techbridge.btm.controller.EquipoController(service, this);

       
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Obtenemos exactamente en qué fila y columna se hizo el clic
                int filaAfectada = jTable1.rowAtPoint(evt.getPoint());
                int columnaAfectada = jTable1.columnAtPoint(evt.getPoint());

                if (columnaAfectada == 3 && filaAfectada >= 0) {

                    //  tomsmos el valor de la celda 
                    Object valorCelda = jTable1.getValueAt(filaAfectada, 1);
                    // si ta vacia
                    if (valorCelda == null || valorCelda.toString().trim().isEmpty()) {
                        javax.swing.JOptionPane.showMessageDialog(
                                null,
                                "La celda está vacía. No hay ningún Equipo para eliminar en esta fila.",
                                "Aviso",
                                javax.swing.JOptionPane.WARNING_MESSAGE
                        );
                        return;
                    }

                    String nombreEquipo = valorCelda.toString();
                    int opcion = javax.swing.JOptionPane.showConfirmDialog(
                            null,
                            "¿Estás absolutamente seguro de eliminar a " + nombreEquipo + " del sistema?\nEsta acción borrará todos sus contratos y no se puede deshacer.",
                            "Eliminar Equipo",
                            javax.swing.JOptionPane.YES_NO_OPTION,
                            javax.swing.JOptionPane.ERROR_MESSAGE
                    );

                    //Si el usuario dice "Si"
                    if (opcion == javax.swing.JOptionPane.YES_OPTION) {
                        //;p eliminas
                    }
                }
            }
        });

        //actualizarTablaEquipos();
    }

    private void initTablaEquipos() {

        jTable1.getTableHeader().setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setBackground(new java.awt.Color(33, 83, 126));
                setForeground(java.awt.Color.WHITE);
                setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                setBorder(javax.swing.BorderFactory.createMatteBorder(
                        0, 0, 1, 1, new java.awt.Color(255, 255, 255, 50)));

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
    }

    private void initTablaRoster() {

        jTable2.getTableHeader().setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setBackground(new java.awt.Color(33, 83, 126));
                setForeground(java.awt.Color.WHITE);
                setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                setBorder(javax.swing.BorderFactory.createMatteBorder(
                        0, 0, 1, 1, new java.awt.Color(255, 255, 255, 50)));

                return this;
            }
        });

        if (jTable2.getParent() != null) {
            jTable2.getParent().setBackground(java.awt.Color.WHITE);
        }

        jTable2.setShowHorizontalLines(true);
        jTable2.setShowVerticalLines(true);
        jTable2.setGridColor(new java.awt.Color(200, 200, 200));
        jTable2.setRowHeight(30);
    }

    @Override
    public com.techbridge.btm.DTO.EquipoDTO getDatosEquipo() {
        String nombre = txtNombre.getText();

        double presupuesto = 0.0;
        try {
            presupuesto = Double.parseDouble(txtPresupuesto.getText());
        } catch (NumberFormatException e) {
            throw new RuntimeException("El presupuesto debe ser un número válido sin letras ni comas.");
        }

        return new com.techbridge.btm.DTO.EquipoDTO(nombre, presupuesto);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarError(String error) {
        javax.swing.JOptionPane.showMessageDialog(this, error, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void limpiarCampos() {
        txtNombre.setText("");      
        txtPresupuesto.setText("");  
    }
    
    public void actualizarTablaEquipos() {


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCreateJugador = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        roundPanel7 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        btnCrearEquipo = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        header21 = new com.techbridge.btm.view.components.Header2();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtPresupuesto = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        imageAvatar2 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        pnlJugadoresExistentes = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header22 = new com.techbridge.btm.view.components.Header2();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlGestionarJugador = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header23 = new com.techbridge.btm.view.components.Header2();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 241, 246));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setOpaque(false);

        pnlCreateJugador.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel7.setBackground(new java.awt.Color(33, 83, 126));

        btnCrearEquipo.setText("Crear Equipo");
        btnCrearEquipo.setAlignmentX(0.5F);
        btnCrearEquipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrearEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCrearEquipo.addActionListener(this::btnCrearEquipoActionPerformed);

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnCrearEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCrearEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        header21.setBackground(new java.awt.Color(33, 83, 126));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registrar Nuevo Equipo");

        javax.swing.GroupLayout header21Layout = new javax.swing.GroupLayout(header21);
        header21.setLayout(header21Layout);
        header21Layout.setHorizontalGroup(
            header21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header21Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header21Layout.setVerticalGroup(
            header21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        txtNombre.setText("Ej: New York Yankees");
        txtNombre.addActionListener(this::txtNombreActionPerformed);

        txtPresupuesto.setText("Ej: 150000000");
        txtPresupuesto.addActionListener(this::txtPresupuestoActionPerformed);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Nombre de la Franquicia");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Presupuesto Anual ($)");

        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/result_btmlogo.png"))); // NOI18N

        javax.swing.GroupLayout pnlCreateJugadorLayout = new javax.swing.GroupLayout(pnlCreateJugador);
        pnlCreateJugador.setLayout(pnlCreateJugadorLayout);
        pnlCreateJugadorLayout.setHorizontalGroup(
            pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCreateJugadorLayout.createSequentialGroup()
                .addGroup(pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCreateJugadorLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                .addComponent(txtPresupuesto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4)))
                    .addGroup(pnlCreateJugadorLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlCreateJugadorLayout.setVerticalGroup(
            pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreateJugadorLayout.createSequentialGroup()
                .addComponent(header21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pnlJugadoresExistentes.setBackground(new java.awt.Color(255, 255, 255));

        header22.setBackground(new java.awt.Color(33, 83, 126));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion de Equipos");

        javax.swing.GroupLayout header22Layout = new javax.swing.GroupLayout(header22);
        header22.setLayout(header22Layout);
        header22Layout.setHorizontalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(270, 270, 270))
        );
        header22Layout.setVerticalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(11, Short.MAX_VALUE))
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
                "sel", "Nombre del equipo", "presupuesto", "borrar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
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
            .addComponent(header22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        pnlJugadoresExistentesLayout.setVerticalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addComponent(header22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pnlGestionarJugador.setBackground(new java.awt.Color(255, 255, 255));

        header23.setBackground(new java.awt.Color(33, 83, 126));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Roster: Nombre equipo");

        javax.swing.GroupLayout header23Layout = new javax.swing.GroupLayout(header23);
        header23.setLayout(header23Layout);
        header23Layout.setHorizontalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header23Layout.createSequentialGroup()
                .addContainerGap(240, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        header23Layout.setVerticalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header23Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Posición", "Edad", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout pnlGestionarJugadorLayout = new javax.swing.GroupLayout(pnlGestionarJugador);
        pnlGestionarJugador.setLayout(pnlGestionarJugadorLayout);
        pnlGestionarJugadorLayout.setHorizontalGroup(
            pnlGestionarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionarJugadorLayout.createSequentialGroup()
                .addGroup(pnlGestionarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(14, 14, 14))
        );
        pnlGestionarJugadorLayout.setVerticalGroup(
            pnlGestionarJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionarJugadorLayout.createSequentialGroup()
                .addComponent(header23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Equipos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pnlCreateJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlGestionarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jLabel1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlGestionarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlCreateJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void btnCrearEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEquipoActionPerformed
        controller.registrarEquipo();
    }//GEN-LAST:event_btnCrearEquipoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPresupuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPresupuestoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu btnCrearEquipo;
    private com.techbridge.btm.view.components.Header2 header21;
    private com.techbridge.btm.view.components.Header2 header22;
    private com.techbridge.btm.view.components.Header2 header23;
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlCreateJugador;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlGestionarJugador;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlJugadoresExistentes;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel7;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtNombre;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtPresupuesto;
    // End of variables declaration//GEN-END:variables
}
