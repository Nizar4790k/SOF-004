package com.example.lab1;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment   {


    private EditText mEditText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,null,false);

        mEditText = view.findViewById(R.id.edit_text);
        mEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                String text = mEditText.getText().toString();

                if(text.equals("")){
                    return false;
                } else{
                    int number = Integer.parseInt(text);
                    if (keyCode==KeyEvent.KEYCODE_VOLUME_UP){


                        number++;



                    }else if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){

                        number--;



                    } else {
                        return false;
                    }

                    System.out.println(number);

                    mEditText.setText(String.valueOf(number));

                    return true;
                }



            }
        });



        return view;






    }




}
