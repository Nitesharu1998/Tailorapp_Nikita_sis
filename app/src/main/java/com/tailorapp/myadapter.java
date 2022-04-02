package com.tailorapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tailorapp.ui.customer.CustomerViewModel;
import com.tailorapp.ui.order.OrderViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{

    ArrayList<CustomerViewModel> dataholder;


    public myadapter(ArrayList<CustomerViewModel> dataholder)
    { this.dataholder = dataholder; }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.singlerow,parent,false);
        myviewholder viewholder= new myviewholder(view);
        return  viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dphoneNumber.setText(dataholder.get(position).getPhonenumber());
        holder.demail.setText(dataholder.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView dname,dphoneNumber,demail;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            dname=(TextView) itemView.findViewById(R.id.diplayname);
            dphoneNumber=(TextView) itemView.findViewById(R.id.diplayphoneNumber);
            demail=(TextView) itemView.findViewById(R.id.diplayemail);

        }
    }



}



