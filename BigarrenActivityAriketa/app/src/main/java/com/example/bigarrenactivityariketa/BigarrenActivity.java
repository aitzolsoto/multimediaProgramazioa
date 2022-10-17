package com.example.bigarrenactivityariketa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BigarrenActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "Erantzuna";
    int emaitza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigarren);

        Intent intent = getIntent();
        String zenbakia = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        emaitza = Integer.parseInt(zenbakia) + 10;
        returnReply();
    }

    public void returnReply(){
        Intent replyintent = new Intent();
        replyintent.putExtra(EXTRA_REPLY,String.valueOf(emaitza));
        setResult(RESULT_OK,replyintent);
        finish();
    }
}