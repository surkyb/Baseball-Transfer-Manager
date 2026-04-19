package com.techbridge.btm.view.components;

import com.techbridge.btm.view.dashboard.swing.ButtonMenu;
import com.techbridge.btm.view.dashboard.swing.scrollbar.ScrollBarCustom;
import com.techbridge.btm.view.event.EventMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Surky
 */
public class Menu extends javax.swing.JPanel {

    private EventMenu event;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setOpaque(false);
        ScrollBarCustom sb = new ScrollBarCustom();
        sb.setForeground(new Color(130, 130, 130, 100));
        jScrollPane1.setVerticalScrollBar(sb);
        panelMenu.setLayout(new MigLayout("wrap, fillx, inset 3", "[fill]", "[]0[]"));
    }
    
    public void initMenu(EventMenu event){
        this.event = event;
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/1.png")),"Dasboard", 0);
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/2.png")),"Dasboard", 1);
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/3.png")),"Dasboard", 2);
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/4.png")),"Dasboard", 3);
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/5.png")),"Dasboard", 4);
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/6.png")),"Dasboard", 5);
        addEmpty();
        addMenu(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/logout.png")), "Logout", 8);
    }
    
    private void addEmpty(){
        panelMenu.add(new JLabel(), "push");
    }
    
    private void addMenu(Icon icon, String text, int index) {
        ButtonMenu menu = new ButtonMenu();
        menu.setIcon(icon);
        menu.setText("  " + text);
        panelMenu.add(menu);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(index);
                setSelected(menu);
            }
        });
    }

    private void setSelected(ButtonMenu menu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof ButtonMenu) {
                ButtonMenu b = (ButtonMenu) com;
                b.setSelected(false);
            }
        }
        menu.setSelected(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imageAvatar1 = new com.techbridge.btm.view.dashboard.swing.ImageAvatar();
        roundPanel2 = new com.techbridge.btm.view.dashboard.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 204, 204));

        roundPanel1.setBackground(new java.awt.Color(11, 32, 59));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 224, 224));
        jLabel1.setText("User Name");

        jLabel2.setForeground(new java.awt.Color(203, 203, 203));
        jLabel2.setText("Admin");

        imageAvatar1.setBorderSize(2);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/profile.jpg"))); // NOI18N

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        roundPanel2.setBackground(new java.awt.Color(11, 32, 59));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setBackground(new java.awt.Color(11, 32, 59));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelMenu);

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.techbridge.btm.view.dashboard.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMenu;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel1;
    private com.techbridge.btm.view.dashboard.swing.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
