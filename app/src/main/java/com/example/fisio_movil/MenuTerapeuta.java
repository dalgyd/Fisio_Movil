package com.example.fisio_movil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MenuTerapeuta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_terapeuta);

        //getSupportActionBar().hide();//Oculta barra superior

    }

    //Cambia la pantalla a ver servicios disponibles
    public void serviciosDisponibles (View sd){
        Intent cambiar10 = new Intent(this, ServiciosDisponibles.class);
        startActivity(cambiar10);
    }

    //Cambia la pantalla a ver los servicios programados
    public void serviciosProgramados (View sp){
        Intent cambiar11 = new Intent(this, ServiciosProgramados.class);
        startActivity(cambiar11);
    }

    //Cambia la pantalla a ver el historial de servicios
    public void historialServiciosT (View s){
        Intent cambiar12 = new Intent(this, HistorialTerapeuta.class);
        startActivity(cambiar12);
    }

    //Cambia la pantalla a ver las noticias de los terapeutas
    public void noticiasT (View nt){
        Intent cambiar13 = new Intent(this, NoticiasTerapeuta.class);
        startActivity(cambiar13);
    }

    //Cambia la pantalla a perfil del terapeuta
    public void perfilT (View s){
        Intent cambiar14 = new Intent(this, DatosTerapeuta.class);
        startActivity(cambiar14);
    }

    // inicio configuracion del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menudeopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int opcion = item.getItemId();

        switch (opcion){
            case R.id.home:
                Intent cambiar = new Intent(this, MainActivity.class);
                startActivity(cambiar);
                return true;
            case R.id.salir:
                //finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    // fin configuracion del menu
}