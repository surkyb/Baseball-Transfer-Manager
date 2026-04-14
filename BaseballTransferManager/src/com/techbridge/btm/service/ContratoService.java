package com.techbridge.btm.service;

import com.techbridge.btm.model.Contrato;
import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.EstadoContrato;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.repository.ContratoRepository;
import java.time.LocalDate;

/**
 *
 * @author gilber
 */
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public void crearContrato(int idJugador, int idEquipo, double salario){

        if (idJugador <= 0 || idEquipo <= 0) {
            throw new IllegalArgumentException("IDs inválidos.");
        }
        if (salario <= 0) {
            throw new IllegalArgumentException("El salario debe ser mayor a cero.");
        }

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

        contratoRepository.guardarContrato(contrato);
    }

    public Contrato buscarContrato(int idContrato){
        if (idContrato <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        return contratoRepository.buscarContrato(idContrato);
    }

    public void cancelarContrato(int idContrato){
        if (idContrato <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }

        Contrato contratoExistente = contratoRepository.buscarContrato(idContrato);
        if (contratoExistente == null) {
            throw new IllegalArgumentException("El contrato no existe.");
        }

        contratoRepository.cancelarContrato(idContrato);
    }
}
