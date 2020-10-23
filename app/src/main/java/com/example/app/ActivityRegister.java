package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void functionUserRegistrado (View v){
        Intent intentUserRegister = new Intent (this, chooseLiarIndustrial.class);
        startActivity(intentUserRegister);
    }

}