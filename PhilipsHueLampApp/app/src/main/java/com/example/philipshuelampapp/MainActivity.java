package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.model.Product;
import com.example.philipshuelampapp.service.network.HueEmulatorService;
import com.example.philipshuelampapp.service.network.IHueEmulatorServiceListener;
import com.example.philipshuelampapp.ui.LampAdapter;
import com.example.philipshuelampapp.ui.LampItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IHueEmulatorServiceListener {
    private static final String LOGTAG = MainActivity.class.getName();
    private RecyclerView lampRecyclerView;
    private LampAdapter adapter;
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
        LampItems.add(new LampItem(new Product())); // test

        lampRecyclerView = findViewById(R.id.LampRecycler);
        lampRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new LampAdapter(LampItems);

        lampRecyclerView.setLayoutManager(layoutManager);
        lampRecyclerView.setAdapter(adapter);

//        adapter.setOnItemClickListener(new LampAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();            }
//        });
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