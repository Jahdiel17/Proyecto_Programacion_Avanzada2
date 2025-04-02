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
import DTO.HuespedesDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HuespedesDAO {
     public List<HuespedesDTO> obtenerHuespedes(){
         List<HuespedesDTO> lista = new ArrayList<>();
         String sql = "SELECT id, nombre, apellido, correo, telefono, identidad FROM huespedes WHERE activo = 1";
         
         try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                lista.add(new HuespedesDTO(
                    resultado.getInt("id"),
                    resultado.getString("nombre"),
                    resultado.getString("apellido"),
                    resultado.getString("correo"),
                    resultado.getString("telefono"),
                    resultado.getString("identidad")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return lista;
     }
     
    public boolean agregarHuesped(HuespedesDTO huesped) {
        String sql = "INSERT INTO huespedes (nombre, apellido, correo, telefono, identidad) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, huesped.getNombre());
            stmt.setString(2, huesped.getApellido());
            stmt.setString(3, huesped.getCorreo());
            stmt.setString(4, huesped.getTelefono());
            stmt.setString(5, huesped.getIdentidad());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public boolean actualizarHuesped(HuespedesDTO huesped) {
        String sql = "UPDATE huespedes SET nombre = ?, apellido = ?, correo = ?, telefono = ?, identidad = ? WHERE id = ? AND activo = 1";

        try (Connection conn = ConnectionDB.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, huesped.getNombre());
            stmt.setString(2, huesped.getApellido());
            stmt.setString(3, huesped.getCorreo());
            stmt.setString(4, huesped.getTelefono());
            stmt.setString(5, huesped.getIdentidad());
            stmt.setInt(6, huesped.getId());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    public boolean eliminarHuesped(int id) {
        String sql = "UPDATE huespedes SET activo = 0 WHERE id = ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }


}
