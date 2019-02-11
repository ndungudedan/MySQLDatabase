package com.tidtech.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import static android.provider.BaseColumns._ID;

public class DBopenHelper extends SQLiteOpenHelper {
    public static final String DB_Name="School.db";
    public static int Db_Version=1;

    public static final String TABLE_NAME = "Courses";
    public static final String COLUMN_ID= "ID";
    public static final String COLUMN_course= "Course";


    public DBopenHelper(@Nullable Context context) {
        super(context, DB_Name, null, Db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         String SQL_CreateTable="CREATE TABLE "+TABLE_NAME+"("+
                _ID+"INTEGER PRIMARY KEY,"+COLUMN_ID+"TEXT UNIQUE NOT NULL,"+COLUMN_course+"TEXT NOT NULL"+");";
        sqLiteDatabase.execSQL(SQL_CreateTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
