package com.example.tarea7;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ReminderAdapter mAdapter;
    private Button mButtonAddReminder;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view;


        if(ReminderLab.getInstance(getContext()).getReminders().size()==0){
            view = inflater.inflate(R.layout.empty_reminders,null,false);
            mButtonAddReminder = view.findViewById(R.id.button_new_reminder);
            mButtonAddReminder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToReminderFragment();
                }
            });

            return view;
        }else{
            view = inflater.inflate(R.layout.fragment_main_reminder_list,null,false);
            mRecyclerView = view.findViewById(R.id.recycler_view);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


            updateUI();

            return view;
        }



    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_main_reminder_list,menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void updateUI(){

        ReminderLab reminderLab = ReminderLab.getInstance(getActivity());
        List<Reminder> reminders = reminderLab.getReminders();

        mAdapter = new ReminderAdapter(reminders);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_reminder:
                goToReminderFragment();
                return true;

            case R.id.today_reminder:
                showTodayReminders();


                return true;
                default:

                    return  super.onOptionsItemSelected(item);

        }
    }

    private class ReminderHolder extends  RecyclerView.ViewHolder implements RecyclerView.OnClickListener{


        private Reminder mReminder;
        private ImageView mImageView;
        private TextView mTextViewTitle;
        private TextView mTextViewDate;


        public ReminderHolder(LayoutInflater inflater,ViewGroup group){
            super(inflater.inflate(R.layout.list_item_reminder,group,false));

            mImageView = itemView.findViewById(R.id.imageView);
            mTextViewTitle = itemView.findViewById(R.id.text_view_title_item);
            mTextViewDate = itemView.findViewById(R.id.text_view_date_item);
            itemView.setOnClickListener(this);

        }


        public void bind(Reminder reminder){
            mReminder = reminder;



            mTextViewDate.setText(DateFormat.getDateInstance().format(mReminder.getDate()));
            mTextViewTitle.setText(mReminder.getTitle());

            if(mReminder.isDone()){
                mImageView.setVisibility(View.VISIBLE);
            }else{
                mImageView.setVisibility(View.INVISIBLE);
            }



        }

        @Override
        public void onClick(View v) {
            Intent intent =ReminderFragment.createOrUpdateIntent(getContext(),getString(R.string.button_update),mReminder.getUUID().toString());
            startActivity(intent);
        }
    }

    private class ReminderAdapter extends  RecyclerView.Adapter<ReminderHolder> {

       private List<Reminder> mReminderList;


        public ReminderAdapter(List<Reminder> reminders){
            mReminderList = reminders;
        }

        @NonNull
        @Override
        public ReminderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return  new ReminderHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ReminderHolder holder, int position) {

            holder.bind(mReminderList.get(position));
        }

        @Override
        public int getItemCount() {
            return mReminderList.size();
        }



    }

    private void showTodayReminders(){

       List<Reminder> reminders= ReminderLab.getInstance(getContext()).getReminders();

        Date date = new Date();

        if(reminders.size()==0){
            return;
        }


        for(Reminder r : reminders){




            Calendar currentCalendar = new GregorianCalendar();
            currentCalendar.setTime(date);

            int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
            int currentMonth = currentCalendar.get(Calendar.MONTH);
            int currentYear = currentCalendar.get(Calendar.YEAR);

            Calendar reminderCalendar = new GregorianCalendar();
            reminderCalendar.setTime(r.getDate());

            int reminderDay = reminderCalendar.get(Calendar.DAY_OF_MONTH);
            int reminderMonth = reminderCalendar.get(Calendar.MONTH);
            int reminderYear = reminderCalendar.get(Calendar.YEAR);

            if(reminderDay== currentDay && reminderMonth==currentMonth && currentYear==reminderYear)
            {
                Toast.makeText(getContext(),r.toString(),Toast.LENGTH_SHORT).show();


            }


        }


    }


    private void goToReminderFragment(){
        Intent intent = ReminderFragment.createOrUpdateIntent(getContext(),getString(R.string.button_add), "");

        startActivity(intent);
    }
}
