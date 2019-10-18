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






    public Vehicle getVehicle(VehicleType vehicleType,int year,Brand brand,String model){




        switch (vehicleType){
            case SPORTVEHICLE:

                return new SportVehicle(brand,model,year);

            case SEDAMVEHICLE:
                return new SedanVehicle(brand,model,year);

            case  ALLTERRAINVEHICLE:
                return new AllTerrainVehicle(brand,model,year);


                default: return null;

        }





    }

    public enum VehicleType {

        SPORTVEHICLE,SEDAMVEHICLE,ALLTERRAINVEHICLE


    }


}



