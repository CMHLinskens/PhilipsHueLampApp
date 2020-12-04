package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.model.Product;
import com.example.philipshuelampapp.service.network.HueEmulatorService;
import com.example.philipshuelampapp.service.network.IHueEmulatorServiceListener;
import com.example.philipshuelampapp.ui.LampAdapter;
import com.example.philipshuelampapp.ui.LampItem;

import org.json.JSONObject;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

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
        hueEmulatorService.setLightName("1", "barry");
        hueEmulatorService.setLightBrightness("3", 254);
    }

    @Override
    public void onLampsError(Lamp newLamps) {
        lamps = newLamps;
    }

    @Override
    public void onActionSuccess(String response) {
        Scanner reader = new Scanner(response);
        reader.useDelimiter("/");

        String lampId = "";
        String change = "";
        while(reader.hasNext()){
            String next = reader.next();
            if(next.matches("[0-9]"))
                lampId = next;
            else if(!reader.hasNext()){
                change = next;
            }
        }

        Log.d(LOGTAG, lampId + " has changed " + change);
    }

    @Override
    public void onActionError() {

    }
}