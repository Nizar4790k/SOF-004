package com.example.tarea8;

import androidx.annotation.NonNull;

public abstract class Vehicle  {

    private Brand mVehicleBrand;
    private  int mYear;
    private  String mModel;




    public Vehicle(Brand vehicleBrand,String model,int year){
        this.mVehicleBrand= vehicleBrand;
        this.mModel = model;
        this.mYear = year;
    }



    public Brand getVehicleBrand() {
        return mVehicleBrand;
    }

    public void setVehicleBrand(Brand vehicleBrand) {
        mVehicleBrand = vehicleBrand;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }


    @NonNull
    @Override
    public String toString() {
        return getVehicleBrand().toString() + " "+ getModel() +" "+getYear();
    }
}
