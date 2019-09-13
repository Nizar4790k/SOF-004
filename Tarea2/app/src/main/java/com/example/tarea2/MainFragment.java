package com.example.tarea2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainFragment extends Fragment {



    private Button mAddBtn;
    private Button mSubstractBtn;
    private Button mMultiplyBtn;
    private Button mClearBtn;

    private EditText mNum1;
    private EditText mNum2;

    private TextView mOutputTxt;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v=  inflater.inflate(R.layout.fragment_main,null,false);

        mAddBtn=(Button) v.findViewById(R.id.btn_add);
        mSubstractBtn = (Button)v.findViewById(R.id.btn_substract);
        mMultiplyBtn = (Button) v.findViewById(R.id.btn_multiply);
        mClearBtn = (Button) v.findViewById(R.id.btn_clear);


        mNum1 = (EditText) v.findViewById(R.id.etxt_num1);
        mNum2 = (EditText)v.findViewById(R.id.etxt_num2);

        mOutputTxt = (TextView) v.findViewById(R.id.txt_output);




        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtNum1 =mNum1.getText().toString();
                String txtNum2 = mNum2.getText().toString();

                if(areEmpty(txtNum1,txtNum2)){
                    return;
                }


                int num1 = Integer.parseInt(txtNum1);
                int num2 = Integer.parseInt(txtNum2);

                int sum = add(num1,num2);

                updateOutput(sum);


            }
        });


        mSubstractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtNum1 =mNum1.getText().toString();
                String txtNum2 = mNum2.getText().toString();

                if(areEmpty(txtNum1,txtNum2)){
                    return;
                }

                int num1 = Integer.parseInt(txtNum1);
                int num2 = Integer.parseInt(txtNum2);

                int diference = substract(num1,num2);

                updateOutput(diference);



            }
        });

        mMultiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtNum1 =mNum1.getText().toString();
                String txtNum2 = mNum2.getText().toString();

                if(areEmpty(txtNum1,txtNum2)){
                    return;
                }

                int num1 = Integer.parseInt(txtNum1);
                int num2 = Integer.parseInt(txtNum2);

                int product = multiply(num1,num2);

                updateOutput(product);





            }
        });

        mClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });







        return v;



    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private int add(int num1, int num2){

        return num1+num2;
    }


    private int substract(int num1,int num2){
        return num1-num2;
    }

    private  int multiply(int num1,int num2){
        return num1*num2;
    }


    private void updateOutput(int result){

        String output=null;

        if(result<0){

            output =  getString(R.string.output_not_calculated);

        } else {

            int year = new GregorianCalendar().get(Calendar.YEAR);
            int birthYear = year-result;

            output = new StringBuilder().append(getString(R.string.output_result1)+ "" +
                    "("+ result+")" + getString(R.string.output_result2) +" ("+birthYear+")").toString();
        }


        mOutputTxt.setText(output);





    }

    private boolean areEmpty(String txtNum1,String txtNum2){


        if(txtNum1.equals("")|| txtNum2.equals("") ){
            Toast.makeText(getContext(),R.string.field_empty,Toast.LENGTH_SHORT).show();

            return true;
        } else {
            return false;
        }

    }

    private void clearAll(){
        mOutputTxt.setText(R.string.output_default);
        mNum1.setText("");
        mNum2.setText("");
    }

}
