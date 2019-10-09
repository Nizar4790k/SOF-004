package com.example.tarea6;

import androidx.fragment.app.Fragment;

public class WelcomeActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new WelcomeFragment();
    }
}
