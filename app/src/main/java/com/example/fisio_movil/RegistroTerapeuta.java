package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class RegistroTerapeuta extends AppCompatActivity {

    //Variables para el dropdown de tipoId
    String[] itemsTipoId = {"CC","CE","TI","RC","PEP","PAS"};
    AutoCompleteTextView tipoDocT;
    ArrayAdapter<String> adapterItems;

    //Variables para el dropdown de terapias
    String[] itemsProfesion = {"Terapia Fisica","Terapia Respiratoria","Terapia Ocupacional","Terapia de Lenguaje"};
    AutoCompleteTextView profesionTerapeuta;
    ArrayAdapter<String> adapterItems2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_terapeuta);

        getSupportActionBar().hide();//Oculta barra superior

        //inicia configuracion de la lista de tipo id
        tipoDocT = findViewById(R.id.tipoDocT);

        adapterItems = new ArrayAdapter<String>(this,R.layout.style_lista,itemsTipoId);
        tipoDocT.setAdapter(adapterItems);
        //finaliza configuracion de la lista de tipo id

        //inicia configuracion de la lista de terapias
        profesionTerapeuta = findViewById(R.id.profesionTerapeuta);

        adapterItems2 = new ArrayAdapter<String>(this,R.layout.style_lista,itemsProfesion);
        profesionTerapeuta.setAdapter(adapterItems2);
        //finaliza configuracion de la lista de terapias

    }

    //Cambia la pantalla a ver el tratamiento de datos
    public void tratamientoDatosPersonalesT (View tdp){
        Intent cambiar17 = new Intent(this, TratatiendoDatos.class);
        startActivity(cambiar17);
    }

    //Boton para confirmar registro y llevar al menu del paciente
    public void registroBtnT (View brp){
        Intent cambiar18 = new Intent(this, MenuTerapeuta.class);
        startActivity(cambiar18);
        Toast.makeText(this,"Usuario registrado",Toast.LENGTH_SHORT).show();
    }

}