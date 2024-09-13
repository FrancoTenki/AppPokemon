package com.example.pokemonapp.entities;

public class Pokemon {
    public String Nombre;
    public String Tipo;
    public double longitud;
    public double latitud;

    public Pokemon(String nombre, String tipo, double longitud, double latitud) {
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
    }
}
