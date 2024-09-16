package com.example.pokemonapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pokemonapp.R;
import com.example.pokemonapp.entities.Pokemon;
import com.google.gson.Gson;

public class DetailPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_pokemon);

        Intent intent =getIntent();
        String pokemonJson=intent.getStringExtra("POKEMON");
        Pokemon pokemon=new Gson().fromJson(pokemonJson,Pokemon.class);

        TextView tvName=findViewById(R.id.tvNameDet);
        TextView tvTipo=findViewById(R.id.tvTipoDet);
        Button btnVerUbica=findViewById(R.id.btnVerUbicacionPo);

        tvName.setText(pokemon.Nombre);
        tvTipo.setText(pokemon.Tipo);

        btnVerUbica.setOnClickListener(view -> {
            Intent intentUb=new Intent(view.getContext(),MapsActivity.class);
            intentUb.putExtra("POKEMON",pokemonJson);
            view.getContext().startActivity(intentUb);
        });
    }
}