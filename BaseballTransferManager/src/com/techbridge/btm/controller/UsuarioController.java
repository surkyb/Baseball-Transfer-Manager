package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.LoginDTO;
import com.techbridge.btm.model.Usuario;
import com.techbridge.btm.service.AuthService;
import com.techbridge.btm.view.LoginViewInterface;

/**
 * @author Surky
 */
public class UsuarioController {
    
    private final AuthService authService;

    public UsuarioController(AuthService authService) {
        this.authService = authService;
    }

    public void procesarLogin(LoginViewInterface loginView) {
        LoginDTO dto = new LoginDTO(loginView.getUsername(), loginView.getPassword());
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
    
    public void procesarRegistro(LoginViewInterface loginView) {

        Usuario nuevoUsuario = new Usuario(loginView.getUsername(), loginView.getCorreo(), loginView.getPassword());

        try {

            authService.registrarUsuario(nuevoUsuario);

            loginView.mostrarMensajeExito("Ha sido registrado satisfactoriamente");
            loginView.cerrarVentana();

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