package com.techbridge.btm.view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Surky
 */
public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    private MyTextField txtEmailLogin;
    private MyPasswordField txtPassLogin;
    private MyTextField txtUser;
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private Button btnRegistrarse;
    private Button btnEntrar;

    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }

    private void initRegister() {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Nuevo Gerente");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(187, 31, 45));
        register.add(label);
        txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/user.png")));
        txtUser.setHint("Nombre del Mánager");
        register.add(txtUser, "w 60%");
        txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/mail.png")));
        txtEmail.setHint("Correo Electrónico");
        register.add(txtEmail, "w 60%");
        txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/pass.png")));
        txtPass.setHint("Contraseña");
        register.add(txtPass, "w 60%");
        btnRegistrarse = new Button();
        btnRegistrarse.setBackground(new Color(187, 31, 45));
        btnRegistrarse.setForeground(new Color(250, 250, 250));
        btnRegistrarse.setText("REGISTRARSE");
        register.add(btnRegistrarse, "w 40%, h 40");
    }

    private void initLogin() {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Acceso al Sistema");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(187, 31, 45));
        login.add(label);
        txtEmailLogin = new MyTextField();
        txtEmailLogin.setPrefixIcon(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/mail.png")));
        txtEmailLogin.setHint("Correo Electrónico");
        login.add(txtEmailLogin, "w 60%");
        txtPassLogin = new MyPasswordField();
        txtPassLogin.setPrefixIcon(new ImageIcon(getClass().getResource("/com/techbridge/btm/view/icon/pass.png")));
        txtPassLogin.setHint("Contraseña");
        login.add(txtPassLogin, "w 60%");
        btnEntrar = new Button();
        btnEntrar.setBackground(new Color(187, 31, 45));
        btnEntrar.setForeground(new Color(250, 250, 250));
        btnEntrar.setText("ENTRAR");
        login.add(btnEntrar, "w 40%, h 40, gaptop 20");
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }

    }

    public void addEventLogin(ActionListener event) {
        btnEntrar.addActionListener(event);
    }

    public void addEventRegister(ActionListener event) {
        btnRegistrarse.addActionListener(event);
    }

    public String getLoginEmail() {
        return txtEmailLogin.getText();
    }

    public String getLoginPassword() {
        // getPassword() devuelve un char[], hay que convertirlo a String
        return String.valueOf(txtPassLogin.getPassword());
    }

    public String getRegisterUserName() {
        return txtUser.getText();
    }

    public String getRegisterEmail() {
        return txtEmail.getText();
    }

    public String getRegisterPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    public void limpiarTodosLosCampos() {
        // Limpiamos Login
        txtEmailLogin.setText("");
        txtPassLogin.setText("");

        // Limpiamos Registro
        txtUser.setText("");
        txtEmail.setText("");
        txtPass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
