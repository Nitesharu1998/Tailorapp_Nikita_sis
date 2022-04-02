package com.tailorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tailorapp.data.MyDbHandler;

public class Chaudidar extends AppCompatActivity {
private EditText fulllength,seatround, bottomround, kneelength,kneeround;
Button savebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chaudidar);
        MyDbHandler db = new MyDbHandler(Chaudidar.this);
        fulllength=findViewById(R.id.etxt1);
        seatround=findViewById(R.id.etxt2);
        bottomround=findViewById(R.id.etxt3);
        kneelength=findViewById(R.id.etxt4);
        kneeround=findViewById(R.id.etxt5);
        savebtn=findViewById(R.id.savebtn);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fulllength, Seatround, Bottomround, Kneelength,Kneeround;
                Fulllength = fulllength.getText().toString();
                Seatround = seatround.getText().toString();
                Bottomround = bottomround.getText().toString();
               Kneelength = kneelength.getText().toString();
               Kneeround =kneeround.getText().toString();
                boolean i = db.addchuadidarinfo(Fulllength, Seatround, Bottomround, Kneelength,Kneeround);
                if (i) {
                    Toast.makeText(Chaudidar.this, "Successful", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(Chaudidar.this, " Not Successful", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
}