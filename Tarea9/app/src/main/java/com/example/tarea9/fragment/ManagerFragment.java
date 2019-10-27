package com.example.tarea9.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea9.R;

public class ManagerFragment extends Fragment {


    private EditText mSalaryEditText;
    private EditText mNameEditText;
    private Spinner mSpinnerLocal;
    private Button mButtonAddorUpdate;
    private EditText mEditTextDepartment;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.list_fragment,container,false);

        mNameEditText = view.findViewById(R.id.edit_text_name);
        mSalaryEditText = view.findViewById(R.id.edit_text_salary);
        mEditTextDepartment= view.findViewById(R.id.edit_text_department);
        mSpinnerLocal = view.findViewById(R.id.spinner_local);


        final String[] locals = {getString(R.string.choose_local),"1","2","3","4"};
        ArrayAdapter<String> a =new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, locals);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerLocal.setAdapter(a);


        final boolean isCreatorMode = getActivity().getIntent().getBooleanExtra(CREATOR_MODE,true);




        mButtonAddorUpdate = view.findViewById(R.id.add_or_update_button);

        mButtonAddorUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });















       return view;






    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
