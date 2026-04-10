/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.service;

import com.techbridge.btm.model.Contrato;
import com.techbridge.btm.repository.ContratoRepository;
import com.techbridge.btm.repository.ContratoRepositoryImpl;


/**
 *
 * @author gilber
 */
public class ContratoService {
    
    private ContratoRepository contratoRepository= new ContratoRepositoryImpl();
    
    
    public void crearContrato(Contrato contrato) {
        
        if (contrato.getJugador() == null || contrato.getEquipo() == null) {
            System.out.println("Datos inválidos");
            return;
}
        contratoRepository.guardarContrato(contrato);
        System.out.println("Contrato guardado correctamente");
    }

    
    public Contrato buscarContrato(int idContrato) {
        return contratoRepository.buscarContrato(idContrato);
    }

    
    public void cancelarContrato(int idContrato) {
        contratoRepository.cancelarContrato(idContrato);
        System.out.println("Contrato cancelado");
    }
}
