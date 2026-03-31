package com.techbridge.btm.repository;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author gilber
 */
public class EquipoRepositoryImpl implements EquipoRepository {
    
    // utilizamos el override para sobreescribir el metodo guardarEquipo // 
    @Override 
    public void guardarEquipo(Equipo equip) {
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "INSERT INTO equipo (nombre, presupuesto) VALUES (?, ?)";
        
        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setString(1, equip.getNombre());
            ps.setDouble(2, equip.getPresupuesto());
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea guardar en este caso//
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // utilizamos el override para sobreescribir el metodo buscarEquipo // 
    @Override
    public Equipo buscarEquipo(String nombre) {
        Equipo equip = null; //Inicialisamos//
        
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "SELECT * FROM equipo WHERE nombre = ?";
        
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
                
                //Aqui agregamos los datos dados por la busqueda a un objeto tipo Equipo
                equip = new Equipo();
                equip.setNombre(resul.getString("nombre"));
                equip.setPresupuesto(resul.getDouble("presupuesto"));
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        // Despues de todo el proceso, devolvera el jugador buscado con todo sus datos
        return equip;
    }

    // utilizamos el override para sobreescribir el metodo eliminarEquipo // 
    @Override
    public void eliminarEquipo(String nombre) {
        
         //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "DELETE FROM equipo WHERE nombre = ?";
        
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
