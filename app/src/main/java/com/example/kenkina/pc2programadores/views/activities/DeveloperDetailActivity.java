package com.example.kenkina.pc2programadores.views.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kenkina.pc2programadores.R;
import com.example.kenkina.pc2programadores.models.Ability;
import com.example.kenkina.pc2programadores.models.Developer;
import com.example.kenkina.pc2programadores.views.adapters.AbilityViewHolder;
import com.example.kenkina.pc2programadores.views.adapters.DeveloperViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeveloperDetailActivity extends AppCompatActivity {

    Context mContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_detail);

        Intent intent = getIntent();
        if (intent == null) {
            startActivity(new Intent(mContext, DashboardActivity.class));
        }

        String uid = intent.getStringExtra("developerUid");


        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("developers").child(uid).child("abilities");
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DatabaseReference reference = dataSnapshot.getRef();
                FirebaseRecyclerAdapter<Ability, AbilityViewHolder> adapter;
                adapter = new FirebaseRecyclerAdapter<Ability, AbilityViewHolder>(
                        Ability.class, R.layout.item_level, AbilityViewHolder.class, reference) {
                    @Override
                    protected void populateViewHolder(AbilityViewHolder viewHolder, Ability dev, int position) {
                        viewHolder.nombreTextView.setText(dev.getName());
                        viewHolder.levelTextView.setText(dev.getLevel());
                    }
                };
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
