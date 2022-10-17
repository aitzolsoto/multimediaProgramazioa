package com.example.bigarrenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_REPLY = "Erantzuna";
    int emaitza;
    Button btnBueltatu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String zenbakia = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        emaitza = Integer.parseInt(zenbakia) + 10;
        returnReply();
        //TextView textView = findViewById(R.id.text_message);
        //textView.setText(message);

        btnBueltatu = (Button)findViewById(R.id.btnBueltatu);
        btnBueltatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                //Intent i = new Intent(view.getContext(), MainActivity.class);
                //startActivity(i);
                //returnReply(view);
            }
        });
    }

    public void returnReply(){
        //String reply = mReply.getText().ToString();
        Intent replyintent = new Intent();
        //replyintent.putExtra(EXTRA_REPLY,reply);
        replyintent.putExtra(EXTRA_REPLY,String.valueOf(emaitza));
        setResult(RESULT_OK,replyintent);
        finish();
    }
}