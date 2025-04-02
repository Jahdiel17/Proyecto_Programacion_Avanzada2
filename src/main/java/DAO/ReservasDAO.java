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
import DTO.ReservasDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservasDAO {
    public List<ReservasDTO> obtenerReservas() {
        List<ReservasDTO> lista = new ArrayList<>();
        String sql = """
                        SELECT r.id, r.fecha_entrada, r.fecha_salida, r.precio,
                               h.id AS huesped_id, h.nombre AS huesped_nombre, h.apellido AS huesped_apellido,
                               hab.id AS habitacion_id, hab.numero_habitacion,
                               er.id AS estado_reserva_id, er.nombre_estado
                        FROM reservas r
                        JOIN huespedes h ON r.huesped_id = h.id
                        JOIN habitaciones hab ON r.habitacion_id = hab.id
                        JOIN estados_reserva er ON r.estado_reserva_id = er.id
                        WHERE r.activo = 1
                    """;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                lista.add(new ReservasDTO(
                    resultado.getInt("id"),
                    resultado.getInt("huesped_id"),
                    resultado.getString("huesped_nombre") + " " + resultado.getString("huesped_apellido"),
                    resultado.getInt("habitacion_id"),
                    resultado.getString("numero_habitacion"),
                    resultado.getDate("fecha_entrada"),
                    resultado.getDate("fecha_salida"),
                    resultado.getInt("estado_reserva_id"),
                    resultado.getString("nombre_estado"),
                    resultado.getDouble("precio")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener reservas activas: " + ex.getMessage());
        }
        return lista;
    }
    
    public boolean agregarReserva(int huespedId, int habitacionId, java.sql.Date fechaEntrada, 
                                  java.sql.Date fechaSalida, int estadoReservaId, double precio) {
        String sql = """
            INSERT INTO reservas (huesped_id, habitacion_id, fecha_entrada, fecha_salida, estado_reserva_id, precio, activo) 
            VALUES (?, ?, ?, ?, ?, ?, 1)
        """;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, huespedId);
            stmt.setInt(2, habitacionId);
            stmt.setDate(3, fechaEntrada);
            stmt.setDate(4, fechaSalida);
            stmt.setInt(5, estadoReservaId);
            stmt.setDouble(6, precio);

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al agregar reserva: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean actualizarReserva(int id, int huespedId, int habitacionId, java.sql.Date fechaEntrada, java.sql.Date fechaSalida, int estadoReservaId, double precio) {
        String sql = """
            UPDATE reservas 
            SET huesped_id = ?, habitacion_id = ?, fecha_entrada = ?, 
                fecha_salida = ?, estado_reserva_id = ?, precio = ? 
            WHERE id = ? AND activo = 1
        """;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, huespedId);
            stmt.setInt(2, habitacionId);
            stmt.setDate(3, fechaEntrada);
            stmt.setDate(4, fechaSalida);
            stmt.setInt(5, estadoReservaId);
            stmt.setDouble(6, precio);
            stmt.setInt(7, id);

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar reserva: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean eliminarReserva(int id) {
        String sql = " UPDATE reservas SET activo = 0 WHERE id = ? AND activo = 1";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar reserva: " + ex.getMessage());
            return false;
        }
    }
}
