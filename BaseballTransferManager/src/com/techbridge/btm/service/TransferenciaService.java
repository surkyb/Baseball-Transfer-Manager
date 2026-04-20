package com.techbridge.btm.service;

import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.model.Transferencia;
import com.techbridge.btm.repository.ContratoRepository;
import com.techbridge.btm.repository.TransferenciaRepository;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Joshua Abreu
 */
public class TransferenciaService {
   
    private final TransferenciaRepository transferenciaRepository;
    private final ContratoRepository contratoRepository;
    
    public TransferenciaService(TransferenciaRepository transferenciaRepo, ContratoRepository contratoRepo) {
        this.transferenciaRepository = transferenciaRepo;
        this.contratoRepository = contratoRepo;
    }
    
    public void transferirJugador(int idJugador, int idEquipoOrigen, int idEquipoDestino, double monto)throws Exception{
        
        
        
        if (idEquipoOrigen == idEquipoDestino) {
            throw new Exception("No puedes transferir al mismo equipo");
        }

        if (monto <= 0){
            throw new Exception("El monto de transferencia debe ser mayor a 0");
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
                
    } 
    
    public List<Object[]> listarHistorial() {
        return transferenciaRepository.listarHistorialParaTabla();
    }
}
