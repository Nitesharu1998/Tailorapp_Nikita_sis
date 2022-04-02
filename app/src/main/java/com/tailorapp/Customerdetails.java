package com.tailorapp;


import static com.google.android.material.internal.ContextUtils.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentTransaction;

import com.tailorapp.data.MyDbHandler;
import com.tailorapp.ui.order.OrderFragment;


public class Customerdetails extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    EditText phoneNumber;
    EditText email;
    Button order;
    MyDbHandler g;

    MyDbHandler db = new MyDbHandler(Customerdetails.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerdetails);


        name = findViewById(R.id.Cusname);
        phoneNumber = findViewById(R.id.Cusphn);
        email = findViewById(R.id.Cusemail);
        order = findViewById(R.id.button2);

        order.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String Name, PhoneNumber, Email;
        Name = name.getText().toString();
        PhoneNumber = phoneNumber.getText().toString();
        Email = email.getText().toString();

        if (Name.equals("") || PhoneNumber.equals("") || Email.equals("")) {
            Toast.makeText(Customerdetails.this, "Enter all data", Toast.LENGTH_SHORT).show();
        } else {
            boolean i = db.addCustomer(Name, PhoneNumber, Email);
            if (i) {
                Toast.makeText(Customerdetails.this, "Successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Customerdetails.this, " Not Successful", Toast.LENGTH_SHORT).show();
            }
            name.setText("");
            phoneNumber.setText("");
            email.setText("");

        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.sid1, new OrderFragment());
        order.setVisibility(View.GONE);
        fragmentTransaction.commit();
    }

}

