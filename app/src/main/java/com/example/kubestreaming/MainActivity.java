package com.example.kubestreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kubestreaming.adapter.RecycleViewAdapter;
import com.example.kubestreaming.adapter.RecyclerItemClickListener;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;

    private ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Movies List
        initRecycleView();
        createMovieObjects();

        //Carousel images and listener
        carouselView = findViewById(R.id.carouselViewID);
        carouselView.setPageCount(movies.size());
        carouselView.setImageListener( ImageListener );

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                movieDescriptionActivity(movies.get(position));
            }
        });

    }

    //Set Carousel imgListner
    ImageListener ImageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            Movie movie = movies.get(position);
            imageView.setImageResource(movie.getImg());

        }
    };

    //RecycleView Adapter Config
    private void initRecycleView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recicleViewID);
        recyclerView.setLayoutManager(layoutManager);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, movies);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Movie movie = movies.get(position);
                movieDescriptionActivity(movie);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    //Movies Database
    private void createMovieObjects(){

        Movie movie1 = new Movie("Blade Runner",001,1982,117,R.drawable.bladerunner_poster,
                "No século 21, uma corporação desenvolve clones humanos para serem usados como escravos em colônias fora da Terra, identificados como replicantes. Em 2019, um ex-policial é acionado para caçar um grupo fugitivo vivendo disfarçado em Los Angeles.");

        Movie movie2 = new Movie("Die Hard",002,1988,131,R.drawable.diehard_poster,
                "NYPD cop John McClane’s plan to reconcile with his estranged wife is thrown for a serious loop when, minutes after he arrives at her office, the entire building is overtaken by a group of terrorists. With little help from the LAPD, wisecracking McClane sets out to single-handedly rescue the hostages and bring the bad guys down.");

        Movie movie3 = new Movie("The Treasure of the Sierra Madre",003,1948,126,R.drawable.sieramadre_poster,
                "O Dr. Drew Pinsky fala sobre os vícios silenciosos que acometem mães e donas de casa, que hoje atingem números alarmantes. Casos de dependência de remédios controlados são comuns, mas vícios mais insidiosos, como o da compra, passam despercebidos.");

        Movie movie4 = new Movie("Mad Max: Fury Road",004,2015,120,R.drawable.furyroad_poster,
                "Num mundo apocalíptico, uma mulher se rebela contra um tirano ao procurar uma nova casa para um grupo de mulheres prisioneiras com a ajuda dum homem chamado Max.");

        Movie movie5 = new Movie("Joker",005,2019,122,R.drawable.jokerposter,
                "Isolado, intimidado e desconsiderado pela sociedade, o fracassado comediante Arthur Fleck inicia seu caminho como uma mente criminosa após assassinar três homens em pleno metrô. Sua ação inicia um movimento popular contra a elite de Gotham City, da qual Thomas Wayne é seu maior representante.");

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

    }

    //Link to Movie Activity
    private void movieDescriptionActivity(Movie objeto){

        Intent intent = new Intent(MainActivity.this, MovieDescription.class);
        intent.putExtra("object", objeto);
        startActivity(intent);
        onStop();

    }

}