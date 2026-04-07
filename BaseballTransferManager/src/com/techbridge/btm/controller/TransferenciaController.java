/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.controller;

import com.techbridge.btm.model.Transferencia;
import com.techbridge.btm.service.TransferenciaService;
import com.techbridge.btm.view.TransferenciaViewInterface;
/**
 *
 * @author Joshua Abreu
 */
public class TransferenciaController {
    private TransferenciaService service;
    private TransferenciaViewInterface view;
    
    // constructor
    public TransferenciaController(TransferenciaViewInterface view) {
        this.view = view;
        this.service = new TransferenciaService();
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
            view.mostrarMensajeError("Error en los datos ingresados");

        } catch (Exception e) {
            view.mostrarMensajeError("Error inesperado al realizar la transferencia");
            e.printStackTrace();
        }
    }

    // metodo opcional para pruebas o uso directo
    public void transferirJugador(int idJugador, int idOrigen, int idDestino, double monto) {
        service.transferirJugador(idJugador, idOrigen, idDestino, monto);
    }
}
    
