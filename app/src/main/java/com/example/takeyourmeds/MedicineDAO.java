package com.example.takeyourmeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MedicineDAO {

    private ConnectionDB connection;
    private SQLiteDatabase db;


    public MedicineDAO(Context context){
        connection = new ConnectionDB(context);
        db = connection.getWritableDatabase();
    }

    public long med_Create(Medicine medicine){
        Medicine medicie = new Medicine();
        medicie.setMedName("teste");
        ContentValues values = new ContentValues();
        values.put("med_name", medicine.getMedName());
        return db.insert("medicine", null, values);
    }

}
