/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.controller;

import com.techbridge.btm.model.Contrato;
import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.EstadoContrato;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.service.ContratoService;
import com.techbridge.btm.view.ContratoViewInterface;
import java.time.LocalDate;

/**
 *
 * @author gilber
 */
public class ContratoController {
    
    private ContratoService contratoService = new ContratoService();
    private ContratoViewInterface view;
    
    public void crearContrato(int idJugador, int idEquipo, double salario) {

        try {
            // Validaciones básicas
            if (idJugador <= 0 || idEquipo <= 0) {
                view.mostrarMensajeError("IDs invalidos");
                return;
}

            if (salario <= 0) {
                view.mostrarMensajeError("El salario debe ser mayor a 0");
                return;
            }

            
            // Creamos los objetos necesrios
            Jugador jugador = new Jugador();
            jugador.setId(idJugador);

            Equipo equipo = new Equipo();
            equipo.setIdEquipo(idEquipo);

            Contrato contrato = new Contrato();
            contrato.setJugador(jugador);
            contrato.setEquipo(equipo);
            contrato.setSalario(salario);
            contrato.setFechaInicio(LocalDate.now());
            contrato.setFechaFin(null);
            contrato.setEstadoContrato(EstadoContrato.ACTIVO);

            // Llamar al service
            contratoService.crearContrato(contrato);

            // Mensaje de éxito
            view.mostrarMensajeExito("Contrato creado con exito");
            
            view.limpiarCampos();

        } catch (IllegalArgumentException e) {

            view.mostrarMensajeError("Error en los datos");

        } catch (Exception e) {

            view.mostrarMensajeError("Error inesperado al realizar el contrato");
            e.printStackTrace();
        }
    }

    

    
    public Contrato buscarContrato(int idContrato) {

        try {
            if (idContrato <= 0) {
                view.mostrarMensajeError("Id invalido");
            }

            return contratoService.buscarContrato(idContrato);

        } catch (Exception e) {

            view.mostrarMensajeError("Error inesperado al realizar la busqueda");
            e.printStackTrace();
            return null;
        }
    }

   
    public void cancelarContrato(int idContrato) {

        try {
            if (idContrato <= 0) {
                view.mostrarMensajeError("Id invalido");
                return;
            }

            contratoService.cancelarContrato(idContrato);

            view.mostrarMensajeExito("Contrato eliminado correctamente");

        } catch (IllegalArgumentException e) {

            view.mostrarMensajeError("Error en los datos ingresados");

        } catch (Exception e) {

            view.mostrarMensajeError("Error inesperado al realizar la cancelacion");
        }
    }
}

