package com.example.tarea3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment  {


    private  Button btnExit;
    private EditText mEditText;
    private TextView mTextView;

    public Button getBtnExit() {
        return btnExit;
    }

    public EditText getEditText() {
        return mEditText;
    }

    public TextView getTextView() {
        return mTextView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, null, false);


        mEditText = (EditText)view.findViewById(R.id.edit_text);
        mTextView =  (TextView) view.findViewById(R.id.txt_view);
        btnExit = (Button) view.findViewById(R.id.btn_exit);


        /*
        btnExit.setOnLongClickListener( new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View v) {

     Activity mainActivity =getActivity();
                mainActivity.finish();
                mainActivity.moveTaskToBack(true);

                return false;
            }
        });
         */

        btnExit.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Start
                        break;
                    case MotionEvent.ACTION_UP:

                        // End
                        Activity mainActivity =getActivity();
                        mainActivity.finish();
                        mainActivity.moveTaskToBack(true);

                        break;
                }
                return false;
            }
        });


        return view;


    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


/*
    private String generateReport(int quantity){

        int  [] bills = {100,50,20,10,5};
        int  billCount[] = new int [5];// pos 0= 100 bils, pos 1 = 50 bills, pos 2= 20 bills,
        // pos 3 = 10 cents, pos 4 = 5 cent

        for(int i=0;i<billCount.length;i++){
            billCount[i]=0;
        }


        do{


            if(quantity%100==0){
                quantity-=100;
                billCount[0]++;
            } else if (quantity%50==0){
                quantity-=50;
                billCount[1]++;

            } else if (quantity%20==0){
                quantity-=20;
                billCount[2]++;
            }


        }while (quantity!=0);




        StringBuilder sb = new StringBuilder();

        for(int i=0;i<billCount.length;i++){

            String count = String.valueOf(billCount[i]);
            String bill = String.valueOf(bills[i]);

            String line = getResources().getString(R.string.bill_count,count,bill);

            sb.append(line + "\n");

        }



        return  sb.toString();
    }
*/

}
