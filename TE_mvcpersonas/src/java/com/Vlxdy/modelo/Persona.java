package com.Vlxdy.modelo;
/**
 *
 * @author Vlxdy Hishikawa
 */
public class Persona {
    private int Id;
    private String Nombres;
    private String Apellidos;
    private int Edad;

    public Persona() {
        Id = 0;
        Nombres = "";
        Apellidos = "";
        Edad = 0;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }   
}

