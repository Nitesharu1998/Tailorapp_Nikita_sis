package com.tailorapp.ui.order;

import android.content.Context;

public class OrderViewModel {
    String name;
    String phonenumber;
    String email;
    Context context;

    public OrderViewModel(String email, String phonenumber, String name) {
        this.phonenumber = phonenumber;
        this.name=name;
        this.email = email;
    }

    public OrderViewModel(String phonenumber,String email) {
        this.phonenumber = phonenumber;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



