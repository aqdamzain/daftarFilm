package com.dicoding.picodiploma.daftarfilm2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewFilmAdapter extends RecyclerView.Adapter<CardViewFilmAdapter.CardViewViewHolder> {

    private ArrayList<Film> listFilm;
    public CardViewFilmAdapter(ArrayList<Film> list) {
        this.listFilm = list;
    }

    @NonNull
    @Override
    public CardViewFilmAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_film, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewFilmAdapter.CardViewViewHolder holder, int position) {
        final Film film = listFilm.get(position);
        Glide.with(holder.itemView.getContext())
                .load(film.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.txtName.setText(film.getName());
        holder.txtDuration.setText(film.getDuration());
        holder.txtGenre.setText(film.getGenres());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent mIntent = new Intent(context, Detail.class);
                mIntent.putExtra(Detail.EXTRA_FILM, film);
                context.startActivity(mIntent);
            }
        });

            }

    @Override
    public int getItemCount() {
        return listFilm.size();
    }


    class CardViewViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private ImageView imgPhoto;
        private TextView txtDuration;
        private TextView txtGenre;

        CardViewViewHolder(View view) {
            super(view);
            txtName = view.findViewById(R.id.txt_name);
            imgPhoto = view.findViewById(R.id.img_photo);
            txtDuration = view.findViewById(R.id.txt_duration);
            txtGenre = view.findViewById(R.id.txt_genre);
        }
    }
}
