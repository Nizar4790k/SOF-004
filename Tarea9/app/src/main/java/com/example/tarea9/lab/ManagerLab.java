package com.example.tarea9.lab;

import com.example.tarea9.model.Employee;

import java.util.List;

public class ManagerLab implements Lab {

    private static ManagerLab instance;



    private ManagerLab(){

    }

    public static ManagerLab getInstance(){

        if(instance==null){
            instance=new ManagerLab();
        }

        return instance;

    }


    @Override
    public void add(Employee e) {

    }

    @Override
    public void update(Employee e) {

    }

    @Override
    public void delete(Employee e) {

    }

    @Override
    public List<Employee> getEmployeeList() {
        return null;
    }
}
