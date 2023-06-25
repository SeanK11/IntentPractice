package com.example.intentpractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button moveToOtherBtn;
    private Button sendMessageBtn;
    private Button editNicknameBtn;
    private Button dialBtn;
    private Button callBtn;
    private Button smsBtn;
    private Button kakaoStoreBtn;
    private Button naverWebBtn;
    private TextView nicknameTxt;
    private int REQUEST_FOR_NICKNAME = 1005;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveToOtherBtn = findViewById(R.id.moveToOtherBtn);
        sendMessageBtn = findViewById(R.id.sendMessageBtn);
        editNicknameBtn = findViewById(R.id.editNicknameBtn);
        dialBtn = findViewById(R.id.dialBtn);
        callBtn = findViewById(R.id.callBtn);
        smsBtn = findViewById(R.id.smsBtn);
        kakaoStoreBtn = findViewById(R.id.kakaoStoreBtn);
        naverWebBtn = findViewById(R.id.naverWebBtn);


        //kakao Store로 이동
        kakaoStoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri myUri = Uri.parse("market://details?id=com.kakao.talk");
                Intent myIntent = new Intent(Intent.ACTION_VIEW, myUri);

                startActivity(myIntent);
            }
        });

        //naver로 이동
        naverWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri myUri = Uri.parse("https://naver.com");
                Intent myIntent = new Intent(Intent.ACTION_VIEW, myUri);

                startActivity(myIntent);
            }
        });

        // SMS 액션 예제
        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText phoneNumEdt = findViewById(R.id.phoneNumEdt);
                String inputPhoneNum = phoneNumEdt.getText().toString();
                Uri myUri = Uri.parse("smsto:" + inputPhoneNum);
                Intent myIntent = new Intent(Intent.ACTION_SENDTO, myUri);
                myIntent.putExtra("sms_body", "미리 내용 입력");

                startActivity(myIntent);
            }
        });

        // Call 액션 예제
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText phoneNumEdt = findViewById(R.id.phoneNumEdt);
                String inputPhoneNum = phoneNumEdt.getText().toString();
                Uri myUri = Uri.parse("tel:" + inputPhoneNum);
                Intent myIntent = new Intent(Intent.ACTION_CALL, myUri);

                startActivity(myIntent);
            }
        });

        // DIAL 액션 예제
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // phoneNumEdt에 입력한 전화번호를 받아서 => 해당 번호에 전화 연결
                EditText phoneNumEdt = findViewById(R.id.phoneNumEdt);
                String inputPhoneNum = phoneNumEdt.getText().toString();
                Uri myUri = Uri.parse("tel:" + inputPhoneNum);
                Intent myIntent = new Intent(Intent.ACTION_DIAL, myUri);

                startActivity(myIntent);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        nicknameTxt = findViewById(R.id.nicknameTxt);
        if (requestCode == REQUEST_FOR_NICKNAME) {
            if (resultCode == RESULT_OK) {
                String newNickname = data.getStringExtra("nickname");
                nicknameTxt.setText(newNickname);
            }
        }
    }
}