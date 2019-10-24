package com.example.tarea9.lab;

import com.example.tarea9.model.Employee;

import java.util.List;

public class EmployeeLab {

    private static EmployeeLab instance;




    private EmployeeLab(){

    }


    public void add(Employee employee){

    }

    public void update(Employee employee){

    }

    public void delete(Employee e) {

    }


    public List<Employee> getEmployeeList() {
        return null;
    }






    public  static EmployeeLab getInstance(){
        if(instance==null){
            instance = new EmployeeLab();
        }

        return instance;

    }

}
