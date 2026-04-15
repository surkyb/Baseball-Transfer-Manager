package com.techbridge.btm.service;

import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.repository.EquipoRepository;
import com.techbridge.btm.repository.EquipoRepositoryImpl;
import java.util.ArrayList;

/**
 * Clase: EquipoService
 * Misión principal: Actuar como la aduana o filtro de seguridad antes de tocar la base de datos.
 * Aquí aplicamos la "Lógica de Negocio" (las reglas estrictas de la aplicación).
 * * @author dell
 */
public class EquipoService {

    /* * 1. LA CONEXIÓN (El Puente)
     * Declaramos una variable inmutable (final) del tipo EquipoRepository.
     * Esta variable es nuestro "cable" directo hacia la capa de la base de datos.
     * Usamos la 'interfaz' (EquipoRepository) en lugar de la implementación directa 
     * para mantener el código limpio y seguro.
     */
    private final EquipoRepository equipoRepo;

    /* * 2. EL CONSTRUCTOR (El Motor de Arranque)
     * Este método se ejecuta automáticamente cuando alguien crea un "EquipoService".
     * Aquí le damos vida a nuestra variable, conectándola con la implementación real
     * (EquipoRepositoryImpl) que es la que tiene las consultas SQL. (Necesario)
     */
    public EquipoService() {
        this.equipoRepo = new EquipoRepositoryImpl();
    }

    /*
     * 3. MÉTODO: REGISTRAR EQUIPO
     * Recibe un objeto 'Equipo' completo desde la pantalla visual (el frontend).
     */
    public void registrarEquipo(Equipo equip) throws Exception {
        
        // REGLA DE NEGOCIO 1: Auditoría forense de datos.
        // Validamos que el frontend no nos esté enviando un equipo fantasma (nulo).
        // Si es nulo, detenemos el proceso lanzando una Excepción (error controlado) para que el programa no colapse.
        if (equip == null) {
            throw new Exception("El equipo no puede estar vacío.");
        }
        
        // Si pasa la barrera de seguridad, le damos la orden al Repositorio para que lo guarde en SQL.
        equipoRepo.guardarEquipo(equip);
    }

    /*
     * 4. MÉTODO: OBTENER EQUIPO
     * Recibe un texto (el nombre del equipo) y devuelve el objeto Equipo con todos sus datos.
     */
    public Equipo obtenerEquipo(String nombre) throws Exception {
        
        // REGLA DE NEGOCIO 2: Filtro antisabotaje.
        // Verificamos si el nombre viene nulo o si solo enviaron espacios en blanco (.trim().isEmpty()).
        // Evitamos hacer una búsqueda inútil en la base de datos.
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debes proporcionar un nombre válido para buscar.");
        }
        
        // Ordenamos al Repositorio que busque el equipo en la base de datos y lo guardamos en una variable.
        Equipo equipoEncontrado = equipoRepo.buscarEquipo(nombre);
        
        // REGLA DE NEGOCIO 3: Validación de existencia.
        // Si el repositorio no encontró nada, devuelve 'null'. Debemos avisarle al usuario.
        if (equipoEncontrado == null) {
            throw new Exception("No existe ningún equipo registrado con el nombre: " + nombre);
        }
        
        // Si todo salió bien, devolvemos el equipo encontrado.
        return equipoEncontrado;
    }

    /*
     * 5. MÉTODO: DESTRUIR EQUIPO
     * Recibe un nombre y elimina el registro de la base de datos.
     */
    public void destruirEquipo(String nombre) throws Exception {
        
        // Validamos nuevamente que el nombre no sea basura o espacios en blanco.
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Nombre inválido. Operación cancelada.");
        }
        
        // REGLA DE NEGOCIO 4: Doble verificación cruzada.
        // Antes de intentar borrar, verificamos lógicamente si el equipo realmente existe.
        // Reutilizamos el método de búsqueda del repositorio para confirmar.
        Equipo equipoExistente = equipoRepo.buscarEquipo(nombre);
        
        // Si no existe, bloqueamos la acción para no enviar una consulta SQL de borrado que fallará.
        if (equipoExistente == null) {
            throw new Exception("El equipo que intentas eliminar no existe en la base de datos.");
        }

        // Si existe, damos la orden de ejecución final.
        equipoRepo.eliminarEquipo(nombre);
    }

    /*
     * 6. MÉTODO: OBTENER ROSTER (Lista de jugadores)
     * Recibe el ID numérico de un equipo y devuelve una lista (ArrayList) llena de objetos 'Jugador'.
     */
    public ArrayList<Jugador> obtenerRoster(int idEquipo) throws Exception {
        
        // REGLA DE NEGOCIO 5: Lógica básica.
        // En bases de datos, los IDs autoincrementables empiezan en 1. 
        // Si nos envían un 0 o un número negativo, es un dato corrupto. Lo bloqueamos.
        if (idEquipo <= 0) {
            throw new Exception("El ID del equipo es corrupto o inválido.");
        }
        
        // Solicitamos la lista al repositorio y la devolvemos directamente.
        return equipoRepo.buscarPorEquipo(idEquipo);
    }
}