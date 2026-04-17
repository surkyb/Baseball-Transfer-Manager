package com.techbridge.btm.model;

import java.time.LocalDate;

/**
 *
 * @author Surky
 */
public class Transferencia {

    private int idTransferencia;
    private Jugador jugador;
    private Equipo equipoOrigen;
    private Equipo equipoDestino;
    private double monto;
    private LocalDate fecha;

    public Transferencia() {
    }

    public Transferencia(int idTransferencia, Jugador jugador, Equipo equipoOrigen, Equipo equipoDestino, double monto, LocalDate fecha) {
        this.idTransferencia = idTransferencia;
        this.jugador = jugador;
        this.equipoOrigen = equipoOrigen;
        this.equipoDestino = equipoDestino;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(int idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipoOrigen() {
        return equipoOrigen;
    }

    public void setEquipoOrigen(Equipo equipoOrigen) {
        this.equipoOrigen = equipoOrigen;
    }

    public Equipo getEquipoDestino() {
        return equipoDestino;
    }

    public void setEquipoDestino(Equipo equipoDestino) {
        this.equipoDestino = equipoDestino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
