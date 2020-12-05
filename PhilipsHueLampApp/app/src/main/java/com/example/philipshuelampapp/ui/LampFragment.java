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
        colorSlider.setProgress((int) ((lamp.getState().getHue() * 100) / 65534.0));
        brightnessSlider = view.findViewById(R.id.brightnessSlider);
        brightnessSlider.setProgress((int) ((lamp.getState().getBri() * 100) / 254.0));
        saturationSlider = view.findViewById(R.id.saturationSlider);
        saturationSlider.setProgress((int) ((lamp.getState().getSat() * 100) / 254.0));

        colorSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int newHueValue = (int)((progress/100.0) * 65534);
                colorTextView.setText(getString(R.string.color) + " " + newHueValue);
                lampManager.setHue(lamp, newHueValue);
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
                int newBrightnessValue = (int)((progress/100.0) * 254);
                brightnessTextView.setText(getString(R.string.brightness) + " " + newBrightnessValue);
                lampManager.setBrightness(lamp, newBrightnessValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {            }
        });

        saturationSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int newSaturationValue = (int)((progress/100.0) * 254);
                saturationTextView.setText(getString(R.string.saturation) + " " + newSaturationValue);
                lampManager.setSaturation(lamp, newSaturationValue);
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
//        productNameTextView = view.findViewById(R.id.productNameTextView);
        iDTextView = view.findViewById(R.id.iDTextView);
        colorTextView = view.findViewById(R.id.colorTextView);
        brightnessTextView = view.findViewById(R.id.brightnessTextView);
        saturationTextView = view.findViewById(R.id.saturationTextView);

        String name = lamp.getName();
        nameTextView.setText(name);
        String modelID = getString(R.string.modelID) + " " + lamp.getModelid();
        modelIDTextView.setText(modelID);
//        String productName = getString(R.string.productName) + lamp.getProductname();
//        productNameTextView.setText(productName);
        String uniqueID = getString(R.string.ID) + " " + lamp.getUniqueid();
        iDTextView.setText(uniqueID);
        String color = getString(R.string.color) + " " + lamp.getState().getHue();
        colorTextView.setText(color);
        String brightness = getString(R.string.brightness) + " " + lamp.getState().getBri();
        brightnessTextView.setText(brightness);
        String saturation = getString(R.string.saturation) + " " + lamp.getState().getSat();
        saturationTextView.setText(saturation);
    }

    private void initializeButtons(View view, Product lamp) {
        powerButton = view.findViewById(R.id.powerButton);
        if (lamp.getState().getOn())
            powerButton.setText(getString(R.string.turn_off));
        else
            powerButton.setText(getString(R.string.turn_on));

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

                    // Set the lamp to the latest values
                    lampManager.setHue(lamp, lamp.getState().getHue());
                    lampManager.setBrightness(lamp, lamp.getState().getBri());
                    lampManager.setSaturation(lamp, lamp.getState().getSat());
                }
            }
        });
    }
}
