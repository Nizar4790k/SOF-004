package com.example.tarea9.fragment;

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
import com.example.tarea9.lab.EmployeeLab;
import com.example.tarea9.model.Employee;
import com.example.tarea9.model.Worker;

public class WorkerFragment extends Fragment {

   private EditText mEditTextName;
   private EditText mEditTextSalary;
   private EditText mEditTextPosition;
   private Spinner mSpinnerLocal;
   private CheckBox mHasTitle;
   private Button mButtonAddOrCreate;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.form_fragment,null,false);

        mEditTextName= view.findViewById(R.id.edit_text_name);
        mEditTextSalary = view.findViewById(R.id.edit_text_salary);
        mEditTextPosition = view.findViewById(R.id.edit_text_position);
        mSpinnerLocal =view.findViewById(R.id.spinner_local);
        mHasTitle = view.findViewById(R.id.check_box_has_title);
        mButtonAddOrCreate = view.findViewById(R.id.add_or_update_button);


        mButtonAddOrCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name  = mEditTextName.getText().toString();
                double salary =Double.parseDouble( mEditTextSalary.getText().toString());
                String position = mEditTextPosition.getText().toString();
                int local = (int)mSpinnerLocal.getSelectedItem();

                Employee employee;



                employee = new Worker(name, position, local, salary);
                EmployeeLab employeeLab = EmployeeLab.getInstance();









                 employeeLab.add(employee);





            }
        });



        return view;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);

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

            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
