
package com.techbridge.btm.service;

import com.techbridge.btm.model.Estadisticas;
import com.techbridge.btm.repository.EstadisticasRepository;

/**
 *
 * @author Surky
 */
public class EstadisticasService {

    private EstadisticasRepository repository;

    public EstadisticasService(EstadisticasRepository repository) {
        this.repository = repository;
    }

    public Estadisticas buscarEstadisticasPorJugador(int idJugador) {

        return repository.buscarEstadisticasPorJugador(idJugador);
    }

    public void guardarEstadisticas(Estadisticas e) {
        repository.guardarEstadisticas(e);
    }
}
