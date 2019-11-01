package com.example.segundoparcial;

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

import com.example.segundoparcial.model.Addition;
import com.example.segundoparcial.model.Multiplication;
import com.example.segundoparcial.model.Sustration;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainFragment extends Fragment {



    private Button mCalculateButton;
    private Button mClearBtn;

    private EditText mNum1;
    private EditText mNum2;
    private EditText mNum3;


    private TextView mResultTxt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v=  inflater.inflate(R.layout.fragment_main,null,false);


        mClearBtn = (Button) v.findViewById(R.id.btn_clear);


        mNum1 = (EditText) v.findViewById(R.id.etxt_num1);
        mNum2 = (EditText)v.findViewById(R.id.etxt_num2);
        mNum3= (EditText) v.findViewById(R.id.etxt_num3);






        mResultTxt = (TextView) v.findViewById(R.id.txt_result);



        mCalculateButton = v.findViewById(R.id.calculate_button);

        mCalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtNum1 =mNum1.getText().toString();
                String txtNum2 = mNum2.getText().toString();
                String txtNum3= mNum3.getText().toString();

                String [] texts={txtNum1,txtNum2,txtNum3};


               if( areEmpty(texts)){
                   return;
               }


                int num1 = Integer.parseInt(txtNum1);
                int num2 = Integer.parseInt(txtNum2);
                int num3 = Integer.parseInt(txtNum3);

                Addition addition = (Addition)
                        OperationFactory.getInstance(getContext()).getOperation(num1,num2,num3, OperationFactory.OperationType.ADDITION);


                Sustration sustration = (Sustration)
                        OperationFactory.getInstance(getContext()).getOperation(num1,num2,num3, OperationFactory.OperationType.SUSTRATION);


                Multiplication multiplication = (Multiplication)
                        OperationFactory.getInstance(getContext()).getOperation(num1,num2,num3, OperationFactory.OperationType.MULTIPLICATION);



                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(addition);
                stringBuilder.append("\n");
                stringBuilder.append(sustration);
                stringBuilder.append("\n");
                stringBuilder.append(multiplication);

                mResultTxt.setText(stringBuilder.toString());




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


    private void updateOuput(int result){



        StringBuilder sb = new StringBuilder();
        sb.append(getResources().getString(R.string.display_result));
        sb.append(result);

        mResultTxt.setText(sb.toString()); // Seting text to result










    }

    private boolean areEmpty(String [] textNum){


        for (String text: textNum){

            if(text.equals("")){
                Toast.makeText(getContext(),R.string.field_empty,Toast.LENGTH_SHORT).show();
                return true;
            } else {
               continue;
            }




        }

        return false;


    }

    private void clearAll(){

        mNum1.setText("");
        mNum2.setText("");
        mNum3.setText("");
        mResultTxt.setText(R.string.result_default);
    }

}
