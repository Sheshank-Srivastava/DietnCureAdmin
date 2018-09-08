package com.dietncure.dietncureadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this,"Hello" +name,Toast.LENGTH_SHORT).show();
    }
}
