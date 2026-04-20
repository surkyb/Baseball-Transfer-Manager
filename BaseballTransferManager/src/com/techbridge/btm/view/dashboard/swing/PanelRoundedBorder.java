/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.view.dashboard.swing;

/**
 *
 * @author UserGPC
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelRoundedBorder extends JPanel {

    private Color fillColor = Color.WHITE;
    private Color lineColor = new Color(200, 200, 200); // El mismo gris clarito de tus TextFields

    public PanelRoundedBorder() {
        // Fondo transparente para que no salgan esquinas cuadradas
        setOpaque(false); 
        
        // Un pequeño margen interno para que el JComboBox no quede pegado a la línea gris
        setBorder(new EmptyBorder(2, 5, 2, 5)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 1. Dibuja el fondo blanco curvo
        g2.setColor(fillColor);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        
        g2.dispose();
        
        // 2. Fundamental para el JPanel: esto dibuja el JComboBox que pongas adentro
        super.paintComponent(g); 
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 3. Dibuja la misma línea gris perfecta en el contorno
        g2.setColor(lineColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        
        g2.dispose();
    }
}