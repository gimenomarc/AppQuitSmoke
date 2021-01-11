package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBtabacoIndustrial extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Tabacos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String LOGTAG = "LOGTAG";

    public static final String TABLE_TABACOS = "Tabacos";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "nombre";
    public static final String COLUMN_CANTIDAD = "cantidad";
    public static final String COLUMN_PRECIO = "precio";

    //Creamoos la DB
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_TABACOS + " ( " +
                    COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_CANTIDAD + " INTEGER, " +
                    COLUMN_PRECIO + " INTEGER " + " ) ";

    //Constructor DB
    public DBtabacoIndustrial (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void insertarTabaco (String id, String nombre, String precio, String cantidad){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            ContentValues valores = new ContentValues();
            valores.put ("id", id);
            valores.put ("nombre", nombre);
            valores.put ("cantidad", cantidad);
            valores.put ("precio", precio);
            db.insert("tabacos", null, valores);
            db.close();
        }
    }

    public void modificarTabacos (String id, String nombre,String cantidad, String precio){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put ("id", id);
        valores.put ("nombre", nombre);
        valores.put ("cantidad", cantidad);
        valores.put ("precio", precio);
        db.update("tabacos", valores, "id", null);
        db.close();
    }

    public void borrarTabacos(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("tabacos", "id" + id, null);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.i(LOGTAG, "Table tabacos has been created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TABACOS);
        onCreate(sqLiteDatabase);
    }

    public void datosTabacoIndustrial(SQLiteDatabase db){
        db.execSQL("INSERT INTO DBtabacoLiar values ('1','Marlboro',30, 5.15)");
        db.execSQL("INSERT INTO DBtabacoLiar values ('2','Winston Silver', 30, 4.60)");
        System.out.println("Ha cargado datosTabacoIndustrial");
    }
}
