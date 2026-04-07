/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.service;

import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.model.Transferencia;
import com.techbridge.btm.repository.ContratoRepository;
import com.techbridge.btm.repository.ContratoRepositoryImpl;
import com.techbridge.btm.repository.TransferenciaRepository;
import com.techbridge.btm.repository.TransferenciaRepositoryImpl;
import java.time.LocalDate;

/**
 *
 * @author Joshua Abreu
 */
public class TransferenciaService {
   
    private TransferenciaRepository transferenciaRepository = new TransferenciaRepositoryImpl();
    private ContratoRepository contratoRepository = new ContratoRepositoryImpl();
    
    public void transferirJugador(int idJugador, int idEquipoOrigen, int idEquipoDestino, double monto){
        
        if(idEquipoOrigen == idEquipoDestino){
            System.out.println("No puedes transferir al mismo equipo");
            return;
        }
        
        if(monto <= 0){
            System.out.println("Monto invalido");
            return;
        }
        //crear objeto jugador
        Jugador jugador = new Jugador();
        jugador.setId(idJugador);
        
        //crear equipo origen
        Equipo origen = new Equipo();
        origen.setIdEquipo(idEquipoOrigen);
        
        //crear equipo destino
        Equipo destino = new Equipo();
        destino.setIdEquipo(idEquipoDestino);
        
        //crear transferencia
        Transferencia transferencia = new Transferencia();
        transferencia.setJugador(jugador);
        transferencia.setEquipoOrigen(origen);
        transferencia.setEquipoDestino(destino);
        transferencia.setMonto(monto);
        transferencia.setFecha(LocalDate.now());
        
        //guardar transferencia
        transferenciaRepository.guardarTransferencia(transferencia);
        
        //actualizar contrato
        contratoRepository.actualizarEquipoJugador(idJugador, idEquipoDestino);
        
        System.out.println("Transferencia completa realizada");
        
    } 
}
