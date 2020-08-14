package com.example.netsalary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //creating keys:
    public static final String GROSS_SALARY = "com.salarycalc.GROSS_SALARY";
    public static final String DEPENDENTS = "com.salarycalc.DEPENDENTS";
    public static final String DISCOUNTS = "com.salarycalc.DISCOUNTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //editTexts informed by user:
        final EditText editTextGrossSalary = (EditText)findViewById(R.id.editTextGrossSalary);
        final EditText editTextDependents = (EditText)findViewById(R.id.editTextDependents);
        final EditText editTextDiscounts = (EditText)findViewById(R.id.editTextDiscounts);

    Button btnCalculate = (Button)findViewById(R.id.btnCalculate);

    btnCalculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //check if editTexts are filled:
            validateFields();


                //when user click on Calculate Button, go to next screen
                //parameters = context and results
                //Intent intent = new Intent(getApplicationContext(), ResultsActivity.class); //option 1
                Intent intent = new Intent(MainActivity.this, ResultActivity.class); //option 2

                //send values of editTexts to next screen
                intent.putExtra(GROSS_SALARY, Double.parseDouble(editTextGrossSalary.getText().toString()));
                intent.putExtra(DEPENDENTS, Integer.parseInt(editTextDependents.getText().toString()));
                intent.putExtra(DISCOUNTS, Double.parseDouble(editTextDiscounts.getText().toString()));

                startActivity(intent);

        }


    });


    }

    private void validateFields() {
        final EditText editTextGrossSalary = (EditText)findViewById(R.id.editTextGrossSalary);
        final EditText editTextDependents = (EditText)findViewById(R.id.editTextDependents);
        final EditText editTextDiscounts = (EditText)findViewById(R.id.editTextDiscounts);

        if (editTextGrossSalary.getText().length() <= 0)
        {
            editTextGrossSalary.setText("1000");
        }

        if (editTextDependents.getText().length() <= 0)
        {
            editTextDependents.setText("0");
        }

        if (editTextDiscounts.getText().length() <= 0)
        {
            editTextDiscounts.setText("0");
        }
    }
}