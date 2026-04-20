package com.techbridge.btm.repository;

import com.techbridge.btm.dbconnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Surky
 * 
 */
public class DashboardRepositoryImpl {

    public int obtenerTotal(String tabla) {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM " + tabla;
        
        try (Connection con = DatabaseConnection.getConexion(); // Usa tu clase de conexión
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}