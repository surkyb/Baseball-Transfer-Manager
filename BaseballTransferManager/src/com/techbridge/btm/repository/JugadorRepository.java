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
    //metodo para mas adelante poder mostrar todos los jugadores en la tabla jugadores del swing
    java.util.List<Jugador> listarTodos();
    
    //metodo para hacer un jugador agente libre
    void liberarJugador(String nombreJugador) throws Exception;
    //metodo para asignar un equipo
    void asignarEquipo(String nombreJugador, String nombreEquipo, String salario, String fInicio, String fFin) throws Exception;
    //metodo para renovar un contrato
    void renovarContrato(String nombreJugador, String nuevoSalario, String nuevaFechaFin) throws Exception;
    
    String obtenerDetallesJugador(String nombreJugador) throws Exception;
    
    java.util.List<com.techbridge.btm.model.Jugador> listarJugadoresPorEquipo(String nombreEquipo) throws Exception;
}
