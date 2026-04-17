package com.techbridge.btm.repository;

import com.techbridge.btm.model.Transferencia;

/**
 *
 * @author gilber
 */
public interface TransferenciaRepository {
    // Aqui creamos este metodo para poder guardar una transferencia dado por el GUI
    void guardarTransferencia(Transferencia transfe); 
    
    // Esto lo creamos para poder buscar una transferencia por su id correspondiente
    Transferencia buscarTransferencia(int idTransferencia);
    
    // Este otro metodo lo creamos para eliminar una transferencia
    void eliminarTransferencia(int idTransferencia);
    
}
