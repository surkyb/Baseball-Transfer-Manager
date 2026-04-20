package com.techbridge.btm;
import com.techbridge.btm.controller.UsuarioController;
import com.techbridge.btm.repository.UsuarioRepository;
import com.techbridge.btm.repository.UsuarioRepositoryImpl;
import com.techbridge.btm.service.AuthService;
import com.techbridge.btm.view.LoginJFrame;

/**
 *
 * @author Surky
 */
public class Main {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

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

        //  Arrancar la aplicación abriendo EL LOGIN 
        java.awt.EventQueue.invokeLater(() -> {
            //  dependencias de autenticación
            UsuarioRepository repo = new UsuarioRepositoryImpl();
            AuthService service = new AuthService(repo);
            UsuarioController controller = new UsuarioController(service);

            // Iniciar la vista de Login
            LoginJFrame view = new LoginJFrame(controller);
            view.setVisible(true);            

        });
    }
}

