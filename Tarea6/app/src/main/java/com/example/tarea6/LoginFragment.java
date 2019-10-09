package com.example.tarea6;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment  extends Fragment {

    private EditText mUserEditText;
    private  EditText mPasswordEditText;
    private Button mButtonLogIn;

    private final String USER ="user";
    private final String PASSWORD = "1234";



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);

        mUserEditText = view.findViewById(R.id.edit_text_user);
        mPasswordEditText = view.findViewById(R.id.edit_text_password);
        mButtonLogIn = view.findViewById(R.id.button_login);

        mButtonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = mUserEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                if(user.equals(USER) && password.equals(PASSWORD)){
                    String firstName = getActivity().getIntent().getStringExtra(RegisterFragment.FIRST_NAME);
                    String  lastName = getActivity().getIntent().getStringExtra(RegisterFragment.LAST_NAME);

                    Intent intent = new Intent(getContext(),WelcomeActivity.class);
                    intent.putExtra(RegisterFragment.FIRST_NAME,firstName);
                    intent.putExtra(RegisterFragment.LAST_NAME,lastName);

                    startActivity(intent);


                }else {
                    Toast.makeText(getContext(),R.string.wrong,Toast.LENGTH_SHORT).show();
                }



            }
        });




        return view;
    }
}
