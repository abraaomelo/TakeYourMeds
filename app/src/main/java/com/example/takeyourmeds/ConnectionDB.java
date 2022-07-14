package com.example.takeyourmeds;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ConnectionDB extends SQLiteOpenHelper {

    private static final String name = "TakeYourMeds.db";
    private static final int version=1;

    public ConnectionDB(Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table medicine (med_id integer primary key autoincrement, med_name varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
