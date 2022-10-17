package com.example.bigarrenactivityariketa;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Mezua";
    Button btnBidali;
    TextView textBidalitakoa;
    TextView textJasotakoa;
    EditText txtZenbakia;
    String bidalitakoZenbakia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBidalitakoa = findViewById(R.id.textSend);
        textJasotakoa = findViewById(R.id.textReply);
        txtZenbakia = findViewById(R.id.editTextZenbakia);

        btnBidali = (Button)findViewById(R.id.btnBidali);
        btnBidali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityAldatu();
            }
        });
    }

    private void activityAldatu() {
        bidalitakoZenbakia = String.valueOf(txtZenbakia.getText());
        Intent i = new Intent(this, BigarrenActivity.class);
        i.putExtra(EXTRA_MESSAGE,bidalitakoZenbakia);
        startForResult.launch(i);
    }

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null && result.getResultCode()==RESULT_OK){
                if(result.getData()!=null && result.getData().getStringExtra(BigarrenActivity.EXTRA_REPLY)!=null){
                    String reply = result.getData().getStringExtra(BigarrenActivity.EXTRA_REPLY);
                    textBidalitakoa.setText("Bidalitakoa: " + bidalitakoZenbakia);
                    textJasotakoa.setText("Jasotakoa: " + reply);
                }
            }
            if(result!=null && result.getResultCode()==RESULT_CANCELED){
                //Log.d(LOG_TAG,"Bigarren acitivity-a cancelled");
            }
        }
    });
}