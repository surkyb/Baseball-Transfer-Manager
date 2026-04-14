package com.techbridge.btm.view;

import com.techbridge.btm.model.Contrato;
import com.techbridge.btm.model.EstadoContrato;

/**
 *
 * @author gilber
 */
public interface ContratoViewInterface {
    
    //para obtener los datos desde la vista
    int getIdJugador();
    int getIdEquipo();
    int getIdContrato();
    double getSalario();
    EstadoContrato getEstadoContrato();
    void mostrarDetallesContrato(Contrato contrato);
    
    //para mostrarle mensajes al usuario
    void mostrarMensajeError(String mensaje);
    void mostrarMensajeExito(String mensaje);
    
    
    //para limpiar la pantalla después de una transferencia
    void limpiarCampos();
    
}
