/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm;

import com.techbridge.btm.repository.ContratoRepository;
import com.techbridge.btm.repository.ContratoRepositoryImpl;
import com.techbridge.btm.repository.TransferenciaRepository;
import com.techbridge.btm.repository.TransferenciaRepositoryImpl;
import com.techbridge.btm.service.TransferenciaService;

/**
 *
 * @author Joshua Abreu
 */
public class PruebaTransferencia {

    public static void main(String[] args) {
        TransferenciaRepository transferenciaRepo = new TransferenciaRepositoryImpl();
        ContratoRepository contratoRepo = new ContratoRepositoryImpl();

        TransferenciaService service = new TransferenciaService(transferenciaRepo, contratoRepo);
        try {
            service.transferirJugador(1, 1, 2, 500000);
            System.out.println("Prueba terminada. Revisar MySQL");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
