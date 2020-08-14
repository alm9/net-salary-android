package com.example.netsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button btnBackToHome = (Button)findViewById(R.id.btnBackToHome);

        btnBackToHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            //click button to go back to first screen (home)
            //ResultsActivity.this = current activity //(first parameter could be getApplicationContext())
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);

            startActivity(intent);

            }
        });

    }
}