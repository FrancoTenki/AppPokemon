package com.example.pokemonapp.services;

import com.example.pokemonapp.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PokemonService {
    @GET("/Pokemon")
    Call<List<Pokemon>> getAll();

    @GET("/Pokemon/{id}")
    Call< Pokemon > find(@Path("id") int id);

    @POST("/Pokemon")
    Call<Pokemon> create(@Body Pokemon pokemon);
}
