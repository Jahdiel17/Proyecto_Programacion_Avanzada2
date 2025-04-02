/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Jahdi
 */
public class Habitacion {
    private int id;
    private String numeroHabitacion;
    private TipoHabitacion tipoHabitacion;
    private boolean activo;

    public Habitacion(int id, String numeroHabitacion, TipoHabitacion tipoHabitacion, boolean activo) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.activo = activo;
    }

    public Habitacion() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNumeroHabitacion() { return numeroHabitacion; }
    public void setNumeroHabitacion(String numeroHabitacion) { this.numeroHabitacion = numeroHabitacion; }

    public TipoHabitacion getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
