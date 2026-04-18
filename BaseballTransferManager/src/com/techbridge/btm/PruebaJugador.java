/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm;

import com.techbridge.btm.repository.JugadorRepository;
import com.techbridge.btm.repository.JugadorRepositoryImpl;
import com.techbridge.btm.service.JugadorService;

/**
 *
 * @author Joshua Abreu
 */
public class PruebaJugador {
    public static void main(String[] args) {

        //Crear repository
        JugadorRepository repo = new JugadorRepositoryImpl();

        //Inyectar en service
        JugadorService service = new JugadorService(repo);

        try {
            //Probar registro
            service.registrarJugador("Juan", 25, "Pitcher", 50000);

            System.out.println("Jugador registrado correctamente ✅");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
