/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jahdi
 */
public class HabitacionesDTO {
    private int id;
    private String habitacion;
    private int tipo_habitacion;
    private String tipo;
    private int capacidad;
    private String descripcion;
    
    public HabitacionesDTO(int id, String habitacion, int tipo_habitacion, String tipo, int capacidad, String descripcion){
        this.id = id;
        this.habitacion = habitacion;
        this.tipo_habitacion = tipo_habitacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
    }
    
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getHabitacion() { 
        return habitacion; 
    }
    public void setHabitacion(String habitacion) { 
        this.habitacion = habitacion; 
    }
    
    public int getTipoHabitacion() { 
        return tipo_habitacion; 
    }
    public void setTipoHabitacion(int tipo_habitacion) { 
        this.tipo_habitacion = tipo_habitacion; 
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
