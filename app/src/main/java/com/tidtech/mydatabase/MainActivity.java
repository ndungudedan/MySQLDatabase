package com.tidtech.mydatabase;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txt1;
    EditText txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(EditText)findViewById(R.id.courseId);
        txt2=(EditText)findViewById(R.id.course);

    }

    public void addToDatabase(View view) {
        String id=txt1.getText().toString();
        String name=txt2.getText().toString();
        insertData(id, name);
        txt1.getText().clear();
        txt2.getText().clear();
    }

    private void insertData(String id, String name) {
        DBopenHelper helper = new DBopenHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(DBopenHelper.COLUMN_ID, id);
        content.put(DBopenHelper.COLUMN_course, name);

        database.insert(DBopenHelper.TABLE_NAME, null, content);
    }
}
