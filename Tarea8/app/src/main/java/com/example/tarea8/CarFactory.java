package com.example.tarea8;

import java.util.List;

public class CarFactory  {

    private static CarFactory sCarFactory;

    private  CarFactory(){



    }


    public  static CarFactory get(){
        if(sCarFactory==null){
            sCarFactory = new CarFactory();
        }

        return sCarFactory;
    }



    public List<SportVehicle> getSportVehicles(){

        List<SportVehicle>


    }



}
