package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.service.network.HueEmulatorService;
import com.example.philipshuelampapp.ui.LampAdapter;
import com.example.philipshuelampapp.ui.LampItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LOGTAG = MainActivity.class.getName();
    private RecyclerView lampRecyclerView;
    private LampAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LampItem> lampItems = new ArrayList<>();

    private HueEmulatorService hueEmulatorService;
    public Lamp lamps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hueEmulatorService = new HueEmulatorService();
        lamps = hueEmulatorService.getLights();

        lampItems = new ArrayList<>();
        lampItems.add(new LampItem(lamps.getProduct()));
        lampItems.add(new LampItem(lamps.getProduct2()));
        lampItems.add(new LampItem(lamps.getProduct3()));

        lampRecyclerView = findViewById(R.id.LampRecycler);
        lampRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new LampAdapter(lampItems);

        lampRecyclerView.setLayoutManager(layoutManager);
        lampRecyclerView.setAdapter(adapter);

//        adapter.setOnItemClickListener(new LampAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();            }
//        });
    }
}