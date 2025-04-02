/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TipoHabitacionesDTO;
import config.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jahdi
 */
public class TipoHabitacionesDAO {

    public List<TipoHabitacionesDTO> obtenerTipoHabitaciones() {
        List<TipoHabitacionesDTO> lista = new ArrayList<>();
        String sql = "SELECT id, tipo, capacidad, descripcion FROM tipo_habitaciones";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                TipoHabitacionesDTO tipoHabitacion = new TipoHabitacionesDTO(
                        resultado.getInt("id"),
                        resultado.getString("tipo"),
                        resultado.getInt("capacidad"),
                        resultado.getString("descripcion")
                );
                lista.add(tipoHabitacion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener tipos de habitaciones: " + ex.getMessage());
        }
        return lista;
    }
}
