package com.example.fisio_movil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Cancelarcuenta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelarcuenta);

        getSupportActionBar().hide();

    }

    public void regreso (View r){
        Intent cambiar2 = new Intent(this, DatosTerapeuta.class);
        startActivity(cambiar2);
        Intent cambiar3 = new Intent(this, DatosPaciente.class);
        startActivity(cambiar3);
    }

    //Cambia la pantalla a el tipo de registro
    public void cancelacion (View c){
        Intent cambiar4 = new Intent(this, MainActivity.class);
        startActivity(cambiar4);
    }




}
