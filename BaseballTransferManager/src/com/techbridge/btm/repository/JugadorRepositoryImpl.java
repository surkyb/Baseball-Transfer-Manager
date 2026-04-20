package com.techbridge.btm.repository;
import com.techbridge.btm.dbconnection.DatabaseConnection;
import com.techbridge.btm.model.Equipo;
import com.techbridge.btm.model.Jugador;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                ju.setId(resul.getInt("id"));
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
    @Override
    public java.util.List<Jugador> listarTodos() {
        java.util.List<Jugador> lista = new java.util.ArrayList<>();
        String sql = "SELECT j.id, j.nombre, j.posicion, j.edad, j.valor, " +
                     "e.nombre AS equipo_nombre, c.fecha_fin " +
                     "FROM Jugador j " +
                     "LEFT JOIN Contrato c ON j.id = c.id_jugador AND c.id_estado_contrato = 1 " +
                     "LEFT JOIN Equipo e ON c.id_equipo = e.id";
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet resul = ps.executeQuery()) {
            
            // Usamos un while porque pueden ser muchos jugadores
            while (resul.next()) {
                Jugador ju = new Jugador();
                ju.setId(resul.getInt("id"));
                ju.setNombre(resul.getString("nombre"));
                ju.setEdad(resul.getInt("edad"));
                ju.setPosicion(resul.getString("posicion"));
                ju.setValor(resul.getDouble("valor"));
                
                // 1. Extraemos el nombre del equipo. Si es nulo, le ponemos "Agente Libre"
                String nombreEquipo = resul.getString("equipo_nombre");
                Equipo eq = new Equipo();
                if(nombreEquipo != null){
                    eq.setNombre(nombreEquipo);
                }else{
                    eq.setNombre("Agente Libre");
                }
                ju.setEquipo(eq);// Guardamos el objeto equipo dentro del jugador
                

                // --- MANEJO DE LA FECHA DE CONTRATO ---
                java.sql.Date fecha = resul.getDate("fecha_fin");
                if (fecha != null) {
                    ju.setFechaFin(fecha.toString());
                } else {
                    ju.setFechaFin("N/A");
                }            
                lista.add(ju); // Lo metemos en la lista
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public void liberarJugador(String nombreJugador) throws Exception {
        // Esta consulta busca el contrato activo del jugador y le cambia el estado
        // (Usando una subconsulta para encontrar el ID del jugador por su nombre)
        String sql = "UPDATE Contrato SET id_estado_contrato = ? WHERE id_jugador = (SELECT id FROM Jugador WHERE nombre = ?)";
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // AQUI hay un detalle clave: el número 2 representa el estado "Terminado" o "Agente Libre"
            ps.setInt(1, 2); 
            ps.setString(2, nombreJugador);
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas == 0) {
                throw new Exception("No se encontró un contrato activo para este jugador.");
            }
            
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al liberar jugador: " + e.getMessage());
        }
    }
    @Override
    public void asignarEquipo(String nombreJugador, String nombreEquipo, String salario, String fInicio, String fFin) throws Exception {
        String sql = "INSERT INTO Contrato (id_jugador, id_equipo, id_estado_contrato, fecha_inicio, fecha_fin, salario) " +
                     "VALUES ((SELECT id FROM Jugador WHERE nombre = ?), " +
                     "(SELECT id FROM Equipo WHERE nombre = ?), 1, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreJugador);
            ps.setString(2, nombreEquipo);
            ps.setString(3, fInicio);
            ps.setString(4, fFin);
            ps.setDouble(5, Double.parseDouble(salario));

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al registrar el contrato: " + e.getMessage());
        }
    }
    @Override
    public void renovarContrato(String nombreJugador, String nuevoSalario, String nuevaFechaFin) throws Exception {
        // Actualizamos el salario y la fecha de fin del contrato activo del jugador
        String sql = "UPDATE Contrato SET salario = ?, fecha_fin = ? " +
                     "WHERE id_estado_contrato = 1 AND id_jugador = (SELECT id FROM Jugador WHERE nombre = ?)";
        
        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setDouble(1, Double.parseDouble(nuevoSalario));
            ps.setString(2, nuevaFechaFin);
            ps.setString(3, nombreJugador);
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas == 0) {
                throw new Exception("El jugador no tiene un contrato activo para renovar.");
            }
            
        } catch (SQLException e) {
            throw new Exception("Error en la base de datos al renovar: " + e.getMessage());
        }
    }
    @Override
    public String obtenerDetallesJugador(String nombreJugador) throws Exception {
        // Hacemos JOIN con Contrato, Equipo y Estadisticas
        String sql = "SELECT e.nombre as equipo, c.salario, c.fecha_fin, " +
                     "est.juegos, est.home_runs, est.promedio_bateo " +
                     "FROM Jugador j " +
                     "LEFT JOIN Contrato c ON j.id = c.id_jugador AND c.id_estado_contrato = 1 " +
                     "LEFT JOIN Equipo e ON c.id_equipo = e.id " +
                     "LEFT JOIN Estadisticas est ON j.id = est.id_jugador " +
                     "WHERE j.nombre = ?";

        StringBuilder detalles = new StringBuilder();
        detalles.append("=== Perfil del Jugador: ").append(nombreJugador).append(" ===\n\n");

        try (Connection con = DatabaseConnection.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreJugador);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String equipo = rs.getString("equipo");
                double salario = rs.getDouble("salario");
                java.sql.Date fechaFin = rs.getDate("fecha_fin");
                
                // Si las estadísticas son nulas, la BD devolverá 0 por defecto para los enteros
                int juegos = rs.getInt("juegos");
                int hr = rs.getInt("home_runs");
                double avg = rs.getDouble("promedio_bateo");

                detalles.append("ESTADO ACTUAL\n");
                detalles.append("Equipo: ").append(equipo != null ? equipo : "Agente Libre").append("\n");
                detalles.append("Salario: $").append(salario > 0 ? salario : "No aplica").append("\n");
                detalles.append("Fin de contrato: ").append(fechaFin != null ? fechaFin.toString() : "No aplica").append("\n\n");

                detalles.append("ESTADÍSTICAS\n");
                detalles.append("- Juegos jugados: ").append(juegos).append("\n");
                detalles.append("- Home Runs: ").append(hr).append("\n");
                detalles.append("- Promedio de Bateo: ").append(avg);
            } else {
                throw new Exception("Jugador no encontrado en la base de datos.");
            }
        } catch (SQLException e) {
            throw new Exception("Error al consultar la base de datos: " + e.getMessage());
        }
        return detalles.toString();
    }
}
