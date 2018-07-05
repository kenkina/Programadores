package com.example.kenkina.pc2programadores.views.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kenkina.pc2programadores.R;
import com.example.kenkina.pc2programadores.models.Ability;
import com.example.kenkina.pc2programadores.models.Developer;
import com.example.kenkina.pc2programadores.views.adapters.DeveloperViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends AppCompatActivity {

    Context mContext = this;

    FirebaseRecyclerAdapter<Developer, DeveloperViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, NewAbilityActivity.class));
            }
        });

        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("developers");
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //String uid = FirebaseAuth.getInstance().getUid();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DatabaseReference reference = dataSnapshot.getRef();

                adapter = new FirebaseRecyclerAdapter<Developer, DeveloperViewHolder>(
                        Developer.class, R.layout.item_developer, DeveloperViewHolder.class, reference) {
                    @Override
                    protected void populateViewHolder(DeveloperViewHolder viewHolder, Developer dev, final int position) {
                        viewHolder.nombreTextView.setText(dev.getEmail());
                        viewHolder.bioTextView.setText(dev.getBio());
                        viewHolder.developButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(mContext, DeveloperDetailActivity.class);
                                intent.putExtra("developerUid", adapter.getItem(position).getUid());
                                startActivity(intent);
                            }
                        });
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
