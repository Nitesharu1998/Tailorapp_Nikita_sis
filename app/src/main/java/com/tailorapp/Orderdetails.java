package com.tailorapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tailorapp.data.MyDbHandler;
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
        initUI();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recview2.setLayoutManager(linearLayoutManager);
        dataholder2 = new ArrayList<>();

        Cursor cursor = new MyDbHandler(Orderdetails.this).readalldata();
        if (cursor != null){
            while (cursor.moveToNext()) {
                OrderViewModel obj = new OrderViewModel(cursor.getString(3), cursor.getString(2), cursor.getString(1));
                dataholder2.add(obj);
            }
            if  (dataholder2.size()!=0){
                OrderDetailsAdapter adapter = new OrderDetailsAdapter(context, dataholder2);
                recview2.setAdapter(adapter);
            }
        }
    }

    private void initUI() {
        recview2 = findViewById(R.id.recview2);
        completebtn = findViewById(R.id.complete);
        context = Orderdetails.this;
    }
}