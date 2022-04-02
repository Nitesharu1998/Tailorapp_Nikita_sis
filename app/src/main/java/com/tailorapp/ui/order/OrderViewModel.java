package com.tailorapp.ui.order;

public class OrderViewModel {
    String name;
    String phonenumber;
    String email;

    public OrderViewModel(String name) {
        this.name = name;
    }

    public OrderViewModel(String phonenumber,String email) {
        this.phonenumber = phonenumber;
        this.email = email;

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



