package com.example.ariketaaplikazioaireki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtLink;
    Button btnIreki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLink = findViewById(R.id.txtLink);
        btnIreki = findViewById(R.id.btnIreki);
        btnIreki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ireki();
            }
        });
    }

    private void ireki(){
        String url = txtLink.getText().toString();
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setData(Uri.parse(url));
// Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(sendIntent, url);

// Verify the original intent will resolve to at least one activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }

    }
}