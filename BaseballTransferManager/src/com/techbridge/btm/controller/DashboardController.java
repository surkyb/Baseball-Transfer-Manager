package com.techbridge.btm.controller;

import com.techbridge.btm.repository.DashboardRepositoryImpl;

/**
 *
 * @author UserGPC
 */
public class DashboardController {
    
    private DashboardRepositoryImpl repo;

    public DashboardController() {
        this.repo = new DashboardRepositoryImpl();
    }

    public int getTotalJugadores() {
        return repo.obtenerTotal("jugador");
    }

    public int getTotalEquipos() {
        return repo.obtenerTotal("equipo");
    }

    public int getTotalTransacciones() {
        return repo.obtenerTotal("transferencia");
    }
}
