package com.example.tarea9.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tarea9.R;
import com.example.tarea9.activity.WorkerActivity;
import com.example.tarea9.activity.MainActivity;
import com.example.tarea9.lab.EmployeeLab;
import com.example.tarea9.model.Worker;

import java.util.UUID;

public class WorkerFragment extends Fragment {


   private EditText mEditTextName;
   private EditText mEditTextSalary;
   private EditText mEditTextPosition;
   private Spinner mSpinnerLocal;
   private CheckBox mHasTitle;
   private Button mButtonAddOrCreate;

   private Worker mWorker;


    private static final String CREATOR_MODE="CreatorMode";
   private static final String IDENTIFIER="Identifier";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.worker_fragment,null,false);


        mEditTextName= view.findViewById(R.id.edit_text_name);
        mEditTextSalary = view.findViewById(R.id.edit_text_salary);
        mEditTextPosition = view.findViewById(R.id.edit_text_position);
        mSpinnerLocal =view.findViewById(R.id.spinner_local);
        mHasTitle = view.findViewById(R.id.check_box_has_title);
        mButtonAddOrCreate = view.findViewById(R.id.add_or_update_button);


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
           mWorker = EmployeeLab.getInstance(getContext()).getWorker(uuid);


            buttonText = getString(R.string.update);




            mEditTextName.setText(mWorker.getName());
            mEditTextSalary.setText(String.valueOf(mWorker.getSalary()));
            mEditTextPosition.setText(mWorker.getPosition());
            mHasTitle.setChecked(mWorker.hasTitle());
            mSpinnerLocal.setSelection(Integer.parseInt(mWorker.getLocal()));

            setHasOptionsMenu(true);




        }

        mButtonAddOrCreate.setCompoundDrawablesWithIntrinsicBounds(drawable,0,0,0);
        mButtonAddOrCreate.setText(buttonText);







        mButtonAddOrCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name  = mEditTextName.getText().toString();

                String position = mEditTextPosition.getText().toString();
                String local = (String)mSpinnerLocal.getSelectedItem();
                String salaryString =mEditTextSalary.getText().toString();
                boolean hasTitle = mHasTitle.isChecked();

                boolean areEmpty = name.equals("") || position.equals("") || local.equals(locals[0])
                        || salaryString.equals("");

                if(areEmpty){
                    Toast.makeText(getContext(),R.string.not_valid,Toast.LENGTH_SHORT).show();
                    return;
                }

                double salary = Double.parseDouble(salaryString);



                EmployeeLab employeeLab = EmployeeLab.getInstance(getContext());



                if(isCreatorMode){

                    mWorker = new Worker(name,position,local,salary,hasTitle);

                    mWorker.setSalary(salary);
                    mWorker.setName(name);
                    mWorker.setPosition(position);
                    mWorker.setLocal(local);
                    mWorker.setHasTitle(hasTitle);



                    employeeLab.add(mWorker);


                }else{

                    mWorker.setSalary(salary);
                    mWorker.setName(name);
                    mWorker.setPosition(position);
                    mWorker.setLocal(local);
                    mWorker.setHasTitle(hasTitle);

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

        Intent intent = new Intent(context, WorkerActivity.class);


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
