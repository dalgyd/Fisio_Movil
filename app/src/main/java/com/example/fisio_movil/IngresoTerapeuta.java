package com.example.fisio_movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class IngresoTerapeuta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_terapeuta);

        getSupportActionBar().hide();

        TextView usernameTerapeuta = (TextView) findViewById(R.id.usernameTerapeuta);
        TextView passwordTerapeuta = (TextView) findViewById(R.id.passwordTerapeuta);

        Button loginbtnT = (Button) findViewById(R.id.loginbtnT);

        //Codigo del boton tipo login
        loginbtnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameTerapeuta.getText().toString().equals("admin") && passwordTerapeuta.getText().toString().equals("admin")){
                    Toast.makeText(IngresoTerapeuta.this,"Ingreso Exitoso", Toast.LENGTH_SHORT).show();

                    //Confirmar como realizar el cambio de vista

                }else{
                    Toast.makeText(IngresoTerapeuta.this,"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();}
            }
        });
    }
}