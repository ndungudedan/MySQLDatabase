package com.tidtech.mydatabase;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText txt1;
    EditText txt2;
    Spinner spin;
    String spinItem="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=(EditText)findViewById(R.id.courseId);
        txt2=(EditText)findViewById(R.id.name);
        spin=(Spinner)findViewById(R.id.spinner);

        ArrayList<String> list=new ArrayList<>();
        list.add("Computer Science");
        list.add("Computer Technology");
        list.add("Software Engineering");
        list.add("BBIT");
        list.add("IT");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);
        spin.setOnItemSelectedListener(this);

    }

    public void addToDatabase(View view) {
        String id=txt1.getText().toString();
        String name=txt2.getText().toString();
        insertData(id, name,spinItem);
        txt1.getText().clear();
        txt2.getText().clear();

    }

    private void insertData(String id, String name,String course) {
        DBopenHelper helper = new DBopenHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(DBopenHelper.COLUMN_ID, id);
        content.put(DBopenHelper.COLUMN_name, name);
        content.put(DBopenHelper.COLUMN_course, course);

        database.insert(DBopenHelper.TABLE_NAME, null, content);
        insertInfo(course);
    }
    private void insertInfo(String course) {
        DBopenHelper helper = new DBopenHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(DBopenHelper.COLUMN_course, course);
        if(course=="Computer Science"){
            content.put(DBopenHelper.COLUMN_unit, "Python");
            content.put(DBopenHelper.COLUMN_lecturer, "Mr.Kamau");
        }
        if(course=="Computer Technology"){
            content.put(DBopenHelper.COLUMN_unit, "Java");
            content.put(DBopenHelper.COLUMN_lecturer, "Mr.Atsiaya");
        }
        if(course=="Software Engineering"){
            content.put(DBopenHelper.COLUMN_unit, "Visual Basic");
            content.put(DBopenHelper.COLUMN_lecturer, "Mrs.Olela");
        }
        if(course=="BBIT"){
            content.put(DBopenHelper.COLUMN_unit, "Web");
            content.put(DBopenHelper.COLUMN_lecturer, "Mr.Abdi");
        }
        if(course=="IT"){
            content.put(DBopenHelper.COLUMN_unit, "Android");
            content.put(DBopenHelper.COLUMN_lecturer, "Mr.Chemgor");
        }

        database.insert(DBopenHelper.TABLE_INFO, null, content);
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.spinner:
                spinItem=adapterView.getItemAtPosition(i).toString();
                break;
    }

}
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
