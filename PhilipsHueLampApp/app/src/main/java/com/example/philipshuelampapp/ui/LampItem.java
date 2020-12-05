package com.example.philipshuelampapp.ui;


import android.os.Parcel;
import android.os.Parcelable;

import com.example.philipshuelampapp.model.Capabilities;
import com.example.philipshuelampapp.model.Config;
import com.example.philipshuelampapp.model.Product;
import com.example.philipshuelampapp.model.State;
import com.example.philipshuelampapp.model.Swupdate;

public class LampItem {
    private final Product lamp;
//    private String name;
//    private String modelid;
//    private String productname;
//    private int imageResource;
//    private String type;
//    private State state;
//    private Swupdate swupdate;
//    private String manufacturername;
//    private Capabilities capabilities;
//    private Config config;
//    private String uniqueid;
//    private String swversion;

    public LampItem(Product lamp) {
        this.lamp = lamp;

    }

//    public int getImageResource() {
//        return imageResource;
//    }

    public Product getLamp(){
        return lamp;
    }
}
