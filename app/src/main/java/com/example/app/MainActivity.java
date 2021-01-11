package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton floatingActionButton;
    EditText user, pass;
    TextView btnEntrar, btnRegistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.textUsername);
        pass = (EditText) findViewById(R.id.textPassword);
        btnEntrar = (TextView) findViewById(R.id.btnIniciarSesion);
        btnRegistrar = (TextView) findViewById(R.id.btnRegistrarse);
        dao = new daoUsuario(this);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciarSesion:
                String u = user.getText().toString();
                String p = pass.getText().toString();
                if (u.equals("")&&p.equals("")) {
                    Toast.makeText(this, "ERROR: campos vacios", Toast.LENGTH_LONG).show();
                }else if (dao.login(u,p)==1){
                    Usuario ux = dao.getUsuario(u,p);
                    Toast.makeText(this, "Iniciando Sesion...", Toast.LENGTH_LONG).show();
                Intent i2 = new Intent (this, menuPrincipal.class);
                i2.putExtra("id", ux.getId());
                startActivity(i2);
                finish();
            }
                break;
            case R.id.btnRegistrarse:
                Intent i = new Intent (this, ActivityRegister.class);
                startActivity(i);
                break;
        }
    }
}