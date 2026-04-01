package com.techbridge.btm.repository;

import com.techbridge.btm.model.Jugador;


/**
 *
 * @author gilber
 */
public interface JugadorRepository {
    // Aqui creamos este metodo para poder guardar los jugadores dados por el GUI
    void guardar(Jugador ju); 
    
    // Esto lo creamos para poder buscar un jugador por su nombre
    Jugador buscarJugador (String nombre);
    
    // Este otro metodo lo creamos para eliminar un jugador
    void eliminar(String nombre);
    
}
