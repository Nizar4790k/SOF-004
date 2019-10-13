package com.example.tarea7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReminderLab {

    private Context mContext;
    private static ReminderLab sReminderLab;
    private List<Reminder> mRemiders;
    private SQLiteDatabase mDatabase;


            private ReminderLab(Context context){

                mRemiders = new ArrayList<>();
                mContext = context;


            }


            public static ReminderLab getInstance(Context context){

                if(sReminderLab==null){
                    sReminderLab = new ReminderLab(context);
                }

                return sReminderLab;
            }


            public void addReminder(Reminder reminder){

            }

            public void updateReminder(Reminder reminder){

            }

            public List<Reminder> getReminders(){

                return mRemiders;
            }

            public void deleteReminder(Reminder reminder){

            }

            private Reminder getReminder(UUID id){


                return null;
            }


}
