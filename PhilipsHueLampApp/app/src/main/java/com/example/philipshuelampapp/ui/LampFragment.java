package com.example.philipshuelampapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lamp_fragment, container, false);
        if (savedInstanceState != null)
        lamp = lamps.get((int)savedInstanceState.get("position")).getLamp();

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
}
