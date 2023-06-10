package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditNicknameActivity extends AppCompatActivity {
    private Button okBtn;
    private EditText newNicknameEdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nickname);

        okBtn = findViewById(R.id.okBtn);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newNicknameEdt = findViewById(R.id.newNicknameEdt);
                String inputNewNickname = newNicknameEdt.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("nickname", inputNewNickname);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}