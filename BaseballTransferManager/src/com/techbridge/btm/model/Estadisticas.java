/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.model;

/**
 *
 * @author surky
 */
public class Estadisticas {
    
    private int idEstadisticas;
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
    
    
    

    public Estadisticas() {
    }

    public Estadisticas(int juegos, int hits, int homeRuns, int rbis, double promedioBateo) {
        this.juegos = juegos;
        this.hits = hits;
        this.homeRuns = homeRuns;
        this.rbis = rbis;
        this.promedioBateo = promedioBateo;
    }

    public int getJuegos() {
        return juegos;
    }

    public void setJuegos(int juegos) {
        this.juegos = juegos;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public int getRbis() {
        return rbis;
    }

    public void setRbis(int rbis) {
        this.rbis = rbis;
    }

    public double getPromedioBateo() {
        return promedioBateo;
    }

    public void setPromedioBateo(double promedioBateo) {
        this.promedioBateo = promedioBateo;
    }

    public int getIdEstadisticas() {
        return idEstadisticas;
    }

    public void setIdEstadisticas(int idEstadisticas) {
        this.idEstadisticas = idEstadisticas;
    }

    public int getTurnosAlBate() {
        return turnosAlBate;
    }

    public void setTurnosAlBate(int turnosAlBate) {
        this.turnosAlBate = turnosAlBate;
    }

    public int getBaseXBola() {
        return baseXBola;
    }

    public void setBaseXBola(int baseXBola) {
        this.baseXBola = baseXBola;
    }

    public int getPonches() {
        return ponches;
    }

    public void setPonches(int ponches) {
        this.ponches = ponches;
    }

    public int getBasesRobadas() {
        return basesRobadas;
    }

    public void setBasesRobadas(int basesRobadas) {
        this.basesRobadas = basesRobadas;
    }

    public int getCarrerasAnotadas() {
        return carrerasAnotadas;
    }

    public void setCarrerasAnotadas(int carrerasAnotadas) {
        this.carrerasAnotadas = carrerasAnotadas;
    }
    
    
    
}
