/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.view;

import com.techbridge.btm.DTO.EquipoDTO;

/**
 *
 * @author Joshua Abreu
 */
public interface EquipoViewInterface {
    //obtener datos mediante DTO
    EquipoDTO getDatosEquipo();
    
    //mostrar resultados
    void mostrarMensaje(String mensaje);
    void mostrarError(String mensaje);
    
    //limpiar campos
    void limpiarCampos();
}
