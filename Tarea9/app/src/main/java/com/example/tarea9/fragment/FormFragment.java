package com.example.tarea9.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tarea9.R;
import com.example.tarea9.activity.FormActivity;
import com.example.tarea9.activity.MainActivity;
import com.example.tarea9.database.EmployeeDbSchema;
import com.example.tarea9.lab.EmployeeLab;
import com.example.tarea9.model.Worker;

import java.util.UUID;

public class FormFragment extends Fragment {

   private EditText mEditTextName;
   private EditText mEditTextSalary;
   private EditText mEditTextPosition;
   private Spinner mSpinnerLocal;
   private CheckBox mHasTitle;
   private Button mButtonAddOrCreate;

   private Worker mWorker;
   private EmployeeLab mEmployeeLab;


   private static final String CREATOR_MODE="CreatorMode";
   private static final String IDENTIFIER="Identifier";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_fragment,null,false);


        mEmployeeLab = EmployeeLab.getInstance(getContext());

        mEditTextName= view.findViewById(R.id.edit_text_name);
        mEditTextSalary = view.findViewById(R.id.edit_text_salary);
        mEditTextPosition = view.findViewById(R.id.edit_text_position);
        mSpinnerLocal =view.findViewById(R.id.spinner_local);
        mHasTitle = view.findViewById(R.id.check_box_has_title);
        mButtonAddOrCreate = view.findViewById(R.id.add_or_update_button);


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
           mWorker = EmployeeLab.getInstance(getContext()).getEmployee(uuid, EmployeeDbSchema.WorkerTable.NAME,
                   EmployeeDbSchema.WorkerTable.Cols.UUID);


            buttonText = getString(R.string.update);




            mEditTextName.setText(mWorker.getName());
            mEditTextSalary.setText(String.valueOf(mWorker.getSalary()));
            mEditTextPosition.setText(mWorker.getPosition());
            mHasTitle.setChecked(mWorker.hasTitle());
            setHasOptionsMenu(true);




        }

        mButtonAddOrCreate.setCompoundDrawablesWithIntrinsicBounds(drawable,0,0,0);
        mButtonAddOrCreate.setText(buttonText);







        mButtonAddOrCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name  = mEditTextName.getText().toString();
                double salary =Double.parseDouble( mEditTextSalary.getText().toString());
                String position = mEditTextPosition.getText().toString();
                int local = 4;
                boolean hasTitle = mHasTitle.isChecked();

                mWorker.setSalary(salary);
                mWorker.setName(name);
                mWorker.setPosition(position);
                mWorker.setLocal(local);
                mWorker.setHasTitle(hasTitle);




                EmployeeLab employeeLab = EmployeeLab.getInstance(getContext());



                if(isCreatorMode){
                    employeeLab.add(mWorker);


                }else{

                    employeeLab.update(mWorker);
                }

                getBack();




            }
        });



        return view;


    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.form_fragment,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();


        switch (itemId){
            case R.id.delete_menu_item:
                EmployeeLab.getInstance(getContext()).delete(mWorker);
                getBack();

            return true;
        }



        return super.onOptionsItemSelected(item);
    }



    public static Intent newIntent(Context context, UUID uuid){

        Intent intent = new Intent(context, FormActivity.class);


        if(uuid==null){
            intent.putExtra(CREATOR_MODE,true);
        }else {
            intent.putExtra(CREATOR_MODE,false);
            intent.putExtra(IDENTIFIER,uuid);
        }


        return intent;



    }


    private void getBack(){
        Intent i=new Intent(getContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }





}
