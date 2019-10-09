package com.example.tarea6;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static com.example.tarea6.RegisterFragment.FIRST_NAME;
import static com.example.tarea6.RegisterFragment.LAST_NAME;

public class DialogRegistryValidation extends DialogFragment {

    private String mText;
    private String  [] mNames;

    public DialogRegistryValidation(String text){
        mText = text;
    }

    public DialogRegistryValidation(String text,String [] names){
        mText = text;
        mNames = names;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity()).
                setTitle(mText);

            if(mText.equals(getString(R.string.success))){
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent =  new Intent(getContext(),LoginActivity.class);

                        intent.putExtra(FIRST_NAME,mNames[0]);
                        intent.putExtra(LAST_NAME,mNames[1]);



                        startActivity(intent);


                    }
                });

            } else{
                builder.setPositiveButton(R.string.ok,null);
            }

        return builder.create();

    }
}
