package com.tailorapp.ui.receipt;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReceiptViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ReceiptViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is receipt fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}