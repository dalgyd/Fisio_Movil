package com.example.fisio_movil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class IngresoPaciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_paciente);

        getSupportActionBar().hide();

        TextView usernamePaciente = (TextView) findViewById(R.id.usernamePaciente);
        TextView passwordPaciente = (TextView) findViewById(R.id.passwordPaciente);

        Button loginbtnP = (Button) findViewById(R.id.loginbtnP);

        //Codigo del boton tipo login
        loginbtnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernamePaciente.getText().toString().equals("admin") && passwordPaciente.getText().toString().equals("admin")){
                    Toast.makeText(IngresoPaciente.this,"Ingreso Exitoso", Toast.LENGTH_SHORT).show();

                    //confirmar como se realiza el cambio de activity desde el login
                    Intent intent = new Intent(getApplicationContext(), MenuPaciente.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(IngresoPaciente.this,"Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();}
            }
        });

    }


}