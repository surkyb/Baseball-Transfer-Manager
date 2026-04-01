package com.techbridge.btm.repository;
import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Transferencia;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author gilbe
 */
public class TransferenciaRepositoryImpl implements TransferenciaRepository {
    
    // utilizamos el override para sobreescribir el metodo guardarTransferencia // 
    @Override 
    public void guardarTransferencia(Transferencia transfe) {
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "INSERT INTO transferencia (id_jugador, id_equipo_origen, id_equipo_destino, monto, fecha) VALUES (?, ?, ?, ?, ?)";
        
        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, transfe.getIdJugador());
            ps.setInt(2, transfe.getEquipoOrigen().getIdEquipo());
            ps.setInt(3, transfe.getEquipoDestino().getIdEquipo());
            ps.setDouble(4,transfe.getMonto());
            ps.setDate(5, java.sql.Date.valueOf (transfe.getFecha()));
            
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea guardar en este caso//
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // utilizamos el override para sobreescribir el metodo buscarTransferencia // 
    @Override
    public Transferencia buscarTransferencia(int idTransferencia) {
        Transferencia transfe = null; //Inicialisamos//
        
        //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "SELECT * FROM transferencia WHERE id = ?";
        
        /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps  = con.prepareStatement(sql)){
            
            //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, idTransferencia);
            
            //El resultSet contiene el resultado
            ResultSet resul = ps.executeQuery();
            
            if (resul.next()){
                
                //Aqui agregamos los datos dados por la busqueda a un objeto tipo Transferencia
                transfe = new Transferencia();
                transfe.setIdTransferencia(resul.getInt("id"));
                
                transfe.setIdJugador(resul.getInt("id_jugador"));
             
                //Aqui creamos un objeto tipo Equipo para poder leer el ID de la base de datos y mostrarlo
                Equipo origen = new Equipo();
                origen.setIdEquipo(resul.getInt("id_equipo_origen"));
                transfe.setEquipoOrigen(origen);
                
                Equipo destino = new Equipo();
                destino.setIdEquipo(resul.getInt("id_equipo_destino"));
                transfe.setEquipoDestino(destino);
                
                transfe.setMonto(resul.getDouble("monto"));
                transfe.setFecha(resul.getDate("fecha").toLocalDate());
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        // Despues de todo el proceso, devolvera el contrato buscado con todo sus datos
        return transfe;
    }

    // utilizamos el override para sobreescribir el metodo eliminarTransferencia // 
    @Override
    public void eliminarTransferencia(int idTransferencia) {
        
         //Declaramos una variable String la cual contendra la consulta SQL//
        String sql = "DELETE FROM transferencia WHERE id = ?";
        
         /*Agregamos un try catch para poder manejar cualquier tipo de error
        y evitar que se cierre abruptamente */
        
        /*Dentro del try se encuentra la coneccion con la base de datos
        para hacer la consulta, y el PreparedStatement es para poder inyectar
        la consulta SQL */
        
        try (Connection con =DatabaseConnection.getConexion();
              PreparedStatement ps = con.prepareStatement(sql)) {
            
             //Aqui agregamos las informaciones necesarias en la consulta//
            ps.setInt(1, idTransferencia);
            
            //El executeUpdate se utiliza para ya ejecutar la consulta (o sea eliminar en este caso)//
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
