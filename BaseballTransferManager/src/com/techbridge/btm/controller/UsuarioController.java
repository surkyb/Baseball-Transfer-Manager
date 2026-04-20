package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.LoginDTO;
import com.techbridge.btm.view.Dashboard;
import com.techbridge.btm.model.Usuario;
import com.techbridge.btm.service.AuthService;
import com.techbridge.btm.view.AuthViewInterface;

/**
 * Controlador encargado de manejar la lógica entre la vista y el servicio.
 * Gestiona el login y el registro de usuarios.
 * @author Surky
 */
public class UsuarioController {

    private final AuthService authService;

    public UsuarioController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Procesa el login del usuario.
     * Valida los campos, crea el DTO y delega al servicio.
     * @param loginView vista que implementa la interfaz
     */
    public void procesarLogin(AuthViewInterface loginView) {
        //validar si los campos están vacíos
        if (loginView.getLoginEmail().trim().isEmpty() || loginView.getLoginPassword().isEmpty()) {
            loginView.mostrarMensajeError("Por favor, llena todos los campos de acceso.");
            return;
        }

        if (!loginView.getLoginEmail().contains("@")) {
            loginView.mostrarMensajeError("Correo invalido");
            return;
        }

        LoginDTO dto = new LoginDTO(loginView.getLoginEmail().trim(), loginView.getLoginPassword());

        try {
            // Llamar al servicio
            if (authService.login(dto)) {
                loginView.cerrarVentana();
                
              java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        Dashboard dashboard = new Dashboard();
                        dashboard.setVisible(true);
                    }
                });
              
            }

        } catch (Exception e) {

            loginView.mostrarMensajeError(e.getMessage());
            loginView.limpiarCampos();

        }
    }
    /**
     * Procesa el registro de un nuevo usuario.
     * Valida datos y delega al servicio.
     * @param loginView vista que contiene los datos del registro
     */
    public void procesarRegistro(AuthViewInterface loginView) {
        if (loginView.getRegisterUsername().trim().isEmpty()
                || loginView.getRegisterEmail().trim().isEmpty()
                || loginView.getRegisterPassword().isEmpty()) {
            loginView.mostrarMensajeError("Todos los campos son obligatorios para registrarse.");
            return;
        }

        if (!loginView.getRegisterEmail().contains("@")) {
            loginView.mostrarMensajeError("Por favor, ingrese un correo válido para registrarse.");
            return;
        }

        Usuario nuevoUsuario = new Usuario(
                loginView.getRegisterUsername().trim(), 
                loginView.getRegisterPassword(), 
                loginView.getRegisterEmail().trim()
        );

        try {

            authService.registrarUsuario(nuevoUsuario);
            loginView.mostrarMensajeExito("Ha sido registrado satisfactoriamente. Ahora puede iniciar sesión.");
            loginView.limpiarCampos();
        } catch (Exception e) {
            loginView.mostrarMensajeError(e.getMessage());
            loginView.limpiarCampos();
        }
    }
}
