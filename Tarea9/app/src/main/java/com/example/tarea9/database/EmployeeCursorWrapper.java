package com.example.tarea9.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.tarea9.model.Employee;
import com.example.tarea9.model.Manager;
import com.example.tarea9.model.Worker;

import java.util.UUID;

public class EmployeeCursorWrapper extends CursorWrapper {

    public EmployeeCursorWrapper(Cursor cursor) {
        super(cursor);
    }


    public Worker getWorker(){

        String name = getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.NAME));
        double salary = getDouble(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.SALARY));
        String position  = getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.POSITION));
        boolean hasTitle = getInt(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.HAS_TITLE))==1?true:false;
        UUID uuid =UUID.fromString(getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.UUID)));
        int local = getInt(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.LOCAL));






        Worker worker = new Worker(name,position,local,salary,uuid,hasTitle);




        return worker;

    }



}
