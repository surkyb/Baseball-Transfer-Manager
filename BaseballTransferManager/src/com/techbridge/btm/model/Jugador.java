/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.model;

/**
 *
 * @author surky
 */
public class Jugador {

    private int id;
    private String nombre;
    private int edad;
    private String posicion;
    private double valor;
    private boolean esJugadorActivo;

    private Estadisticas estadisticas;
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(int id, String nombre, int edad, String posicion, double valor, boolean esJugadorActivo, Estadisticas estadisticas, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.valor = valor;
        this.esJugadorActivo = esJugadorActivo;
        this.estadisticas = estadisticas;
        this.equipo = equipo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEsJugadorActivo() {
        return esJugadorActivo;
    }

    public void setEsJugadorActivo(boolean esJugadorActivo) {
        this.esJugadorActivo = esJugadorActivo;
    }

    public Estadisticas getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(Estadisticas estadisticas) {
        this.estadisticas = estadisticas;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
  
}
