package com.tailorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tailorapp.data.MyDbHandler;
import com.tailorapp.ui.customer.CustomerViewModel;
import com.tailorapp.ui.order.OrderViewModel;

import java.util.ArrayList;

public class Orderdetails extends AppCompatActivity {
RecyclerView recview2;
Button completebtn;
TextView moredetails;
    ArrayList<OrderViewModel> dataholder2;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        recview2=findViewById(R.id.recview2);
        context=Orderdetails.this;
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      recview2.setLayoutManager(linearLayoutManager);
        dataholder2 = new ArrayList<>();

        Cursor cursor = new MyDbHandler(Orderdetails.this).readalldata();
        while (cursor.moveToNext()) {
          OrderViewModel obj = new OrderViewModel(cursor.getString(1));
            dataholder2.add(obj);
        }
        myadapter2 adapter = new myadapter2(context,dataholder2);
        recview2.setAdapter(adapter);

        completebtn=findViewById(R.id.complete);



    }




}