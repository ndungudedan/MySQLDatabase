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
    public static final String COLUMN_name= "Names";

    public static final String TABLE_INFO = "Info";
    public static final String COLUMN_unit= "Unit";
    public static final String COLUMN_lecturer= "Lecturer";


    public DBopenHelper(@Nullable Context context) {
        super(context, DB_Name, null, Db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         String SQL_CreateTable="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+
                _ID+" INTEGER PRIMARY KEY,"+COLUMN_ID+" TEXT UNIQUE NOT NULL,"+COLUMN_name+" TEXT NOT NULL,"+
                 COLUMN_course+" TEXT NOT NULL"+")";
        sqLiteDatabase.execSQL(SQL_CreateTable);

        String SQL_CreateTable_Info="CREATE TABLE IF NOT EXISTS "+TABLE_INFO+"("
                +COLUMN_course+" TEXT UNIQUE NOT NULL,"+COLUMN_unit+" TEXT NOT NULL,"+
                COLUMN_lecturer+" TEXT NOT NULL"+")";
        sqLiteDatabase.execSQL(SQL_CreateTable_Info);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
