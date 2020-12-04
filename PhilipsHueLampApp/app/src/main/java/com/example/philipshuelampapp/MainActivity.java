package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.philipshuelampapp.model.Lamp;
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
}