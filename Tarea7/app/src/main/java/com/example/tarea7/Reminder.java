package com.example.tarea7;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.UUID;

public class Reminder {

    private String mTitle;
    private Date  mDate;
    private boolean mIsDone;
    private UUID mUUID;

    public Reminder(String title, Date date, boolean isDone) {
        mUUID=UUID.randomUUID();
        mTitle = title;
        mDate = date;
        mIsDone = isDone;
    }

    public Reminder(UUID id) {
        mUUID=id;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setDone(boolean done) {
        mIsDone = done;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public boolean isDone() {
        return mIsDone;
    }


    @NonNull
    @Override
    public String toString() {
        return "Title:"+getTitle()+ "\n"
                +"Date: "+getDate().toString();
    }
}
