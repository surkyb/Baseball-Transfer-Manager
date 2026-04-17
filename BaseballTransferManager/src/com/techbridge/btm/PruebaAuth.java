package com.techbridge.btm;

/**
 *
 * @author Surky
 */
import com.techbridge.btm.controller.UsuarioController;
import com.techbridge.btm.repository.UsuarioRepository;
import com.techbridge.btm.repository.UsuarioRepositoryImpl;
import com.techbridge.btm.service.AuthService;
import com.techbridge.btm.view.LoginJFrame;

public class PruebaAuth {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginJFrame.class.getName());

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {

            // 1. Repositorio
            UsuarioRepository repo = new UsuarioRepositoryImpl();

            // 2. Servicio
            AuthService service = new AuthService(repo);

            // 3. Controlador
            UsuarioController controller = new UsuarioController(service);

            // 4. Vista
            LoginJFrame view = new LoginJFrame(controller);
            view.setVisible(true);
        });
    }
}
