package com.example.tarea3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    protected Fragment createFragment() {
        return new MainFragment();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

            MainFragment fragment = (MainFragment) mFragment;
        TextView textView = fragment.getTextView();
        EditText editText = fragment.getEditText();

        if (KeyEvent.KEYCODE_MENU == keyCode ||  KeyEvent.KEYCODE_HOME==keyCode ||  KeyEvent.KEYCODE_BACK==keyCode ) {

            String value = editText.getText().toString();

            if(value.equals(null) || value.equals("")){

                Toast.makeText(this,R.string.empty_field,Toast.LENGTH_SHORT).show();

                return false;
            }


            int number = Integer.parseInt(value);
            textView.setText(fragment.generateReport(number));


            return true;

        }else if(KeyEvent.KEYCODE_VOLUME_DOWN==keyCode){
            textView.setText("");
            editText.setText("");


        }


        return false;
    }







}

