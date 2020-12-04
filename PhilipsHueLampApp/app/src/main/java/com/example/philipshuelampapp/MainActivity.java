package com.example.philipshuelampapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.service.network.HueEmulatorService;
import com.example.philipshuelampapp.service.network.IHueEmulatorServiceListener;

public class MainActivity extends AppCompatActivity implements IHueEmulatorServiceListener {
    private static final String LOGTAG = MainActivity.class.getName();

    private HueEmulatorService hueEmulatorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hueEmulatorService = new HueEmulatorService(this, this);

        hueEmulatorService.getLights();
    }

    @Override
    public void onLampsReceived(Lamp lamp) {

    }

    @Override
    public void onLampsError() {

    }
}