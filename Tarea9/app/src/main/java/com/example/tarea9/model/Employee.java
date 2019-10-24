package com.example.tarea9.model;

import java.util.UUID;

public class Employee  {


    private String mName;
    private String mPosition;
    private int mLocal;
    private UUID mUUID;
    protected double mSalary;


    public Employee(String name, String position, int local, double salary) {

        mUUID = UUID.randomUUID();
        mName = name;
        mPosition = position;
        mLocal = local;
        mSalary = salary;

    }

    public int getLocal() {
        return mLocal;
    }

    public void setLocal(int local) {
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


}
