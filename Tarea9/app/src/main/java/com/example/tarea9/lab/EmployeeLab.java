package com.example.tarea9.lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tarea9.database.EmployeeCursorWrapper;
import com.example.tarea9.database.EmployeeDbSchema;
import com.example.tarea9.database.EmployeeOpenHelper;
import com.example.tarea9.model.Employee;
import com.example.tarea9.model.Manager;
import com.example.tarea9.model.Worker;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLab {



    private static EmployeeLab instance;
    private SQLiteDatabase mDatabase;



    private EmployeeLab(Context context){
        mDatabase = new EmployeeOpenHelper(context).getWritableDatabase();

    }


    public <T extends Employee> void add(T employee){

        String tableName=null;

        if(employee instanceof Worker){

            tableName= EmployeeDbSchema.WorkerTable.NAME;
        }else{
            tableName= EmployeeDbSchema.ManagerTable.NAME;
        }



        ContentValues contentValues =getContentValues(employee);
        mDatabase.insert(tableName,null,contentValues);

    }

    public <T extends Employee>void update (T e) {



    }

    public <T extends Employee>void delete (T e) {





    }


    public List< ? extends Employee > getEmployeeList(String tableName) {

        List<?> employees = new ArrayList<>();




        EmployeeCursorWrapper cursorWrapper = queryReminder(null,
                null,tableName);


        try{
            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()){
                employees.add(()cursorWrapper.getWorker());
                cursorWrapper.moveToNext();

            }

        } finally {
            cursorWrapper.close();
        }



        return reminders;






        return null ;
    }






    public  static EmployeeLab getInstance(Context context){
        if(instance==null){
            instance = new EmployeeLab(context);
        }

        return instance;

    }

    private static<T extends Employee> ContentValues getContentValues(T employee){

       ContentValues contentValues = new ContentValues();


       if(employee instanceof Worker){
          Worker worker = (Worker) employee;

           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.NAME,worker.getName());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.SALARY,worker.getSalary());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.POSITION,worker.getPosition());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.HAS_TITLE,worker.hasTitle()?1:0 );
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.LOCAL,worker.getLocal());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.UUID,worker.getUUID().toString());
       }else {

           Manager manager = (Manager) employee;

           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.NAME,manager.getName());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.SALARY,manager.getSalary());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.LOCAL,manager.getLocal());
           contentValues.put(EmployeeDbSchema.WorkerTable.Cols.UUID,manager.getUUID().toString());


       }


       return contentValues;



    }


    private EmployeeCursorWrapper queryReminder(String whereClause, String[] whereArgs, String tableName) {
        Cursor cursor = mDatabase.query(
                tableName,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new EmployeeCursorWrapper(cursor);
    }



}
