package com.example.tarea9.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tarea9.model.Employee;

public class EmployeeOpenHelper extends SQLiteOpenHelper {


    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "employeebase.db";

    public EmployeeOpenHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+EmployeeDbSchema.WorkerTable.NAME+"("+"_id integer primary key autoincrement,"
                + EmployeeDbSchema.WorkerTable.Cols.NAME+","+
                EmployeeDbSchema.WorkerTable.Cols.POSITION+","+
                EmployeeDbSchema.WorkerTable.Cols.LOCAL+","+
                EmployeeDbSchema.WorkerTable.Cols.UUID+","+
                EmployeeDbSchema.WorkerTable.Cols.SALARY+","
                +EmployeeDbSchema.WorkerTable.Cols.HAS_TITLE+")");


        db.execSQL("create table "+EmployeeDbSchema.ManagerTable.NAME+"("+"_id integer primary key autoincrement,"
                + EmployeeDbSchema.ManagerTable.Cols.NAME+","+
                EmployeeDbSchema.ManagerTable.Cols.LOCAL+","+
                EmployeeDbSchema.ManagerTable.Cols.UUID+","+
                EmployeeDbSchema.ManagerTable.Cols.SALARY+","+
                EmployeeDbSchema.ManagerTable.Cols.DEPARTMENT+")");


    }








    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
