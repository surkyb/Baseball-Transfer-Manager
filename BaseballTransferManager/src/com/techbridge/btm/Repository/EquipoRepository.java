package com.techbridge.btm.repository;

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
    
}
