package com.example.tarea9.fragment;

import android.content.Context;
import android.content.Intent;
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
import com.example.tarea9.activity.ManagerActivity;
import com.example.tarea9.activity.WorkerActivity;
import com.example.tarea9.database.EmployeeDbSchema;
import com.example.tarea9.lab.EmployeeLab;
import com.example.tarea9.model.Manager;

import java.util.UUID;

public class ManagerFragment extends Fragment {


    private static String CREATOR_MODE ="CreatorMode";
    private static String IDENTIFIER="identifier";


    private EditText mSalaryEditText;
    private EditText mNameEditText;
    private Spinner mSpinnerLocal;
    private Button mButtonAddorUpdate;
    private EditText mEditTextDepartment;
    private Manager mManager;



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



        int drawable=0;
        String buttonText;

        if(isCreatorMode){

            //  visibility=View.VISIBLE;if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = R.drawable.ic_add_button;



            buttonText  = getString(R.string.add);
            setHasOptionsMenu(false);


        }else{




            drawable = R.drawable.ic_update;

            UUID uuid = (UUID) getActivity().getIntent().getSerializableExtra(IDENTIFIER);
            mManager = EmployeeLab.getInstance(getContext()).getManager(uuid, EmployeeDbSchema.ManagerTable.NAME,
                    EmployeeDbSchema.ManagerTable.Cols.UUID);


            buttonText = getString(R.string.update);




            mEditTextName.setText(mManager.getName());
            mEditTextSalary.setText(String.valueOf(mManager.getSalary()));
            mEditTextPosition.setText(mManager.getPosition());
            mHasTitle.setChecked(mManager.hasTitle());
            mSpinnerLocal.setSelection(Integer.parseInt(mManager.getLocal()));

            setHasOptionsMenu(true);




        }





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


    public static Intent newIntent(Context context, UUID uuid){

        Intent intent = new Intent(context, ManagerActivity.class);


        if(uuid==null){
            intent.putExtra(CREATOR_MODE,true);
        }else {
            intent.putExtra(CREATOR_MODE,false);
            intent.putExtra(IDENTIFIER,uuid);
        }


        return intent;



    }

}
