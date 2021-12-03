package com.example.kubestreaming;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.synnapps.carouselview.ViewListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;

    private int [] imgs = {
            R.drawable.bladerunner_poster,
            R.drawable.diehard_poster,
            R.drawable.furyroad_poster,
            R.drawable.jokerposter,
            R.drawable.sieramadre_poster,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carouselView = findViewById(R.id.carouselViewID);
        carouselView.setPageCount(imgs.length);
        carouselView.setImageListener( ImageListener );



    }

    ViewListener viewListener = new ViewListener() {
        @Override
        public View setViewForPosition(int position) {
            //View custonView = getLayoutInflater().inflate();
            return null;
        }
    };

    ImageListener ImageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imgs[position]);

        }
    };

}