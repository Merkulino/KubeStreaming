package com.example.kubestreaming;

import android.widget.ImageView;

import java.io.Serializable;

public class Movie implements Serializable {

    private String name;
    private int id;
    private int date;
    private int duration;
    private int img;
    private String description;

    public Movie(String name, int id, int date, int duration, int img, String description) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.img = img;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
