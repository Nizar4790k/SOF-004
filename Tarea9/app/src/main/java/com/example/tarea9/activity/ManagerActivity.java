package com.example.tarea9.activity;

import androidx.fragment.app.Fragment;

import com.example.tarea9.fragment.ManagerFragment;

public class ManagerActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new ManagerFragment();
    }
}
