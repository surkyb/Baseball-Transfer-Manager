/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.techbridge.btm.repository;

import com.techbridge.btm.model.Estadisticas;

/**
 *
 * @author gilber
 */
public interface EstadisticasRepository {
    
    // Aqui creamos este metodo para poder guardar las estadisticas dado por el GUI
    void guardarEstadisticas(Estadisticas estadis); 
    
    Estadisticas buscarEstadisticas(int idEstadisticas);
    
    
}
