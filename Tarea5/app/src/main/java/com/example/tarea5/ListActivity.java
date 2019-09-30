package com.example.tarea5;

import androidx.fragment.app.Fragment;

public class ListActivity extends  SingleActivityFragment {
    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
