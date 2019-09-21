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

public class MainFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

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


        mCheckBoxMusic.setOnCheckedChangeListener(this);
        mCheckBoxCar.setOnCheckedChangeListener(this);

        mCheckBoxPerson.setOnCheckedChangeListener(this);
        mCheckBoxStreet.setOnCheckedChangeListener(this);




        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCheckedChanged(CompoundButton button,boolean isChecked) {

        boolean isCarSelected = mCheckBoxCar.isSelected();
        boolean isStreetSelected = mCheckBoxStreet.isSelected();
        boolean isMusicSelected = mCheckBoxMusic.isSelected();
        boolean isPersonSelected = mCheckBoxPerson.isSelected();


        if(!(isCarSelected && isStreetSelected && isMusicSelected && isPersonSelected)){



        }

        if(isCarSelected && isStreetSelected && isMusicSelected && isPersonSelected){




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

        }



        if(isMusicSelected && isPersonSelected){

        }

        //------------------------


        if(isPersonSelected && isCarSelected && isMusicSelected){

        }

        if(isPersonSelected && isCarSelected && isStreetSelected){

        }


        if (isMusicSelected && isStreetSelected && isPersonSelected){

        }

        if (isMusicSelected && isStreetSelected && isCarSelected){

        }



        //







    }
}
