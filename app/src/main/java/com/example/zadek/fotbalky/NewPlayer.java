package com.example.zadek.fotbalky;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewPlayer extends AppCompatActivity {

    public static final String EXTRA_NAME = "com.example.zadek.fotbalky.NEW_PLAYER_NAME_REPLY";

    private EditText playersNameEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        playersNameEditText = findViewById(R.id.newPlayerNameEditText);

        final Button addPlayerButton = findViewById(R.id.addNewPlayerButton);
        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();

                if (TextUtils.isEmpty(playersNameEditText.getText())) {
                    makeToast("Player's name can't be empty");
                } else {
                    String name = playersNameEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_NAME, name);
                    setResult(RESULT_OK, replyIntent);

                    finish();
                }
            }
        });
    }

    private void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
