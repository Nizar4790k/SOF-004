package com.example.tarea7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Date;

public class ReminderFragment extends Fragment {

    private static final String CREATE_OR_UPDATE_REMINDER = "com.example.tarea7.CreateOrUpdate";
    private static final String DATE_PICKER="DialogDate";
    private static final int REQUEST_DATE=0;


    private Button mDateButton;
    private Button mCreateOrUpdateButton;
    private EditText mTitleEditText;
    private CheckBox mDoneCheckBox;

    private Reminder mReminder;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reminder, null, false);




        mTitleEditText = view.findViewById(R.id.edit_text_title);
        mCreateOrUpdateButton = view.findViewById(R.id.button_create_or_update);
        mDateButton = view.findViewById(R.id.button_date);  //
        mDoneCheckBox= view.findViewById(R.id.check_box_done);

        Intent intent = getActivity().getIntent();


        String title = mTitleEditText.getText().toString();
        boolean isDone = mDoneCheckBox.isChecked();

        mReminder = new Reminder(title,new Date(),isDone);

        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                FragmentManager fm = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mReminder.getDate());
                dialog.setTargetFragment(ReminderFragment.this,REQUEST_DATE);
                dialog.show(fm,DATE_PICKER);

                //Pick the date;
            }
        });

        mCreateOrUpdateButton.setText(intent.getStringExtra(CREATE_OR_UPDATE_REMINDER));
        mCreateOrUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean createReminder = mCreateOrUpdateButton.getText().equals(getString(R.string.button_add));


                if(mCreateOrUpdateButton.getText().equals(createReminder)){
                    mReminder.setTitle(mTitleEditText.getText().toString());
                    mReminder.setDone(mDoneCheckBox.isChecked());


                    //Create Reminder

                }else{
                    //Update Reminder
                }
            }
        });




        return view;




    }


    public static Intent createOrUpdateIntent(Context context,String buttonText){

        Intent intent = new Intent(context,ReminderActivity.class);
        intent.putExtra(CREATE_OR_UPDATE_REMINDER,buttonText);
        return intent;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==REQUEST_DATE){
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mReminder.setDate(date);
            updateDate();

        }



    }

    private void updateDate(){
        mDateButton.setText(mReminder.getDate().toString());
    }
}