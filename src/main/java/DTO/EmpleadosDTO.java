/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jahdi
 */
public class EmpleadosDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int cargoId;
    private String correo;
    private String telefono;
    private double salario;
    private String contrasena;

    public EmpleadosDTO(int id, String nombre, String apellido, int cargoId, String correo, 
                       String telefono, double salario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargoId = cargoId;
        this.correo = correo;
        this.telefono = telefono;
        this.salario = salario;
        this.contrasena = contrasena;
    }

    // Getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCargoId() {
        return cargoId;
    }
    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

