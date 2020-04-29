package com.dicoding.picodiploma.daftarfilm2;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Movies extends Fragment {
    private RecyclerView rvMovies;
    private ArrayList<Film> list = new ArrayList<>();

    public Movies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(getListData());
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewFilmAdapter cardViewHeroAdapter = new CardViewFilmAdapter(list);
        rvMovies.setAdapter(cardViewHeroAdapter);
    }


    public ArrayList<Film> getListData(){
        String[] dataName;
        String[] dataRelease;
        TypedArray dataPhoto;
        String[] dataDuration;
        String[] dataGenre;
        String[] dataSynopsis;
        String[] dataType;
        String[] dataLanguage;
        String[] dataRated;
        ArrayList<Film> list = new ArrayList<>();

        dataName = getResources().getStringArray(R.array.data_movies_name);
        dataPhoto = getResources().obtainTypedArray(R.array.data_movies_photo);
        dataRelease = getResources().getStringArray(R.array.data_movies_year);
        dataDuration = getResources().getStringArray(R.array.data_movies_duration);
        dataGenre = getResources().getStringArray(R.array.data_movies_genre);
        dataSynopsis = getResources().getStringArray((R.array.data_movies_synopsis));
        dataType = getResources().getStringArray(R.array.data_movies_type);
        dataLanguage = getResources().getStringArray(R.array.data_movies_language);
        dataRated = getResources().getStringArray(R.array.data_movies_rating);

        for(int i=0; i<dataName.length; i++) {
            Film film = new Film();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setName(dataName[i]);
            film.setYear(dataRelease[i]);
            film.setDuration(dataDuration[i]);
            film.setGenres(dataGenre[i]);
            film.setSynopsis(dataSynopsis[i]);
            film.setType(dataType[i]);
            film.setLanguage(dataLanguage[i]);
            film.setRated(dataRated[i]);
            list.add(film);
        }
        return list;
    }

}
