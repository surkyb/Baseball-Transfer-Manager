package com.techbridge.btm.model;

/**
 *
 * @author Surky
 */
public class Usuario {
    private int id; 
    private String userName;
    private String contrasena;
    private String correo;

    public Usuario() {
    }

    public Usuario(String userName, String correo, String contrasena) {
        this.userName = userName;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(int id, String userName, String contrasena, String correo) {
        this.id = id;
        this.userName = userName;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
    
}
