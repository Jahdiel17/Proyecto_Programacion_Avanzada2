/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Jahdi
 */
import java.util.Date;

public class Reserva {
    private int id;
    private Huesped huesped; // Relación con Huesped
    private Habitacion habitacion; // Relación con Habitacion
    private Date fechaEntrada;
    private Date fechaSalida;
    private EstadoReserva estadoReserva; // Relación con EstadoReserva
    private double precio;
    private boolean activo;

    public Reserva(int id, Huesped huesped, Habitacion habitacion, Date fechaEntrada, Date fechaSalida, EstadoReserva estadoReserva, double precio, boolean activo) {
        this.id = id;
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estadoReserva = estadoReserva;
        this.precio = precio;
        this.activo = activo;
    }

    public Reserva() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Huesped getHuesped() { return huesped; }
    public void setHuesped(Huesped huesped) { this.huesped = huesped; }

    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }

    public Date getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(Date fechaEntrada) { this.fechaEntrada = fechaEntrada; }

    public Date getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(Date fechaSalida) { this.fechaSalida = fechaSalida; }

    public EstadoReserva getEstadoReserva() { return estadoReserva; }
    public void setEstadoReserva(EstadoReserva estadoReserva) { this.estadoReserva = estadoReserva; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
