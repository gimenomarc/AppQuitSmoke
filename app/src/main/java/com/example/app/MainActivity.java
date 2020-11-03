package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    //private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final EditText datoUsuario = findViewById(R.id.nameLogin);
        final EditText datoPassword = findViewById(R.id.passwordLogin);

        TextView botonIniciarSesion = findViewById(R.id.botonSignIn);
        botonIniciarSesion.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                functionLoginIn(v, datoUsuario, datoPassword);
            }
        });




    }

    public void changeActivityRegistrarse(View view) {
        Intent intentRegistrarse = new Intent(this, ActivityRegister.class);
        startActivity(intentRegistrarse);
    }

    public void intentTest(View view) {
        Intent intentTest = new Intent(this, ActivityRegister.class);
        startActivity(intentTest);
    }

    public void intentFacebook(View arg0){
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        startActivity(facebookIntent);
    }

    public void intentGoogle(View arg0){
        Intent googleIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com/signin/v2/identifier?hl=es&passive=true&continue=https%3A%2F%2Fwww.google.es%2F&ec=GAZAAQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin"));
        startActivity(googleIntent);
    }

    public void intentLinkedin(View arg0){
        Intent linkedinIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.linkedin.com"));
        startActivity(linkedinIntent);
    }

    public void intentTwitter (View arg0){
        Intent twitterIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("https://mobile.twitter.com/?lang=es"));
        startActivity(twitterIntent);
    }

    public void intentTerminosCondiciones (View v) {
        Intent intentTerminos = new Intent (this, terminos_condiciones.class);
        startActivity(intentTerminos);
    }

    public void functionLoginIn(View v, EditText datosUsuario, EditText datosPassword){
        Intent intentLogin = new Intent(this, insideApp.class);
        BaseDeDatos bd = new BaseDeDatos( this, "android", null, 1);
        List<Usuario> listaUsuarios = bd.getData();

        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println(listaUsuarios.get(i));
            if (datosUsuario.getText().toString().equals(listaUsuarios.get(i).getNombre()) && datosPassword.getText().toString().equals(listaUsuarios.get(i).getPassword()))
            startActivity(intentLogin);
        }
    }
}
