/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.view.dashboard.swing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ComboBoxBuscador<E> extends JComboBox<E> {

    public ComboBoxBuscador() {
        super();
        setOpaque(false); // Necesario para que se vean nuestras esquinas redondas
        setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Fuente suave y moderna

        // Inyectamos nuestros estilos personalizados
        setUI(new CustomComboBoxUI());
        setRenderer(new CustomRenderer());
    }

    // --- MAGIA GRÁFICA: Pintamos el fondo, el borde y la Lupa ---
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 1. Fondo gris claro "píldora"
        g2.setColor(new Color(228, 228, 230)); 
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        // 2. Borde gris sutil
        g2.setColor(new Color(200, 200, 200));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        // 3. Dibujar la "Lupa" (Magnifying glass) exactamente como en tu foto
        g2.setColor(new Color(130, 130, 130)); // Gris oscuro para la lupa
        g2.setStroke(new BasicStroke(1.5f));
        int lupaX = 12; // Posición X
        int lupaY = (getHeight() - 12) / 2; // Centrado verticalmente
        
        g2.drawOval(lupaX, lupaY, 10, 10); // El círculo
        g2.drawLine(lupaX + 8, lupaY + 8, lupaX + 13, lupaY + 13); // El mango

        g2.dispose();
        
        // 4. Dejar que Java dibuje el texto del jugador seleccionado encima
        super.paintComponent(g); 
    }

    // --- INTERFAZ: Cambiamos la flecha desplegable ---
    private class CustomComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            JButton button = new JButton() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(new Color(150, 150, 150)); // Flecha gris
                    
                    // Dibujar el triángulo hacia abajo
                    int size = 5;
                    int x = (getWidth() - size - 2) / 2;
                    int y = (getHeight() - (size / 2)) / 2;
                    
                    Polygon triangle = new Polygon();
                    triangle.addPoint(x, y);
                    triangle.addPoint(x + size + 2, y);
                    triangle.addPoint(x + (size / 2) + 1, y + size);
                    g2.fillPolygon(triangle);
                    g2.dispose();
                }
            };
            button.setBorder(new EmptyBorder(0, 0, 0, 10));
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            return button;
        }

        // Anular el fondo blanco cuadrado que hace Java al hacer clic
        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            // Vacío para respetar nuestro fondo gris redondeado
        }
    }

    // --- RENDERIZADOR: Espaciado para no escribir encima de la lupa ---
    private class CustomRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            // index == -1 es la caja cerrada principal
            if (index == -1) {
                // ¡TRUCO! 30px de margen izquierdo para empujar el texto a la derecha de la lupa
                setBorder(new EmptyBorder(5, 30, 5, 10)); 
                setOpaque(false); 
                setForeground(new Color(80, 80, 80)); // Letra gris como en tu foto
            } else {
                // Estilo de la lista cuando se abre
                setBorder(new EmptyBorder(8, 10, 8, 10));
                setOpaque(true);
                if (isSelected) {
                    setBackground(new Color(210, 210, 210)); // Hover gris
                    setForeground(Color.BLACK);
                } else {
                    setBackground(Color.WHITE);
                    setForeground(new Color(80, 80, 80));
                }
            }
            return this;
        }
    }
}