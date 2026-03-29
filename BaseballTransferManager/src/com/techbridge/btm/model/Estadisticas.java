/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.model;

/**
 *
 * @author UserGPC
 */
public class Estadisticas {
    
    private int juegos;
    private int hits;
    private int homeRuns;
    private int rbis;
    private double promedioBateo;

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

    
    
}
