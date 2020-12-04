package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.model.Product;
import com.example.philipshuelampapp.service.network.HueEmulatorService;
import com.example.philipshuelampapp.ui.LampAdapter;
import com.example.philipshuelampapp.ui.LampItem;
import com.example.philipshuelampapp.ui.ListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ILampManager {
    private static final String LOGTAG = MainActivity.class.getName();
    private Lamp lamps;
    private ArrayList<LampItem> lampItems = new ArrayList<>();

    private HueEmulatorService hueEmulatorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hueEmulatorService = new HueEmulatorService();
        lamps = hueEmulatorService.getLights();

        ListFragment listFragment = new ListFragment();
        lampItems = new ArrayList<>();
        lampItems.add(new LampItem(lamps.getProduct()));
        lampItems.add(new LampItem(lamps.getProduct2()));
        lampItems.add(new LampItem(lamps.getProduct3()));
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).commit();
    }

    @Override
    public ArrayList<LampItem> getLamps() {
        return lampItems;
    }

    @Override
    public void setName(Product lamp, String name) {
        lamp.setName(name);
        hueEmulatorService.setLightName(lamp == lamps.getProduct()? "1" : lamp == lamps.getProduct2()? "2" : "3", name);
    }

    @Override
    public void setPowerState(Product lamp, boolean state) {
        lamp.getState().setOn(state);
        hueEmulatorService.setLightPowerState(lamp == lamps.getProduct()? "1" : lamp == lamps.getProduct2()? "2" : "3", state);
    }

    @Override
    public void setBrightness(Product lamp, int value) {
        lamp.getState().setBri(value);
        hueEmulatorService.setLightBrightness(lamp == lamps.getProduct()? "1" : lamp == lamps.getProduct2()? "2" : "3", value);
    }

    @Override
    public void setHue(Product lamp, int value) {
        lamp.getState().setHue(value);
        hueEmulatorService.setLightHue(lamp == lamps.getProduct()? "1" : lamp == lamps.getProduct2()? "2" : "3", value);
    }

    @Override
    public void setSaturation(Product lamp, int value) {
        lamp.getState().setSat(value);
        hueEmulatorService.setLightSaturation(lamp == lamps.getProduct()? "1" : lamp == lamps.getProduct2()? "2" : "3", value);
    }
}