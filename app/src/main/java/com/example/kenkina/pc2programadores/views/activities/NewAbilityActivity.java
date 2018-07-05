package com.example.kenkina.pc2programadores.views.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.kenkina.pc2programadores.R;
import com.example.kenkina.pc2programadores.models.Ability;
import com.example.kenkina.pc2programadores.models.Developer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewAbilityActivity extends AppCompatActivity {

    EditText abilityEditText, levelEditText;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_ability);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        abilityEditText = findViewById(R.id.abilityEditText);
        levelEditText = findViewById(R.id.levelEditText);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid = FirebaseAuth.getInstance().getUid();

                if (uid != null && !uid.isEmpty()) {
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("developers");

                    String name = abilityEditText.getText().toString();
                    String level = levelEditText.getText().toString();

                    Ability ability = new Ability(name, level);
                    databaseReference.child(uid).child("abilities").push().setValue(ability);
                    //myRef.child("Developers").push().setValue(dev);
                    finish();
                }
            }
        });
    }
}