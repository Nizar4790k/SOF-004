package com.example.tarea3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_money_container);

        if(fragment==null){
            fragment = new MoneyFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_money_container,fragment).commit();
        }


    }
}
