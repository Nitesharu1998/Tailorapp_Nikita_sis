package com.tailorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tailorapp.data.MyDbHandler;

public class Salwar extends AppCompatActivity {
private EditText fulllength,seatround,bottom,beltlength;
Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salwar);
        MyDbHandler db = new MyDbHandler(Salwar.this);
        fulllength = findViewById(R.id.txted1);
        seatround = findViewById(R.id.txted2);
        bottom = findViewById(R.id.txted3);
        beltlength = findViewById(R.id.txted4);
        save = findViewById(R.id.savebtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fullength, Seatround, Bottom, Beltlength;
                Fullength = fulllength.getText().toString();
                Seatround = seatround.getText().toString();
                Bottom = bottom.getText().toString();
                Beltlength = beltlength.getText().toString();
                boolean i = db.addsalwarinfo(Fullength, Seatround, Bottom, Beltlength);
                if (i) {
                    Toast.makeText(Salwar.this, "Successful", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(Salwar.this, " Not Successful", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }}