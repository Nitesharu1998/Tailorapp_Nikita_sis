package com.tailorapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tailorapp.ui.order.OrderViewModel;

import java.util.ArrayList;

public class myadapter2 extends RecyclerView.Adapter<myadapter2.myviewholder2> {
    ArrayList<OrderViewModel> dataholder2;
    Context context;

    public myadapter2(Context context,ArrayList<OrderViewModel> dataholder2) {

        this.context=context;
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
    public void onBindViewHolder(@NonNull myviewholder2 holder, int position) {
        holder.dataname.setText(dataholder2.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataholder2.size();
    }

    class myviewholder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView dataname;

        public myviewholder2(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            dataname = (TextView) itemView.findViewById(R.id.diplayname);


        }

        @Override
        public void onClick(View v) {
//            int position =this.getAdapterPosition();
//          OrderViewModel details = dataholder2.get(position);
//          String dataname = details.getName();

          Intent intent =new Intent(context,Details.class);
//          intent.putExtra("name",dataname);
         context.startActivity(intent);

        }
    }

}
