package com.dicoding.picodiploma.daftarfilm2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_FILM= "extra_film";

    ImageView ivPhoto;
    TextView tvName, tvSynopsis, tvType, tvDuration, tvRelease, tvLanguage, tvGenre, tvRating;
    Button btnShare, btnLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivPhoto = findViewById(R.id.img_photo);
        tvName = findViewById(R.id.txt_name);
        tvSynopsis = findViewById(R.id.tv_synopsis);
        tvType = findViewById(R.id.tv_type);
        tvDuration = findViewById(R.id.tv_duration);
        tvRelease = findViewById(R.id.tv_release);
        tvLanguage = findViewById(R.id.tv_language);
        tvGenre = findViewById(R.id.tv_genre);
        tvRating = findViewById(R.id.tv_rating);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        ivPhoto.setImageResource(film.getPhoto());
        tvName.setText(film.getName());
        tvSynopsis.setText(film.getSynopsis());
        tvType.setText(film.getType());
        tvDuration.setText(film.getDuration());
        tvRelease.setText(film.getYear());
        tvLanguage.setText(film.getLanguage());
        tvGenre.setText(film.getGenres());
        tvRating.setText(film.getRated());

        btnShare = findViewById(R.id.btn_set_share);
        btnShare.setOnClickListener(this);
        btnLike = findViewById(R.id.btn_set_like);
        btnLike.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_set_share:
                Toast.makeText(Detail.this,"Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_set_like:
                Toast.makeText(Detail.this,"Like", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
