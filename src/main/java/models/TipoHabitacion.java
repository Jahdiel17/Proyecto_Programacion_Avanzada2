/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Jahdi
 */
public class TipoHabitacion {
    private int id;
    private String tipo;
    private int capacidad;
    private String descripcion;

    public TipoHabitacion(int id, String tipo, int capacidad, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }

    public TipoHabitacion() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
