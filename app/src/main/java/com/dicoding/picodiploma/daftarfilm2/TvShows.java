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
public class TvShows extends Fragment {
    private RecyclerView rvTvShows;
    private ArrayList<Film> list = new ArrayList<>();

    public TvShows() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTvShows = view.findViewById(R.id.rv_tv_shows);
        rvTvShows.setHasFixedSize(true);

        list.addAll(getListData());
        rvTvShows.setLayoutManager(new LinearLayoutManager(getActivity()));
        CardViewFilmAdapter cardViewHeroAdapter = new CardViewFilmAdapter(list);
        rvTvShows.setAdapter(cardViewHeroAdapter);
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

        dataName = getResources().getStringArray(R.array.data_tv_shows_name);
        dataPhoto = getResources().obtainTypedArray(R.array.data_tv_shows_photo);
        dataRelease = getResources().getStringArray(R.array.data_tv_shows_year);
        dataDuration = getResources().getStringArray(R.array.data_tv_shows_duration);
        dataGenre = getResources().getStringArray(R.array.data_tv_shows_genre);
        dataSynopsis = getResources().getStringArray((R.array.data_tv_shows_synopsis));
        dataType = getResources().getStringArray(R.array.data_tv_shows_type);
        dataLanguage = getResources().getStringArray(R.array.data_tv_shows_language);
        dataRated = getResources().getStringArray(R.array.data_tv_shows_rating);

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
