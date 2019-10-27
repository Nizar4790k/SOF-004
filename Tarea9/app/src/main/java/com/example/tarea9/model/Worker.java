package com.example.tarea9.model;

import java.util.UUID;

public class Worker extends Employee {

    private  static double PERCENTAGE_SALARY=0.30;

    private boolean mHasTitle;



    public Worker(String name, String position, String local, double salary,boolean hasTitle) {
        super(name, position, local, salary);
        mHasTitle=hasTitle;


    }


    public Worker(String name, String position, String local, double salary,UUID uuid,boolean hasTitle) {
        super(name, position, local, salary,uuid);
        mHasTitle=hasTitle;

    }

    @Override
    public void setSalary(double baseSalary){

        super.setSalary(baseSalary);

    }


    public boolean hasTitle() {
        return mHasTitle;
    }

    public void setHasTitle(boolean hasTitle) {
        mHasTitle = hasTitle;
    }

    public static double calculateTotalSalary(double baseSalary,boolean hasTitle){

        if(hasTitle){

           double salary =(baseSalary)+baseSalary*PERCENTAGE_SALARY;

           return salary;
        }else {
            return baseSalary;
        }


    }


}
