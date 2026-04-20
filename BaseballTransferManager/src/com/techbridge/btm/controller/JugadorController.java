/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.controller;

import com.techbridge.btm.DTO.JugadorDTO;
import com.techbridge.btm.model.Jugador;
import com.techbridge.btm.service.JugadorService;
import com.techbridge.btm.view.JugadorViewInterface;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joshua Abreu
 */
/**
 * Capa de Controlador: El cerebro del flujo de datos.
 * Su responsabilidad es manejar las peticiones de la vista y orquestar las respuestas.
 */
public class JugadorController {
    // Dependencias: El controlador necesita al servicio (lógica) y a la interfaz de la vista
    private JugadorService service;
    private JugadorViewInterface view;

    /**
     * Constructor: Inyecta el servicio y la vista. 
     * Esto facilita las pruebas unitarias y el desacoplamiento.
     */
    public JugadorController(JugadorService service, JugadorViewInterface view) {
        this.service = service;
        this.view = view;
    }
    
    /**
     * Proceso de Registro: Coordina la captura, validación y respuesta.
     */
    public void registrarJugador(){
        try {
            // 1. CAPTURA: Pedimos a la vista los datos empaquetados en un DTO
            JugadorDTO dto = view.getDatosJugador();
            
            // 2. PROCESO: Pasamos los datos del DTO al servicio para que aplique la lógica
            service.registrarJugador(
                dto.getNombre(),
                dto.getEdad(),
                dto.getPosicion(),
                dto.getValor()
            );
            
            // 3. RESPUESTA POSITIVA: Notificamos éxito y limpiamos la interfaz
            view.mostrarMensaje("Jugador registrado correctamente");
            view.limpiarCampos();
            
        } catch(Exception e) {
            // 4. RESPUESTA NEGATIVA: Capturamos cualquier error (validaciones o DB) 
            // y lo enviamos a la vista para informar al usuario.
            view.mostrarError(e.getMessage());
        }
    }

    /**
     * Puentes hacia el Servicio: Métodos que simplemente redirigen la petición.
     */
    public java.util.List<Jugador> listarTodosLosJugadores() {
        return service.listarTodosLosJugadores();
    }

    public void liberarJugador(String nombreJugador) throws Exception {
        service.liberarJugador(nombreJugador);
    }
    
    public void asignarEquipo(String nombreJugador, String nombreEquipo, String salario, String fInicio, String fFin) throws Exception {
        service.asignarEquipo(nombreJugador, nombreEquipo, salario, fInicio, fFin);
    }
    
    public void renovarContrato(String nombreJugador, String nuevoSalario, String nuevaFechaFin) throws Exception {
        service.renovarContrato(nombreJugador, nuevoSalario, nuevaFechaFin);
    }
    
    public String obtenerDetallesJugador(String nombreJugador) throws Exception {
        return service.obtenerDetallesJugador(nombreJugador);
    }

    public void eliminarJugador(String nombreJugador) throws Exception {
        service.eliminarJugador(nombreJugador);
    }

    /**
     * Adaptador para la Interfaz: Convierte una lista de objetos Jugador 
     * en una lista de arreglos de Objetos (Object[]) que el JTable de Swing pueda entender.
     */
    public List<Object[]> listarJugadoresParaTabla() {
        List<Jugador> jugadores = service.listarTodosLosJugadores();
        List<Object[]> datos = new ArrayList<>();

        for (Jugador j : jugadores) {
            // Solo extraemos las columnas necesarias para la vista simplificada
            datos.add(new Object[]{
                j.getId(),
                j.getNombre(),
                j.getPosicion()
            });
        }
        return datos;
    }

    public java.util.List<com.techbridge.btm.model.Jugador> listarJugadoresPorEquipo(String nombreEquipo) throws Exception {
        return service.listarJugadoresPorEquipo(nombreEquipo);
    }
}