package com.example.tarea7.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.tarea7.Reminder;

import java.util.Date;
import java.util.UUID;

public class ReminderCursorWrapper extends CursorWrapper {


    public ReminderCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Reminder getReminder(){

        String uuid = getString(getColumnIndex(ReminderDbSchema.ReminderTable.Cols.UUID));
        String title = getString(getColumnIndex(ReminderDbSchema.ReminderTable.Cols.TITLE));
        long date = getLong(getColumnIndex(ReminderDbSchema.ReminderTable.Cols.DATE));
        int isDone= getInt(getColumnIndex(ReminderDbSchema.ReminderTable.Cols.DONE));


        Reminder reminder = new Reminder(UUID.fromString(uuid));
        reminder.setTitle(title);
        reminder.setDone(isDone!=0);
        reminder.setDate(new Date(date));

        return reminder;

    }





}
