package com.example.tarea5;

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

public class MainFragment  extends Fragment {


    public static final String NAME = "NAME";


    private EditText mEditText;
    private Button mButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment,null,false);


        mEditText = view.findViewById(R.id.edit_text_name);
        mButton = view.findViewById(R.id.button_next);




        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mEditText.getText().toString();
                Intent intent = new Intent(getContext(), ListActivity.class);
                intent.putExtra(NAME,name);

                startActivity(intent);

            }
        });



        return view;
    }

}
