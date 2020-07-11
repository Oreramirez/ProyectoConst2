package com.example.rikuwa_cliente.Login;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginModelo implements LoginInterface.Model{

    private  LoginInterface.TaskListener listener;
    FirebaseAuth mAuth;

    public LoginModelo(LoginInterface.TaskListener listener) {
        this.listener = listener;
        mAuth= FirebaseAuth.getInstance();
    }

    @Override
    public void mtdDoLogin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    listener.mtdOnSuccess();
                }else{
                    if(task.getException()!=null)
                        listener.mtdOnError(task.getException().getMessage());
                }
            }
        });
    }
}
