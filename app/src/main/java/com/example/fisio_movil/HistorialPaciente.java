package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HistorialPaciente extends AppCompatActivity {
    List<ListaServicios> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_paciente);

        getSupportActionBar().hide();

        init();

    }

    public void init(){
        elements = new ArrayList<ListaServicios>();
        elements.add(new ListaServicios("Terapia Fisica", "Profesional 2", "2021/12/10", "Programado"));
        elements.add(new ListaServicios("Terapia Respiratoria", "Profesional 3", "2021/11/30", "Ejecutado"));
        elements.add(new ListaServicios("Terapia Ocupacional", "Profesional 4", "2021/11/15", "Cancelado"));
        elements.add(new ListaServicios("Terapia de Lenguaje", "Profesional 5", "2021/11/08", "Ejecutado"));



        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listadoServicios);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(listAdapter);
    }

}