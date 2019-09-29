package com.example.lab2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SecondActivity extends SingleFragmentActivity {






    @Override
    protected Fragment createFragment() {
        return new SecondFragment();
    }


}
