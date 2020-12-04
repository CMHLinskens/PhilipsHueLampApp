package com.example.philipshuelampapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philipshuelampapp.MainActivity;
import com.example.philipshuelampapp.R;
import com.example.philipshuelampapp.model.Lamp;
import com.example.philipshuelampapp.model.Product;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    private Context context;
    private RecyclerView lampRecyclerView;
    private LampAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Lamp lamps;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lamplist_fragment, container, false);
        ArrayList<LampItem> LampItems = new ArrayList<>();
        LampItems.add(new LampItem(new Product())); // test

        lampRecyclerView = rootView.findViewById(R.id.LampRecycler);
        lampRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        adapter = new LampAdapter(LampItems);

        lampRecyclerView.setLayoutManager(layoutManager);
        lampRecyclerView.setAdapter(adapter);

        //        adapter.setOnItemClickListener(new LampAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();            }
//        });

        return rootView;
    }

    public ListFragment(Lamp lamps) {
        this.lamps = lamps;
    }
}
