/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.repository;

import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Estadisticas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gilber
 */
public class EstadisticasRepositoryImpl implements EstadisticasRepository{
     // utilizamos el override para sobreescribir el metodo guardarEstadisticas //  
    @Override 
    public void guardarEstadisticas(Estadisticas estadis) {
        
        // 1. Preguntamos si ya existe en la base de datos usando tu propio método
        Estadisticas existe = buscarEstadisticasPorJugador(estadis.getIdJugador());
        String sql;

        if (existe != null) {
            // Si EXISTE, hacemos un UPDATE
            sql = "UPDATE estadisticas SET juegos=?, hits=?, home_runs=?, rbis=?, promedio_bateo=?, turnos_al_bate=?, base_x_bola=?, ponches=?, bases_robadas=?, carreras_anotadas=? WHERE id_jugador=?";
        } else {
            // si no hacemos un INSERT
            sql = "INSERT INTO estadisticas (juegos, hits, home_runs, rbis, promedio_bateo, turnos_al_bate, base_x_bola, ponches, bases_robadas, carreras_anotadas, id_jugador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        }
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            // ¡Magia! Los parámetros encajan perfectamente tanto para el UPDATE como para el INSERT
            ps.setInt(1, estadis.getJuegos());
            ps.setInt(2, estadis.getHits());
            ps.setInt(3, estadis.getHomeRuns());
            ps.setInt(4, estadis.getRbis());
            ps.setDouble(5, estadis.getPromedioBateo());
            ps.setInt(6, estadis.getTurnosAlBate());
            ps.setInt(7, estadis.getBaseXBola());
            ps.setInt(8, estadis.getPonches());
            ps.setInt(9, estadis.getBasesRobadas());
            ps.setInt(10, estadis.getCarrerasAnotadas());
            
            // El ID del jugador siempre va de último en ambas consultas
            ps.setInt(11, estadis.getIdJugador()); 
            
            // Ejecutamos
            ps.executeUpdate();
            
        } catch (Exception e) {
            // Si algo falla, ahora sí nos enteraremos
            System.out.println("Error grave al guardar en BD: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // utilizamos el override para sobreescribir el metodo buscarEstadisticas // 
    @Override
    public Estadisticas buscarEstadisticas(int idEstadisticas) {
        Estadisticas estadis = null; //Inicialisamos//

        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "SELECT * FROM estadisticas WHERE id = ?";

        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
 /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        try (Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, idEstadisticas);
            
            //El resultSet contiene el resultado
            ResultSet resul = ps.executeQuery();

            if (resul.next()) {

                //Aqui agregamos los datos dados por la busqueda a un objeto tipo Contrato
                estadis = new Estadisticas();
                estadis.setIdEstadisticas(resul.getInt("id"));
                estadis.setIdJugador(resul.getInt("id_jugador"));
                estadis.setJuegos(resul.getInt("juegos"));
                estadis.setHits(resul.getInt("hits"));
                estadis.setHomeRuns(resul.getInt("home_runs"));
                estadis.setRbis(resul.getInt("rbis"));
                estadis.setPromedioBateo(resul.getDouble("promedio_bateo"));
                estadis.setTurnosAlBate(resul.getInt("turnos_al_bate"));
                estadis.setBaseXBola(resul.getInt("base_x_bola"));
                estadis.setPonches(resul.getInt("ponches"));
                estadis.setBasesRobadas(resul.getInt("bases_robadas"));
                estadis.setCarrerasAnotadas(resul.getInt("carreras_anotadas"));
                
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
        // Despues de todo el proceso, devolvera el contrato buscado con todo sus datos
        return estadis;
    }
    
    
    @Override
public Estadisticas buscarEstadisticasPorJugador(int idJugador) {
    Estadisticas estadis = null;
    String sql = "SELECT * FROM estadisticas WHERE id_jugador = ?";

    try (Connection con = DatabaseConnection.getConexion(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
         
        ps.setInt(1, idJugador);
        ResultSet resul = ps.executeQuery();

        if (resul.next()) {
            estadis = new Estadisticas();
            estadis.setIdEstadisticas(resul.getInt("id"));
            estadis.setIdJugador(resul.getInt("id_jugador"));
            estadis.setJuegos(resul.getInt("juegos"));
            estadis.setHits(resul.getInt("hits"));
            estadis.setHomeRuns(resul.getInt("home_runs"));
            estadis.setRbis(resul.getInt("rbis"));
            estadis.setPromedioBateo(resul.getDouble("promedio_bateo"));
            estadis.setTurnosAlBate(resul.getInt("turnos_al_bate")); 
            estadis.setBaseXBola(resul.getInt("base_x_bola"));
            estadis.setPonches(resul.getInt("ponches"));
            estadis.setBasesRobadas(resul.getInt("bases_robadas"));
            estadis.setCarrerasAnotadas(resul.getInt("carreras_anotadas"));
        }
    } catch (Exception e) { 
        e.printStackTrace();
    }
    return estadis;
}
}

