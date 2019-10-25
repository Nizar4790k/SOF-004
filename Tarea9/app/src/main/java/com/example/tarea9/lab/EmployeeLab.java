package com.example.tarea9.lab;

import com.example.tarea9.model.Employee;

import java.util.List;

public class EmployeeLab {

    private static EmployeeLab instance;




    private EmployeeLab(){

    }


    public <T extends Employee> void add(T e){


    }

    public <T extends Employee>void update (T e) {



    }

    public <T extends Employee>void delete (T e) {





    }


    public List<? extends Employee> getEmployeeList() {




        return null ;
    }






    public  static EmployeeLab getInstance(){
        if(instance==null){
            instance = new EmployeeLab();
        }

        return instance;

    }

}
