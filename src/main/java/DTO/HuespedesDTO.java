/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Jahdi
 */
public class HuespedesDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String identidad;
    
    public HuespedesDTO(int id, String nombre, String apellido, String correo, String telefono, String identidad){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.identidad = identidad;
    }
    
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

    public String getIdentidad() { 
        return identidad; 
    }
    public void setIdentidad(String identidad) { 
        this.identidad = identidad; 
    }
}
