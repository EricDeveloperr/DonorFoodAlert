package com.example.donoralert;

import com.google.firebase.firestore.GeoPoint;

public class Food {

    String name, description;
    GeoPoint location;

    public Food (String name, String description, GeoPoint location)
    {
        this.location = location;
        this.name = name;
        this.description = description;
    }

}
