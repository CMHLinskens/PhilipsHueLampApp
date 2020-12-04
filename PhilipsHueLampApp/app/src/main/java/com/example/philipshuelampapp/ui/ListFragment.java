package com.example.philipshuelampapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philipshuelampapp.ILampManager;
import com.example.philipshuelampapp.MainActivity;
import com.example.philipshuelampapp.R;
import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.model.Product;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private RecyclerView lampRecyclerView;
    private ILampManager lampManager;
    private LampAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LampItem> lamps;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lamplist_fragment, container, false);
//        LampItems.add(new LampItem(new Product())); // test

        lampRecyclerView = rootView.findViewById(R.id.LampRecycler);
        lampRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        adapter = new LampAdapter(lamps);

        lampRecyclerView.setLayoutManager(layoutManager);
        lampRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new LampAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ((FragmentActivity) rootView.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LampFragment()).commit();
            }
        });
        return rootView;
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

    public LampAdapter getAdapter() { return this.adapter; }
}
