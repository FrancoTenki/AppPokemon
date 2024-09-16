package com.example.pokemonapp.entities;

public class Pokemon {
    public String Nombre;
    public String Tipo;
    public double longuitud;
    public double latitud;

    public Pokemon(String nombre, String tipo, double longuitud, double latitud) {
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.longuitud = longuitud;
        this.latitud = latitud;
    }
}
