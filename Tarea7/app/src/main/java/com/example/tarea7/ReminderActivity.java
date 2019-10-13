package com.example.tarea7;

import androidx.fragment.app.Fragment;

public class ReminderActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ReminderFragment();
    }
}
