package com.example.philipshuelampapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.philipshuelampapp.R;

import java.util.ArrayList;

public class LampAdapter extends RecyclerView.Adapter<LampAdapter.LampViewHolder> {
    private final ArrayList<LampItem> lampItems;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    public static class LampViewHolder extends RecyclerView.ViewHolder {
        public TextView itemNameTextView;
        public LampViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.LampName);
            itemView.setOnClickListener(v -> {
                if(onItemClickListener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                        onItemClickListener.onItemClick(position);
                }
            });
        }
    }

    public LampAdapter(ArrayList<LampItem> lampItems) {
        this.lampItems = lampItems;
    }

    @NonNull
    @Override
    public LampViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lamp_item, parent, false);
        return new LampViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LampViewHolder holder, int position) {
        LampItem currentLampItem = lampItems.get(position);
        holder.itemNameTextView.setText(currentLampItem.getLamp().getName());
    }

    @Override
    public int getItemCount() {
        return lampItems.size();
    }

}
