package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class DatosTerapeuta extends AppCompatActivity {

    //Variables para el dropdown de tipoId
    String[] itemsTipoId = {"CC","CE","TI","RC","PEP","PAS"};
    AutoCompleteTextView tipoDocP;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_terapeuta);

        getSupportActionBar().hide();//Oculta barra superior

        //inicia configuracion de la lista de tipo id
        tipoDocP = findViewById(R.id.tipoDocP);

        adapterItems = new ArrayAdapter<String>(this,R.layout.style_lista,itemsTipoId);
        tipoDocP.setAdapter(adapterItems);
        //finaliza configuracion de la lista de tipo id

    }

    //Boton para confirmar registro y llevar al menu del paciente
    public void siguiente (View brp){
        Intent cambiar16 = new Intent(this, Cancelarcuenta.class);
        startActivity(cambiar16);
        Toast.makeText(this,"Usuario registrado",Toast.LENGTH_SHORT).show();
    }

}