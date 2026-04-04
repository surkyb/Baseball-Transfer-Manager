package com.techbridge.btm;

/**
 *
 * @author Surky
 */

import com.techbridge.btm.controller.UsuarioController;
import com.techbridge.btm.repository.UsuarioRepositoryImpl;
import com.techbridge.btm.service.AuthService;
import com.techbridge.btm.view.LoginViewInterface;

public class PruebaAuth {

    public static void main(String[] args) {
        
        //inyectamos dependencias
        UsuarioRepositoryImpl repo = new UsuarioRepositoryImpl();
        AuthService service = new AuthService(repo);
        UsuarioController controller = new UsuarioController(service);

        LoginViewInterface pantallaSimulada = new LoginViewInterface() {
            @Override
            public String getUsername() { return "surky_dev"; } 
            
            @Override
            public String getPassword() { return "Secreto123"; } 
            
            @Override
            public String getCorreo() { return "surky@itla.edu.do"; } 
            
            @Override
            public void mostrarMensajeError(String mensaje) { 
                System.out.println("ERROR EN PANTALLA: " + mensaje); 
            }
            
            @Override
            public void mostrarMensajeExito(String mensaje) { 
                System.out.println(" ÉXITO EN PANTALLA: " + mensaje); 
            }
            
            @Override
            public void limpiarCampos() { 
                System.out.println("(Borrando campos de texto...)"); 
            }
            
            @Override
            public void cerrarVentana() { 
                System.out.println("(Cerrando la ventana de Login...)"); 
            }
        };

        System.out.println(" PRUEBA 1: REGISTRO (SIGN UP) ---");
        controller.procesarRegistro(pantallaSimulada);

        System.out.println(" PRUEBA 2: INICIO DE SESIÓN (LOGIN) ---");
        controller.procesarLogin(pantallaSimulada);
        
        System.out.println("PRUEBA 3: FORZAR UN ERROR ---");
        //   intentar registrar a la misma persona 
        controller.procesarRegistro(pantallaSimulada);
    }
}
