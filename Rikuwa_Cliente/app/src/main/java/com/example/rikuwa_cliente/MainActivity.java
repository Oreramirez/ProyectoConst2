package com.example.rikuwa_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;

    //Hooks
    View primero,segundo,tercero,cuarto,quinto,sexto;
    TextView titulo;
    ImageView imagen;
    //Animations
    Animation topAnimantion,bottomAnimation,middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animation Calls
        topAnimantion = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

        //Hooks
        primero = findViewById(R.id.linea1);
        segundo = findViewById(R.id.linea2);
        tercero = findViewById(R.id.linea3);
        cuarto = findViewById(R.id.linea4);
        quinto = findViewById(R.id.linea5);
        sexto = findViewById(R.id.linea6);
        imagen = findViewById(R.id.logo);
        titulo = findViewById(R.id.titulo);

        //Setting Animations to the elements of Splash
        primero.setAnimation(topAnimantion);
        segundo.setAnimation(topAnimantion);
        tercero.setAnimation(topAnimantion);
        cuarto.setAnimation(topAnimantion);
        quinto.setAnimation(topAnimantion);
        sexto.setAnimation(topAnimantion);
        imagen.setAnimation(middleAnimation);
        titulo.setAnimation(bottomAnimation);

//Splash Screen Code to call new Activity after some time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
