package com.example.tarea4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment implements CompoundButton.OnClickListener {

   private CheckBox mCheckBoxMusic;
   private CheckBox mCheckBoxCar;
   private CheckBox mCheckBoxPerson;
   private CheckBox mCheckBoxStreet;
   private ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment,null,false);

        mCheckBoxMusic = view.findViewById(R.id.checkBoxMusic);
        mCheckBoxStreet = view.findViewById(R.id.checkBoxStreet);
        mCheckBoxPerson = view.findViewById(R.id.checkBoxPerson);
        mCheckBoxCar = view.findViewById(R.id.checkBoxCar);



        mImageView = view.findViewById(R.id.imageView);


        mCheckBoxMusic.setOnClickListener(this);
        mCheckBoxCar.setOnClickListener(this);

        mCheckBoxPerson.setOnClickListener(this);
        mCheckBoxStreet.setOnClickListener(this);




        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {

        boolean isCarSelected = mCheckBoxCar.isChecked();
        boolean isStreetSelected = mCheckBoxStreet.isChecked();
        boolean isMusicSelected = mCheckBoxMusic.isChecked();
        boolean isPersonSelected = mCheckBoxPerson.isChecked();



        if(!(isCarSelected && isStreetSelected && isMusicSelected && isPersonSelected)){

            mImageView.setImageResource(R.drawable.blank);

        }


        if(isCarSelected && isStreetSelected && isMusicSelected && isPersonSelected){

            mImageView.setImageResource(R.drawable.street_music_car_person);
            return;

        }


        //------------------

        if(isCarSelected){
            mImageView.setImageResource(R.drawable.car);
        }

        if(isMusicSelected){

            mImageView.setImageResource(R.drawable.music);
        }

        if (isStreetSelected){

            mImageView.setImageResource(R.drawable.street);

        }

        if(isPersonSelected){

            mImageView.setImageResource(R.drawable.person);

        }

        //-------------

        if (isCarSelected && isMusicSelected){

            mImageView.setImageResource(R.drawable.car_music);

        }

        if(isCarSelected && isPersonSelected){

            mImageView.setImageResource(R.drawable.car_person);

        }


        if(isCarSelected && isStreetSelected){
            mImageView.setImageResource(R.drawable.car_street);
        }




        if (isStreetSelected && isMusicSelected){

            mImageView.setImageResource(R.drawable.music_street);


        }

        if(isStreetSelected && isPersonSelected){
            mImageView.setImageResource(R.drawable.street_person);
        }



        if(isMusicSelected && isPersonSelected){

            mImageView.setImageResource(R.drawable.person_music);


        }

        //------------------------


        if(isPersonSelected && isCarSelected && isMusicSelected){

            mImageView.setImageResource(R.drawable.person_music_car);

        }

        if(isPersonSelected && isCarSelected && isStreetSelected){

            mImageView.setImageResource(R.drawable.person_car_street);

        }


        if (isMusicSelected && isStreetSelected && isPersonSelected){

            mImageView.setImageResource(R.drawable.music_street_person);

        }

        if (isMusicSelected && isStreetSelected && isCarSelected){

            mImageView.setImageResource(R.drawable.music_street_car);

        }




        //







    }
}
