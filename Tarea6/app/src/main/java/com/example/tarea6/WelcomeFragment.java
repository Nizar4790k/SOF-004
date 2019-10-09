package com.example.tarea6;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment {

    private TextView mTextViewWelcome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_welcome,null,false);

        mTextViewWelcome = view.findViewById(R.id.text_view_welcome);

        Intent intent = getActivity().getIntent();

        String firstName = intent.getStringExtra(RegisterFragment.FIRST_NAME);
        String lastName = intent.getStringExtra(RegisterFragment.LAST_NAME);

        String welcomeSentence = getString(R.string.text_welcome,firstName,lastName);

        mTextViewWelcome.setText(welcomeSentence);


       return view;
    }
}
