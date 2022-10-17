package com.example.implicitintentsariketa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //URL
    private EditText textURl;
    private Button btnURL;
    //Location
    private EditText textLocation;
    private Button btnLocation;
    //Share
    private EditText textShare;
    private Button btnShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textURl = findViewById(R.id.editTextUrl);
        textLocation = findViewById(R.id.editTextLocation);
        textShare = findViewById(R.id.editTextShare);

        btnURL = findViewById(R.id.btnUrl);
        btnLocation = findViewById(R.id.btnLocation);
        btnShare = findViewById(R.id.btnShare);

        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl();
            }
        });

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLocation();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareText();
            }
        });
    }

    private void openUrl(){
        String url = textURl.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void openLocation(){
        /*String loc = textLocation.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Log.i("addressUri",addressUri.toString());
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }else{

        }*/

        String URL = "http://maps.google.com/maps?q=" + textLocation.getText().toString();
        Uri url = Uri.parse(URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void shareText(){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        String message = textShare.getText().toString();
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,message);
        //shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The title");
        startActivity(Intent.createChooser(shareIntent, "Share..."));

        /*Intent shareIntent = ShareCompat.IntentBuilder.from(activity)
          .setType("text/plain")
          .setText(shareText)
          .getIntent();
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
          startActivity(shareIntent);
        }*/
    }
}