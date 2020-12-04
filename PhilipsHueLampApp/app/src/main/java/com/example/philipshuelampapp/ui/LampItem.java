package com.example.philipshuelampapp.ui;


import com.example.philipshuelampapp.model.Capabilities;
import com.example.philipshuelampapp.model.Config;
import com.example.philipshuelampapp.model.State;
import com.example.philipshuelampapp.model.Swupdate;

public class LampItem {
    private String name;
    private String modelid;
    private String productname;
    private int imageResource;
//    private String type;
//    private State state;
//    private Swupdate swupdate;
//    private String manufacturername;
//    private Capabilities capabilities;
//    private Config config;
//    private String uniqueid;
//    private String swversion;

    public LampItem(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }
}
