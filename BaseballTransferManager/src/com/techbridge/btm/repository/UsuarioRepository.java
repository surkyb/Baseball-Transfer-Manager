
package com.techbridge.btm.repository;

import com.techbridge.btm.model.Usuario;

/**
 * @author Surky
 */
public interface UsuarioRepository {
// metodos a implementar buscarPorUsernmae (para el login) y guardarUsuario para (sing up)
    public void guardarUsuario(Usuario usuario);
    
    public Usuario buscarPorUserName(String username);
    
    public Usuario buscarPorEmail(String email);
}

