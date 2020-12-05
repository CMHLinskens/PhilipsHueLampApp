package com.example.philipshuelampapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.philipshuelampapp.ILampManager;
import com.example.philipshuelampapp.R;
import com.example.philipshuelampapp.model.Product;

import java.util.ArrayList;

public class LampFragment extends Fragment {
    private Product lamp;
    private ILampManager lampManager;
    private ArrayList<LampItem> lamps;
    private TextView nameTextView;
    private TextView modelIDTextView;
    private TextView productNameTextView;
    private TextView stateTextView;
    private TextView iDTextView;
    private TextView colorTextView;
    private TextView brightnessTextView;
    private TextView saturationTextView;
    private SeekBar colorSlider;
    private SeekBar brightnessSlider;
    private SeekBar saturationSlider;
    private Button powerButton;
    private boolean power;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lamp_fragment, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null)
            lamp = lamps.get(bundle.getInt("position")).getLamp();

        initializeSliders(view, lamp);
        initializeTextViews(view, lamp);
        initializeButtons(view, lamp);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ILampManager) {
            lampManager = (ILampManager) context;
            lamps = lampManager.getLamps();
        } else {
            throw new RuntimeException("Not an instanceOf ILampManager");
        }
    }

    private void initializeSliders(View view, Product lamp){
        colorSlider = view.findViewById(R.id.colorSlider);
        colorSlider.setProgress((int) (lamp.getState().getHue() / 65534.0));
        brightnessSlider = view.findViewById(R.id.brightnessSlider);
        brightnessSlider.setProgress((int) (lamp.getState().getBri() / 254.0));
        saturationSlider = view.findViewById(R.id.saturationSlider);
        saturationSlider.setProgress((int) (lamp.getState().getSat() / 254.0));

        colorSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lampManager.setHue(lamp, progress * 65534);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        brightnessSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lampManager.setBrightness(lamp, progress * 254);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });

        saturationSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lampManager.setSaturation(lamp, progress * 254);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });
    }

    private void initializeTextViews(View view, Product lamp) {
        nameTextView = view.findViewById(R.id.nameTextView);
        modelIDTextView = view.findViewById(R.id.modelIDTextView);
        productNameTextView = view.findViewById(R.id.productNameTextView);
        stateTextView = view.findViewById(R.id.stateTextView);
        iDTextView = view.findViewById(R.id.iDTextView);
        colorTextView = view.findViewById(R.id.colorTextView);
        brightnessTextView = view.findViewById(R.id.brightnessTextView);
        saturationTextView = view.findViewById(R.id.saturationTextView);

        String name = getString(R.string.name) + lamp.getName();
        nameTextView.setText(name);
        String modelID = getString(R.string.modelID) + lamp.getModelid();
        modelIDTextView.setText(modelID);
        String productName = getString(R.string.productName) + lamp.getProductname();
        productNameTextView.setText(productName);
        String state = getString(R.string.state) + lamp.getState();
        stateTextView.setText(state);
        String uniqueID = "Unique ID: " + lamp.getUniqueid();
        iDTextView.setText(uniqueID);
        String color = getString(R.string.color) + "?";
        colorTextView.setText(color);
        String brightness = getString(R.string.brightness) + "?";
        brightnessTextView.setText(brightness);
        String saturation = getString(R.string.saturation) + "?";
        saturationTextView.setText(saturation);
    }

    private void initializeButtons(View view, Product lamp) {
        powerButton = view.findViewById(R.id.powerButton);
        if (lamp.getState().getOn())
            powerButton.setText(getString(R.string.turn_on));
        else
            powerButton.setText(getString(R.string.turn_off));

        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lamp.getState().getOn()) {
                    lampManager.setPowerState(lamp, false);
                    powerButton.setText(getString(R.string.turn_on));
                }
                else {
                    lampManager.setPowerState(lamp, true);
                    powerButton.setText(getString(R.string.turn_off));
                }
            }
        });
    }
}
