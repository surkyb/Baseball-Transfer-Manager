
package com.techbridge.btm.DTO;

/**
 *
 * @author Surky
 */
public class EstadisticasDTO {

    private int idEstadisticas;
    private int idJugador;
    private int juegos;
    private int hits;
    private int homeRuns;
    private int rbis;
    private double promedioBateo;
    private int turnosAlBate;
    private int baseXBola;
    private int ponches;
    private int basesRobadas;
    private int carrerasAnotadas;

    public EstadisticasDTO(int idEstadisticas, int idJugador, int juegos, int hits,
                           int homeRuns, int rbis, double promedioBateo,
                           int turnosAlBate, int baseXBola, int ponches,
                           int basesRobadas, int carrerasAnotadas) {

        this.idEstadisticas = idEstadisticas;
        this.idJugador = idJugador;
        this.juegos = juegos;
        this.hits = hits;
        this.homeRuns = homeRuns;
        this.rbis = rbis;
        this.promedioBateo = promedioBateo;
        this.turnosAlBate = turnosAlBate;
        this.baseXBola = baseXBola;
        this.ponches = ponches;
        this.basesRobadas = basesRobadas;
        this.carrerasAnotadas = carrerasAnotadas;
    }

    
    public int getIdEstadisticas() { return idEstadisticas; }
    public int getIdJugador() { return idJugador; }
    public int getJuegos() { return juegos; }
    public int getHits() { return hits; }
    public int getHomeRuns() { return homeRuns; }
    public int getRbis() { return rbis; }
    public double getPromedioBateo() { return promedioBateo; }
    public int getTurnosAlBate() { return turnosAlBate; }
    public int getBaseXBola() { return baseXBola; }
    public int getPonches() { return ponches; }
    public int getBasesRobadas() { return basesRobadas; }
    public int getCarrerasAnotadas() { return carrerasAnotadas; }

    public void setIdJugador(int jugadorSeleccionadoId) {
    this.idJugador = idJugador;
    }
}