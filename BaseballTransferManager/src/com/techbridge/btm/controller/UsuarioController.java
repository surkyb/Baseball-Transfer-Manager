package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.LoginDTO;
import com.techbridge.btm.model.Usuario;
import com.techbridge.btm.service.AuthService;
import com.techbridge.btm.view.AuthViewInterface;

/**
 * @author Surky
 */
public class UsuarioController {

    private final AuthService authService;

    public UsuarioController(AuthService authService) {
        this.authService = authService;
    }

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
            if (authService.login(dto)) {
                loginView.mostrarMensajeExito("Ha sido logeado satisfactoriamente");
                loginView.cerrarVentana();
            }

        } catch (Exception e) {

            loginView.mostrarMensajeError(e.getMessage());
            loginView.limpiarCampos();

        }
    }

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

        Usuario nuevoUsuario = new Usuario(loginView.getRegisterUsername().trim(), loginView.getRegisterEmail().trim(), loginView.getRegisterPassword());

        try {

            authService.registrarUsuario(nuevoUsuario);
            loginView.mostrarMensajeExito("Ha sido registrado satisfactoriamente. Ahora puede iniciar sesión.");
            loginView.limpiarCampos();
        } catch (Exception e) {
            loginView.mostrarMensajeError(e.getMessage());
            loginView.limpiarCampos();
        }
    }
    // ver si el usuario existe, si no pues guardar el registro 

}

/*
Extraiga el usuario y clave de la interfaz

Cree el UsuarioDTO

Llame al authService.login()

Si ta redi, llame a mostrarMensajeExito() y cerrarVentana()

Si falla  atrape la excepción y use mostrarMensajeError y limpiarCampo
*/
