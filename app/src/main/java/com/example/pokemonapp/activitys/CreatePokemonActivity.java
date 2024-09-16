package com.example.pokemonapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pokemonapp.R;
import com.example.pokemonapp.entities.Pokemon;
import com.example.pokemonapp.services.PokemonService;
import com.google.gson.Gson;

import okhttp3.internal.Internal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreatePokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_pokemon);


        Button btnGuardarContacto = findViewById(R.id.btnGuardarPokemon);
        EditText etName = findViewById(R.id.etName);
        EditText etTipo = findViewById(R.id.etTipo);
        EditText etLonguitud = findViewById(R.id.etLonguitud);
        EditText etLatitud = findViewById(R.id.etLatitud);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://66d5b8d5f5859a7042673637.mockapi.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        btnGuardarContacto.setOnClickListener(view -> {

            String name = etName.getText().toString();
            String tipo = etTipo.getText().toString();
            int longuitud =Integer.parseInt(etLonguitud.getText().toString());
            int latitud = Integer.parseInt(etLatitud.getText().toString());

            Pokemon po=new Pokemon(name,tipo,longuitud,latitud);

            service.create(po).enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    Log.i("MAIN_APP", String.valueOf(response.code()));

                    if(response.isSuccessful()){
                        Pokemon newpokemon=response.body();

                        Intent intent=getIntent();
                        intent.putExtra("POKEMON",new Gson().toJson(newpokemon));

                        setResult(100,intent);
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable throwable) {
                    Log.e("MAIN_APP", throwable.getMessage());
                }
            });
        });
    }
}