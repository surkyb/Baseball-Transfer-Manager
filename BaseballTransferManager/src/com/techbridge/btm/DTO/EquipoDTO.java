/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.DTO;

/**
 *
 * @author Joshua Abreu
 */
public class EquipoDTO {
    private String nombre;
    private double presupuesto;
    
    public EquipoDTO(){
        
    }
    public EquipoDTO(String nombre, double presupuesto){
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public double getPresupuesto(){
        return presupuesto;
    }
    public void setPresupuesto(double presupuesto){
        this.presupuesto = presupuesto;
    }
}
