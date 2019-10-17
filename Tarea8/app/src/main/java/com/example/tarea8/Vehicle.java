package com.example.tarea8;

public abstract class Vehicle  {

    private Brand mVehicleBrand;

    private  int mYear;
    private  String mModel;
    private int mPhoto;

    public Vehicle(Brand vehicleBrand, int year, String model, int photo) {
        setVehicleBrand(vehicleBrand);
        setYear(year);
        setModel(model);
        setPhoto(photo);
    }

    public Vehicle(Brand vehicleBrand,String model){
        this.mVehicleBrand= vehicleBrand;
        this.mModel = model;
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

    public int getPhoto() {
        return mPhoto;
    }

    public void setPhoto(int photo) {
        mPhoto = photo;
    }
}
