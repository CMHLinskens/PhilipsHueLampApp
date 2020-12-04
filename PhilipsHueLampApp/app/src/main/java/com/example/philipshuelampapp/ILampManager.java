package com.example.philipshuelampapp;

import com.example.philipshuelampapp.model.Product;
import com.example.philipshuelampapp.ui.LampItem;

import java.util.ArrayList;

public interface ILampManager {
    ArrayList<LampItem> getLamps();
    void setName(Product lamp, String name);
    void setPowerState(Product lamp, boolean state);
    void setBrightness(Product lamp, int value);
    void setHue(Product lamp, int value);
    void setSaturation(Product lamp, int value);
}
