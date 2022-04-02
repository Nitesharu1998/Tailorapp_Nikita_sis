package com.tailorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       username= findViewById(R.id.et1);
       password= findViewById(R.id.et2);
       login= findViewById(R.id.button);


        login.setOnClickListener(v -> {
            if(username.getText().toString().equals("deepa") && password.getText().toString().equals("deepa123")) {
                //correct
                Toast.makeText(MainActivity.this,"LOGIN SUCCESFULL",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,nav_activity.class);
                startActivity(intent);
            }else
                //incorrect
                Toast.makeText(MainActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();

        });





}}