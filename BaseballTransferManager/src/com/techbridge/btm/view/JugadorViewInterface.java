/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.view;

import com.techbridge.btm.DTO.JugadorDTO;
/**
 *
 * @author Joshua Abreu
 */
public interface JugadorViewInterface {
    //entrada de datos
    JugadorDTO getDatosJugador();
    
    //salida de datos
    void mostrarMensaje(String mensaje);
    void mostrarError(String error);
    
    void limpiarCampos();
}
