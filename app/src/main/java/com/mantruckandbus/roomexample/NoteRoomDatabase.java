package com.mantruckandbus.roomexample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase
{
    public abstract INoteDao mNoteDao();
    private static volatile NoteRoomDatabase sNoteRoomInstance;

    static NoteRoomDatabase getDatabase(final Context context)
    {
        if (sNoteRoomInstance == null)
        {
            synchronized (NoteRoomDatabase.class)
            {
                if (sNoteRoomInstance == null)
                {
                    sNoteRoomInstance =
                        Room.databaseBuilder(context.getApplicationContext(),
                        NoteRoomDatabase.class, "note_database")
                        .build();
                }
            }
        }
        return sNoteRoomInstance;
    }
}
