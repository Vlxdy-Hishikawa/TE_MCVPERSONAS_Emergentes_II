package com.Vlxdy.modelo;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class Nota {
    private int Id;
    private String Hora;
    private String Actividad;
    private String Completado;

    public Nota() {
        Id = 0 ;
        Hora = "" ;
        Actividad = "" ;
        Completado = "" ;  
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public String getCompletado() {
        return Completado;
    }

    public void setCompletado(String Completado) {
        this.Completado = Completado;
    }
    
}
