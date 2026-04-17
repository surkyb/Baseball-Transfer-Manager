package com.techbridge.btm.repository;
import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                equip.setIdEquipo(resul.getInt("id"));
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
    
    /**
     *
     * @param idEquipo
     * @return
     */
    @Override
    public ArrayList<Jugador> buscarPorEquipo(int idEquipo){
    
        List<Jugador> jugador = new ArrayList();
        String sql = "SELECT j.nombre AS nombre_jugador, e.nombre AS nombre_equipo " +
                     "FROM jugador j " +
                     "JOIN contrato c ON j.id = c.id_jugador " +
                     "JOIN equipo e ON c.id_equipo = e.id " +
                     "WHERE e.id = ?";
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, idEquipo);
           
            //El resultSet contiene el resultado
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                
                Jugador ju = new Jugador();
                
                ju.setId(rs.getInt("id"));
                ju.setNombre(rs.getString("nombre_jugador"));
                
                Equipo equi = new Equipo();
                equi.setIdEquipo(rs.getInt("id_equipo"));
                equi.setNombre(rs.getString("nombre_equipo"));
                
                ju.setEquipo(equi);
                jugador.add(ju);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Aqui retornamos la lista de los jugadores
        return (ArrayList<Jugador>) jugador;
    }
    
}
