package com.example.tarea5;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends SingleActivityFragment{

    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }


}
