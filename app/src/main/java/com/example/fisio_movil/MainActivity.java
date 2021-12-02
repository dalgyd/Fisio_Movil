package com.example.fisio_movil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();//Oculta barra superior

    }

    //Cambia la pantalla a el ingreso como paciente
    public void ingresoPaciente (View p){
        Intent cambiar = new Intent(this, IngresoPaciente.class);
        startActivity(cambiar);
    }

    //Cambia la pantalla a el ingreso como terapueta
    public void ingresoTerapeuta (View t){
        Intent cambiar2 = new Intent(this, IngresoTerapeuta.class);
        startActivity(cambiar2);
    }

    //Cambia la pantalla a el tipo de registro
    public void registrarse (View r){
        Intent cambiar3 = new Intent(this, TipoRegistro.class);
        startActivity(cambiar3);
    }


}