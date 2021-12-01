package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class SolicitarServicio extends AppCompatActivity {

    //variables para la fecha
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

    //variables para el cuadro de dialogo
    private Dialog dialog;
    private Button ShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_servicio);

        //Dialog
        ShowDialog = findViewById(R.id.solicitarServicioBtn);

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

        //Inicia la cofiguracion del boton y el cuadro de dialogo
        Button solicitarServicioBtn = (Button) findViewById(R.id.solicitarServicioBtn);
        Dialog dialog;

        dialog = new Dialog(SolicitarServicio.this); //Indicamos donde se mostrara el dialogo
        dialog.setContentView(R.layout.custom_dialog); //Conexion al archivo custom dialog
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background2));
        }

        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background2)); // Asiganamos el Fondo del Dialog (Background)
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        //Declaramos los botones
        Button Okey = dialog.findViewById(R.id.btn_okay);
        Button Cancel = dialog.findViewById(R.id.btn_cancel);

        Okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SolicitarServicio.this,"Servicio solicitado", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SolicitarServicio.this,"Servicio cancelado", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        ShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        
    }

    //Boton para confirmar registro y llevar al menu del paciente
    public void regresarMenuP (View ss){
        Intent cambiar19 = new Intent(this, MenuPaciente.class);
        startActivity(cambiar19);
        //Toast.makeText(this,"Usuario registrado",Toast.LENGTH_SHORT).show();
    }

}