package com.example.tarea8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class VehicleFragment extends Fragment {

    private static final String BRAND ="com.example.tarea8.Brand";


    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view,null,false);


        mRecyclerView = view.findViewById(R.id.recycler_view);






        return view;



    }


    public Intent getIntent(Context context, Brand brand){

        Intent intent = new Intent(context,VehicleActivity.class);
        intent.putExtra(BRAND,brand);

        return intent;



    }


}
