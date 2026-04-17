package com.techbridge.btm.model;

/**
 *
 * @author surky
 */
public enum EstadoContrato {
    ACTIVO(1),
    EXPIRADO(2),
    CANCELADO(3),
    EN_NEGOCIACION(4);
    
    private final int id; //Id que conincide con la BD
    
    //constructor para poder pasar los id en la variable 
    EstadoContrato(int id){
        this.id = id;
    }
    
    //getter para obtener el número y mandarlo a mySQL
    public int getId(){
        return id;
    }
    
    //metodo para traer el enum correspondiente segun el id que pasa sql
    //fromId toma como parametro el id de la bd 
    public static EstadoContrato fromId(int id){
        
        for(EstadoContrato estado: EstadoContrato.values()){
            if(estado.getId() == id){
                return estado; // devolvemos el objeto estado de contrato
            }
        }
        throw new IllegalArgumentException("ID Invalido: " + id);
    }
};
