/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm;

import com.techbridge.btm.controller.TransferenciaController;
import com.techbridge.btm.service.TransferenciaService;

/**
 *
 * @author Joshua Abreu
 */
public class PruebaTransferencia {
    public static void main(String[] args) {
        TransferenciaService service = new TransferenciaService();
        service.transferirJugador(1, 1, 2, 500000);
        
        System.out.println("Prueba terminada. Revisar MySQL");
    }
}
