package com.tailorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tailorapp.data.MyDbHandler;

public class Top extends AppCompatActivity {
    Button save;
    private EditText fulllength, chestround, waistlength, waistround, seatlength, seatround, shoulder, readyshoulder, sleeveslength, sleevesround, frontneck, backneck, armhole, topbottom;
    String custPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        MyDbHandler db = new MyDbHandler(Top.this);
        fulllength = findViewById(R.id.edtxt1);
        chestround = findViewById(R.id.edtxt2);
        waistlength = findViewById(R.id.edtxt3);
        waistround = findViewById(R.id.edtxt4);
        seatlength = findViewById(R.id.edtxt5);
        seatround = findViewById(R.id.edtxt6);
        shoulder = findViewById(R.id.edtxt7);
        readyshoulder = findViewById(R.id.edtxt8);
        sleeveslength = findViewById(R.id.edtxt9);
        sleevesround = findViewById(R.id.edtxt10);
        frontneck = findViewById(R.id.edtxt11);
        backneck = findViewById(R.id.edtxt12);
        armhole = findViewById(R.id.edtxt13);
        topbottom = findViewById(R.id.edtxt14);
        save = findViewById(R.id.save);

        if (getIntent().getData()!=null){
            custPhoneNumber=getIntent().getStringExtra("PhoneNumber");
        }
        else {
            Toast.makeText(this, "No user selected", Toast.LENGTH_SHORT).show();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Fulllength, Chestround, Waistlength, Waistround, Seatlength, Seatround, Shoulder, Readyshoulder, Sleeveslength, Sleevesround, Frontneck, Backneck, Armhole, Topbottom;

                Fulllength = fulllength.getText().toString();
                Chestround = chestround.getText().toString();
                Waistlength = waistlength.getText().toString();
                Waistround = waistround.getText().toString();
                Seatlength = seatlength.getText().toString();
                Seatround = seatround.getText().toString();
                Shoulder = shoulder.getText().toString();
                Readyshoulder = readyshoulder.getText().toString();
                Sleeveslength = sleeveslength.getText().toString();
                Sleevesround = sleevesround.getText().toString();
                Frontneck = frontneck.getText().toString();
                Backneck = backneck.getText().toString();
                Armhole = armhole.getText().toString();
                Topbottom = topbottom.getText().toString();

                boolean i = db.addtopinfo(custPhoneNumber,Fulllength, Chestround, Waistlength, Waistround, Seatlength, Seatround, Shoulder, Readyshoulder, Sleeveslength, Sleevesround, Frontneck, Backneck, Armhole, Topbottom);
                if (i) {
                    Toast.makeText(Top.this, "Successful", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Top.this, " Not Successful", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}