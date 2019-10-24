package com.example.tarea9.lab;

import com.example.tarea9.model.Employee;

import java.util.List;

public class EmployeLab implements Lab {

    private static EmployeLab instance;




    private EmployeLab(){

    }


    public void add(Employee employee){

    }

    public void update(Employee employee){

    }

    @Override
    public void delete(Employee e) {

    }

    @Override
    public List<Employee> getEmployeeList() {
        return null;
    }






    private EmployeLab getInstance(){
        if(instance==null){
            instance = new EmployeLab();
        }

        return instance;

    }

}
