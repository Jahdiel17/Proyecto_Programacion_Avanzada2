/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Jahdi
 */
public class EstadoReserva {
    private int id;
    private String nombreEstado;

    public EstadoReserva(int id, String nombreEstado) {
        this.id = id;
        this.nombreEstado = nombreEstado;
    }

    public EstadoReserva() {}

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreEstado() { return nombreEstado; }
    public void setNombreEstado(String nombreEstado) { this.nombreEstado = nombreEstado; }
}
