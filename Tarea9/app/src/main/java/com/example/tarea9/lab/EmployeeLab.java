package com.example.tarea9.lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;

import com.example.tarea9.database.EmployeeCursorWrapper;
import com.example.tarea9.database.EmployeeDbSchema;
import com.example.tarea9.database.EmployeeOpenHelper;
import com.example.tarea9.model.Employee;
import com.example.tarea9.model.Manager;
import com.example.tarea9.model.Worker;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EmployeeLab {



    private static EmployeeLab instance;
    private SQLiteDatabase mDatabase;



    private EmployeeLab(Context context){
        mDatabase = new EmployeeOpenHelper(context).getWritableDatabase();

    }


    public void add(Employee employee){

        ContentValues contentValues = getContentValues(employee);
        String tableName=null;

        if(employee instanceof Worker){

            tableName= EmployeeDbSchema.WorkerTable.NAME;

        }else{



            tableName= EmployeeDbSchema.ManagerTable.NAME;


        }


        mDatabase.insert(tableName,null,contentValues);

    }

    public void update(Employee employee){

        String uuidString;
        ContentValues contentValues;

        if(employee instanceof Worker){

            Worker worker = (Worker) employee;

             uuidString = worker.getUUID().toString();
             contentValues = getContentValues(worker);

              mDatabase.update(EmployeeDbSchema.WorkerTable.NAME,contentValues,
                    EmployeeDbSchema.WorkerTable.Cols.UUID+ " = ?",
                    new String []{uuidString});

        }else{

            Manager manager = (Manager) employee;

             uuidString = manager.getUUID().toString();
             contentValues = getContentValues(manager);

            mDatabase.update(EmployeeDbSchema.ManagerTable.NAME,contentValues,
                    EmployeeDbSchema.ManagerTable.Cols.UUID+ " = ?",
                    new String []{uuidString});


        }




    }

    public void delete (Employee employee) {


        if(employee instanceof  Worker){
            Worker worker = (Worker) employee;

            mDatabase.delete(EmployeeDbSchema.WorkerTable.NAME,
                    EmployeeDbSchema.WorkerTable.Cols.UUID + "= ?",
                    new String[]{worker.getUUID().toString()});



        }else{

            Manager worker = (Manager) employee;

            mDatabase.delete(EmployeeDbSchema.WorkerTable.NAME,
                    EmployeeDbSchema.WorkerTable.Cols.UUID + "= ?",
                    new String[]{worker.getUUID().toString()});



        }




    }

    public Manager getManager(UUID uuid) {

        EmployeeCursorWrapper cursorWrapper = queryReminder(EmployeeDbSchema.ManagerTable.Cols.UUID + " = ?"
                , new String[]{uuid.toString()}, EmployeeDbSchema.ManagerTable.NAME);


       try {
            if (cursorWrapper.getCount() == 0) {
                return null;
            }

            cursorWrapper.moveToFirst();
            return cursorWrapper.getManager();
        }finally{

            cursorWrapper.close();


        }

    }


    public Worker getWorker(UUID uuid) {

        EmployeeCursorWrapper cursorWrapper = queryReminder(EmployeeDbSchema.WorkerTable.Cols.UUID + " = ?"
                , new String[]{uuid.toString()}, EmployeeDbSchema.WorkerTable.NAME);


        try {
            if (cursorWrapper.getCount() == 0) {
                return null;
            }

            cursorWrapper.moveToFirst();
            return cursorWrapper.getWorker();
        }finally{

            cursorWrapper.close();


        }

    }





    public List<Worker> getWorkerList() {

        List<Worker> workers = new ArrayList<>();




        EmployeeCursorWrapper cursorWrapper = queryReminder(null,
                null, EmployeeDbSchema.WorkerTable.NAME);



        try{
            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()){
                workers.add(cursorWrapper.getWorker());
                cursorWrapper.moveToNext();

            }

        } finally {
            cursorWrapper.close();
        }



        return workers;



    }






    public List<Manager> getManagerList(){
        List<Manager> managers = new ArrayList<>();




        EmployeeCursorWrapper cursorWrapper = queryReminder(null,
                null, EmployeeDbSchema.ManagerTable.NAME);



        try{
            cursorWrapper.moveToFirst();

            while (!cursorWrapper.isAfterLast()){
                managers.add(cursorWrapper.getManager());
                cursorWrapper.moveToNext();

            }

        } finally {
            cursorWrapper.close();
        }



        return managers;

    }








    public  static EmployeeLab getInstance(Context context){
        if(instance==null){
            instance = new EmployeeLab(context);
        }

        return instance;

    }

    private static ContentValues getContentValues(Employee employee) {



        if(employee instanceof Worker){
            ContentValues contentValues = new ContentValues();



                Worker worker =(Worker) employee;

                contentValues.put(EmployeeDbSchema.WorkerTable.Cols.NAME, worker.getName());
                contentValues.put(EmployeeDbSchema.WorkerTable.Cols.SALARY, worker.getSalary());
                contentValues.put(EmployeeDbSchema.WorkerTable.Cols.POSITION, worker.getPosition());
                contentValues.put(EmployeeDbSchema.WorkerTable.Cols.HAS_TITLE, worker.hasTitle() ? 1 : 0);
                contentValues.put(EmployeeDbSchema.WorkerTable.Cols.LOCAL, worker.getLocal());
                contentValues.put(EmployeeDbSchema.WorkerTable.Cols.UUID, worker.getUUID().toString());

            return  contentValues;

        }else{

            Manager manager =(Manager) employee;
            ContentValues contentValues = new ContentValues();
            contentValues.put(EmployeeDbSchema.ManagerTable.Cols.NAME,manager.getName());
            contentValues.put(EmployeeDbSchema.ManagerTable.Cols.SALARY,manager.getSalary());
            contentValues.put(EmployeeDbSchema.ManagerTable.Cols.LOCAL,manager.getLocal());
            contentValues.put(EmployeeDbSchema.ManagerTable.Cols.UUID,manager.getUUID().toString());
            contentValues.put(EmployeeDbSchema.ManagerTable.Cols.DEPARTMENT,manager.getDeparment());
            return contentValues;

        }




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
