package com.example.kursovaya;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "DataBase.db";


    public DbHelper(Context context) {
        super(context, "DataBase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Roles ( ID   INTEGER PRIMARY KEY, Role TEXT )");
        db.execSQL("CREATE TABLE Users( ID INTEGER PRIMARY KEY, Role REFERENCES Roles (ID), Login TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
