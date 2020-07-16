package com.example.rikuwa_administrador.ui.unidades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UnidadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UnidadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("unidades fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }}
