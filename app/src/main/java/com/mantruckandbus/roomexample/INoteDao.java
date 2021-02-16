package com.mantruckandbus.roomexample;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface INoteDao
{
    @Insert
    void insert(Note note);
}
