package com.example.tarea9.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.tarea9.model.Manager;
import com.example.tarea9.model.Worker;

import java.util.UUID;

public class EmployeeCursorWrapper extends CursorWrapper {

    public EmployeeCursorWrapper(Cursor cursor) {
        super(cursor);
    }


    public Worker getWorker()
    {

        String name = getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.NAME));
        double salary = getDouble(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.SALARY));
        String position  = getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.POSITION));
        boolean hasTitle = getInt(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.HAS_TITLE))==1?true:false;
        UUID uuid =UUID.fromString(getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.UUID)));
        String local = getString(getColumnIndex(EmployeeDbSchema.WorkerTable.Cols.LOCAL));



        Worker worker = new Worker(name,position,local,salary,uuid,hasTitle);




        return worker;

    }


    public Manager getManager()
    {

        String name = getString(getColumnIndex(EmployeeDbSchema.ManagerTable.Cols.NAME));
        double salary = getDouble(getColumnIndex(EmployeeDbSchema.ManagerTable.Cols.SALARY));
        UUID uuid =UUID.fromString(getString(getColumnIndex(EmployeeDbSchema.ManagerTable.Cols.UUID)));
        String local = getString(getColumnIndex(EmployeeDbSchema.ManagerTable.Cols.LOCAL));
        String department = getString(getColumnIndex(EmployeeDbSchema.ManagerTable.Cols.DEPARTMENT));

        Manager manager = new Manager(name,null,local,salary,uuid,department);

        return manager;

    }




}
