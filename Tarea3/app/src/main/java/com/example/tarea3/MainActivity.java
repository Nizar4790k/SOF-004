package com.example.tarea3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

            MainFragment fragment = (MainFragment) mFragment;

        if (KeyEvent.KEYCODE_MENU == keyCode ||  KeyEvent.KEYCODE_HOME==keyCode ||  KeyEvent.KEYCODE_BACK==keyCode ) {

            TextView textView = fragment.getTextView();
            EditText editText = fragment.getEditText();
            int number = Integer.parseInt(editText.getText().toString());
            textView.setText(generateReport(number));


            return true;

        }

        return false;
    }


    private String generateReport(int quantity){

        final String [] type= {getResources().getString(R.string.bill),
                getResources().getString(R.string.coin)};
        final String [] unit = {"$","¢"};
        final int  [] bills = {100,50,20,10,5};
        int  billCount[] = new int [5];// pos 0= 100 bills, pos 1 = 50 bills, pos 2= 20 bills,
        // pos 3 = 10 cents, pos 4 = 5 cent

        for(int i=0;i<billCount.length;i++){
            billCount[i]=0;
        }


        do{

                if(quantity>=100){
                    quantity-=100;
                    billCount[0]++;
                } else if (quantity>=50){
                    quantity-=50;
                    billCount[1]++;

                } else if (quantity>=20){
                    quantity-=20;
                    billCount[2]++;
                }else {

                    quantity*=100;

                    if(quantity>=10){
                        quantity-=10;
                        billCount[3]+=100;

                    } else if(quantity>=5){
                        quantity-=5;
                        billCount[4]+=100;

                    }

                    quantity/=100;
                }







        }while (quantity!=0);




        StringBuilder sb = new StringBuilder();

        for(int i=0;i<billCount.length;i++){

            String count = String.valueOf(billCount[i]);
            String bill = String.valueOf(bills[i]);

           String line = i<3 ? getResources().getString(R.string.bill_count,count,type[0],bill,unit[0])
                   :getResources().getString(R.string.bill_count,count,type[1],bill,unit[1]);




            sb.append(line + "\n");

        }



        return  sb.toString();
    }





}

