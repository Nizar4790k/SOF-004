package com.example.tarea4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AboutDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());


        View view = LayoutInflater.from(getActivity()).inflate(R.layout.about_dialog,null);

        ImageView imageView = view.findViewById(R.id.imageViewProfile);
        imageView.setImageResource(R.drawable.profile);




        dialogBuilder.setView(view);
        dialogBuilder.setTitle(R.string.about);
        dialogBuilder.setPositiveButton(R.string.ok,null);


        AlertDialog alertDialog = dialogBuilder.create();




        return alertDialog;





    }
}
