package com.example.fisio_movil.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbProfesional extends FisioMovilDb{

    Context context; // Variable global
    FisioMovilDb dbHelper = new FisioMovilDb(context); // Intancia del objeto DbHleper = nuestra base de datos
    SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

    // Constructor
    public DbProfesional(@Nullable Context context) {
        // SUPER: Llama al contructor de la clase padre
        super(context);
        this.context = context;
    }

    // Long: Es de tipo entero de mayor tamaño


    // NEW
    public Boolean insertarProfesional(String NombreCompleto,
                                       String TipoId,
                                       String Identificacion,
                                       String Especialidad,
                                       String SoporteAcademico,
                                       String CorreoElectronico,
                                       String Contrasena){

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("NombreCompleto", NombreCompleto);
        values.put("TipoId", TipoId);
        values.put("Identificacion", Identificacion);
        values.put("Especialidad", Especialidad);
        values.put("SoporteAcademico", SoporteAcademico);
        values.put("CorreoElectronico", CorreoElectronico);
        values.put("Contrasena", Contrasena);

        long result = db.insert(TABLE_PROFESIONAL, null, values);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checknomusuario(String NombreCompleto){ //esta es ka qye esta llegando null
        FisioMovilDb dbHelper = new FisioMovilDb(context); // Instancia del objeto DbHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //
        // Colección de filas que son aleatorias
        Cursor cursor = db.rawQuery("SELECT * FROM profesional WHERE NombreCompleto =?", new String[] {NombreCompleto});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean actualizaProfesional(Integer Id,
                                        String NombreCompleto,
                                        String TipoId,
                                        String Identificacion,
                                        String Especialidad,
                                        String SoporteAcademico,
                                        String CorreoElectronico,
                                        String Contrasena){

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("NombreCompleto", NombreCompleto);
        values.put("TipoId", TipoId);
        values.put("Identificacion", Identificacion);
        values.put("Especialidad", Especialidad);
        values.put("SoporteAcademico", SoporteAcademico);
        values.put("CorreoElectronico", CorreoElectronico);
        values.put("Contrasena", Contrasena);

        String IDtx= String.valueOf(Id);
        long result = db.update(TABLE_PROFESIONAL, values, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean eliminarProfesional(Integer Id) {

        String IDtx= String.valueOf(Id);
        long result = db.delete(TABLE_PROFESIONAL, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkcontrasena(String NombreCompleto, String Contrasena){
        FisioMovilDb dbHelper = new FisioMovilDb(context); // Instaciamos nuestra conexión
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM profesional WHERE NombreCompleto =? and Contrasena=?", new String[] {NombreCompleto, Contrasena});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
