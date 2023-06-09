 package com.example.intentpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class OtherActivity extends AppCompatActivity {
    private Button returnToMainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        returnToMainBtn = findViewById(R.id.returnToMainBtn);
        returnToMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent myIntent = new Intent(OtherActivity.this, MainActivity.class);
//                startActivity(myIntent);
                finish();
            }
        });
    }
}