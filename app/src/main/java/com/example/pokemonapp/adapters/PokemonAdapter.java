package com.example.pokemonapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonapp.R;
import com.example.pokemonapp.entities.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private final List<Pokemon> data;

    public PokemonAdapter(List<Pokemon> data) {this.data = data;}

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_pokemon, parent, false);

        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        View view=holder.itemView;

        Pokemon item=data.get(position);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvNumber = view.findViewById(R.id.tvTipo);

        tvName.setText(item.Nombre);
        tvNumber.setText(item.Tipo);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public PokemonViewHolder(@NonNull View itemView) {super(itemView);}
    }
}
