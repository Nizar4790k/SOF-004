package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends SingleFragmentActivity {




    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }


}
