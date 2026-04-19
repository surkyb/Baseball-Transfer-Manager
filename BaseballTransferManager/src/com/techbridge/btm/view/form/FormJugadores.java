package com.techbridge.btm.view.form;

/**
 *
 * @author Surky
 */
public class FormJugadores extends javax.swing.JPanel {

    /**
     * Creates new form FormJugadores
     */
    public FormJugadores() {
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

        pnlCreateJugador = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        roundPanel7 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        buttonMenu1 = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        header21 = new com.techbridge.btm.view.components.Header2();
        jLabel5 = new javax.swing.JLabel();
        textFieldRounded1 = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        textFieldRounded2 = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        textFieldRounded5 = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        panelRoundedBorder1 = new com.techbridge.btm.view.dashboard.swing.PanelRoundedBorder();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlJugadoresExistentes = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header22 = new com.techbridge.btm.view.components.Header2();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlGestionarJugador = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header23 = new com.techbridge.btm.view.components.Header2();
        jLabel3 = new javax.swing.JLabel();
        imageAvatar2 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        jLabel9 = new javax.swing.JLabel();
        panelRoundedBorder2 = new com.techbridge.btm.view.dashboard.swing.PanelRoundedBorder();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        roundPanel1 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        jLabel18 = new javax.swing.JLabel();
        roundPanel2 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        btnAgenteLibre = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        roundPanel3 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        btnRenovarContrato = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        roundPanel4 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        btnAsignarAEquipo = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        roundPanel5 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        btnDetallesContrato = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 241, 246));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setOpaque(false);

        pnlCreateJugador.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel7.setBackground(new java.awt.Color(33, 83, 126));

        buttonMenu1.setText("Crear Jugador");
        buttonMenu1.setAlignmentX(0.5F);
        buttonMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonMenu1.addActionListener(this::buttonMenu1ActionPerformed);

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        header21.setBackground(new java.awt.Color(33, 83, 126));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Registrar nuevo jugador");

        javax.swing.GroupLayout header21Layout = new javax.swing.GroupLayout(header21);
        header21.setLayout(header21Layout);
        header21Layout.setHorizontalGroup(
            header21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(42, 42, 42))
        );
        header21Layout.setVerticalGroup(
            header21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        textFieldRounded1.setText("Ej: Shoei Ohtani");
        textFieldRounded1.addActionListener(this::textFieldRounded1ActionPerformed);

        textFieldRounded2.setText("Ej: 31");
        textFieldRounded2.addActionListener(this::textFieldRounded2ActionPerformed);

        textFieldRounded5.setText("Ej: 700M");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pitcher (P)", "Catcher (C)", "Primera Base (1B)", "Segunda Base (2B)", "Tercera Base (3B)", "Shortstop (SS)", "Jardinero Izquierdo (LF)", "Jardinero Central (CF)", "Jardinero Derecho (RF)", "Bateador Designado (DH)" }));
        jComboBox1.setBorder(null);
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        javax.swing.GroupLayout panelRoundedBorder1Layout = new javax.swing.GroupLayout(panelRoundedBorder1);
        panelRoundedBorder1.setLayout(panelRoundedBorder1Layout);
        panelRoundedBorder1Layout.setHorizontalGroup(
            panelRoundedBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, 222, Short.MAX_VALUE)
        );
        panelRoundedBorder1Layout.setVerticalGroup(
            panelRoundedBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Nombre completo");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Edad");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Posicion");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Valor actual en el mercado");

        javax.swing.GroupLayout pnlCreateJugadorLayout = new javax.swing.GroupLayout(pnlCreateJugador);
        pnlCreateJugador.setLayout(pnlCreateJugadorLayout);
        pnlCreateJugadorLayout.setHorizontalGroup(
            pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlCreateJugadorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(textFieldRounded5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textFieldRounded1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textFieldRounded2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRoundedBorder1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlCreateJugadorLayout.setVerticalGroup(
            pnlCreateJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreateJugadorLayout.createSequentialGroup()
                .addComponent(header21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldRounded1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(textFieldRounded2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRoundedBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addComponent(textFieldRounded5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(roundPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pnlJugadoresExistentes.setBackground(new java.awt.Color(255, 255, 255));

        header22.setBackground(new java.awt.Color(33, 83, 126));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion de jugadores");

        javax.swing.GroupLayout header22Layout = new javax.swing.GroupLayout(header22);
        header22.setLayout(header22Layout);
        header22Layout.setHorizontalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header22Layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
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
                {null, null, null, null, null, null, null, "Borrar"},
                {null, null, null, null, null, null, null, "Borrar"},
                {null, null, null, null, null, null, null, "Borrar"},
                {null, null, null, null, null, null, null, "Borrar"},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sel", "Nombre", "Posición", "Equipo", "Edad", "Fin contrato", "Valor", "Borrar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlJugadoresExistentesLayout = new javax.swing.GroupLayout(pnlJugadoresExistentes);
        pnlJugadoresExistentes.setLayout(pnlJugadoresExistentesLayout);
        pnlJugadoresExistentesLayout.setHorizontalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1))
        );
        pnlJugadoresExistentesLayout.setVerticalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addComponent(header22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlGestionarJugador.setBackground(new java.awt.Color(255, 255, 255));
        pnlGestionarJugador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header23.setBackground(new java.awt.Color(33, 83, 126));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Detalle de estado y contrato");

        javax.swing.GroupLayout header23Layout = new javax.swing.GroupLayout(header23);
        header23.setLayout(header23Layout);
        header23Layout.setHorizontalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
        );
        header23Layout.setVerticalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pnlGestionarJugador.add(header23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 728, -1));

        imageAvatar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/result_btmlogo.png"))); // NOI18N
        pnlGestionarJugador.add(imageAvatar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 60, 126, 135));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("Asignar / Cambiar de equipo");
        pnlGestionarJugador.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 70, -1, -1));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pitcher (P)", "Catcher (C)", "Primera Base (1B)", "Segunda Base (2B)", "Tercera Base (3B)", "Shortstop (SS)", "Jardinero Izquierdo (LF)", "Jardinero Central (CF)", "Jardinero Derecho (RF)", "Bateador Designado (DH)" }));
        jComboBox2.setBorder(null);
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        javax.swing.GroupLayout panelRoundedBorder2Layout = new javax.swing.GroupLayout(panelRoundedBorder2);
        panelRoundedBorder2.setLayout(panelRoundedBorder2Layout);
        panelRoundedBorder2Layout.setHorizontalGroup(
            panelRoundedBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, 0, 188, Short.MAX_VALUE)
        );
        panelRoundedBorder2Layout.setVerticalGroup(
            panelRoundedBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pnlGestionarJugador.add(panelRoundedBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 100, 198, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Edad: ");
        pnlGestionarJugador.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 237, 186, 18));

        jLabel11.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("Nombre del jugador: ");
        pnlGestionarJugador.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 207, 420, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 30, 30));
        jLabel12.setText("Tag de estado:");
        pnlGestionarJugador.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 106, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 30, 30));
        jLabel13.setText("Detalles de contrato");
        pnlGestionarJugador.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 30, 30));
        jLabel15.setText("Cambiar estado");
        pnlGestionarJugador.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        roundPanel1.setBackground(new java.awt.Color(109, 176, 104));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ACTIVO");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGestionarJugador.add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 100, -1, 30));

        roundPanel2.setBackground(new java.awt.Color(176, 19, 18));

        btnAgenteLibre.setText("Establecer como agente libre");
        btnAgenteLibre.addActionListener(this::btnAgenteLibreActionPerformed);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnAgenteLibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgenteLibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlGestionarJugador.add(roundPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        roundPanel3.setBackground(new java.awt.Color(21, 76, 124));

        btnRenovarContrato.setText("Renovar contrato");
        btnRenovarContrato.addActionListener(this::btnRenovarContratoActionPerformed);

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRenovarContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
        );

        pnlGestionarJugador.add(roundPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 120, 30));

        roundPanel4.setBackground(new java.awt.Color(21, 76, 124));

        btnAsignarAEquipo.setText("Confirmar asignacion");
        btnAsignarAEquipo.setActionCommand("");
        btnAsignarAEquipo.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btnAsignarAEquipo.addActionListener(this::btnAsignarAEquipoActionPerformed);

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAsignarAEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAsignarAEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlGestionarJugador.add(roundPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        roundPanel5.setBackground(new java.awt.Color(21, 76, 124));

        btnDetallesContrato.setText("Detalles ");
        btnDetallesContrato.addActionListener(this::btnDetallesContratoActionPerformed);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDetallesContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDetallesContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlGestionarJugador.add(roundPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 120, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Jugadores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlCreateJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlGestionarJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(482, 482, 482))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlGestionarJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlCreateJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    private void buttonMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonMenu1ActionPerformed

    private void textFieldRounded1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRounded1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRounded1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void textFieldRounded2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRounded2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldRounded2ActionPerformed

    private void btnAsignarAEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarAEquipoActionPerformed
// campos de texto para la ventana
        javax.swing.JTextField txtSalario = new javax.swing.JTextField();
        javax.swing.JTextField txtFechaInicio = new javax.swing.JTextField();
        javax.swing.JTextField txtFechaFin = new javax.swing.JTextField();

// Placeholder
        txtFechaInicio.setText("YYYY-MM-DD");
        txtFechaFin.setText("YYYY-MM-DD");
        txtSalario.setText("Ej: 15000000");

// diseño ventana
        Object[] mensaje = {
            "Ingrese los detalles del nuevo contrato:",
            " ",
            "Salario Base ($):", txtSalario,
            "Fecha de Inicio:", txtFechaInicio,
            "Fecha de Finalización:", txtFechaFin
        };

//ventana
        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                mensaje,
                "Confirmar Asignación de Equipo",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE
        );

//Capturar los dato si "ok""
        if (opcion == javax.swing.JOptionPane.OK_OPTION) {
            String salario = txtSalario.getText();
            String fechaInicio = txtFechaInicio.getText();
            String fechaFin = txtFechaFin.getText();

            // controller.asignarEquipo(idJugador, idEquipoSeleccionado, salario, fechaInicio, fechaFin);
            // Mensaje temporal
            System.out.println("Asignación lista para guardar. Salario: " + salario);
}    }//GEN-LAST:event_btnAsignarAEquipoActionPerformed

    private void btnDetallesContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetallesContratoActionPerformed

    private void btnRenovarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenovarContratoActionPerformed
// campos
        javax.swing.JTextField txtNuevoSalario = new javax.swing.JTextField();
        javax.swing.JTextField txtNuevaFechaFin = new javax.swing.JTextField();
        txtNuevaFechaFin.setText("YYYY-MM-DD");

        Object[] mensaje = {
            "Detalles de la renovación:",
            " ",
            "Nuevo Salario Ajustado ($):", txtNuevoSalario,
            "Nueva Fecha de Vencimiento:", txtNuevaFechaFin
        };

        //la ventana
        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                mensaje,
                "Renovar Contrato de Jugador",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE
        );
//Capturr los datos
        if (opcion == javax.swing.JOptionPane.OK_OPTION) {
            String nuevoSalario = txtNuevoSalario.getText();
            String nuevaFechaFin = txtNuevaFechaFin.getText();

            System.out.println("Renovación lista. Nuevo fin: " + nuevaFechaFin);
}    }//GEN-LAST:event_btnRenovarContratoActionPerformed

    private void btnAgenteLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgenteLibreActionPerformed
        int opcion = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "¿Estás completamente seguro de establecer a este jugador como Agente Libre?\n"
                + "Esto terminará su contrato actual inmediatamente.",
                "⚠️ Advertencia Crítica",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.WARNING_MESSAGE
        );

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            System.out.println("El jugador ha sido liberado. Ahora es Agente Libre.");
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "El jugador ahora es Agente Libre.",
                    "Operación Exitosa",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE
            );
}    }//GEN-LAST:event_btnAgenteLibreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu btnAgenteLibre;
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu btnAsignarAEquipo;
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu btnDetallesContrato;
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu btnRenovarContrato;
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu buttonMenu1;
    private com.techbridge.btm.view.components.Header2 header21;
    private com.techbridge.btm.view.components.Header2 header22;
    private com.techbridge.btm.view.components.Header2 header23;
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.techbridge.btm.view.dashboard.swing.PanelRoundedBorder panelRoundedBorder1;
    private com.techbridge.btm.view.dashboard.swing.PanelRoundedBorder panelRoundedBorder2;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlCreateJugador;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlGestionarJugador;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlJugadoresExistentes;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel1;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel2;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel3;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel4;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel5;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel7;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded textFieldRounded1;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded textFieldRounded2;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded textFieldRounded5;
    // End of variables declaration//GEN-END:variables
}
