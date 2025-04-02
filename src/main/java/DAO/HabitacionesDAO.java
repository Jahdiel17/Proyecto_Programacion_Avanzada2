/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Jahdi
 */
import config.ConnectionDB;
import DTO.HabitacionesDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDAO {
    public List<HabitacionesDTO> obtenerHabitaciones() {
        List<HabitacionesDTO> lista = new ArrayList<>();
        String sql = "SELECT id, numero_habitacion, tipo_habitacion_id FROM habitaciones WHERE activo = 1";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                lista.add(new HabitacionesDTO(
                    resultado.getInt("id"),
                    resultado.getString("numero_habitacion"),
                    resultado.getInt("tipo_habitacion_id")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return lista;
    }
    
    public boolean actualizarHabitacion(HabitacionesDTO habitacion) {
        String sql = "UPDATE habitaciones SET numero_habitacion = ?, tipo_habitacion_id = ? WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, habitacion.getHabitacion());
            stmt.setInt(2, habitacion.getTipoHabitacion());
            stmt.setInt(3, habitacion.getId());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; 
        } catch (SQLException ex) {
            System.out.println("Error al actualizar habitación: " + ex.toString());
        }
        return false;
    }

    public boolean eliminarHabitacion(int id) {
        String sql = "UPDATE habitaciones SET activo = 0 WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar habitación: " + ex.toString());
        }
        return false;
    }
}
