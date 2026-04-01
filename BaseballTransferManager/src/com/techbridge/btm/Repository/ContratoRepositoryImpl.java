/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.Repository;

import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Contrato;
import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.EstadoContrato;
import com.techbridge.btm.model.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gilber
 */
public class ContratoRepositoryImpl implements ContratoRepository {

    // utilizamos el override para sobreescribir el metodo guardarContrato // 
    @Override
    public void guardarContrato(Contrato cont) {
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "INSERT INTO contrato (id_jugador, id_equipo, id_estado_contrato, fecha_inicio, fecha_fin, salario) VALUES (?, ?, ?, ?, ?, ?)";

        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
 /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        try (Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setObject(1, cont.getJugador().getId());
            ps.setObject(2, cont.getEquipo().getIdEquipo());
            ps.setObject(3, cont.getEstadoContrato().getId());
            ps.setDate(4, java.sql.Date.valueOf(cont.getFechaInicio()));
            ps.setDate(5, java.sql.Date.valueOf(cont.getFechaFin()));
            ps.setDouble(6, cont.getSalario());
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea guardar en este caso//
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // utilizamos el override para sobreescribir el metodo buscarContrato // 
    @Override
    public Contrato buscarContrato(int idContrato) {
        Contrato cont = null; //Inicialisamos//

        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "SELECT * FROM contrato WHERE id = ?";

        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
 /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        try (Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, idContrato);

            //El resultSet contiene el resultado
            ResultSet resul = ps.executeQuery();

            if (resul.next()) {

                //Aqui agregamos los datos dados por la busqueda a un objeto tipo Contrato
                cont = new Contrato();
                cont.setIdContrato(resul.getInt("id"));

                //Aqui creamos un objeto tipo jugador para poder leer el ID de la base de datos y mostrarlo
                Jugador ju = new Jugador();
                ju.setId(resul.getInt("id_jugador"));
                cont.setJugador(ju);

                //Aqui creamos un objeto tipo Equipo para poder leer el ID de la base de datos y mostrarlo
                Equipo equi = new Equipo();
                equi.setIdEquipo(resul.getInt("id_equipo"));
                cont.setEquipo(equi);

                cont.setFechaInicio(resul.getDate("fecha_inicio").toLocalDate());
                cont.setFechaFin(resul.getDate("fecha_fin").toLocalDate());
                cont.setSalario(resul.getDouble("salario"));

                
                int idEstado = resul.getInt("id_estado_contrato");

                cont.setEstadoContrato(
                        EstadoContrato.FromId(idEstado)
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Despues de todo el proceso, devolvera el contrato buscado con todo sus datos
        return cont;
    }

    // utilizamos el override para sobreescribir el metodo cancelarContrato // 
    @Override
    public void cancelarContrato(int idContrato) {

        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "DELETE FROM contrato WHERE id = ?";

        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
 /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        try (Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, idContrato);

            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea cancelar en este caso)//
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
