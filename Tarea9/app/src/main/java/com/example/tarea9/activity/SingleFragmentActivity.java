package com.example.tarea9.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tarea9.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {


    public abstract Fragment createFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment fragment = createFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragment==null){
            fragmentManager.beginTransaction().add(R.id.fragment_container,fragment)
                    .commit();
        }


    }
}
