package com.techbridge.btm.repository;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author gilber
 */
public class JugadorRepositoryImpl implements JugadorRepository {
    
    // utilizamos el override para sobreescribir el metodo guardar // 
    @Override 
    public void guardar(Jugador ju) {
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "INSERT INTO jugador(nombre, edad, posicion, valor) VALUES (?, ?, ?, ?)";
        
        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setString(1, ju.getNombre());
            ps.setInt(2, ju.getEdad());
            ps.setString(3, ju.getPosicion());
            ps.setDouble(4, ju.getValor());
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea guardar en este caso//
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // utilizamos el override para sobreescribir el metodo BuscarJugador // 
    @Override
    public Jugador buscarJugador(String nombre) {
        Jugador ju = null; //Inicialisamos//
        
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "SELECT * FROM jugador WHERE nombre = ?";
        
        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps  = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setString(1, nombre);
            //El resultSet contiene el resultado
            ResultSet resul = ps.executeQuery();
            
            if (resul.next()){
                
                //Aqui agregamos los datos dados por la busqueda a un objeto tipo Jugador
                ju = new Jugador();
                ju.setNombre(resul.getString("nombre"));
                ju.setEdad(resul.getInt("edad"));
                ju.setPosicion(resul.getString("posicion"));
                ju.setValor(resul.getDouble("valor"));
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        // Despues de todo el proceso, devolvera el jugador buscado con todo sus datos
        return ju;
    }

    // utilizamos el override para sobreescribir el metodo eliminar // 
    @Override
    public void eliminar(String nombre) {
        
         //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "DELETE FROM jugador WHERE nombre = ?";
        
         /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con =DatabaseConnection.getConexion();
              PreparedStatement ps = con.prepareStatement(sql)) {
            
             //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setString(1, nombre);
            
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea eliminar en este caso)//
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
