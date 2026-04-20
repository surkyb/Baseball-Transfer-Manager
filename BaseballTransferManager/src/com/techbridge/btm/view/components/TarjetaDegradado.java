package com.techbridge.btm.view.components;

/**
 *
 * @author UserGPC
 */
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class TarjetaDegradado extends JPanel {

    private int radioEsquinas = 25;

    public TarjetaDegradado() {
        
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color colorOscuro = new Color(33, 83, 126);   // Tu azul MLB original
        Color colorClaro = new Color(100, 135, 165);   // Un azul un poco más claro para el brillo

        GradientPaint degradado = new GradientPaint(0, 0, colorOscuro, getWidth(), getHeight(), colorClaro);
        g2.setPaint(degradado);

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radioEsquinas, radioEsquinas);

        g2.dispose();
    }
}