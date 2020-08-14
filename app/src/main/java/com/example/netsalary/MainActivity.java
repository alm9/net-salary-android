package com.example.netsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button btnCalculate = (Button)findViewById(R.id.btnCalculate);

    btnCalculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //when user click on Calculate Button, go to next screen
            //parameters = context and results
            //Intent intent = new Intent(getApplicationContext(), ResultsActivity.class); //option 1
            Intent intent = new Intent(MainActivity.this, ResultActivity.class); //option 2

            startActivity(intent);
        }
    });


    }
}