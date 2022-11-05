package com.example.task_app.task;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWorks extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Works.db";

    public DataBaseWorks(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Lector de Consultas de Nuestra BD, crear una BD
        sqLiteDatabase.execSQL("CREATE TABLE Tarea (" +
                               "id_tarea INTEGER PRIMARY KEY NOT NULL, "+
                                "nombre VARCHAR NOT NULL, "+
                                "fecha VARCHAR NOT NULL,"+
                                "descripcion VARCHAR NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Actualizar una BD
    }

    public void guardarDatos(String work, String date, String desc){
        getReadableDatabase().execSQL("INSERT IN TO Tarea VALUES ("+null+",'"+work+"','"+date+"','"+desc+"');");
    }

    public Cursor getTareas(){
        return getReadableDatabase().query("Tarea", null, null, null, null, null, null  );
    }
}
