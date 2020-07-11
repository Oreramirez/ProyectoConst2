package com.example.rikuwa_cliente.Registro;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegistroModelo implements RegistroInterface.Model{

    private  RegistroInterface.TaskListener listener;
    FirebaseAuth mAuth;

    public RegistroModelo(RegistroInterface.TaskListener listener) {
        this.listener = listener;
        mAuth= FirebaseAuth.getInstance();
    }

    @Override
    public void mtdOnRegistro(final String nombre, String apellido, String zona, String direccion, String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                            .setDisplayName(nombre)
                            .build();
                    FirebaseUser user = mAuth.getCurrentUser();
                    if(user!=null)
                    user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                listener.mtdOnSuccess();
                            }else if (task.getException() !=null){
                                listener.mtdOnError(task.getException().getMessage());
                            }
                        }
                    });
                }else if(task.getException()!=null)
                        listener.mtdOnError(task.getException().getMessage());
                }
        });
    }
}
