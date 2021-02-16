package com.mantruckandbus.roomexample;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class NewNoteActivity extends AppCompatActivity
{
    public final static String NOTE_ADDED = "new_note";
    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        mEditText = findViewById(R.id.etNewNote);

        Button button = findViewById(R.id.bAdd);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent resultIntent = new Intent();
                if (TextUtils.isEmpty(mEditText.getText()))
                {
                    setResult(RESULT_CANCELED, resultIntent);
                }
                else
                {
                    String note = mEditText.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED, note);
                    setResult(RESULT_OK, resultIntent);
                }
                finish();
            }
        });

    }
}
