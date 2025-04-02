/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jahdi
 */
import java.sql.Date;

public class ReservasDTO {
    private int id;
    private int huespedId;
    private String huespedNombre;
    private int habitacionId;
    private String numeroHabitacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int estadoReservaId;
    private String estadoReserva;
    private double precio;

    public ReservasDTO(int id, int huespedId, String huespedNombre, int habitacionId, String numeroHabitacion,
                       Date fechaEntrada, Date fechaSalida, int estadoReservaId, String estadoReserva, double precio) {
        this.id = id;
        this.huespedId = huespedId;
        this.huespedNombre = huespedNombre;
        this.habitacionId = habitacionId;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoReservaId = estadoReservaId;
        this.estadoReserva = estadoReserva;
        this.precio = precio;
    }

    public int getId() { 
        return id; 
    }
    
    public void setId(int id) { 
        this.id = id; 
    }

    public int getHuespedId() { 
        return huespedId; 
    }
    
    public void setHuespedId(int huespedId) { 
        this.huespedId = huespedId; 
    }

    public String getHuespedNombre() { 
        return huespedNombre; 
    }
    
    public void setHuespedNombre(String huespedNombre) { 
        this.huespedNombre = huespedNombre; 
    }

    public int getHabitacionId() { 
        return habitacionId; 
    }
    
    public void setHabitacionId(int habitacionId) { 
        this.habitacionId = habitacionId; 
    }

    public String getNumeroHabitacion() { 
        return numeroHabitacion; 
    }
    
    public void setNumeroHabitacion(String numeroHabitacion) { 
        this.numeroHabitacion = numeroHabitacion; 
    }

    public Date getFechaEntrada() { 
        return fechaEntrada; 
    }
    
    public void setFechaEntrada(Date fechaEntrada) { 
        this.fechaEntrada = fechaEntrada; 
    }

    public Date getFechaSalida() { 
        return fechaSalida; 
    }
    
    public void setFechaSalida(Date fechaSalida) { 
        this.fechaSalida = fechaSalida; 
    }

    public int getEstadoReservaId() { 
        return estadoReservaId; 
    }
    
    public void setEstadoReservaId(int estadoReservaId) { 
        this.estadoReservaId = estadoReservaId; 
    }

    public String getEstadoReserva() { 
        return estadoReserva; 
    }
    
    public void setEstadoReserva(String estadoReserva) { 
        this.estadoReserva = estadoReserva; 
    }

    public double getPrecio() { 
        return precio; 
    }
    
    public void setPrecio(double precio) { 
        this.precio = precio; 
    }
}

