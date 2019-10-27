package com.example.tarea9.activity;

import androidx.fragment.app.Fragment;

import com.example.tarea9.fragment.WorkerFragment;

public class WorkerActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new WorkerFragment();
    }
}
