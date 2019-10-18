package com.example.tarea8;

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






    public Vehicle getVehicle(VehicleType vehicleType){




        switch (vehicleType){
            case SPORTVEHICLE:
                return new SportVehicle();

            case SEDAMVEHICLE:
                return new SedanVehicle();

            case  ALLTERRAINVEHICLE:
                return new AllTerrainVehicle();


                default: return null;

        }





    }

    public enum VehicleType {

        SPORTVEHICLE,SEDAMVEHICLE,ALLTERRAINVEHICLE


    }


}



