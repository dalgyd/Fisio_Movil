package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SolicitarServicio extends AppCompatActivity {

    //Variables para el dropdown de terapias
    String[] itemsTerapias = {"Terapia Fisica","Terapia Respiratoria","Terapia Ocupacional","Terapia de Lenguaje"};
    AutoCompleteTextView terapiaSolicitada;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_servicio);

        //inicia configuracion de la lista de terapias
        terapiaSolicitada = findViewById(R.id.terapiaSolicitada);

        adapterItems = new ArrayAdapter<String>(this,R.layout.style_lista,itemsTerapias);
        terapiaSolicitada.setAdapter(adapterItems);
        //finaliza configuracion de la lista de terapias
        
    }
}