package com.tailorapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tailorapp.ui.order.OrderViewModel;

import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.myviewholder2> {
    ArrayList<OrderViewModel> dataholder2;
    Context context;

    public OrderDetailsAdapter(Context context, ArrayList<OrderViewModel> dataholder2) {

        this.context = context;
        this.dataholder2 = dataholder2;
    }

    @NonNull
    @Override
    public myviewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.singlerow2, parent, false);
        myviewholder2 viewholder = new myviewholder2(view);
        return viewholder;
    }


    @Override
    public void onBindViewHolder(@NonNull myviewholder2 holder, final int position) {
        holder.dataname.setText(dataholder2.get(position).getName());

        holder.complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("customer_name", dataholder2.get(position).getPhonenumber());
                System.out.println("name to send>>>>>>>>>>>>>>>>>>"+dataholder2.get(position).getPhonenumber());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataholder2.size();
    }

    class myviewholder2 extends RecyclerView.ViewHolder {
        TextView dataname;
        Button complete;

        public myviewholder2(@NonNull View view) {
            super(view);
            dataname = view.findViewById(R.id.diplayname);
            complete = view.findViewById(R.id.complete);
        }
    }

}
