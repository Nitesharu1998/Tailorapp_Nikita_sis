package com.tailorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tailorapp.data.MyDbHandler;

public class Blause extends AppCompatActivity {
    private EditText fulllength, chestround, waistlength, sleeveslength, sleevesround, frontneck, backneck, shoulder, readyshoulder, armhole, tuckspoint;
    Button save;
    String custPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blause);
        MyDbHandler db = new MyDbHandler(Blause.this);
        fulllength = findViewById(R.id.txte1);
        chestround = findViewById(R.id.txte2);
        waistlength = findViewById(R.id.txte3);
        sleeveslength = findViewById(R.id.txte4);
        sleevesround = findViewById(R.id.txte5);
        frontneck = findViewById(R.id.txte6);
        backneck = findViewById(R.id.txte7);
        shoulder = findViewById(R.id.txte8);
        readyshoulder = findViewById(R.id.txte9);
        armhole = findViewById(R.id.txte10);
        tuckspoint = findViewById(R.id.txte11);
        save = findViewById(R.id.savebtn);

        if (getIntent().getData() != null) {
            custPhoneNumber = getIntent().getStringExtra("PhoneNumber");
        } else {
            Toast.makeText(this, "No user selected", Toast.LENGTH_SHORT).show();
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fulllength, Chestround, Waistlength, Sleeveslength, Sleevesround, Frontneck, Backneck, Shoulder, Readyshoulder, Armhole, Tuckspoint;
                Fulllength = fulllength.getText().toString();
                Chestround = chestround.getText().toString();
                Waistlength = waistlength.getText().toString();
                Sleeveslength = sleeveslength.getText().toString();
                Sleevesround = sleevesround.getText().toString();
                Frontneck = frontneck.getText().toString();
                Backneck = backneck.getText().toString();
                Shoulder = shoulder.getText().toString();
                Readyshoulder = readyshoulder.getText().toString();
                Armhole = armhole.getText().toString();
                Tuckspoint = tuckspoint.getText().toString();
                boolean i = db.addblauseinfo(custPhoneNumber, Fulllength, Chestround, Waistlength, Sleeveslength, Sleevesround, Frontneck, Backneck, Shoulder, Readyshoulder, Armhole, Tuckspoint);
                if (i) {
                    Toast.makeText(Blause.this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Blause.this, " Not Successful", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}