package com.example.personal.proyecto1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BasedeDatos extends SQLiteOpenHelper {
    //3 CREACION DEL CONSTRUCTOR
    // 4 CREACION DE LA TABLA
    String tabla= "CREATE TABLE Tarea(Id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion Text, examinar Text)";
    //String tabla2 = "CREATE TABLE Lugares(Id INTEGER PRIMARY KEY AUTOINCREMENT, TProReg Text, TCiuReg Text, TDirr Text, TCat INTEGER, TComen Text)";

    public BasedeDatos (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        //5 invocar a la creacion de la tabla
        db.execSQL(tabla);
        // db.execSQL(tabla2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
