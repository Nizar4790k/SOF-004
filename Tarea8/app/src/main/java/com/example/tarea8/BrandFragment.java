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
    private  List<Brand> mBrands;

    public static final String TYPE="Type";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,null,false);

        mBrands = new ArrayList<>();

        mRecyclerView = view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        int type = getActivity().getIntent().getIntExtra(TYPE,0);

        Brand brand1 = null;
        Brand brand2 = null;


        switch (type){

            case R.string.sport_cars:

            brand1= new Brand("Ferrari",R.drawable.ferrari);
            brand2 = new Brand("Lamborgini",R.drawable.lamborgini);



            break;


            case R.string.sedan_cars:

                brand1 = new Brand("Hyundai",R.drawable.hyundai);
                brand2 = new Brand("Honda",R.drawable.honda);



                break;

            case R.string.all_terrain_cars:

                brand1 = new Brand("Suzuki",R.drawable.suzuki);
                brand2 = new Brand("Yamaha",R.drawable.yamaha);

                break;


        }


        mBrands.add(brand1);
        mBrands.add(brand2);

        BrandAdapter brandAdapter = new BrandAdapter(mBrands);
        mRecyclerView.setAdapter(brandAdapter);

        return view;
    }


    private class  BrandAdapter extends RecyclerView.Adapter<BrandHolder>{

        List<Brand> mBrands;


        public BrandAdapter( List<Brand> brands){
            mBrands= brands;
        }



        @NonNull
        @Override
        public BrandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getContext());

            return new BrandHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull BrandHolder holder, int position) {

            holder.bind(mBrands.get(position));


        }

        @Override
        public int getItemCount() {
            return mBrands.size();
        }
    }

    private class BrandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageView;
        private TextView mTextView;
        private Brand mBrand;


        public BrandHolder(LayoutInflater inflater, ViewGroup group){

            super(inflater.inflate(R.layout.brand_list_item,group,false));
            mImageView = itemView.findViewById(R.id.image_view_brand);
            mTextView = itemView.findViewById(R.id.text_view_name_brand);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {




        }


        public void bind(Brand brand){

            mBrand= brand;
            mTextView.setText(brand.getName());
            mImageView.setImageResource(brand.getPhoto());

        }




    }


    public static Intent getIntent(int type, Context context){

        Intent intent = new Intent(context,BrandActivity.class);
        intent.putExtra(TYPE,type);

        return intent;


    }



}
