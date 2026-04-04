package com.techbridge.btm.service;

import com.techbridge.btm.DTO.LoginDTO;
import com.techbridge.btm.model.Usuario;
import com.techbridge.btm.repository.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Surky
 */
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //metodo que verifica el login, (si el usuaruio se necuentra en la bd)
    public boolean login(LoginDTO loginDTO) throws Exception {
        // busca el usuario en la BD 
        Usuario usuario = usuarioRepository.buscarPorUserName(loginDTO.getUsername());

        if (usuario == null) {
            throw new Exception("El usuario ingresado no existe en el sistema.");
        }
        //contraseña de la bd vs la del login
        //checkpw recibe: (Contraseña escrita por el usuario, Hash guardado en la BD)
        if(!BCrypt.checkpw(loginDTO.getPassword(), usuario.getContrasena())){
        
            throw new Exception("Contraseña incorrecta. Inténtalo de nuevo.");
        }
        return true;
    }
    
    public boolean registrarUsuario(Usuario nuevoUsuario) throws Exception {
        
        Usuario usuarioExistente = usuarioRepository.buscarPorUserName(nuevoUsuario.getUserName());
        
        if(usuarioExistente != null){
            throw new Exception("El nombre de usuario '" + nuevoUsuario.getUserName() + "' ya está en uso. Por favor, elige otro.");
        }
        
        String claveEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(),BCrypt.gensalt());
        
        nuevoUsuario.setContrasena(claveEncriptada);
        
        usuarioRepository.guardarUsuario(nuevoUsuario); 
        
        return true;
    }
  

 
}