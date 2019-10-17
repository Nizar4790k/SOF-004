package com.example.tarea8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class TypeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new TypeFragment ();
    }
}
