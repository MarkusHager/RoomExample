package com.mantruckandbus.roomexample;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NoteViewModel extends AndroidViewModel
{
    private static final String TAG = NoteViewModel.class.getSimpleName();
    private INoteDao mNoteDao;
    private NoteRoomDatabase mNoteDB;

    public NoteViewModel(@NonNull Application application)
    {
        super(application);
        mNoteDB = NoteRoomDatabase.getDatabase(application);
        mNoteDao = mNoteDB.mNoteDao();
    }

    public void insert(Note note)
    {
        new InsertAsyncTask(mNoteDao).execute(note);
    }

    @Override
    protected void onCleared()
    {
        super.onCleared();
        Log.i(TAG, "view model destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void>
    {
        INoteDao mNoteDao;

        public InsertAsyncTask(INoteDao noteDao)
        {
            mNoteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes)
        {
            mNoteDao.insert(notes[0]);
            return null;
        }
    }
}
