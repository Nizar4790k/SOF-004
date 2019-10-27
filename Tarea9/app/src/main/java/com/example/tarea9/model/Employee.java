package com.example.tarea9.model;

import java.util.UUID;

public class Employee  {




    private String mName;
    private String mPosition;
    private String mLocal;
    private UUID mUUID;
    protected double mSalary;



    public Employee(String name, String position, String local, double baseSalary) {

        mUUID = UUID.randomUUID();
        mName = name;
        mPosition = position;
        mLocal = local;
        mSalary = baseSalary;

        

    }

    public Employee(String name, String position, String local, double salary,UUID uuid) {

        mUUID = uuid;
        mName = name;
        mPosition = position;
        mLocal = local;
        mSalary = salary;



    }

    public String getLocal() {
        return mLocal;
    }

    public void setLocal(String local) {
        mLocal = local;
    }

    public double getSalary() {
        return mSalary;
    }

    public void setSalary(double salary) {
        mSalary = salary;
    }

    public String getName() {
        return mName;
    }

    public String getPosition() {
        return mPosition;
    }


    public void setName(String name) {
        mName = name;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    public UUID getUUID() {
        return mUUID;
    }

}
