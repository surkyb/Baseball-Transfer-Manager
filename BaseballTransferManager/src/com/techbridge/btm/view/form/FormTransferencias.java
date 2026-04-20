package com.techbridge.btm.view.form;

import com.techbridge.btm.controller.TransferenciaController;
import com.techbridge.btm.repository.ContratoRepositoryImpl;
import com.techbridge.btm.repository.TransferenciaRepositoryImpl;
import com.techbridge.btm.service.TransferenciaService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Surky
 */
public class FormTransferencias extends javax.swing.JPanel {

    private TransferenciaController controller;

    public FormTransferencias() {
        initComponents();
        inicializarControlador(); // Conecta con la BD
        configurarTabla();        
        cargarTablaHistorial();   
        
        
        btnNuevaTransferencia.addActionListener(e -> abrirDialogoTransferencia());
    }
    
    
    // Método para crear y mostrar el formulario emergente
    private void abrirDialogoTransferencia() {
   java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        javax.swing.JDialog dialogo = new javax.swing.JDialog((java.awt.Frame) parentWindow, "Registrar Transferencia", true);
        dialogo.setSize(400, 350);
        dialogo.setLocationRelativeTo(parentWindow);
        dialogo.setLayout(new java.awt.BorderLayout());
        
        javax.swing.JPanel pnlForm = new javax.swing.JPanel(new java.awt.GridLayout(5, 2, 10, 20));
        pnlForm.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- CAMBIO: Usamos ComboBox en lugar de TextField ---
        pnlForm.add(new javax.swing.JLabel("Jugador:"));
        javax.swing.JComboBox<ComboItem> cmbJugador = new javax.swing.JComboBox<>();
        pnlForm.add(cmbJugador);

        pnlForm.add(new javax.swing.JLabel("Equipo Origen:"));
        javax.swing.JComboBox<ComboItem> cmbOrigen = new javax.swing.JComboBox<>();
        pnlForm.add(cmbOrigen);

        pnlForm.add(new javax.swing.JLabel("Equipo Destino:"));
        javax.swing.JComboBox<ComboItem> cmbDestino = new javax.swing.JComboBox<>();
        pnlForm.add(cmbDestino);

        pnlForm.add(new javax.swing.JLabel("Monto ($):"));
        javax.swing.JTextField txtMonto = new javax.swing.JTextField();
        pnlForm.add(txtMonto);

        try (java.sql.Connection con = com.techbridge.btm.dbconnection.DatabaseConnection.getConexion();
             java.sql.Statement st = con.createStatement()) {
            
            java.sql.ResultSet rsJug = st.executeQuery("SELECT id, nombre FROM jugador");
            while (rsJug.next()) {
                cmbJugador.addItem(new ComboItem(rsJug.getInt("id"), rsJug.getString("nombre")));
            }
            
            java.sql.ResultSet rsEq = st.executeQuery("SELECT id, nombre FROM equipo");
            while (rsEq.next()) {
                ComboItem equipo = new ComboItem(rsEq.getInt("id"), rsEq.getString("nombre"));
                cmbOrigen.addItem(equipo);
                cmbDestino.addItem(equipo);
            }
        } catch (Exception ex) {
            System.out.println("Error cargando listas: " + ex.getMessage());
        }

        // Botones
        javax.swing.JButton btnCancelar = new javax.swing.JButton("Cancelar");
        btnCancelar.addActionListener(e -> dialogo.dispose()); 
        pnlForm.add(btnCancelar);

        javax.swing.JButton btnGuardar = new javax.swing.JButton("Guardar");
        btnGuardar.setBackground(new java.awt.Color(191, 39, 57)); 
        btnGuardar.setForeground(java.awt.Color.WHITE);
        pnlForm.add(btnGuardar);

        // Acción del botón guardar
        btnGuardar.addActionListener(e -> {
            try {
                // Obtenemos los Items seleccionados
                ComboItem jugadorSel = (ComboItem) cmbJugador.getSelectedItem();
                ComboItem origenSel = (ComboItem) cmbOrigen.getSelectedItem();
                ComboItem destinoSel = (ComboItem) cmbDestino.getSelectedItem();

                if (jugadorSel == null || origenSel == null || destinoSel == null) {
                    javax.swing.JOptionPane.showMessageDialog(dialogo, "Asegúrese de seleccionar todos los campos.");
                    return;
                }

                // Extraemos los IDs ocultos
                int idJug = jugadorSel.getId();
                int idOri = origenSel.getId();
                int idDes = destinoSel.getId();
                double monto = Double.parseDouble(txtMonto.getText().trim());

                // 1. Guardamos la transferencia en la base de datos
                controller.transferirJugador(idJug, idOri, idDes, monto);

                javax.swing.JOptionPane.showMessageDialog(dialogo, "Transferencia guardada exitosamente.");
                dialogo.dispose(); 
                
                cargarTablaHistorial(); 

            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(dialogo, "Por favor ingrese números válidos.", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(dialogo, ex.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        });

        dialogo.add(pnlForm, java.awt.BorderLayout.CENTER);
        
        dialogo.setVisible(true); 
    }
    
    
    

    private void inicializarControlador() {
        TransferenciaRepositoryImpl repoTrans = new TransferenciaRepositoryImpl();
        ContratoRepositoryImpl repoContrato = new ContratoRepositoryImpl();
        TransferenciaService service = new TransferenciaService(repoTrans, repoContrato);
        this.controller = new TransferenciaController(service);
    }

    private void configurarTabla() {
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
        
    }
    class ComboItem {
    private int id;
    private String nombre;

    public ComboItem(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nombre; // Esto es lo que verá el usuario en la lista
    }
}

    public void cargarTablaHistorial() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0); 

        try {
            List<Object[]> lista = controller.listarHistorial();
            for (Object[] fila : lista) {
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("Error al cargar el historial: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJugadoresExistentes = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header22 = new com.techbridge.btm.view.components.Header2();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaTransferencia = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 241, 246));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setOpaque(false);

        pnlJugadoresExistentes.setBackground(new java.awt.Color(255, 255, 255));

        header22.setBackground(new java.awt.Color(33, 83, 126));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Historial Completo de Transferencias");

        javax.swing.GroupLayout header22Layout = new javax.swing.GroupLayout(header22);
        header22.setLayout(header22Layout);
        header22Layout.setHorizontalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header22Layout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(347, 347, 347))
        );
        header22Layout.setVerticalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header22Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Jugador", "Origen", "Destino", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlJugadoresExistentesLayout.setVerticalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addComponent(header22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Transferencias");

        btnNuevaTransferencia.setBackground(new java.awt.Color(33, 83, 126));
        btnNuevaTransferencia.setText("Agregar transferencia");
        btnNuevaTransferencia.addActionListener(this::btnNuevaTransferenciaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(btnNuevaTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlJugadoresExistentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaTransferencia)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaTransferenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaTransferencia;
    private com.techbridge.btm.view.components.Header2 header22;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlJugadoresExistentes;
    // End of variables declaration//GEN-END:variables
}
