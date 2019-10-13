package com.example.tarea7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.UUID;

public class ReminderFragment extends Fragment {

    private static final String CREATE_OR_UPDATE_REMINDER = "com.example.tarea7.CreateOrUpdate";
    private static final String DATE_PICKER="DialogDate";
    private static final String REMINDER_ID="com.example.tarea7.ReminderId";
    private static final int REQUEST_DATE=0;


    private Button mDateButton;
    private Button mCreateOrUpdateButton;
    private EditText mTitleEditText;
    private CheckBox mDoneCheckBox;
    private boolean mIsCreateMode;
    private Reminder mReminder;
    private ReminderLab mReminderLab;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reminder, null, false);


        mReminderLab = ReminderLab.getInstance(getContext());


        mTitleEditText = view.findViewById(R.id.edit_text_title);
        mCreateOrUpdateButton = view.findViewById(R.id.button_create_or_update);
        mDateButton = view.findViewById(R.id.button_date);  //
        mDoneCheckBox= view.findViewById(R.id.check_box_done);

        Intent intent = getActivity().getIntent();


        String title = mTitleEditText.getText().toString();

        String buttonText = intent.getStringExtra(CREATE_OR_UPDATE_REMINDER);

        mIsCreateMode = buttonText.equals(getString(R.string.button_add));
        mCreateOrUpdateButton.setText(buttonText);






        mReminder = new Reminder(title,new Date(),false);

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





                if(mIsCreateMode){
                    //Create Reminder

                    mReminder.setTitle(mTitleEditText.getText().toString());
                    mReminder.setDone(false);
                   mReminderLab.addReminder(mReminder);




                }else{
                    //Update Reminder

                    boolean isDone = mDoneCheckBox.isChecked();
                    String  title = mTitleEditText.getText().toString();

                    mReminder.setDone(isDone);
                    mReminder.setTitle(title);

                    mReminderLab.updateReminder(mReminder);




                }




                getBack();

            }
        });


        if(mIsCreateMode){
            mDoneCheckBox.setVisibility(View.INVISIBLE);
            setHasOptionsMenu(false);
            mCreateOrUpdateButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_button_add,0,0,0);
        }
        else {
                mDoneCheckBox.setVisibility(View.VISIBLE);
                String id = intent.getStringExtra(REMINDER_ID);


                mReminder = ReminderLab.getInstance(getContext()).getReminder(UUID.fromString(id));

                mDoneCheckBox.setChecked(mReminder.isDone());
                mDateButton.setText(mReminder.getDate().toString());
                mTitleEditText.setText(mReminder.getTitle());

                mCreateOrUpdateButton.setText(R.string.button_update);
            mCreateOrUpdateButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_button_update,0,0,0);
            setHasOptionsMenu(true);

        }



        return view;




    }


    public static Intent createOrUpdateIntent(Context context,String buttonText,String id){

        Intent intent = new Intent(context,ReminderActivity.class);
        intent.putExtra(CREATE_OR_UPDATE_REMINDER,buttonText);

        if(!id.equals("")){
            intent.putExtra(REMINDER_ID,id);
        }else {
            return intent;
        }


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


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_reminder,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.delete_reminder:
                mReminderLab.deleteReminder(mReminder);
                getBack();

                return  true;


        default:
            return super.onOptionsItemSelected(item);


        }




    }

    private void getBack(){
        Intent i=new Intent(getContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }




}
