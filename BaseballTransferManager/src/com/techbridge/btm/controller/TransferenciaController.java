package com.techbridge.btm.controller;

import com.techbridge.btm.service.TransferenciaService;
import com.techbridge.btm.view.TransferenciaViewInterface;
/**
 *
 * @author Joshua Abreu
 */
public class TransferenciaController {
    
    private final TransferenciaService service;
    private final TransferenciaViewInterface view;
    
    // constructor
    public TransferenciaController(TransferenciaViewInterface view, TransferenciaService service) {
        this.view = view;
        this.service = service;
    }

    // metodo principal conectado a la vista
    public void realizarTransferencia() {

        try {
            int idJugador = view.getIdJugador();
            int idOrigen = view.getIdEquipoOrigen();
            int idDestino = view.getIdEquipoDestino();
            double monto = view.getMonto();

            // validacion 
            if (idJugador <= 0 || idOrigen <= 0 || idDestino <= 0) {
                view.mostrarMensajeError("IDs inválidos");
                return;
            }

            if (monto <= 0) {
                view.mostrarMensajeError("El monto debe ser mayor a 0");
                return;
            }

            // llamada al service
            service.transferirJugador(idJugador, idOrigen, idDestino, monto);

            // mensaje de exito
            view.mostrarMensajeExito("Transferencia realizada correctamente");
            view.limpiarCampos();

        } catch (NumberFormatException e) {
            view.mostrarMensajeError("Por favor, ingrese números válidos en los campos correspondientes.");
        } catch (Exception e) {
            view.mostrarMensajeError(e.getMessage());
        }
    }
        // metodo opcional para pruebas o uso directo
    public void transferirJugador(int idJugador, int idOrigen, int idDestino, double monto) throws Exception {
        service.transferirJugador(idJugador, idOrigen, idDestino, monto);
    }
}
