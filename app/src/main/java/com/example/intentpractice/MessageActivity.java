package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        // 이 화면에 들어올 때 첨부된 데이터를 텍스트뷰에 반영
        String inputMessage = getIntent().getStringExtra("message");

        TextView receivedMessageTxt = findViewById(R.id.receivedMessageTxt);
        receivedMessageTxt.setText(inputMessage);
    }
}