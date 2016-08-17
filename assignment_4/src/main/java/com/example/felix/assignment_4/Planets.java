package com.example.felix.assignment_4;

/**
 * Created by Felix on 2016-08-16.
 */
import android.graphics.drawable.Drawable;

import java.io.Serializable;


public class Planets implements Serializable {
    String name;
    Drawable image;
    String description;
    String fact;

    public Planets(String name, Drawable image, String description, String fact) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.fact = fact;
    }

    public Drawable getImage() {
        return image;
    }
    public void setImage(Drawable image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSummary() {
        return description;
    }
    public String getFact() {
        return fact;
    }

}