package com.techbridge.btm.view;

/**
 *
 * @author Surky
 */
import com.techbridge.btm.controller.UsuarioController;
import com.techbridge.btm.repository.UsuarioRepositoryImpl;
import com.techbridge.btm.service.AuthService;

import javax.swing.*;
import java.awt.*;

/**
 * @author Surky
 */
public class LoginJFrame extends JFrame implements LoginViewInterface {

    // 1. Declaramos los componentes visuales
    private JTextField txtUsername;
    private JTextField txtCorreo;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegistro;

    private UsuarioController controller;

    public LoginJFrame() {
        // Configuraciones básicas de la ventana
        setTitle("Baseball Team Manager - Acceso");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setResizable(false);

        // 3. Inicializamos las dependencias del MVC
        UsuarioRepositoryImpl repo = new UsuarioRepositoryImpl();
        AuthService service = new AuthService(repo);
        this.controller = new UsuarioController(service);

        // 4. Construimos la interfaz gráfica
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new GridLayout(4, 2, 10, 15));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

        // Instanciamos las cajas de texto
        txtUsername = new JTextField();
        txtCorreo = new JTextField();
        txtPassword = new JPasswordField();

        btnLogin = new JButton("Entrar");
        btnRegistro = new JButton("Registrarse");

        panelPrincipal.add(new JLabel("Usuario:"));
        panelPrincipal.add(txtUsername);

        panelPrincipal.add(new JLabel("Correo (Solo Registro):"));
        panelPrincipal.add(txtCorreo);

        panelPrincipal.add(new JLabel("Contraseña:"));
        panelPrincipal.add(txtPassword);

        panelPrincipal.add(btnLogin);
        panelPrincipal.add(btnRegistro);

        // Agregamos el panel a la ventana
        this.add(panelPrincipal);

        // Cuando le den clic a Entrar llamamos al procesarLogin del controlador y le pasamos "this" (esta ventana)
        btnLogin.addActionListener(e -> controller.procesarLogin(this));

        // Cuando le den clic a Registrarse llamamos al procesarRegistro
        btnRegistro.addActionListener(e -> controller.procesarRegistro(this));
    }


    @Override
    public String getUsername() {
        return txtUsername.getText();
    }

    @Override
    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    @Override
    public String getCorreo() {
        return txtCorreo.getText();
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void limpiarCampos() {
        txtUsername.setText("");
        txtCorreo.setText("");
        txtPassword.setText("");
    }

    @Override
    public void cerrarVentana() {
        this.dispose(); // Destruye esta ventana
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginJFrame().setVisible(true);
        });
    }
}
