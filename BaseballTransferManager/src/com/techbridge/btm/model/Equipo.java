package com.techbridge.btm.model;
/**
 *
 * @author Surky
 */
public class Equipo {
    
    private int idEquipo;
    private String nombre;
    private double presupuesto;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, double presupuesto) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
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
}
