package com.example.rikuwa_administrador.ui.horarios;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HorariosViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public HorariosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("HORARIO FRAGMENT");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
