package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity implements View.OnClickListener{
    EditText us, pass, nom, email;
    TextView reg;
    daoUsuario dao;
    Button can;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nom = (EditText) findViewById(R.id.usernameID);
        us = (EditText) findViewById(R.id.nameID);
        pass = (EditText) findViewById(R.id.passwordID);
        email = (EditText) findViewById(R.id.emailID);
        reg = (TextView) findViewById(R.id.textRegistrarse);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao = new daoUsuario(this);
    }


    public void functionUserRegistrado (View v){
        Intent intentUserRegister = new Intent (this, menuPrincipal.class);
        startActivity(intentUserRegister);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ){
            case R.id.textRegistrarse:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pass.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setEmail(email.getText().toString());
                if(!u.isNull()) {
                    Toast.makeText(this, "ERROR: Campos vacios.", Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)) {
                    Toast.makeText(this, "Registrado.", Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent (this, MainActivity.class);
                    startActivity(i2);
                    finish();
                } else {
                    Toast.makeText(this, "Usuario ya registrado.", Toast.LENGTH_LONG).show();
                }
                Intent iLog = new Intent (this, menuPrincipal.class);
                break;
        }
    }
}