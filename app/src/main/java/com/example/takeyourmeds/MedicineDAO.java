package com.example.takeyourmeds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {

    private ConnectionDB connection;
    private SQLiteDatabase db;


    public MedicineDAO(Context context){
        connection = new ConnectionDB(context);
        db = connection.getWritableDatabase();
    }

    public long med_Create(Medicine medicine){
        ContentValues values = new ContentValues();
        values.put("med_name", medicine.getMedName());
        return db.insert("medicine", null, values);
    }

    public List<Medicine> getAllMeds(){
        List<Medicine> medicines = new ArrayList<>();
        Cursor cursor = db.query("medicine", new String[]{"med_id", "med_name"}, null,
                null,null,null, null);
        while (cursor.moveToNext()){
            Medicine med = new Medicine();
            med.setMedID(cursor.getInt(0));
            med.setMedName(cursor.getString(1));
            medicines.add(med);
        }
        return medicines;
    }//EndGetMethd


}//EndClass
