package com.example.tarea9.model;

import java.util.UUID;

public class Manager  extends  Employee{

    private String deparment;


    public Manager(String name, String position, String local, double salary, UUID uuid,String deparment) {
        super(name, position, local,salary,uuid);
        this.deparment=deparment;

    }

    public Manager(String name, String position, String local, double baseSalary, String deparment) {
        super(name, position, local, baseSalary);
        this.deparment = deparment;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }



}






