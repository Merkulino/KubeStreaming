package com.example.kubestreaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDescription extends AppCompatActivity {

    private ImageView imgViewBack, imgViewPoster;
    private TextView movieTitle, movieTime, movieDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_description);

        imgViewBack =      findViewById(R.id.backButtonID);
        imgViewPoster =    findViewById(R.id.imgViewPosterID);
        movieTitle =       findViewById(R.id.txtMovieTitleID);
        movieTime =        findViewById(R.id.txtMovieTimeID);
        movieDescription = findViewById(R.id.txtMovieDescID);

        imgViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { homeActivity(); }
        });

        Intent intent = getIntent();
        Movie movie = (Movie) intent.getSerializableExtra("object");

        imgViewPoster.setImageResource(movie.getImg());
        movieTitle.setText(movie.getName());
        movieTime.setText( String.valueOf(movie.getDuration())+"m");
        movieDescription.setText(movie.getDescription());
    }

    public void homeActivity(){
        Intent intent = new Intent(MovieDescription.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}