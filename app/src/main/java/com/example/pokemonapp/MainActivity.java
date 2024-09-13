package com.example.pokemonapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.adapters.PokemonAdapter;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.services.PokemonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Pokemon> pokemons=new ArrayList<>();
    PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://66d5b8d5f5859a7042673637.mockapi.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        service.getAll().enqueue(new Callback< List<Pokemon> >() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response< List<Pokemon> > response) {
                //if (response.code() == 200)
                Log.i("MAIN_APP", String.valueOf(response.code()));
                if (response.isSuccessful()){
                    //elementos = response.body();
                    pokemons.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
                // aca puedo trabajar con el resultado
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable throwable) {
                Log.e("MAIN_APP", throwable.getMessage());
            }
        });
        
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        RecyclerView rvpokemons = findViewById(R.id.rvPokemons);
        rvpokemons.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PokemonAdapter(pokemons);
        rvpokemons.setAdapter(adapter);
    }
}