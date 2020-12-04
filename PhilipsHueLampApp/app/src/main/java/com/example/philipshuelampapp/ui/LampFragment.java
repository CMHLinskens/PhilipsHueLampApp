package com.example.philipshuelampapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.philipshuelampapp.R;
import com.example.philipshuelampapp.model.Product;

public class LampFragment extends Fragment {
    private Product lamp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lamp_fragment, container);

        return view;
    }
}
