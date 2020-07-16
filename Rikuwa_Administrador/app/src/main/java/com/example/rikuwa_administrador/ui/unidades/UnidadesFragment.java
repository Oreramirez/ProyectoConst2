package com.example.rikuwa_administrador.ui.unidades;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.rikuwa_administrador.R;
import com.example.rikuwa_administrador.ui.home.HomeViewModel;

public class UnidadesFragment extends Fragment {

    private UnidadesViewModel unidadesViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        unidadesViewModel = ViewModelProviders.of(this).get(UnidadesViewModel.class);
        View root = inflater.inflate(R.layout.unidades_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_unidades);
        unidadesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}
