
package com.example.app;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseDeDatos extends SQLiteOpenHelper {

    public BaseDeDatos(@Nullable Context context,
                       @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory,
                       int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "apellido TEXT," +
                "nombreUsuario TEXT," +
                "password TEXT," +
                "email TEXT);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertData(String nombre, String apellido, String nombreUsuario, String password, String email){
        SQLiteDatabase escritura = getWritableDatabase();
        String insert = "INSERT INTO usuarios (nombre, apellido, nombreUsuario, password, email) " +
                "VALUES(\""+nombre+"\",\""+apellido+"\""+",\""+nombreUsuario+"\""+",\""+password+"\""+",\""+email+"\");";
        escritura.execSQL(insert);
        escritura.close();
    }

    public List<Usuario> getData(){
        SQLiteDatabase lectura = getReadableDatabase();
        String sql = "SELECT * FROM usuarios";
        Cursor cursor = lectura.rawQuery(sql, null);
        cursor.moveToFirst();
        List<Usuario> usuarios = new ArrayList<>();
        do{
            usuarios.add(new Usuario(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)));
        } while(cursor.moveToNext());
        Iterator iterator = usuarios.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        lectura.close();
        return usuarios;
    }
}

