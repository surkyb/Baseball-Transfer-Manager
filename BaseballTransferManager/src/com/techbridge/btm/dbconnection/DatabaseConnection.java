package com.techbridge.btm.dbconnection;
import java.sql.*;

/**
 * @author Surky
 */
public class DatabaseConnection {
    final static String URL = "jdbc:mysql://localhost:3306/baseballmanagerbd";
    final static String USER = "root";
    final static String PASSWORD = "admin";
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
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
