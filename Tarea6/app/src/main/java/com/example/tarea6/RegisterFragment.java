package com.example.tarea6;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class RegisterFragment extends Fragment {

    private EditText mEditTextFirstName;
    private EditText mEditTextLastName;
    private Button mButtonNext;

    public static String FIRST_NAME = "firstName";
    public static  String LAST_NAME ="lastName";
    private final String DIALOG_VALIDATION="DialogValidation";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register,container,false);

        mEditTextFirstName = view.findViewById(R.id.edit_text_first_name);
        mEditTextLastName = view.findViewById(R.id.edit_text_last_name);
        mButtonNext = view.findViewById(R.id.button_next);

        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String firstName = mEditTextFirstName.getText().toString();
                String lastName = mEditTextLastName.getText().toString();

                boolean isNotValid = firstName.equals("") || lastName.equals("");

                FragmentManager manager = getFragmentManager();
                if (isNotValid){

                    DialogRegistryValidation dialog  = new DialogRegistryValidation(getString(R.string.wrong));
                    dialog.show(manager,DIALOG_VALIDATION);


                } else {

                    String [] names = {firstName,lastName};

                    DialogRegistryValidation dialog  = new DialogRegistryValidation(getString(R.string.success),names);
                    dialog.show(manager,DIALOG_VALIDATION);





                }



            }
        });


        return  view;

    }




}
