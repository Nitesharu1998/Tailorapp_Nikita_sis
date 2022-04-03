package com.tailorapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.tailorapp.Customerdetails;
import com.tailorapp.Orderdetails;
import com.tailorapp.R;
import com.tailorapp.ui.order.OrderFragment;

public class HomeFragment extends Fragment {

    Button AddCustomerBtn;
    Button AddOrderBtn;
    Button Vieworderdetailsbtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        AddCustomerBtn= view.findViewById(R.id.addCustomer);
        /*AddOrderBtn= view.findViewById(R.id.addOrder);*/
        Vieworderdetailsbtn=view.findViewById(R.id.viewdetails);

        AddCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeFragment.this.getActivity(),Customerdetails.class));
            }
        });
       /* AddOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new OrderFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.sid2, newFragment);
                transaction.addToBackStack(null);
                AddCustomerBtn.setVisibility(View.GONE);
                AddOrderBtn.setVisibility(View.GONE);
               Vieworderdetailsbtn.setVisibility(View.GONE);
                // Commit the transaction
                transaction.commit();
            }
        });*/
        Vieworderdetailsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeFragment.this.getActivity(), Orderdetails.class));

            }
        });

        return view;
    }
}