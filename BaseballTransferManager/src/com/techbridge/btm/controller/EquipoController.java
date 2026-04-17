/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.EquipoDTO;
import com.techbridge.btm.service.EquipoService;
import com.techbridge.btm.view.EquipoViewInterface;
/**
 *
 * @author Joshua Abreu
 */
public class EquipoController {
    private EquipoService service;
    private EquipoViewInterface view;
    
    public EquipoController(EquipoService service, EquipoViewInterface view){
        this.service = service;
        this.view = view;
    }
    
    public void registrarEquipo(){
        try{
            //Obtener datos mediante DTO
            EquipoDTO dto = view.getDatosEquipo();

            // Llamar al service por DTO
            service.registrarEquipo(dto.getNombre(), dto.getPresupuesto());

            // Respuesta
            view.mostrarMensaje("Equipo registrado correctamente");

            // Limpiar 
            view.limpiarCampos();

        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }
}
