package com.techbridge.btm.service;

import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.repository.EquipoRepository;
import com.techbridge.btm.repository.EquipoRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase: EquipoService
 * Misión principal: Actuar como la aduana o filtro de seguridad antes de tocar la base de datos.
 * Aquí aplicamos la "Lógica de Negocio" (las reglas estrictas de la aplicación).
 * * @author dell
 */
public class EquipoService {

    private final EquipoRepository equipoRepo;

    /**
     * Inyección de Dependencias por Constructor.
     * Permite que el Service reciba cualquier implementación de EquipoRepository.
     */
    public EquipoService(EquipoRepository equipoRepo) {
        this.equipoRepo = equipoRepo;
    }

    // Valida y registra un nuevo equipo en el sistema.
    public void registrarEquipo(String nombre, double presupuesto) throws Exception {
        // Validamos que el nombre no sea nulo ni esté compuesto solo por espacios.
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede estar vacío");
        }

        if (presupuesto <= 0) {
            throw new Exception("El presupuesto debe ser mayor a 0");
        }

        // Mapeo: Creamos el objeto Modelo (Entity) a partir de los datos recibidos.
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setPresupuesto(presupuesto);
        
        // Delegamos la persistencia al repositorio.
        equipoRepo.guardarEquipo(equipo);
    }

    // Busca un equipo por su nombre exacto.
    public Equipo obtenerEquipo(String nombre) throws Exception {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Nombre inválido");
        }

        Equipo equipo = equipoRepo.buscarEquipo(nombre);
        // Si el repositorio devuelve null, lanzamos una excepción controlada.
        if (equipo == null) {
            throw new Exception("Equipo no encontrado");
        }

        return equipo;
    }

    // Elimina un equipo tras verificar su existencia.
    public void eliminarEquipo(String nombre) throws Exception {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Nombre inválido");
        }
        // Verificamos existencia antes de intentar borrar.
        Equipo equipo = equipoRepo.buscarEquipo(nombre);

        if (equipo == null) {
            throw new Exception("El equipo no existe");
        }

        equipoRepo.eliminarEquipo(nombre);
    }

    // Obtiene la lista de jugadores (roster) asociados a un equipo específico.
    public ArrayList<Jugador> obtenerRoster(int idEquipo) throws Exception {

        if (idEquipo <= 0) {
            throw new Exception("ID inválido");
        }
        //Retornamos la lista obtenida desde el repositorio
        return equipoRepo.buscarPorEquipo(idEquipo);
    }

    public java.util.List<Equipo> listarEquipos() {
        return equipoRepo.obtenerTodosLosEquipos();
    }
    public java.util.List<com.techbridge.btm.model.Equipo> listarEquiposParaTabla() throws Exception {
        return equipoRepo.listarEquiposParaTabla();
    }
    
}
