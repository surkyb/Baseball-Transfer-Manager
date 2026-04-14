package com.techbridge.btm.controller;

import com.techbridge.btm.model.Contrato;
import com.techbridge.btm.service.ContratoService;
import com.techbridge.btm.view.ContratoViewInterface;

/**
 *
 * @author gilber
 */
public class ContratoController {

    private final ContratoService contratoService;
    private final ContratoViewInterface view;

    public ContratoController(ContratoService contratoService, ContratoViewInterface view) {
        this.view = view;
        this.contratoService = contratoService;
    }

    public void crearContrato() {
        try {

            //pasando datos de la vista
            int idJugador = view.getIdJugador();
            int idEquipo = view.getIdEquipo();
            double salario = view.getSalario();

            // Validaciones básicas
            if (idJugador <= 0 || idEquipo <= 0) {
                view.mostrarMensajeError("IDs invalidos");
                return;
            }

            if (salario <= 0) {
                view.mostrarMensajeError("El salario debe ser mayor a 0");
                return;
            }

            //pasando los datos crudos al service
            contratoService.crearContrato(idJugador, idEquipo, salario);
            view.mostrarMensajeExito("Contrato creado con éxito");
            view.limpiarCampos();
            
        } catch (IllegalArgumentException e) {
            view.mostrarMensajeError("Por favor ingrese números válidos.");
        } catch (Exception e) {
            view.mostrarMensajeError(e.getMessage());
        }
    }

    public void buscarContrato() {

        try {
            int idContrato = view.getIdContrato();

            if (idContrato <= 0) {
                view.mostrarMensajeError("Id invalido");
                return;
            }

            Contrato contrato = contratoService.buscarContrato(idContrato);
            if (contrato != null) {
                view.mostrarDetallesContrato(contrato);
                view.mostrarMensajeExito("Contrato encontrado");
            } else {
                view.mostrarMensajeError("No se encontró el contrato");
            }

        } catch (Exception e) {
            view.mostrarMensajeError(e.getMessage()); 
        }
    }

    public void cancelarContrato() {
        try {
            int idContrato = view.getIdContrato();
            if (idContrato <= 0) {
                view.mostrarMensajeError("Id invalido");
                return;
            }

            contratoService.cancelarContrato(idContrato);
            view.mostrarMensajeExito("Contrato cancelado correctamente");
            view.limpiarCampos();
            
        } catch (IllegalArgumentException e) {
            view.mostrarMensajeError("Error en los datos ingresados");
        } catch (Exception e) {
            view.mostrarMensajeError("Ocurrió un error inesperado."); 
        }
    }
}
