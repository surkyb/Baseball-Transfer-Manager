package com.techbridge.btm.service;

import com.techbridge.btm.DTO.LoginDTO;
import com.techbridge.btm.model.Usuario;
import com.techbridge.btm.repository.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Surky 
 * Servicio que contiene la lógica de autenticación. Maneja login
 * y registro de usuarios.
 */
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Verifica si el login es válido.
     * @param loginDTO
     * @return true si el login es correcto
     * @throws java.lang.Exception
     */
    public boolean login(LoginDTO loginDTO) throws Exception {
        // busca el usuario en la BD 
        Usuario usuario = usuarioRepository.buscarPorEmail(loginDTO.getEmail());
        if (usuario == null) {
            throw new Exception("El correo ingresado no está registrado en el sistema.");
        }
        //contraseña de la bd vs la del login
        //checkpw recibe: (Contraseña escrita por el usuario, Hash guardado en la BD)
        if (!BCrypt.checkpw(loginDTO.getPassword(), usuario.getContrasena())) {

            throw new Exception("Contraseña incorrecta. Inténtalo de nuevo.");
        }
        return true;
    }

    /**
     * Registra un nuevo usuario en el sistema.
     * @param nuevoUsuario
     * @return true;
     * @throws java.lang.Exception
     */
    public boolean registrarUsuario(Usuario nuevoUsuario) throws Exception {

        Usuario usuarioExistente = usuarioRepository.buscarPorUserName(nuevoUsuario.getUserName());

        if (usuarioExistente != null) {
            throw new Exception("El nombre de usuario '" + nuevoUsuario.getUserName() + "' ya está en uso. Por favor, elige otro.");
        }

        Usuario emailExistente = usuarioRepository.buscarPorEmail(nuevoUsuario.getCorreo());

        if (emailExistente != null) {
            throw new Exception("El correo ya está registrado.");
        }

        // Encriptar contraseña
        String claveEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
        nuevoUsuario.setContrasena(claveEncriptada);

        usuarioRepository.guardarUsuario(nuevoUsuario);

        return true;
    }

}
