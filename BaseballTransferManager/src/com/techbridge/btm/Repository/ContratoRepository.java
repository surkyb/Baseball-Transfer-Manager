/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.techbridge.btm.Repository;

import com.techbridge.btm.model.Contrato;

/**
 *
 * @author gilber
 */
public interface ContratoRepository {
    
    // Aqui creamos este metodo para poder guardar un contrato dado por el GUI
    void guardarContrato(Contrato cont); 
    
    // Esto lo creamos para poder buscar un contrato por su id correspondiente
    Contrato buscarContrato(int idContrato);
    
    // Este otro metodo lo creamos para eliminar un contrato
    void cancelarContrato(int idContrato);

}
