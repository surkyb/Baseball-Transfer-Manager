/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.service;

import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.repository.JugadorRepository;

/**
 *
 * @author Joshua Abreu
 */
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }
    
    public void registrarJugador(String nombre, int edad, String posicion, double valor)throws Exception{
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("El nombre es obligatorio");
        }
        if(edad <= 0){
            throw new Exception("Edad inválida");
        }
        if(posicion == null || posicion.trim().isEmpty()){
            throw new Exception("La posición es obligatoria");
        }
        if(valor <= 0){
            throw new Exception("Valor inválida");
        }
        
        //Construccion dle objeto
        Jugador ju = new Jugador();
        ju.setNombre(nombre);
        ju.setEdad(edad);
        ju.setPosicion(posicion);
        ju.setValor(valor);
        
        ju.setEsJugadorActivo(true);
        
        jugadorRepository.guardar(ju);
    }
    
    public Jugador buscarJugador(String nombre)throws Exception{
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("Nombre inválido");
        }
        Jugador jugador = jugadorRepository.buscarJugador(nombre);
        
        if(jugador == null){
            throw new Exception("Jugador no encontrado");
        }
        return jugador;
    }
    
    public void eliminarJugador(String nombre)throws Exception{
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("Nombre inválido ");
        }
        Jugador jugador = jugadorRepository.buscarJugador(nombre);
        
        if(jugador == null){
            throw new Exception("El Jugador no existe");
        }
        jugadorRepository.eliminar(nombre);
    }
    public java.util.List<Jugador> listarTodosLosJugadores() {
        // retornamos lo que da la base de datos.
        return jugadorRepository.listarTodos();
    }
    
    public void liberarJugador(String nombreJugador) throws Exception {
        jugadorRepository.liberarJugador(nombreJugador);
    }
    
    public void asignarEquipo(String nombreJugador, String nombreEquipo, String salario, String fInicio, String fFin) throws Exception {
        jugadorRepository.asignarEquipo(nombreJugador, nombreEquipo, salario, fInicio, fFin);
    }
    
    public void renovarContrato(String nombreJugador, String nuevoSalario, String nuevaFechaFin) throws Exception {
        jugadorRepository.renovarContrato(nombreJugador, nuevoSalario, nuevaFechaFin);
    }
    
    public String obtenerDetallesJugador(String nombreJugador) throws Exception {
        return jugadorRepository.obtenerDetallesJugador(nombreJugador);
    }
}
