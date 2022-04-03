package com.tailorapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tailorapp.data.MyDbHandler;
import com.tailorapp.ui.order.OrderViewModel;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    String str_customerPhone;
    TextView tv_customerPrice, tv_customerOderDetails, tv_customerOrderType, tv_customerEmail, tv_customername;
    LinearLayout ll_details;
    RelativeLayout rel_nodatafound;
    Button btn_doneOrder;
    Activity activity;
    Context context;
    MyDbHandler db;
    ArrayList<OrderViewModel> dataholder2 = new ArrayList<>();
    RecyclerView rclv_allOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initUI();
        checkDataFromDatabase();
    }

    private void checkDataFromDatabase() {
        db = new MyDbHandler(context);
        Cursor cursor = new MyDbHandler(context).readalldata();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                if (cursor.getString(2).equals(str_customerPhone)) {
                    Toast.makeText(activity, cursor.getString(2), Toast.LENGTH_SHORT).show();
                    OrderViewModel obj = new OrderViewModel(cursor.getString(2), cursor.getString(3));
                    dataholder2.add(obj);
                    break;
                } else {
                    Toast.makeText(activity, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initUI() {
        activity = Details.this;
        context = this;

        tv_customerPrice = findViewById(R.id.tv_customerPrice);
        tv_customerOderDetails = findViewById(R.id.tv_customerOderDetails);
        tv_customerOrderType = findViewById(R.id.tv_customerOrderType);
        tv_customerEmail = findViewById(R.id.tv_customerEmail);
        tv_customername = findViewById(R.id.tv_customername);
        ll_details = findViewById(R.id.ll_details);
        rel_nodatafound = findViewById(R.id.rel_nodatafound);
        btn_doneOrder = findViewById(R.id.btn_doneOrder);
        rclv_allOrders=findViewById(R.id.rclv_allOrders);

        str_customerPhone = getIntent().getStringExtra("customer_name");
        System.out.println("customer name>>>>>>>>>>>>>>>" + str_customerPhone);
    }
}