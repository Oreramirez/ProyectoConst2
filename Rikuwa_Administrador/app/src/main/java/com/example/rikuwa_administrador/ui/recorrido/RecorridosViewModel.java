package com.example.rikuwa_administrador.ui.recorrido;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecorridosViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public RecorridosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("RECORRIDO FRAGMENTT!!!");
    }

    public LiveData<String> getText() {
        return mText;
    }


}
