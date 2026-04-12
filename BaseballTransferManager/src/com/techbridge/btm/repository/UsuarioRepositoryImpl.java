package com.techbridge.btm.repository;

import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Usuario;
import java.sql.*;

/**
 * @author Surky
 */
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public void guardarUsuario(Usuario usuario) {
        
        String sql = "INSERT into usuario (user_name,correo,contrasena) VALUES (?,?,?)";
        
        try(Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, usuario.getUserName());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.executeUpdate();
            
            
        
        } catch (SQLException e){
            throw new RuntimeException("Error al guardar usuario", e);
        }
    }

    @Override
    public Usuario buscarPorUserName(String username) {
        
        Usuario usuario = null;
        String sql = "SELECT * from usuario where user_name = ?";
        
        
        try(Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)){
              
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUserName(rs.getString("user_name"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        }catch(SQLException e){
        
            throw new RuntimeException("Error al buscar el usuario por username", e);
        }
        
        return usuario;
    }
    
   @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * from usuario where correo = ?";
        
        try(Connection con = DatabaseConnection.getConexion(); PreparedStatement ps = con.prepareStatement(sql)){
              
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUserName(rs.getString("user_name"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        }catch(SQLException e){
            throw new RuntimeException("Error al buscar el usuario por email", e);
        }
        
        return usuario;
    }
}
