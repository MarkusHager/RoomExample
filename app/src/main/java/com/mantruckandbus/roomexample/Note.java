package com.mantruckandbus.roomexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note
{
    @PrimaryKey
    @NonNull
    private String mId;
    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public Note(@NonNull String id, @NonNull String note)
    {
        mId = id;
        mNote = note;
    }

    @NonNull
    public String getId()
    {
        return mId;
    }

    @NonNull
    public String getNote()
    {
        return mNote;
    }
}
