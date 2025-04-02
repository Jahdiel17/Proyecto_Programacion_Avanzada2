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
import DTO.EstadoReservaDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoReservaDAO {
     public List<EstadoReservaDTO> obtenerEstadosReserva() {
        List<EstadoReservaDTO> lista = new ArrayList<>();
        String sql = "SELECT id, nombre_estado FROM estados_reserva ORDER BY id";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                lista.add(new EstadoReservaDTO(
                    resultado.getInt("id"),
                    resultado.getString("nombre_estado")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return lista;
    }
}
