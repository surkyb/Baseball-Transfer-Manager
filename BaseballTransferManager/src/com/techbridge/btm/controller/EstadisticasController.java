package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.EstadisticasDTO;
import com.techbridge.btm.model.Estadisticas;
import com.techbridge.btm.service.EstadisticasService;
/**
 *
 * @author Surky
 */
public class EstadisticasController {

    private final EstadisticasService service;

    public EstadisticasController(EstadisticasService service) {
        this.service = service;
    }

    //  Obtener estadísticas por jugador
    public EstadisticasDTO obtenerEstadisticasDeJugador(int idJugador) {
        Estadisticas e = service.buscarEstadisticasPorJugador(idJugador);

        if (e == null) {
            return null; 
        }

        return convertirADTO(e);
    }

   public void guardarEstadisticas(EstadisticasDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO no puede ser null");
        }

        Estadisticas e = convertirAModelo(dto);
        service.guardarEstadisticas(e);
    }
   
   private Estadisticas convertirAModelo(EstadisticasDTO dto) {
        Estadisticas e = new Estadisticas();

        e.setIdEstadisticas(dto.getIdEstadisticas()); // útil si luego haces UPDATE
        e.setIdJugador(dto.getIdJugador());
        e.setJuegos(dto.getJuegos());
        e.setHits(dto.getHits());
        e.setHomeRuns(dto.getHomeRuns());
        e.setRbis(dto.getRbis());
        e.setPromedioBateo(dto.getPromedioBateo());
        e.setTurnosAlBate(dto.getTurnosAlBate());
        e.setBaseXBola(dto.getBaseXBola());
        e.setPonches(dto.getPonches());
        e.setBasesRobadas(dto.getBasesRobadas());
        e.setCarrerasAnotadas(dto.getCarrerasAnotadas());

        return e;
    }

    //  para mapear
    private EstadisticasDTO convertirADTO(Estadisticas e) {
        return new EstadisticasDTO(
                e.getIdEstadisticas(),
                e.getIdJugador(),
                e.getJuegos(),
                e.getHits(),
                e.getHomeRuns(),
                e.getRbis(),
                e.getPromedioBateo(),
                e.getTurnosAlBate(),
                e.getBaseXBola(),
                e.getPonches(),
                e.getBasesRobadas(),
                e.getCarrerasAnotadas()
        );
    }
}