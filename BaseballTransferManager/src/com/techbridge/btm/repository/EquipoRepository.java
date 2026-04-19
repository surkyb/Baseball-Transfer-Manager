package com.techbridge.btm.repository;

import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import java.util.ArrayList;

/**
 *
 * @author gilber
 */
public interface EquipoRepository {
    
    // Aqui creamos este metodo para poder guardar un equipo dado por el GUI
    void guardarEquipo(Equipo equip); 
    
    // Esto lo creamos para poder buscar un equipo por su nombre
    Equipo buscarEquipo(String nombre);
    
    // Este otro metodo lo creamos para eliminar un equipo
    void eliminarEquipo(String nombre); 
    
    // Metodo para mostrar los jugadores de un equipo
    ArrayList<Jugador> buscarPorEquipo(int idEquipo);
    
    // Metodo para mostrar los equipos
    java.util.List<Equipo> obtenerTodosLosEquipos();
    
}
