package com.example.rikuwa_administrador.ui.mensajes;

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
import com.example.rikuwa_administrador.ui.horarios.HorariosViewModel;

public class MensajesFragment extends Fragment {

    private MensajesViewModel mensajesViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mensajesViewModel = ViewModelProviders.of(this).get(MensajesViewModel.class);
        View root = inflater.inflate(R.layout.mensajes_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_mensaje);
        mensajesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s);
            }
        });
        return root;
    }

}
