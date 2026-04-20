/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.service;

import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.repository.JugadorRepository;

/**
 *
 * @author Joshua Abreu
 */
/**
 * Capa de Servicio: Gestiona la lógica de negocio de los Jugadores.
 * Actúa como intermediario entre el Controlador y el Repositorio.
 */
public class JugadorService {
    // Referencia al Repositorio mediante una Interfaz (Principio de Inversión de Dependencias)
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }
    
    /**
     * Registra un nuevo jugador aplicando validaciones de integridad.
     */
    public void registrarJugador(String nombre, int edad, String posicion, double valor) throws Exception {
        // --- VALIDACIONES DE NEGOCIO ---
        // Evitamos que entren datos nulos o vacíos a la base de datos
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("El nombre es obligatorio");
        }
        if(edad <= 0){
            throw new Exception("La edad debe ser mayor a 0");
        }
        if(posicion == null || posicion.trim().isEmpty()){
            throw new Exception("La posición es obligatoria");
        }
        if(valor <= 0){
            throw new Exception("El valor de mercado debe ser positivo");
        }
        
        // --- CONSTRUCCIÓN DEL MODELO ---
        // Una vez validados los datos, creamos la entidad Jugador
        Jugador ju = new Jugador();
        ju.setNombre(nombre);
        ju.setEdad(edad);
        ju.setPosicion(posicion);
        ju.setValor(valor);
        ju.setEsJugadorActivo(true); // Por defecto, un jugador nuevo entra como activo
        
        // Persistencia: Mandamos el objeto al repositorio para el INSERT
        jugadorRepository.guardar(ju);
    }
    
    /**
     * Busca un jugador por su nombre.
     */
    public Jugador buscarJugador(String nombre) throws Exception {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("Debe proporcionar un nombre válido");
        }
        
        Jugador jugador = jugadorRepository.buscarJugador(nombre);
        
        // Si el repositorio devuelve null, lanzamos una excepción controlada
        if(jugador == null){
            throw new Exception("Jugador no encontrado en el sistema");
        }
        return jugador;
    }
    
    /**
     * Elimina un jugador previa verificación de existencia.
     */
    public void eliminarJugador(String nombre) throws Exception {
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("Nombre inválido para eliminación");
        }
        
        // Primero verificamos que exista antes de intentar borrar
        Jugador jugador = jugadorRepository.buscarJugador(nombre);
        if(jugador == null){
            throw new Exception("No se puede eliminar: El jugador no existe");
        }
        
        // Ejecuta el DELETE (ayudado por el CASCADE en la DB para las tablas hijas)
        jugadorRepository.eliminar(nombre);
    }

    /**
     * Retorna la lista completa de jugadores desde la base de datos.
     */
    public java.util.List<Jugador> listarTodosLosJugadores() {
        return jugadorRepository.listarTodos();
    }
    
    /**
     * Remueve la vinculación de un jugador con su equipo actual (Agente Libre).
     */
    public void liberarJugador(String nombreJugador) throws Exception {
        jugadorRepository.liberarJugador(nombreJugador);
    }
    
    /**
     * Vincula un jugador con un equipo y crea su registro de contrato.
     */
    public void asignarEquipo(String nombreJugador, String nombreEquipo, String salario, String fInicio, String fFin) throws Exception {
        jugadorRepository.asignarEquipo(nombreJugador, nombreEquipo, salario, fInicio, fFin);
    }
    
    /**
     * Actualiza los términos económicos y de tiempo del contrato de un jugador.
     */
    public void renovarContrato(String nombreJugador, String nuevoSalario, String nuevaFechaFin) throws Exception {
        jugadorRepository.renovarContrato(nombreJugador, nuevoSalario, nuevaFechaFin);
    }
    
    /**
     * Genera un reporte detallado del jugador, incluyendo datos de contrato y equipo.
     */
    public String obtenerDetallesJugador(String nombreJugador) throws Exception {
        return jugadorRepository.obtenerDetallesJugador(nombreJugador);
    }

    /**
     * Filtra jugadores pertenecientes a una franquicia específica.
     */
    public java.util.List<com.techbridge.btm.model.Jugador> listarJugadoresPorEquipo(String nombreEquipo) throws Exception {
        return jugadorRepository.listarJugadoresPorEquipo(nombreEquipo);
    }
}