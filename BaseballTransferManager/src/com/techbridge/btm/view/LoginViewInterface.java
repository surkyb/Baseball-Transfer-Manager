package com.techbridge.btm.view;

/**
 *
 * @author Surky
 */
public interface LoginViewInterface {
    //Esta interfaz le dirá al controlador qué cosas puede pedirle o mandarle a la pantalla
    
    // Para obtener los datos que escribió el usuario
    String getUsername();
    String getPassword();
    String getCorreo();
    
    // Para mostrarle mensajes al usuario
    void mostrarMensajeError(String mensaje);
    void mostrarMensajeExito(String mensaje);
    
    // Para limpiar las cajas de texto si se equivoca
    void limpiarCampos();
    
    // Para cerrar la ventana cuando logre entrar
    void cerrarVentana();
    
}
