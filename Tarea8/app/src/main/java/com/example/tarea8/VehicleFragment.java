package com.example.tarea8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VehicleFragment extends Fragment {

    private static final String BRAND ="com.example.tarea8.Brand";
    private static final String TYPE="Type";
    private static final String LIST_BRAND = "ListBrand";


    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view,null,false);


        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        Brand brandSelected = (Brand)getActivity().getIntent().getSerializableExtra(BRAND);

        CarFactory.VehicleType vehicleType = (CarFactory.VehicleType) getActivity()
                .getIntent().getSerializableExtra(TYPE);


        String[]  brands =  getActivity().getIntent().getStringArrayExtra(LIST_BRAND);





        String [] models1 = null;






        switch (vehicleType){

            case SPORTVEHICLE:
                if(brandSelected.toString().equals(brands[0])){

                    String [] models = {"812superfast","812gts","sf90stradle","f8tributo","f8spider"};
                    models1=models;


                }else{

                    String [] models = {"Veneno","Centenario","Aventador","Huracan","Urus"};
                    models1=models;
                }

                break;


            case SEDAMVEHICLE:
                if(brandSelected.toString().equals(brands[0])){

                    String [] models = {"Sonata","Ioniq","Elantra","Accent","Grandeur"};
                    models1=models;

                }else{

                    String [] models = {"Civic","Insight","Accord","Clarity","Urus"};
                    models1=models;
                }

                break;

            case ALLTERRAINVEHICLE:

                if(brandSelected.toString().equals(brands[0])){

                    String [] models = {"Z400","Z250","Z90","Z50","R450"};
                    models1=models;

                }else{

                    String [] models = {"Raptor 90","YFZ50","700R","YFZ450R","Raptor 700"};
                    models1=models;
                }

                break;






        }

        List<Vehicle> vehicles = getVehicleList(brandSelected,models1,vehicleType);

        VehicleAdapter adapter = new VehicleAdapter(vehicles);
        mRecyclerView.setAdapter(adapter);





        return view;



    }

    private class  VehicleAdapter extends RecyclerView.Adapter<VehicleFragment.VehicleHolder>{


        private List<Vehicle> mVehicles;

        public VehicleAdapter(List<Vehicle> vehicles){
            this.mVehicles=vehicles;
        }



        @NonNull
        @Override
        public VehicleFragment.VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            return new VehicleFragment.VehicleHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull VehicleFragment.VehicleHolder holder, int position) {

            holder.bind(mVehicles.get(position));

        }

        @Override
        public int getItemCount() {
            return mVehicles.size();
        }
    }


    private class VehicleHolder extends RecyclerView.ViewHolder {


        private TextView mTextView;


        public VehicleHolder(LayoutInflater inflater, ViewGroup group){

            super(inflater.inflate(R.layout.vehicle_list_item,group,false));

            mTextView = itemView.findViewById(R.id.text_view_vehicle);


        }




        public void bind(Vehicle vehicle){


            mTextView.setText(vehicle.toString());


        }

    }



    public  static  Intent getIntent(Context context, Brand brandSelected,
                                     CarFactory.VehicleType vehicleType,Brand[] brands)
    {


        String[] brandStringArray= new String [brands.length];

        for(int i=0;i<brands.length;i++){
           brandStringArray[i] =brands[i].toString();
        }


        Intent intent = new Intent(context,VehicleActivity.class);

        intent.putExtra(BRAND,brandSelected);
        intent.putExtra(TYPE,vehicleType);
        intent.putExtra(LIST_BRAND,brandStringArray);


        return intent;



    }


    private List<Vehicle> getVehicleList(Brand brand, String [] models, CarFactory.VehicleType type){



        int [] years ={2010,2012,2016,2018,2014};
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i=0;i<models.length;i++){
            for(int j=0;j<years.length;j++){

                vehicles.add(CarFactory.get().getVehicle(type,years[j],brand,models[i]));
            }
        }

        return vehicles;
    }


}
