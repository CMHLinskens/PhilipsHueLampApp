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
import com.example.philipshuelampapp.ui.ListFragment;

import org.json.JSONObject;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements IHueEmulatorServiceListener {
    private static final String LOGTAG = MainActivity.class.getName();
    private Lamp lamps;

    private HueEmulatorService hueEmulatorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hueEmulatorService = new HueEmulatorService(this);

        hueEmulatorService.getLights();
        ListFragment listFragment = new ListFragment(lamps);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, listFragment).commit();


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