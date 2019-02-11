package com.tidtech.mydatabase;

import android.provider.BaseColumns;

public final class noteContractClass {
    private noteContractClass(){}

    public static final class courseEntry implements BaseColumns {
        public static final String TABLE_NAME = "Courses";
        public static final String COLUMN_ID= "ID";
        public static final String COLUMN_course= "Course";

        static String SQL_CreateTable="CREATE TABLE"+TABLE_NAME+"("+
                _ID+"INTEGER PRIMARY KEY,"+COLUMN_ID+"TEXT UNIQUE NOT NULL,"+COLUMN_course+"TEXT NOT NULL)";
    }

}
