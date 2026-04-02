/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.repository;

import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Estadisticas;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author gilber
 */
public class EstadisticasRepositoryImpl implements EstadisticasRepository{
     // utilizamos el override para sobreescribir el metodo guardarEstadisticas // 
    @Override 
    public void guardarEstadisticas(Estadisticas estadis){
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "INSERT INTO estadisticas (juegos, hits, home_runs, rbis, promedio_bateo) VALUES (?, ?, ?, ?, ?)";
        
        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, estadis.getJuegos());
            ps.setInt(2, estadis.getHits());
            ps.setInt(3, estadis.getHomeRuns());
            ps.setInt(4, estadis.getRbis());
            ps.setDouble(5, estadis.getPromedioBateo());
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea guardar en este caso//
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

