package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    EditText nombreUsuario;
    EditText password;
    EditText email;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.nameRegister);
        apellido = findViewById(R.id.surnameRegister);
        nombreUsuario = findViewById(R.id.usernameRegister);
        password = findViewById(R.id.passwordRegister);
        email = findViewById(R.id.emailRegister);
        
        register = findViewById(R.id.buttonUserRegistrado);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        BaseDeDatos bd = new BaseDeDatos(this, "android", null, 1);
        bd.insertData(nombre.getText().toString(),apellido.getText().toString(),nombreUsuario.getText().toString(),password.getText().toString(),email.getText().toString());
        bd.getData();
    }


    public void functionUserRegistrado (View v){
        Intent intentUserRegister = new Intent (this, chooseLiarIndustrial.class);
        startActivity(intentUserRegister);
    }
}