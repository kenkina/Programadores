package com.example.kenkina.pc2programadores.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kenkina.pc2programadores.R;

public class DeveloperViewHolder extends RecyclerView.ViewHolder {

    public TextView nombreTextView, bioTextView;
    public Button developButton;

    public DeveloperViewHolder(View view) {
        super(view);
        this.nombreTextView = view.findViewById(R.id.nombreTextView);
        this.bioTextView = view.findViewById(R.id.bioTextView);
        this.developButton = view.findViewById(R.id.developButton);
    }
}