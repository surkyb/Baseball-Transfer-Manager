/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.techbridge.btm.view;

import com.techbridge.btm.model.EstadoContrato;
import java.time.LocalDate;

/**
 *
 * @author gilber
 */
public interface ContratoViewInterface {
    
    //para obtener los datos desde la vista
    int getIdJugador();
    int getIdEquipo();
    LocalDate getFechaInicio();
    LocalDate getFechaFin();
    double getSalario();
    EstadoContrato getEstadoContrato();
    
    //para mostrarle mensajes al usuario
    void mostrarMensajeError(String mensaje);
    void mostrarMensajeExito(String mensaje);
    
    //para limpiar la pantalla después de una transferencia
    void limpiarCampos();
}
