package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button moveToOtherBtn;
    private Button sendMessageBtn;
    private Button editNicknameBtn;
    private int REQUEST_FOR_NICKNAME = 1005;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveToOtherBtn = findViewById(R.id.moveToOtherBtn);
        sendMessageBtn = findViewById(R.id.sendMessageBtn);
        editNicknameBtn = findViewById(R.id.editNicknameBtn);

        editNicknameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, EditNicknameActivity.class);
                startActivityForResult(myIntent, REQUEST_FOR_NICKNAME);
            }
        });

        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MessageActivity.class);
                EditText editText = (EditText)findViewById(R.id.messageEdt);
                String inputMessage = editText.getText().toString();
                myIntent.putExtra("message", inputMessage);

                startActivity(myIntent);
            }
        });
        moveToOtherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(myIntent);
            }
        });
    }
}