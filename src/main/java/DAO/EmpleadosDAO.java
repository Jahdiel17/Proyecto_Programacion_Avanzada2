/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Jahdi
 */

import DTO.EmpleadosDTO;
import config.ConnectionDB;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadosDAO {

    public EmpleadosDTO login(String correo, String contrasena) {
        String sql = "SELECT id, nombre, apellido, cargo_id, correo, telefono, salario, contrasena FROM empleados WHERE correo = ? AND activo = 1";
        EmpleadosDTO empleado = null;

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);

            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    String contrasenaHash = resultado.getString("contrasena");

                    if (BCrypt.checkpw(contrasena, contrasenaHash)) {
                        empleado = new EmpleadosDTO(
                                resultado.getInt("id"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido"),
                                resultado.getInt("cargo_id"),
                                resultado.getString("correo"),
                                resultado.getString("telefono"),
                                resultado.getDouble("salario"),
                                contrasena 
                        );
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al intentar hacer login: " + ex.getMessage());
        }

        return empleado;
    }
}

