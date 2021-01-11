package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

public class menuPrincipal extends AppCompatActivity implements View.OnClickListener{

    Button btnEditar, btnEliminar, btnMostrar, btnCerrarsesion;
    TextView nombre, btnSalir;
    int id = 0;
    Usuario u;
    daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        nombre = (TextView) findViewById(R.id.textTitleName);
        btnSalir = (TextView) findViewById(R.id.textLogOut);
        //  btnCerrarsesion = (Button) findViewById(R.id.btnLogut);
        //  btnEditar = (Button) findViewById(R.id.btn);
        //  btnEliminar = (Button) findViewById(R.id.btn);
        //  btnMostrar = (Button) findViewById(R.id.btn);



        //Nombre = nombreUsuario
        Bundle b = getIntent().getExtras();
        id = b.getInt("id");
        dao = new daoUsuario(this);
        u = dao.getUsuarioById(id);

        nombre.setText(u.getNombre());
        btnSalir.setOnClickListener(this);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.textTitleName:
                //Intent intentTest = new Intent (this, SlashScreen.class);
                //startActivity(intentTest);
                break;

            case R.id.textLogOut:
                Intent iLogOut = new Intent (this, MainActivity.class);
                startActivity(iLogOut);
                break;
        }
    }
}

