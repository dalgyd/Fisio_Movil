package com.example.fisio_movil.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FisioMovilDb extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE = "Fisiomovil.db";
    public static final String TABLE_PROFESIONAL = "Profesional";
    public static final String TABLE_PACIENTE = "Paciente";
    public static final String TABLE_CITA = "Cita";
    public static final String TABLE_JORNADA = "Jornada";
    public static final String TABLE_ESTADO_DE_CITA = "Estado_de_Cita";
    public static final String TABLE_TIPO_DOCUMENTO = "Tipo_Documento";
    public static final String TABLE_ESPECIALIDAD = "Especialidad";

        public FisioMovilDb(@Nullable Context context) {
            super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
        }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_PROFESIONAL + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NombreCompleto TEXT NOT NULL,"+
                "TipoId INTEGER NOT NULL,"+
                "Identificacion TEXT NOT NULL,"+
                "Especialidad INTEGER NOT NULL,"+
                "SoporteAcademico TEXT NOT NULL,"+
                "CorreoElectronico TEXT NOT NULL,"+
                "Contrasena TEXT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_PACIENTE + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NombreCompleto TEXT NOT NULL,"+
                "TipoId INTEGER NOT NULL,"+
                "Identificacion TEXT NOT NULL,"+
                "Direccion TEXT NOT NULL,"+
                "Ubicacion TEXT NOT NULL,"+
                "CorreoElectronico TEXT NOT NULL,"+
                "Contrasena TEXT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_CITA + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "IdPaciente INTEGER NOT NULL,"+
                "IdProfesional INTEGER NOT NULL,"+
                "Fecha DATE NOT NULL,"+
                "Jornada INT NOT NULL,"+
                "Direccion TEXT NOT NULL,"+
                "Ubicacion TEXT NOT NULL,"+
                "Estado INT NOT NULL,"+
                "Calificacion INT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_JORNADA + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Jornada TEXT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_ESTADO_DE_CITA + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Estado TEXT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_TIPO_DOCUMENTO + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TipoDeDocumento TEXT NOT NULL)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_ESPECIALIDAD + "("+
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Especialidad TEXT NOT NULL)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL(" DROP TABLE " + TABLE_PROFESIONAL);// Consulta
            onCreate(sqLiteDatabase);
        }


}
