package com.techbridge.btm.view.dashboard.swing; // Asegúrate de que sea tu paquete

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TextFieldRounded extends JTextField {

    private Color fillColor = Color.WHITE;
    private Color lineColor = new Color(200, 200, 200); // El gris clarito del borde de tu imagen

    public TextFieldRounded() {
        // Hacemos el fondo transparente para que Swing no dibuje las esquinas cuadradas blancas
        setOpaque(false); 
        
        // Le damos un margen interno (padding) para que el texto no se pegue a las curvas
        // Arriba: 5, Izquierda: 15, Abajo: 5, Derecha: 15
        setBorder(new EmptyBorder(5, 15, 5, 15)); 
        
        // Color del texto y tamaño por defecto
        setForeground(new Color(50, 50, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 1. Dibuja el fondo blanco con bordes redondeados
        g2.setColor(fillColor);
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        
        g2.dispose();
        // 2. Le dice a Java que ahora sí dibuje el texto normal por encima
        super.paintComponent(g); 
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // 3. Dibuja la línea gris del borde
        g2.setColor(lineColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        
        g2.dispose();
    }
}