package com.techbridge.btm.dbconnection;
import java.sql.*;

/**
 * @author Surky
 * Clase encargada de proveer conexiones a la base de datos.
 */
public class DatabaseConnection {
    final static String URL = "jdbc:mysql://localhost:3306/baseballmanagerbd";
    final static String USER = "root";
    final static String PASSWORD = "admin";
    
    private DatabaseConnection () {}
    
     /**
     * Obtiene una nueva conexión a la base de datos.
     * @return conexión activa
     */
    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(SQLException e) { 
            throw new RuntimeException("Error crítico: No se pudo conectar a la base de datos.", e);
        }
    }
}
