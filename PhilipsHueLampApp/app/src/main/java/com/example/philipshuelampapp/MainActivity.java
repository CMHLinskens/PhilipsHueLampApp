package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.service.network.HueEmulatorService;
import com.example.philipshuelampapp.service.network.IHueEmulatorServiceListener;
import com.example.philipshuelampapp.ui.LampAdapter;
import com.example.philipshuelampapp.ui.LampItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IHueEmulatorServiceListener {
    private static final String LOGTAG = MainActivity.class.getName();
    private RecyclerView lampRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private HueEmulatorService hueEmulatorService;
    private Lamp lamps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hueEmulatorService = new HueEmulatorService(this);

        hueEmulatorService.getLights();
        ArrayList<LampItem> LampItems = new ArrayList<>();
        LampItems.add(new LampItem("YAAA", 0));

        lampRecyclerView = findViewById(R.id.LampRecycler);
        lampRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new LampAdapter(LampItems);

        lampRecyclerView.setLayoutManager(layoutManager);
        lampRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onLampsReceived(Lamp newLamps) {
        lamps = newLamps;
        hueEmulatorService.setLightSaturation("1", 0);
        hueEmulatorService.setLightHue("2", 46920);
        hueEmulatorService.setLightBrightness("3", 60);
    }

    @Override
    public void onLampsError(Lamp newLamps) {
        lamps = newLamps;
    }

    @Override
    public void onActionSuccess() {

    }

    @Override
    public void onActionError() {

    }
}