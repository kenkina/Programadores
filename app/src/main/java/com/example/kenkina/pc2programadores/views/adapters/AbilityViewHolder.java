package com.example.kenkina.pc2programadores.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.kenkina.pc2programadores.R;

public class AbilityViewHolder extends RecyclerView.ViewHolder {

    public TextView nombreTextView, levelTextView;

    public AbilityViewHolder(View view) {
        super(view);
        nombreTextView = view.findViewById(R.id.nombreTextView);
        levelTextView = view.findViewById(R.id.levelTextView);
    }
}