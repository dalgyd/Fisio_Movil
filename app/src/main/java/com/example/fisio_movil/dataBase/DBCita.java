package com.example.fisio_movil.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.fisio_movil.ListaCitas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBCita extends FisioMovilDb {

    Context context; // Variable global

    FisioMovilDb dbHelper = new FisioMovilDb(context); // Intancia del objeto DbHleper = nuestra base de datos
    SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

    // Constructor
    public DBCita(@Nullable Context context) {
        // SUPER: Llama al contructor de la clase padre
        super(context);
        this.context = context;

    }

// Long: Es de tipo entero de mayor tamaño


    // NEW
    public Boolean insertarCita(
            Integer IdPaciente,
            Integer IdProfesional,
            Date Fecha,
            Integer Jornada,
            String Direccion,
            String Ubicacion,
            String Estado,
            String Calificacion) {

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("IdPaciente", IdPaciente);
        values.put("IdProfesional", IdProfesional);
        values.put("Fecha", String.valueOf(Fecha));
        values.put("Jornada", Jornada);
        values.put("Direccion", Direccion);
        values.put("Ubicacion", Ubicacion);
        values.put("Estado", Estado);
        values.put("Calificacion", Calificacion);

        long result = db.insert(TABLE_CITA, null, values);
        if (result == -1) return false;
        else
            return true;

    }


    public void agregarCita(String nombrep, String descripcion, String precio) {
        ContentValues cv = new ContentValues(); // Instancia del objeto ContentValues
        cv.put("nombrep", nombrep);
        cv.put("descripcion", descripcion);
        cv.put("precio", precio);
        this.getWritableDatabase().insert("productos", null, cv);
    }

    public Boolean eliminarCita(Integer Id) {
        String IDtx= String.valueOf(Id);
        long result = db.delete(TABLE_CITA, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean CalificaCita(Integer Id, Integer Calificacion) {
        String IDtx= String.valueOf(Id);

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("Calificacion", String.valueOf(Calificacion));

        long result = db.update(TABLE_CITA, values, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean EstadoCita(Integer Id, Integer Estado) {
        String IDtx= String.valueOf(Id);

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("Estado", String.valueOf(Estado));

        long result = db.update(TABLE_CITA, values, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }


    public List<ListaCitas> consultarCitasPaciente(Integer IdPaciente) {
        List<ListaCitas> listArticulos = new ArrayList<ListaCitas>(); // Instancia de un objeto tipo lista
        String IDtx= String.valueOf(IdPaciente);

        Cursor result = this.getWritableDatabase().query(TABLE_CITA,
                new String[]{"Id",
                        "IdPaciente",
                        "IdProfesional",
                        "Fecha",
                        "Jornada",
                        "Direccion",
                        "Ubicacion",
                        "Estado",
                        "Calificacion"},
                "IdPaciente = ?", new String[] {IDtx}, null, null, null);
        while (result.moveToNext()) {
            ListaCitas nuevoArticulo = new ListaCitas(
                    result.getInt((int) result.getColumnIndex("Id")),
                    result.getInt((int) result.getColumnIndex("IdPaciente")),
                    result.getInt((int) result.getColumnIndex("IdProfesional")),
                    result.getString((int) result.getColumnIndex("Fecha")),
                    result.getInt((int) result.getColumnIndex("Jornada")),
                    result.getString((int) result.getColumnIndex("Direccion")),
                    result.getString((int) result.getColumnIndex("Ubicacion")),
                    result.getInt((int) result.getColumnIndex("Estado")),
                    result.getInt((int) result.getColumnIndex("Calificacion"))
            );
            listArticulos.add(nuevoArticulo);
        }
        return listArticulos;
    }
    public List<ListaCitas> consultarCitasProfesional(Integer IdProfesional) {
        List<ListaCitas> listArticulos = new ArrayList<ListaCitas>(); // Instancia de un objeto tipo lista
        String IDtx= String.valueOf(IdProfesional);

        Cursor result = this.getWritableDatabase().query(TABLE_CITA,
                new String[]{"Id",
                        "IdPaciente",
                        "IdProfesional",
                        "Fecha",
                        "Jornada",
                        "Direccion",
                        "Ubicacion",
                        "Estado",
                        "Calificacion"},
                "IdProfesional = ?", new String[] {IDtx}, null, null, null);
        while (result.moveToNext()) {
            ListaCitas nuevoArticulo = new ListaCitas(
                    result.getInt((int) result.getColumnIndex("Id")),
                    result.getInt((int) result.getColumnIndex("IdPaciente")),
                    result.getInt((int) result.getColumnIndex("IdProfesional")),
                    result.getString((int) result.getColumnIndex("Fecha")),
                    result.getInt((int) result.getColumnIndex("Jornada")),
                    result.getString((int) result.getColumnIndex("Direccion")),
                    result.getString((int) result.getColumnIndex("Ubicacion")),
                    result.getInt((int) result.getColumnIndex("Estado")),
                    result.getInt((int) result.getColumnIndex("Calificacion"))
            );
            listArticulos.add(nuevoArticulo);
        }
        return listArticulos;
    }



}
