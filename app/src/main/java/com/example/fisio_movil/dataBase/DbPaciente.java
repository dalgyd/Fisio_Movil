package com.example.fisio_movil.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbPaciente extends FisioMovilDb{

    Context context; // Variable global
    FisioMovilDb dbHelper = new FisioMovilDb(context); // Intancia del objeto DbHleper = nuestra base de datos
    SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

    // Constructor
    public DbPaciente(@Nullable Context context) {
        // SUPER: Llama al contructor de la clase padre
        super(context);
        this.context = context;

    }

    // Long: Es de tipo entero de mayor tamaño


    // NEW
    public Boolean insertarPaciente(String NombreCompleto,
                                    String TipoId,
                                    String Identificacion,
                                    String Direccion,
                                    String Ubicacion,
                                    String CorreoElectronico,
                                    String Contrasena){
//        FisioMovilDb dbHelper = new FisioMovilDb(context); // Intancia del objeto DbHleper = nuestra base de datos
//        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("NombreCompleto", NombreCompleto);
        values.put("TipoId", TipoId);
        values.put("Identificacion", Identificacion);
        values.put("Direccion", Direccion);
        values.put("Ubicacion", Ubicacion);
        values.put("CorreoElectronico", CorreoElectronico);
        values.put("Contrasena", Contrasena);

        long result = db.insert(TABLE_PACIENTE, null, values);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean actualizaPaciente(Integer Id,
                                     String NombreCompleto,
                                     String TipoId,
                                     String Identificacion,
                                     String Direccion,
                                     String Ubicacion,
                                     String CorreoElectronico,
                                     String Contrasena){
//        FisioMovilDb dbHelper = new FisioMovilDb(context); // Intancia del objeto DbHleper = nuestra base de datos
//        SQLiteDatabase db = dbHelper.getWritableDatabase(); // Agregamos los datos

        ContentValues values = new ContentValues(); // Instancia del objeto values
        values.put("NombreCompleto", NombreCompleto);
        values.put("TipoId", TipoId);
        values.put("Identificacion", Identificacion);
        values.put("Direccion", Direccion);
        values.put("Ubicacion", Ubicacion);
        values.put("CorreoElectronico", CorreoElectronico);
        values.put("Contrasena", Contrasena);

        String IDtx= String.valueOf(Id);
        long result = db.update(TABLE_PACIENTE, values, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean eliminarPaciente(Integer Id) {

        String IDtx= String.valueOf(Id);
        long result = db.delete(TABLE_PACIENTE, "Id = ?", new String[] {IDtx});
        if (result == -1) return false;
        else
            return true;
    }


    public Boolean checknomusuario(String NombreCompleto){ //esta es ka qye esta llegando null
        FisioMovilDb dbHelper = new FisioMovilDb(context); // Instancia del objeto DbHelper
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //
        // Colección de filas que son aleatorias
        Cursor cursor = db.rawQuery("SELECT * FROM paciente WHERE NombreCompleto =?", new String[] {NombreCompleto});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkcontrasena(String NombreCompleto, String Contrasena){
        FisioMovilDb dbHelper = new FisioMovilDb(context); // Instaciamos nuestra conexión
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM paciente WHERE NombreCompleto =? and Contrasena=?", new String[] {NombreCompleto, Contrasena});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
