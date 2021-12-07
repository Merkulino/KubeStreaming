package com.example.kubestreaming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;
    private ImageView imgVBladeRunner, imgVDieHard;

    //Carousel Images
    private int [] imgs = { R.drawable.bladerunner_poster,
                            R.drawable.diehard_poster,
                            R.drawable.furyroad_poster,
                            R.drawable.jokerposter,
                            R.drawable.sieramadre_poster,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgVBladeRunner = findViewById(R.id.imgViewBladeRunner);
        imgVDieHard = findViewById(R.id.dieHardImgView);

        //set imgs in carousel
        carouselView = findViewById(R.id.carouselViewID);
        carouselView.setPageCount(imgs.length);
        carouselView.setImageListener( ImageListener );

        //Movies ArrayList
        ArrayList<Movie> movies = new ArrayList<>();

        Movie blade_runner = new Movie("Blade Runner",001,1982,117,R.drawable.bladerunner_poster,
                "No século 21, uma corporação desenvolve clones humanos para serem usados como escravos em colônias fora da Terra, identificados como replicantes. Em 2019, um ex-policial é acionado para caçar um grupo fugitivo vivendo disfarçado em Los Angeles.");

        Movie dieHard = new Movie("Die Hard",002,1988,131,R.drawable.diehard_poster,
                "NYPD cop John McClane’s plan to reconcile with his estranged wife is thrown for a serious loop when, minutes after he arrives at her office, the entire building is overtaken by a group of terrorists. With little help from the LAPD, wisecracking McClane sets out to single-handedly rescue the hostages and bring the bad guys down.");

        movies.add(blade_runner);
        movies.add(dieHard);

        //Set movie poster on list
        imgVBladeRunner.setImageResource(blade_runner.getImg());
        imgVDieHard.setImageResource(dieHard.getImg());

        imgVBladeRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieDescriptionActivity(blade_runner);
            }
        });

        imgVDieHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieDescriptionActivity(dieHard);
            }
        });
    }

    ImageListener ImageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {  imageView.setImageResource(imgs[position]); }
    };

    private void movieDescriptionActivity(Movie objeto){

        Intent intent = new Intent(MainActivity.this, MovieDescription.class);
        intent.putExtra("object", objeto);
        startActivity(intent);
        onStop();

    }

}