package com.example.tarea6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LoginActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }
}
