/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.JugadorDTO;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.service.JugadorService;
import com.techbridge.btm.view.JugadorViewInterface;
import java.util.ArrayList;
import java.util.List;
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
    //metodo para hacer agente libre un jugador
    public void liberarJugador(String nombreJugador) throws Exception {
        service.liberarJugador(nombreJugador);
    }
    
    public void asignarEquipo(String nombreJugador, String nombreEquipo, String salario, String fInicio, String fFin) throws Exception {
        service.asignarEquipo(nombreJugador, nombreEquipo, salario, fInicio, fFin);
    }
    
    public void renovarContrato(String nombreJugador, String nuevoSalario, String nuevaFechaFin) throws Exception {
        service.renovarContrato(nombreJugador, nuevoSalario, nuevaFechaFin);
    }
    
    public String obtenerDetallesJugador(String nombreJugador) throws Exception {
        return service.obtenerDetallesJugador(nombreJugador);
    }

    // Método para eliminar jugador conectado a la base de datos
    public void eliminarJugador(String nombreJugador) throws Exception {
        service.eliminarJugador(nombreJugador);
    }
    public List<Object[]> listarJugadoresParaTabla() {
        List<Jugador> jugadores = service.listarTodosLosJugadores();
        List<Object[]> datos = new ArrayList<>();

        for (Jugador j : jugadores) {
            datos.add(new Object[]{
                j.getId(),
                j.getNombre(),
                j.getPosicion()
            });
        }

        return datos;
    }
    public java.util.List<com.techbridge.btm.model.Jugador> listarJugadoresPorEquipo(String nombreEquipo) throws Exception {
        return service.listarJugadoresPorEquipo(nombreEquipo); // Asegúrate que tu variable del service se llame así
    }
}


    