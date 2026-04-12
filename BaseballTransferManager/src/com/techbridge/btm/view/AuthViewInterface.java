package com.techbridge.btm.view;

/**
 * Interfaz que define la comunicación entre la vista (UI)
 * y el controlador. Permite obtener datos del usuario
 * y mostrar mensajes en pantalla.
 * 
 * @author Surky
 */
public interface AuthViewInterface {
    
    // Para obtener los datos que escribió el usuario en el login
    String getLoginEmail();
    String getLoginPassword();
    
    //los datos que escribio en el register
    String getRegisterUsername();
    String getRegisterEmail();
    String getRegisterPassword();
    
    
    // Para mostrarle mensajes al usuario
    void mostrarMensajeError(String mensaje);
    void mostrarMensajeExito(String mensaje);
    
    // Para limpiar las cajas de texto si se equivoca
    void limpiarCampos();
    
    // Para cerrar la ventana cuando logre entrar
    void cerrarVentana();
    
}
