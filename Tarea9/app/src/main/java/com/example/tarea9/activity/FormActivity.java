package com.example.tarea9.activity;

import androidx.fragment.app.Fragment;

import com.example.tarea9.fragment.FormFragment;

public class FormActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new FormFragment();
    }
}
