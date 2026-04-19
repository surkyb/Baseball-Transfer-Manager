/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.JugadorDTO;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.service.JugadorService;
import com.techbridge.btm.view.JugadorViewInterface;
/**
 *
 * @author Joshua Abreu
 */
public class JugadorController {
    private JugadorService service;
    private JugadorViewInterface view;

    public JugadorController(JugadorService service, JugadorViewInterface view) {
        this.service = service;
        this.view = view;
    }
    
    //registrar jugador
    public void registrarJugador(){
        try{
            JugadorDTO dto = view.getDatosJugador();
            
            //llamar al services
            service.registrarJugador(
                dto.getNombre(),
                dto.getEdad(),
                dto.getPosicion(),
                dto.getValor()
            );
            
            //respuesta
            view.mostrarMensaje("Jugador registrado correctamente");
            view.limpiarCampos();
        }catch(Exception e){
            view.mostrarError(e.getMessage());
        }
    }
    public java.util.List<Jugador> listarTodosLosJugadores() {
        return service.listarTodosLosJugadores();
    }
}
