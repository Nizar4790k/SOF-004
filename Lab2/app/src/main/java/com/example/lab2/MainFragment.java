package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {



    public static final String TEXT ="ThisText";

    private EditText mEditText;
    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main,null,false);

        mEditText = (EditText) view.findViewById(R.id.editText);
        mButton = (Button) view.findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SecondActivity.class);

                String text = mEditText.getText().toString();
                intent.putExtra(TEXT,text);
                startActivity(intent);


            }
        });


        return view;
    }
}

