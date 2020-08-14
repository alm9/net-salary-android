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

        //Receive values from Home Screen
        Intent intent = getIntent();
        double grossSalary = intent.getDoubleExtra(MainActivity.GROSS_SALARY,0);
        int dependents = intent.getIntExtra(MainActivity.DEPENDENTS,0);
        double discounts = intent.getDoubleExtra(MainActivity.DISCOUNTS,0);

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