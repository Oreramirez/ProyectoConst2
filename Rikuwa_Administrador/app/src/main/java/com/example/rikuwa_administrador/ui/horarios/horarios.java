package com.example.rikuwa_administrador.ui.horarios;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rikuwa_administrador.R;

public class horarios extends Fragment {

    private HorariosViewModel horariosViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        horariosViewModel = ViewModelProviders.of(this).get(HorariosViewModel.class);
        View root = inflater.inflate(R.layout.horarios_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_horario);
        horariosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s);
            }
        });
        return root;
    }

}
