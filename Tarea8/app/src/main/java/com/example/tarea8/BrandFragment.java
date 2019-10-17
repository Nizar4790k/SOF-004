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

import java.util.ArrayList;
import java.util.List;


public class BrandFragment extends Fragment {

    private  RecyclerView mRecyclerView;

    public static final String TYPE="Type";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,null,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        String type = getActivity().getIntent().getStringExtra(TYPE);

            List<String> models = new ArrayList<>();
            Brand brand;

        if(type.equals(getString(R.string.sport_cars))){

            brand = new Brand("Ferrari");
            models.add("F8 Tributo");
            models.add("F8 Spider");
            models.add("488 Pista spider");
            models.add("GTC4 LUSSOT");
            models.add("PortaFino");



        } else if (type.equals(getString(R.string.sedan_cars))){

            brand = new Brand("Toyota");
            models.add("Camry");
            models.add("Prirus");
            models.add("Mirai");
            models.add("Corolla");
            models.add("Avalon");




        }else {


            brand = new Brand("Toyota");
            models.add("Camry");
            models.add("Prirus");
            models.add("Mirai");
            models.add("Corolla");
            models.add("Avalon");


        }




        return view;

    }


    private class  BrandAdapter extends RecyclerView.Adapter<TypeHolder>{


        List<Vehicle> mVehicles;


        public BrandAdapter( List<Vehicle> vehicles){
            mVehicles= vehicles;
        }



        @NonNull
        @Override
        public TypeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            return new TypeHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TypeHolder holder, int position) {



        }

        @Override
        public int getItemCount() {
            mVehicles.size();
        }
    }

    private class TypeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mTextView;

        public TypeHolder(LayoutInflater inflater, ViewGroup group){

            super(inflater.inflate(R.layout.type_list_item,group,false));
            mImageView = itemView.findViewById(R.id.image_view_type);
            mTextView = itemView.findViewById(R.id.text_view_type);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

        }


        public void bind(int image,int name){
            mTextView.setText(name);
            mImageView.setImageResource(image);

        }




    }

    public static Intent getIntent(String type, Context context){

        Intent intent = new Intent(context,BrandActivity.class);
        intent.putExtra(TYPE,type);

        return intent;


    }

}
