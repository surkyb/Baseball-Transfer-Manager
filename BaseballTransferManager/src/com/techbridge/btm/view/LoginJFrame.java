package com.techbridge.btm.view;

import com.techbridge.btm.controller.UsuarioController;
import com.techbridge.btm.view.components.PanelCover;
import com.techbridge.btm.view.components.PanelLoginAndRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Ventana principal de autenticación (Login y Registro). Implementa la interfaz
 * AuthViewInterface para comunicarse con el controlador.
 *
 * @author Surky
 */
public class LoginJFrame extends javax.swing.JFrame implements AuthViewInterface {

    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginAndRegister loginAndRegister;
    private boolean isLogin = true;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("###0.###");
    private final UsuarioController usuarioController;

    /**
     * Constructor que recibe el controlador para manejar la lógica.
     *
     * @param controlador instancia del controlador de usuario
     */
    public LoginJFrame(UsuarioController controlador) {
        this.usuarioController = controlador;
        initComponents();
        init();
    }

    /**
     * Inicializa la interfaz gráfica, configura las animaciones entre login y
     * registro y asigna los eventos de los botones.
     */
    private void init() {
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loginAndRegister = new PanelLoginAndRegister();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.registerRight(fractionCover * 100);
                    } else {
                        cover.loginRight(fractionLogin * 100);
                    }

                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.registerLeft(fraction * 100);
                    } else {
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }

        };
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(loginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        loginAndRegister.showRegister(!isLogin);
        cover.login(isLogin);
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        // Evento del botón de login: llama al controlador
        // para procesar el inicio de sesión
        loginAndRegister.addEventLogin(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // El JFrame se pasa a sí mismo (this) porque él ES la interfaz AuthViewInterface
                usuarioController.procesarLogin(LoginJFrame.this);
            }

        });
        // Evento del botón de registro: llama al controlador
        // para procesar el registro del usuario
        loginAndRegister.addEventRegister(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                usuarioController.procesarRegistro(LoginJFrame.this);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 936, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables

    /**
     * Devuelve el email ingresado en el formulario de login.
     * @return 
     */
    @Override
    public String getLoginEmail() {
        return loginAndRegister.getLoginEmail();
    }

    /**
     * Devuelve la contraseña ingresada en el formulario de login.
     * @return 
     */
    @Override
    public String getLoginPassword() {
        return loginAndRegister.getLoginPassword();
    }

    /**
     * Muestra un mensaje de error en un cuadro de diálogo.
     * @param mensaje
     */
    @Override
    public void mostrarMensajeError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Error de Acceso", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de éxito en un cuadro de diálogo.
     * @param mensaje
     */
    @Override
    public void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * Limpia todos los campos del formulario.
     */
    @Override
    public void limpiarCampos() {
        loginAndRegister.limpiarTodosLosCampos();
    }

    /**
     * Cierra la ventana actual.
     */
    @Override
    public void cerrarVentana() {
        this.dispose();
    }

    /**
     * Devuelve el nombre de usuario ingresado en el registro.
     * @return 
     */
    @Override
    public String getRegisterUsername() {
        return loginAndRegister.getRegisterUserName();
    }

    /**
     * Devuelve el email ingresado en el registro.
     * @return 
     */
    @Override
    public String getRegisterEmail() {
        return loginAndRegister.getRegisterEmail();
    }

    /**
     * Devuelve la contraseña ingresada en el registro.
     * @return 
     */
    @Override
    public String getRegisterPassword() {
        return loginAndRegister.getRegisterPassword();
    }

}
