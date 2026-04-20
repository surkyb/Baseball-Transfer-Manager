package com.techbridge.btm.view.form;

import com.techbridge.btm.DTO.EstadisticasDTO;
import com.techbridge.btm.controller.EstadisticasController;
import com.techbridge.btm.controller.JugadorController; 
import com.techbridge.btm.repository.EstadisticasRepositoryImpl;
import com.techbridge.btm.repository.JugadorRepositoryImpl;
import com.techbridge.btm.service.EstadisticasService;
import com.techbridge.btm.service.JugadorService;
import com.techbridge.btm.view.dashboard.swing.ModelChart;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author Surky
 */
public class FormEstadisticas extends javax.swing.JPanel {

    private EstadisticasController estadisticasController;
    private JugadorController jugadorController;
    private int jugadorSeleccionadoId = -1;
    private int idEstadisticaActual = 0;

    public FormEstadisticas() {
        initComponents();

        inicializarControladores();
        configurarTabla();
        configurarEventoSeleccion();
        cargarTablaJugadores();
    }

    private void inicializarControladores() {
        EstadisticasRepositoryImpl repoStats = new EstadisticasRepositoryImpl();
        EstadisticasService serviceStats = new EstadisticasService(repoStats);
        this.estadisticasController = new EstadisticasController(serviceStats);

        JugadorRepositoryImpl repoJug = new JugadorRepositoryImpl();
        JugadorService serviceJug = new JugadorService(repoJug);
        this.jugadorController = new JugadorController(serviceJug, null);
    }

    private void configurarTabla() {
        tblJugadores.getColumnModel().getColumn(0).setMinWidth(0);
        tblJugadores.getColumnModel().getColumn(0).setMaxWidth(0);
        tblJugadores.getColumnModel().getColumn(0).setPreferredWidth(0);

        tblJugadores.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setBackground(new Color(33, 83, 126));
                setForeground(Color.WHITE);
                setFont(new Font("Segoe UI", Font.BOLD, 13));
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(255, 255, 255, 50)));
                return this;
            }
        });
        tblJugadores.setRowHeight(30);
        tblJugadores.setGridColor(new Color(200, 200, 200));
    }

    private void configurarEventoSeleccion() {

        tblJugadores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int fila = tblJugadores.getSelectedRow();

                if (fila < 0 || tblJugadores.getRowCount() == 0) {
                    return;
                }

                try {
                    int idJugador = Integer.parseInt(
                            tblJugadores.getValueAt(fila, 0).toString()
                    );

                    String nombre = tblJugadores.getValueAt(fila, 1).toString();

                    EstadisticasDTO dto
                            = estadisticasController.obtenerEstadisticasDeJugador(idJugador);

                    jugadorSeleccionadoId = idJugador;

                    if (dto != null) {

                        actualizarGrafico(
                                nombre,
                                dto.getHits(),
                                dto.getHomeRuns(),
                                dto.getRbis(),
                                dto.getBasesRobadas()
                        );

                        llenarFormulario(dto);
                        btnActualizarStats.setEnabled(true);

                    } else {
                        idEstadisticaActual = 0;

                        jugadorSeleccionadoId = idJugador;

                        actualizarGrafico(nombre, 0, 0, 0, 0);
                        limpiarCampos();

                        btnActualizarStats.setEnabled(true);

                        graficoEstadisticas.repaint();
                        graficoEstadisticas.revalidate();

                        JOptionPane.showMessageDialog(
                                FormEstadisticas.this,
                                "El jugador " + nombre + " no tiene estadísticas aún."
                        );
                    }

                } catch (Exception e) {

                    jugadorSeleccionadoId = -1;
                    limpiarCampos();
                    btnActualizarStats.setEnabled(false);

                    JOptionPane.showMessageDialog(
                            FormEstadisticas.this,
                            "Error al seleccionar jugador."
                    );
                }
            }
        });
    }

    public void cargarTablaJugadores() {
        DefaultTableModel modelo = (DefaultTableModel) tblJugadores.getModel();
    modelo.setRowCount(0);

    List<Object[]> lista = jugadorController.listarJugadoresParaTabla();

    for (Object[] fila : lista) {
        modelo.addRow(fila);
    }
}

    private void llenarFormulario(EstadisticasDTO dto) {
        txtJuegos.setText(String.valueOf(dto.getJuegos()));
        txtTurnos.setText(String.valueOf(dto.getTurnosAlBate()));
        txtHits.setText(String.valueOf(dto.getHits()));
        txtCarreras.setText(String.valueOf(dto.getCarrerasAnotadas()));
        txtHomeRuns.setText(String.valueOf(dto.getHomeRuns()));
        txtRbis.setText(String.valueOf(dto.getRbis()));
        txtBasesRobadas.setText(String.valueOf(dto.getBasesRobadas()));
        txtBasesBola.setText(String.valueOf(dto.getBaseXBola()));
        txtPonches.setText(String.valueOf(dto.getPonches()));
    }

    public void actualizarGrafico(
        String nombreJugador,
        int hits,
        int hr,
        int rbis,
        int basesRobadas) {

    graficoEstadisticas.clear();

    graficoEstadisticas.revalidate();
    graficoEstadisticas.repaint();

    graficoEstadisticas.addLegend(
            "Ofensiva: " + nombreJugador,
            new Color(33, 83, 126),
            new Color(60, 115, 165)
    );

    graficoEstadisticas.addData(new ModelChart("Hits", new double[]{hits}));
    graficoEstadisticas.addData(new ModelChart("HR", new double[]{hr}));
    graficoEstadisticas.addData(new ModelChart("RBI", new double[]{rbis}));
    graficoEstadisticas.addData(new ModelChart("Robos", new double[]{basesRobadas}));

    graficoEstadisticas.start();
}

    private void limpiarCampos() {
        txtJuegos.setText("");
        txtTurnos.setText("");
        txtHits.setText("");
        txtCarreras.setText("");
        txtHomeRuns.setText("");
        txtRbis.setText("");
        txtBasesRobadas.setText("");
        txtBasesBola.setText("");
        txtPonches.setText("");
    }

    private EstadisticasDTO construirDTO() {
        return new EstadisticasDTO(
                idEstadisticaActual,
                jugadorSeleccionadoId,
                obtenerValorSeguro(txtJuegos.getText()),
                obtenerValorSeguro(txtHits.getText()),
                obtenerValorSeguro(txtHomeRuns.getText()),
                obtenerValorSeguro(txtRbis.getText()),
                0.0, // Promedio 
                obtenerValorSeguro(txtTurnos.getText()),
                obtenerValorSeguro(txtBasesBola.getText()),
                obtenerValorSeguro(txtPonches.getText()),
                obtenerValorSeguro(txtBasesRobadas.getText()),
                obtenerValorSeguro(txtCarreras.getText())
        );
    }

    private int obtenerValorSeguro(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJugadoresExistentes = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header22 = new com.techbridge.btm.view.components.Header2();
        header24 = new com.techbridge.btm.view.components.Header2();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJugadores = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel3 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        header23 = new com.techbridge.btm.view.components.Header2();
        jLabel5 = new javax.swing.JLabel();
        txtJuegos = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtTurnos = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtHits = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtCarreras = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtHomeRuns = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtRbis = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtBasesRobadas = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtBasesBola = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        txtPonches = new com.techbridge.btm.view.dashboard.swing.TextFieldRounded();
        roundPanel5 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        btnActualizarStats = new com.techbridge.btm.view.dashboard.swing.ButtonMenu();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        roundPanel1 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        graficoEstadisticas = new com.techbridge.btm.view.dashboard.swing.Chart();

        setBackground(new java.awt.Color(242, 241, 246));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlJugadoresExistentes.setBackground(new java.awt.Color(255, 255, 255));

        header22.setBackground(new java.awt.Color(33, 83, 126));

        header24.setBackground(new java.awt.Color(33, 83, 126));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tabla de jugadores");

        javax.swing.GroupLayout header24Layout = new javax.swing.GroupLayout(header24);
        header24.setLayout(header24Layout);
        header24Layout.setHorizontalGroup(
            header24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header24Layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(74, 74, 74))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(header24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        header22Layout.setVerticalGroup(
            header22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header22Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(header24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblJugadores.setBackground(new java.awt.Color(255, 255, 255));
        tblJugadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nombre", "posicion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJugadores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblJugadores);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Seleccionar Jugador");

        javax.swing.GroupLayout pnlJugadoresExistentesLayout = new javax.swing.GroupLayout(pnlJugadoresExistentes);
        pnlJugadoresExistentes.setLayout(pnlJugadoresExistentesLayout);
        pnlJugadoresExistentesLayout.setHorizontalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addGroup(pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(header22, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlJugadoresExistentesLayout.setVerticalGroup(
            pnlJugadoresExistentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugadoresExistentesLayout.createSequentialGroup()
                .addComponent(header22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(pnlJugadoresExistentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 50, 373, 320));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Estadísticas - Visualización y Actualización de Rendimiento");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 6, 676, -1));

        roundPanel3.setBackground(new java.awt.Color(255, 255, 255));

        header23.setBackground(new java.awt.Color(33, 83, 126));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Actualizar estadisticas del jugador ");

        javax.swing.GroupLayout header23Layout = new javax.swing.GroupLayout(header23);
        header23.setLayout(header23Layout);
        header23Layout.setHorizontalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header23Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header23Layout.setVerticalGroup(
            header23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        txtJuegos.addActionListener(this::txtJuegosActionPerformed);

        txtTurnos.addActionListener(this::txtTurnosActionPerformed);

        txtHits.addActionListener(this::txtHitsActionPerformed);

        txtCarreras.addActionListener(this::txtCarrerasActionPerformed);

        txtRbis.addActionListener(this::txtRbisActionPerformed);

        roundPanel5.setBackground(new java.awt.Color(191, 39, 57));

        btnActualizarStats.setText("Guardar Actualización");
        btnActualizarStats.addActionListener(this::btnActualizarStatsActionPerformed);

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualizarStats, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarStats, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Juegos Jugados:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Turnos al Bate:");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("Hits:");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Home Runs:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("Bases Robadas:");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 30, 30));
        jLabel12.setText("RBIs");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 30, 30));
        jLabel13.setText("Carreras Anotadas:");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 30, 30));
        jLabel14.setText("Bases x Bola:");

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 30, 30));
        jLabel15.setText("Ponches");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel3Layout.createSequentialGroup()
                .addComponent(header23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(txtHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtRbis, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel15))
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(txtTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(jLabel14))
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(12, 12, 12)
                                .addComponent(txtJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBasesRobadas, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBasesBola, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPonches, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 122, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addComponent(header23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(txtJuegos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBasesRobadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtHomeRuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtBasesBola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(11, 11, 11)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtHits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtRbis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPonches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)))
                .addGap(18, 18, 18)
                .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(roundPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, 240));

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setOpaque(true);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(graficoEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(graficoEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarStatsActionPerformed

        if (jugadorSeleccionadoId == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona un jugador primero.");
            return;
        }

        try {
            //  Construimos el paquete con lo que está escrito en las cajas
            EstadisticasDTO dto = construirDTO();

            //  Lo mandamos al backend para que se guarde en SQL
            estadisticasController.guardarEstadisticas(dto);

            //  Actualizamos el gráfico animado 
            String nombreJugador = tblJugadores.getValueAt(tblJugadores.getSelectedRow(), 1).toString();
            actualizarGrafico(
                    nombreJugador,
                    dto.getHits(),
                    dto.getHomeRuns(),
                    dto.getRbis(),
                    dto.getBasesRobadas()
            );

            
            javax.swing.JOptionPane.showMessageDialog(this, "¡Estadísticas guardadas y actualizadas correctamente!");

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos: " + e.getMessage());
        }

    }//GEN-LAST:event_btnActualizarStatsActionPerformed

    private void txtJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJuegosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJuegosActionPerformed

    private void txtTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTurnosActionPerformed

    private void txtHitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHitsActionPerformed

    private void txtCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarrerasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarrerasActionPerformed

    private void txtRbisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRbisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRbisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techbridge.btm.view.dashboard.swing.ButtonMenu btnActualizarStats;
    private com.techbridge.btm.view.dashboard.swing.Chart graficoEstadisticas;
    private com.techbridge.btm.view.components.Header2 header22;
    private com.techbridge.btm.view.components.Header2 header23;
    private com.techbridge.btm.view.components.Header2 header24;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel pnlJugadoresExistentes;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel1;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel3;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel5;
    private javax.swing.JTable tblJugadores;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtBasesBola;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtBasesRobadas;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtCarreras;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtHits;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtHomeRuns;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtJuegos;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtPonches;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtRbis;
    private com.techbridge.btm.view.dashboard.swing.TextFieldRounded txtTurnos;
    // End of variables declaration//GEN-END:variables
}
