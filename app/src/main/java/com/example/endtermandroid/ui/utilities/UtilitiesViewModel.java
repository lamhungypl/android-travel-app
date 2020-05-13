package com.example.endtermandroid.ui.utilities.timezone;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class UtilitiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UtilitiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is utilities fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
