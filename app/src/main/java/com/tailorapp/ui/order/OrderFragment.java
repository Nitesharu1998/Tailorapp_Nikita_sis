package com.tailorapp.ui.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tailorapp.Blause;
import com.tailorapp.Chaudidar;
import com.tailorapp.R;
import com.tailorapp.Salwar;
import com.tailorapp.Top;


public class OrderFragment extends Fragment {
    Button topbtn;
    Button salwarbtn;
    Button chuadidarbtn;
    Button blausebtn;
    String phoneNumber;
    Context context;

    public OrderFragment(String phoneNumer) {
        this.phoneNumber=phoneNumer;
    }

    public OrderFragment(Context context) {
        this.context=context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        topbtn = view.findViewById(R.id.topbtn);
        salwarbtn = view.findViewById(R.id.salwarbtn);
        chuadidarbtn = view.findViewById(R.id.chaudidarbtn);
        blausebtn = view.findViewById(R.id.blausebtn);
        initListeners(view);
        return view;
    }

    private void initListeners(View view) {

        topbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Top.class);
                intent.putExtra("PhoneNumber",phoneNumber);
                startActivity(intent);

            }
        });

        salwarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Salwar.class);
                intent.putExtra("PhoneNumber",phoneNumber);
                startActivity(intent);
            }
        });

        chuadidarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chaudidar.class);
                intent.putExtra("PhoneNumber",phoneNumber);
                startActivity(intent);
            }
        });

        blausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(),Blause.class);
                intent.putExtra("PhoneNumber",phoneNumber);
                startActivity(intent);
            }
        });
    }


}