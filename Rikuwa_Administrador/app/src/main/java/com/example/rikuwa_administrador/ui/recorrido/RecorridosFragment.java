package com.example.rikuwa_administrador.ui.recorrido;

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

public class RecorridosFragment extends Fragment {

    private RecorridosViewModel recorridosViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recorridosViewModel = ViewModelProviders.of(this).get(RecorridosViewModel.class);
        View root = inflater.inflate(R.layout.recorridos_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_recorridos);
        recorridosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) { textView.setText(s);
            }
        });
        return root;
    }

}
