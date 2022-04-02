package com.tailorapp.ui.customer;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tailorapp.R;
import com.tailorapp.data.MyDbHandler;
import com.tailorapp.myadapter;

import java.util.ArrayList;

public class CustomerFragment extends Fragment {

    private CustomerViewModel customerViewModel;
    RecyclerView recview;
    ArrayList<CustomerViewModel> dataholder;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer, container, false);
        recview = view.findViewById(R.id.recview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recview.setLayoutManager(linearLayoutManager);
        dataholder = new ArrayList<>();

        Cursor cursor = new MyDbHandler(getActivity()).readalldata();
        while (cursor.moveToNext()) {
            CustomerViewModel obj = new CustomerViewModel(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            dataholder.add(obj);
        }
        myadapter adapter = new myadapter(dataholder);
        recview.setAdapter(adapter);
        return view;
    }
}
