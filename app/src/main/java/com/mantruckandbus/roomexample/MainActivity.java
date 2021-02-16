package com.mantruckandbus.roomexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.UUID;

public class MainActivity extends AppCompatActivity
{
    public static final int NEW_NOTE_ATIVITY_REQUEST_CODE = 1;
    private static final String TAG = MainActivity.class.getSimpleName();
    private NoteViewModel mNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mNoteViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) getApplication()).get(NoteViewModel.class);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivityForResult(intent, NEW_NOTE_ATIVITY_REQUEST_CODE);
            }
        });
        mNoteViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(NoteViewModel.class);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_NOTE_ATIVITY_REQUEST_CODE && resultCode == RESULT_OK)
        {
            // insert code
            final String noteId = UUID.randomUUID().toString();
            Note note = new Note(noteId, data.getStringExtra(NewNoteActivity.NOTE_ADDED));
            mNoteViewModel.insert(note);
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "not saved", Toast.LENGTH_SHORT).show();
        }
    }
}