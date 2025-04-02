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
    
    public HabitacionesDTO(int id, String habitacion){
        this.id = id;
        this.habitacion = habitacion;
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
}
