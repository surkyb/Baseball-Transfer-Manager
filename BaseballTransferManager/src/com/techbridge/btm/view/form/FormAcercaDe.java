
package com.techbridge.btm.view.form;

/**
 *
 * @author UserGPC
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

public class FormAcercaDe extends javax.swing.JPanel {

    public FormAcercaDe() {
        initComponents();
        construirInterfaz();
    }

    private void construirInterfaz() {
        // Configuramos el panel principal
        setLayout(new BorderLayout(20, 20));
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JLabel lblTitulo = new JLabel("Acerca del Sistema");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(new Color(30, 30, 30));
        add(lblTitulo, BorderLayout.NORTH);

        // Contenedor dividido 
        JPanel pnlCentro = new JPanel(new GridLayout(1, 2, 20, 0));
        pnlCentro.setOpaque(false);

        // PANEL IZQUIERDO: INFORMACIÓN Y CREADORES
        com.techbridge.btm.view.dashboard.swing.RoundPanel pnlInfo = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        pnlInfo.setBackground(Color.WHITE);
        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Usamos HTML para formatear todo el texto de la izquierda fácilmente
        String htmlInfo = "<html><body style='font-family: Segoe UI; color: #1e1e1e;'>"
                + "<h2 style='color: #21537E;'>⚾ MLB Gestión Pro</h2>"
                + "<p><b>Versión:</b> 1.0.0</p>"
                + "<hr>"
                + "<h3>Descripción</h3>"
                + "<p>Plataforma integral de inteligencia de negocios para la administración de franquicias de béisbol, gestión de contratos, transferencias y análisis de rendimiento deportivo.</p>"
                + "<hr>"
                + "<h3>👨‍💻 Equipo de Desarrollo</h3>"
                + "<ul>"
                + "<li><b>Surky Alexandra Báez Lluberez</b></li>"
                + "<li><b>Joshua Abreu</b></li>"
                + "<li><b>Gilbert Vido</b></li>"
                + "<li><b>Lucas</b></li>"
                + "<li><b>pedro</b></li>"
                + "</ul>"
                + "<p><i>Desarrollo de Software - ITLA</i><br>"
                + "República Dominicana<br>Abril 2026</p>"
                + "</body></html>";

        JLabel lblInfoContent = new JLabel(htmlInfo);
        lblInfoContent.setVerticalAlignment(JLabel.TOP);
        pnlInfo.add(lblInfoContent, BorderLayout.CENTER);


        // PANEL DERECHO: MANUAL DE USUARIO
        com.techbridge.btm.view.dashboard.swing.RoundPanel pnlManual = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        pnlManual.setBackground(Color.WHITE);
        pnlManual.setLayout(new BorderLayout());
        pnlManual.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String htmlManual = "<html><body style='font-family: Segoe UI; color: #1e1e1e;'>"
                + "<h2 style='color: #BF2739;'>📖 Manual de Usuario Simplificado</h2>"
                + "<p>Siga estas instrucciones para una correcta gestión del sistema:</p>"
                + "<ol>"
                + "<li style='margin-bottom: 10px;'><b>Inicio:</b> Visualiza un resumen global de la liga, incluyendo el total de transacciones y el volumen de dinero movido.</li>"
                + "<li style='margin-bottom: 10px;'><b>Equipos:</b> Utiliza este módulo para dar de alta nuevas franquicias y establecer su presupuesto anual inicial.</li>"
                + "<li style='margin-bottom: 10px;'><b>Jugadores:</b> Registra a los atletas en la base de datos antes de asignarlos a un equipo mediante un contrato.</li>"
                + "<li style='margin-bottom: 10px;'><b>Transferencias:</b> Selecciona un jugador de un equipo origen y transfiérelo a un equipo destino estableciendo el monto de la transacción.</li>"
                + "<li style='margin-bottom: 10px;'><b>Estadísticas:</b> Busca a un jugador específico y actualiza sus números (Hits, HR, RBIs) después de cada jornada para mantener la base de datos al día.</li>"
                + "<li style='margin-bottom: 10px;'><b>Comparar:</b> Herramienta analítica que permite enfrentar las estadísticas de dos jugadores para la toma de decisiones gerenciales.</li>"
                + "</ol>"
                + "</body></html>";

        JEditorPane txtManual = new JEditorPane("text/html", htmlManual);
        txtManual.setEditable(false);
        txtManual.setOpaque(false);
        
        JScrollPane scrollManual = new JScrollPane(txtManual);
        scrollManual.setBorder(null);
        scrollManual.setOpaque(false);
        scrollManual.getViewport().setOpaque(false);

        pnlManual.add(scrollManual, BorderLayout.CENTER);

        // Añadimos ambos paneles al centro
        pnlCentro.add(pnlInfo);
        pnlCentro.add(pnlManual);

        add(pnlCentro, BorderLayout.CENTER);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
