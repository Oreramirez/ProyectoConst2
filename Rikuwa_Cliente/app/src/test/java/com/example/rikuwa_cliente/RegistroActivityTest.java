package com.example.rikuwa_cliente;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.rikuwa_cliente.Login.LoginInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegistroActivityTest extends TestCase {

    private  LoginInterface.TaskListener listener;
    FirebaseAuth mAuth;

    public void testOnCreate() {
    }

    public void testMtdDesactivarInputs() {
    }

    public void testMtdActivarInputs() {
    }

    public void testMtdMostrarProgress() {
    }

    public void testMtdOcultarProgress() {
    }

    public void testMtdHandleRegistro() {
    }

    public void testMtdValidarViews() {

    }

    public void testOnDestroy() {
    }

    public void testMtdOnError() {
    }

    @Test
    public void testMtdOnLogin(String email, String password) {

        Context appContext = testMtdOnLogin.getInstrumentation().getTargetContext();
        assertEquals("com.example.rikuwa_cliente", appContext.getPackageName());
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