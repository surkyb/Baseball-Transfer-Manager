/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.view;

/**
 *
 * @author Joshua Abreu
 */
public interface TransferenciaViewInterface {
    
    //para obtener los datos desde la vista
    int getIdJugador();
    int getIdEquipoOrigen();
    int getIdEquipoDestino();
    double getMonto();
    
    
    //para mostrarle mensajes al usuario
    void mostrarMensajeError(String mensaje);
    void mostrarMensajeExito(String mensaje);
    
    //para limpiar la pantalla después de una transferencia
    void limpiarCampos();
}
