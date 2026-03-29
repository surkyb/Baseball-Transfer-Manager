package com.techbridge.btm.model;

import java.time.LocalDate;

/**
 *
 * @author Surky
 */
public class Contrato {
    
    private int idContrato;
    private Jugador jugador;
    private Equipo equipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double salario;
    private EstadoContrato estadoContrato;

    public Contrato() {
    }

    public Contrato(int idContrato, Jugador jugador, Equipo equipo, LocalDate fechaInicio, LocalDate fechaFin, double salario, EstadoContrato estadoContrato) {
        this.idContrato = idContrato;
        this.jugador = jugador;
        this.equipo = equipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.salario = salario;
        this.estadoContrato = estadoContrato;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public EstadoContrato getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(EstadoContrato estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

}
