package com.example.tarea9.model;

import java.util.UUID;

public class Worker extends Employee {

    private boolean mHasTitle;


    public Worker(String name, String position, int local, double salary,boolean hasTitle) {
        super(name, position, local, salary);
        mHasTitle=hasTitle;

    }


    public Worker(String name, String position, int local, double salary,UUID uuid,boolean hasTitle) {
        super(name, position, local, salary,uuid);
        mHasTitle=hasTitle;

    }


    public boolean hasTitle() {
        return mHasTitle;
    }

    public void setHasTitle(boolean hasTitle) {
        mHasTitle = hasTitle;
    }
}
