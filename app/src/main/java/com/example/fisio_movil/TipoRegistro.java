package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TipoRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_registro);

        getSupportActionBar().hide();//Oculta barra superior

    }

    //Cambia la pantalla a el registro como paciente
    public void registroPaciente (View rp){
        Intent cambiar4 = new Intent(this, RegistroPaciente.class);
        startActivity(cambiar4);
    }

    //Cambia la pantalla a el registro como terapueta
    public void registroTerapeuta (View rt) {
        Intent cambiar5 = new Intent(this, RegistroTerapeuta.class);
        startActivity(cambiar5);
    }
}