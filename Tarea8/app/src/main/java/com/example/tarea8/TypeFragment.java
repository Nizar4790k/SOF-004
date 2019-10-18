package com.example.tarea8;

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


public class TypeFragment extends Fragment {

    private  RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,null,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(new TypeAdapter());


        return view;

    }


    private class  TypeAdapter extends RecyclerView.Adapter<VehicleHolder>{

       private final int [] names = {R.string.sport_cars,R.string.sedan_cars,R.string.all_terrain_cars};
        private  final int [] photo = {R.drawable.sport_car,R.drawable.sedan_car,R.drawable.all_terrain_auto};


        @NonNull
        @Override
        public VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           LayoutInflater inflater = LayoutInflater.from(getContext());

            return new VehicleHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {

            holder.bind(photo[position],names[position]);

        }

        @Override
        public int getItemCount() {
            return photo.length;
        }
    }

    private class VehicleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mTextView;
        private int mName;

       public VehicleHolder(LayoutInflater inflater, ViewGroup group){

           super(inflater.inflate(R.layout.type_list_item,group,false));
           mImageView = itemView.findViewById(R.id.image_view_type);
           mTextView = itemView.findViewById(R.id.text_view_type);
           itemView.setOnClickListener(this);

       }


        @Override
        public void onClick(View v) {


           Intent intent ;

           if(mName==R.string.sport_cars){
               intent = BrandFragment.getIntent(CarFactory.VehicleType.SPORTVEHICLE,getContext());
           } else if (mName == R.string.sedan_cars) {

               intent = BrandFragment.getIntent(CarFactory.VehicleType.SEDAMVEHICLE,getContext());
           }else{
               intent = BrandFragment.getIntent(CarFactory.VehicleType.ALLTERRAINVEHICLE,getContext());
           }

           startActivity(intent);


        }


        public void bind(int image,int name){

           mName = name;
           mTextView.setText(name);
          mImageView.setImageResource(image);

        }

    }



}
