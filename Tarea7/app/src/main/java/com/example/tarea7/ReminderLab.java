package com.example.tarea7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tarea7.database.ReminderBaseHelper;
import com.example.tarea7.database.ReminderCursorWrapper;
import com.example.tarea7.database.ReminderDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReminderLab {

    private Context mContext;
    private static ReminderLab sReminderLab;

    private SQLiteDatabase mDatabase;


            private ReminderLab(Context context){


                mContext = context;
                mDatabase = new ReminderBaseHelper(mContext).getWritableDatabase();


            }


            public static ReminderLab getInstance(Context context){

                if(sReminderLab==null){
                    sReminderLab = new ReminderLab(context);
                }

                return sReminderLab;
            }


            public void addReminder(Reminder reminder){

                ContentValues contentValues = getContentValues(reminder);
                mDatabase.insert(ReminderDbSchema.ReminderTable.NAME,null,contentValues);

            }

            public void updateReminder(Reminder reminder){

                String uuidString = reminder.getUUID().toString();
                ContentValues values = getContentValues(reminder);

                mDatabase.update(ReminderDbSchema.ReminderTable.NAME,values,
                        ReminderDbSchema.ReminderTable.Cols.UUID+ " = ?",
                        new String []{uuidString});

            }

            public List<Reminder> getReminders(){

                List<Reminder> reminders = new ArrayList<>();

                ReminderCursorWrapper cursorWrapper = queryReminder(null,null);

                try{
                    cursorWrapper.moveToFirst();

                    while (!cursorWrapper.isAfterLast()){
                        reminders.add(cursorWrapper.getReminder());
                        cursorWrapper.moveToNext();

                    }

                } finally {
                    cursorWrapper.close();
                }



                return reminders;
            }

            public void deleteReminder(Reminder reminder){



                String uuid= reminder.getUUID().toString();

                mDatabase.delete(ReminderDbSchema.ReminderTable.NAME,
                        ReminderDbSchema.ReminderTable.Cols.UUID+" = ?",
                        new String[]{uuid});


            }

            public Reminder getReminder(UUID id){


                ReminderCursorWrapper cursorWrapper = queryReminder(
                        ReminderDbSchema.ReminderTable.Cols.UUID +" = ?",
                        new String[] {id.toString()}
                );



                try{
                    if(cursorWrapper.getCount()==0){
                        return null;
                    }

                    cursorWrapper.moveToFirst();
                    return cursorWrapper.getReminder();
                }finally {

                    cursorWrapper.close();
                }
            }

            private static ContentValues getContentValues(Reminder reminder){
                // Preparing the values to insert

                ContentValues contentValues = new ContentValues();

                contentValues.put(ReminderDbSchema.ReminderTable.Cols.UUID,reminder.getUUID().toString());
                contentValues.put(ReminderDbSchema.ReminderTable.Cols.DATE,reminder.getDate().getTime());
                contentValues.put(ReminderDbSchema.ReminderTable.Cols.DONE,reminder.isDone()? 1:0);
                contentValues.put(ReminderDbSchema.ReminderTable.Cols.TITLE,reminder.getTitle());

                return contentValues;

            }




    private ReminderCursorWrapper queryReminder(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ReminderDbSchema.ReminderTable.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new ReminderCursorWrapper(cursor);
    }

}
