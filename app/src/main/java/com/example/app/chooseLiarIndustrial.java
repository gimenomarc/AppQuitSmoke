package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chooseLiarIndustrial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_liar_industrial);
    }

    public void intentLogWithLiar (View v){
        Intent intentLogeadoWithLiar = new Intent (this, insideApp.class);
        startActivity(intentLogeadoWithLiar);
    }

    public void intentLogWithIndu (View v){
        Intent intentLogeadoWithIndu = new Intent (this, insideApp.class);
        startActivity(intentLogeadoWithIndu);
    }

}