/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techbridge.btm.dbconnection;
import java.sql.*;

/**
 *
 * @author Surky
 */
public class DatabaseConnection {
    final static String url = "jdbc:mysql://localhost:3306/BaseballManagerBD";
    final static String user = "root";
    final static String password = "admin";
    static Connection conexion = null;
    
    private DatabaseConnection () {}
    
    public static Connection getConexion() {
       try {
       
       
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }
    }catch(SQLException e ){ 
            System.out.println("Error: "+e.getMessage());
    
}
       return conexion;
    }
    
    public static void cerrarConexion() {
        try {
            if (conexion != null ) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void conectar() {
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /*
    public static void main(String[] args) {
        Connection conn = getConexion();
        if(conn != null){
            System.out.println("Conectado correctamente");
        }else{
            System.out.println("Error de conexion");
        } 
    } */
}
