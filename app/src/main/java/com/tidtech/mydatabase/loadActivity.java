package com.tidtech.mydatabase;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class loadActivity extends Activity {
    DBopenHelper dBopenHelper;
    static ArrayList<String> nameArray ;
    static ArrayList<String> courseArray;
    static ArrayList<String> regArray;
   static  ArrayList<String> unitArray;
   static  ArrayList<String> lecArray;
    private ArrayList<noteItem> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        RecyclerView recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        nameArray=new ArrayList<>();
        courseArray=new ArrayList<>();
        regArray=new ArrayList<>();
        unitArray=new ArrayList<>();
        lecArray=new ArrayList<>();
        itemArrayList = new ArrayList<>();

        dBopenHelper=new DBopenHelper(this);
        loadFromDatabase(dBopenHelper);
        accessArray();
        // ArrayList<noteItem> itemArrayList=new ArrayList<>();
         RecyclerAdapter Adapter=new RecyclerAdapter(this,itemArrayList);
        recyclerView.setAdapter(Adapter);

    }

    public static void loadFromDatabase(DBopenHelper dBopenHelper){
        SQLiteDatabase db=dBopenHelper.getReadableDatabase();
        String[] columns = {DBopenHelper.COLUMN_ID,DBopenHelper.COLUMN_name, DBopenHelper.COLUMN_course};
        Cursor cursor = db.query(DBopenHelper.TABLE_NAME, columns, null, null,
                null, null, null);

        String[] Infocolumns = {DBopenHelper.COLUMN_unit,DBopenHelper.COLUMN_lecturer};
        Cursor Infocursor = db.query(DBopenHelper.TABLE_INFO, Infocolumns, null, null,
                null, null, null);
        loadCourses(cursor);
      InfoloadCourses(Infocursor);
    }

    private static void loadCourses(Cursor cursor) {
        int courseIdPos=cursor.getColumnIndex(DBopenHelper.COLUMN_ID);
        int coursePos=cursor.getColumnIndex(DBopenHelper.COLUMN_course);
        int courseName=cursor.getColumnIndex(DBopenHelper.COLUMN_name);
        //refresh views here so that they can load again
        while(cursor.moveToNext()){
            String name=cursor.getString(courseName);
            String courseId=cursor.getString(courseIdPos);
            String course=cursor.getString(coursePos);
            nameArray.add(name);
            courseArray.add(course);
            regArray.add(courseId);
        }
        cursor.close();
    }
    private static void InfoloadCourses(Cursor Infocursor) {
        int unitPos=Infocursor.getColumnIndex(DBopenHelper.COLUMN_unit);
        int lecturerPos=Infocursor.getColumnIndex(DBopenHelper.COLUMN_lecturer);
        //refresh views here so that they can load again
        while(Infocursor.moveToNext()){
            String unit=Infocursor.getString(unitPos);
            String lec=Infocursor.getString(lecturerPos);
            unitArray.add(unit);
            lecArray.add(lec);
        }
        Infocursor.close();
        }
     public  void accessArray(){
        int c=nameArray.size();
        int g=unitArray.size();
        if(c!=0){
            for(int i=0;i<nameArray.size();i++){
                String name=nameArray.get(i);
                String reg=regArray.get(i);
                String course=courseArray.get(i);
                String unit=unitArray.get(i);
                String lec=lecArray.get(i);

                noteItem noteItem=new noteItem(name,reg,course,unit,lec);
                itemArrayList.add(noteItem);
            }
        }
        }

    public void add(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
