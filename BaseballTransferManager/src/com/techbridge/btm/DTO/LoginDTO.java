package com.techbridge.btm.DTO;

/**
 * DTO que transporta los datos necesarios para el login.
 * Contiene únicamente email y contraseña.
 * @author Surky
 */
public class LoginDTO {

    private final String email;
    private final String password;

    /**
     * Constructor del DTO de login.
     *
     * @param email correo del usuario
     * @param password contraseña del usuario
     */
    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }
}
