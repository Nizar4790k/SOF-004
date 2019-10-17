package com.example.tarea8;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract  class SingleFragmentActivity extends AppCompatActivity {


    protected Fragment mFragment;
    protected abstract Fragment createFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_activity);

        FragmentManager fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(R.id.single_fragment_container);

        if(mFragment ==null){
            mFragment = createFragment();
            fm.beginTransaction().add(R.id.single_fragment_container,mFragment).commit();
        }




    }
}