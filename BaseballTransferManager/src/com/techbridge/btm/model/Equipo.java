/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.model;

import java.util.ArrayList;

/**
 *
 * @author Surky
 */
public class Equipo {
    
    private int idEquipo;
    private String nombre;
    private double presupuesto;
    private ArrayList<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, double presupuesto, ArrayList<Jugador> jugadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.jugadores = jugadores;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
            
    
}
