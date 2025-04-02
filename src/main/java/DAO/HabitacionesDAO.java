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
        String sql = "SELECT id, numero_habitacion FROM habitaciones WHERE activo = 1";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                lista.add(new HabitacionesDTO(
                    resultado.getInt("id"),
                    resultado.getString("numero_habitacion")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return lista;
    }
}
