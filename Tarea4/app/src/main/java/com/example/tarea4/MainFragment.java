package com.example.tarea4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainFragment extends Fragment implements CompoundButton.OnClickListener {

   private static final String DIALOG_ABOUT = "DialogAbout";
   private static final String CURRENT_IMAGE = "CurrentImage";

   private CheckBox mCheckBoxMusic;
   private CheckBox mCheckBoxCar;
   private CheckBox mCheckBoxPerson;
   private CheckBox mCheckBoxStreet;
   private int mImageResource;

   private ImageView mImageView;

   private Button mButtonAbout;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment,null,false);

        mCheckBoxMusic = view.findViewById(R.id.checkBoxMusic);
        mCheckBoxStreet = view.findViewById(R.id.checkBoxStreet);
        mCheckBoxPerson = view.findViewById(R.id.checkBoxPerson);
        mCheckBoxCar = view.findViewById(R.id.checkBoxCar);
        mButtonAbout = view.findViewById(R.id.btn_about);


        mImageView = view.findViewById(R.id.imageView);

        if(savedInstanceState!=null){

            mImageResource = savedInstanceState.getInt(CURRENT_IMAGE);
            mImageView.setImageResource(mImageResource);
        }


        mCheckBoxMusic.setOnClickListener(this);
        mCheckBoxCar.setOnClickListener(this);

        mCheckBoxPerson.setOnClickListener(this);
        mCheckBoxStreet.setOnClickListener(this);

        mButtonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager manager = getFragmentManager();
                AboutDialog dialog  = new AboutDialog();
                dialog.show(manager,DIALOG_ABOUT);




            }
        });




        return view;

    }



    @Override
    public void onClick(View view) {


        searchImage();



    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(CURRENT_IMAGE,mImageResource);

    }

    private void searchImage(){

        boolean isCarSelected = mCheckBoxCar.isChecked();
        boolean isStreetSelected = mCheckBoxStreet.isChecked();
        boolean isMusicSelected = mCheckBoxMusic.isChecked();
        boolean isPersonSelected = mCheckBoxPerson.isChecked();



        if(!(isCarSelected && isStreetSelected && isMusicSelected && isPersonSelected)){

            mImageResource = R.drawable.blank;


        }


        if(isCarSelected && isStreetSelected && isMusicSelected && isPersonSelected){

            mImageResource= R.drawable.street_music_car_person;
            mImageView.setImageResource(mImageResource);
            return;

        }


        //------------------

        if(isCarSelected){
            mImageResource = (R.drawable.car);
        }

        if(isMusicSelected){

            mImageResource = (R.drawable.music);
        }

        if (isStreetSelected){

            mImageResource = (R.drawable.street);

        }

        if(isPersonSelected){

            mImageResource = (R.drawable.person);

        }

        //-------------

        if (isCarSelected && isMusicSelected){

            mImageResource = (R.drawable.car_music);

        }

        if(isCarSelected && isPersonSelected){

            mImageResource = (R.drawable.car_person);

        }


        if(isCarSelected && isStreetSelected){
            mImageResource = (R.drawable.car_street);
        }




        if (isStreetSelected && isMusicSelected){

            mImageResource = (R.drawable.music_street);


        }

        if(isStreetSelected && isPersonSelected){
            mImageResource = (R.drawable.street_person);
        }



        if(isMusicSelected && isPersonSelected){

            mImageResource = (R.drawable.person_music);


        }

        //------------------------


        if(isPersonSelected && isCarSelected && isMusicSelected){

            mImageResource = (R.drawable.person_music_car);

        }

        if(isPersonSelected && isCarSelected && isStreetSelected){

            mImageResource = (R.drawable.person_car_street);

        }


        if (isMusicSelected && isStreetSelected && isPersonSelected){

            mImageResource = (R.drawable.music_street_person);

        }

        if (isMusicSelected && isStreetSelected && isCarSelected){

            mImageResource = (R.drawable.music_street_car);

        }


        mImageView.setImageResource(mImageResource);

        //



    }

}
