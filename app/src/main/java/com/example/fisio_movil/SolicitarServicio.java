package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SolicitarServicio extends AppCompatActivity {

    com.google.android.material.textfield.TextInputEditText fechaServicio;
    DatePickerDialog.OnDateSetListener setListener;

    //Variables para el dropdown de terapias
    String[] itemsTerapias = {"Terapia Fisica","Terapia Respiratoria","Terapia Ocupacional","Terapia de Lenguaje"};
    AutoCompleteTextView terapiaSolicitada;
    ArrayAdapter<String> adapterItems;
    //Variables para el dropdown de la jornada
    String[] itemsJornadas = {"Mañana","Tarde","Noche"};
    AutoCompleteTextView jornadaServicio;
    ArrayAdapter<String> adapterItems2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_servicio);

        getSupportActionBar().hide();

        //inicia configuracion de la lista de terapias
        terapiaSolicitada = findViewById(R.id.terapiaSolicitada);

        adapterItems = new ArrayAdapter<String>(this,R.layout.style_lista,itemsTerapias);
        terapiaSolicitada.setAdapter(adapterItems);
        //finaliza configuracion de la lista de terapias

        //Inicia codigo del campo de fecha
        fechaServicio = findViewById(R.id.fechaServicio);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        fechaServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SolicitarServicio.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String date = year + "/" + month + "/" + day;

                        fechaServicio.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        //Finalliza el campo de fecha

        //inicia configuracion de la lista de jornada
        jornadaServicio = findViewById(R.id.jornadaServicio);

        adapterItems2 = new ArrayAdapter<String>(this,R.layout.style_lista,itemsJornadas);
        jornadaServicio.setAdapter(adapterItems2);
        //finaliza configuracion de la lista de jornada
        
    }

    //Boton para confirmar registro y llevar al menu del paciente
    public void solicitarBtn (View ss){
        Intent cambiar19 = new Intent(this, MenuPaciente.class);
        startActivity(cambiar19);
        //Toast.makeText(this,"Usuario registrado",Toast.LENGTH_SHORT).show();
    }

}